package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.bean.LoginBean;
import model.dbconnection.ConnectMySQL;

public class LoginDAO   {
	public static boolean checkLogin(String email, String pass){  
		boolean isValid = false;
          
        try{  
            Connection con=ConnectMySQL.getMySQLConnection();  
            PreparedStatement ps=con.prepareStatement("select * from register where email=? and password=? ");  
            ps.setString(1, email);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
            	isValid = true;
            }
            else {
            	isValid = false;
            }
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return isValid;  
    }  
}
