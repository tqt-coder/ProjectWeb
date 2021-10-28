package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.bean.RegisterBean;
import model.dbconnection.ConnectMySQL;

public class RegisterDAO {
	public static boolean insertRegister(RegisterBean user) throws SQLException {
		Connection conn;
		boolean flag = false;
		try {
			conn = ConnectMySQL.getMySQLConnection();
			String sql = "Insert into member(username, email,password) values (?,?,?)";

			PreparedStatement pstm = conn.prepareStatement(sql);

			pstm.setString(1, user.getUserName());
			pstm.setString(2, user.getEmail());
			pstm.setString(3, user.getPassword());

			pstm.executeUpdate();
			flag = true;

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		return flag;

	}
}
