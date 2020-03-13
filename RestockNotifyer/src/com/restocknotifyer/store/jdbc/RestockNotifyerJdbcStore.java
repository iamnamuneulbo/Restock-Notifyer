package com.restocknotifyer.store.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.restocknotifyer.product.Product;
import com.restocknotifyer.store.RestockNotifyerStore;

public class RestockNotifyerJdbcStore implements RestockNotifyerStore {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public RestockNotifyerJdbcStore() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패");
			e.printStackTrace();
		}

		try {
			String dbURL = "jdbc:mysql://127.0.0.1:3306/restock?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Seoul&autoReconnect=true";
			String dbID = "lsk";
			String dbPassword = "1234";
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			if (conn != null) {
				System.out.println("DB접속 성공");
			}
		} catch (SQLException e) {
			System.out.println("DB접속 실패");
			e.printStackTrace();
		}
	}

	@Override
	public String insert(Product product) {
		
		String SQL = "INSERT INTO product VALUES()";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, null);
			pstmt.setString(2, product.getUserId());
			pstmt.setString(3, product.getPrdUrl());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public ArrayList<Product> select(String userId) {

		String SQL = "SELECT * FROM product WHERE userId = ?";
		ArrayList<Product> list = new ArrayList<Product>();
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setPrdId(rs.getInt(1));
				product.setUserId(rs.getString(2));
				product.setPrdUrl(rs.getString(3));
				product.setStock(rs.getBoolean(4));

				list.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		close();

		return list;
	}

	@Override
	public void delete(int prdId) {
		String SQL = "DELETE FROM product WHERE prdId = ?";

		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, prdId);
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		close();
	}

	@Override
	public void close() {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
