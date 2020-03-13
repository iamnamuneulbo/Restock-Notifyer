package com.restocknotifyer.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class ConnectionFactory {
	
	private String url;
	private String userName;
	private String password;
	private String driver;
	private DataSource dataSource;

	private static Logger Log = Logger.getLogger(ConnectionFactory.class.getSimpleName());

	public ConnectionFactory() {
		Log.info("== ConnectionFactory Constructor is running.. ==");
		Properties properties = new Properties();
		InputStream input = getClass().getResourceAsStream("datasource.properties");

		BasicDataSource basicDataSource = new BasicDataSource();
		
		try {
			properties.load(input);

			url = properties.getProperty("url");
			userName = properties.getProperty("userName");
			password = properties.getProperty("password");
			driver = properties.getProperty("driver");

			Class.forName(driver);
			
			basicDataSource.setUrl(url);
			basicDataSource.setUsername(userName);
			basicDataSource.setPassword(password);
			basicDataSource.setDriverClassName(driver);
			
			basicDataSource.setInitialSize(1000);
			basicDataSource.setMaxIdle(1000);
			basicDataSource.setCacheState(true);
			basicDataSource.setMaxWaitMillis(2000);
			
			
			dataSource = basicDataSource;
			
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
}
