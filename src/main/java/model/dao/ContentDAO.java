package model.dao;

import model.bean.Content;
import model.dbconnection.ConnectMySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class ContentDAO {
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;

	public List<Content> getContent(String title)throws SQLException{
		List<Content> lst=new ArrayList<>();
		String select=null;
		if(title==null)
			select="select id,title,brief,createdate from content, member where authorId";
		else{
			select="select id,title,brief,createdate from content where title like ?";
		}

		try {
			conn=ConnectMySQL.getMySQLConnection();
			ps=conn.prepareStatement(select);
			if(title!=null)
				ps.setString(1,title+"%");
			rs=ps.executeQuery();
			while(rs.next()) {
				lst.add(new Content(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4)
						));
			}
		}
		catch(Exception e){			
		}
		return lst;
	}

	public void deletecontent(String id) {
		try {
			String delete="delete from Content where id=?";
			conn=ConnectMySQL.getMySQLConnection();
			ps=conn.prepareStatement(delete);
			ps.setString(1,id);
			ps.executeUpdate();
		}
		catch(Exception e) {
		}
	}
}