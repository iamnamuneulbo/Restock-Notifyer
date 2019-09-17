package checker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import checker.Product;

public class CheckerDAO {
	// dao : 데이터베이스 접근 객체의 약자로서
	// 실질적으로 db에서 회원정보 불러오거나 db에 회원정보 넣을때
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public CheckerDAO() { // 생성자 실행될때마다 자동으로 db연결이 이루어 질 수 있도록함
		try {
			String dbURL = "jdbc:mysql://3.13.163.79:3306/DFS?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Seoul";
			String dbID = "admin";
			String dbPassword = "ifnt0719";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		} catch (Exception e) {
			e.printStackTrace(); // 오류가 무엇인지 출력
		}
	}
	public ArrayList<Product> getList(String userID) {
		String SQL = "SELECT * FROM CHECK_PRD WHERE userId = ?";
		ArrayList<Product> list = new ArrayList<Product>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Product chkprd = new Product();
				chkprd.setPrdId(rs.getInt(1));
				chkprd.setPrdUrl(rs.getString(2));
				chkprd.setUserId(rs.getString(3));
				chkprd.setDfsName(rs.getString(4));
				
				list.add(chkprd);
				System.out.println("리스트 추가");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
