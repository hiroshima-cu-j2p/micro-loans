package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dao.*;
import dto.User;

import java.sql.Connection;

public class GetUserData {
	public GetUserData(){
		
	}
	/* 
     * METHOD NAME:	userAuthentication
     * DESCRIPTION:	the method to refer a user to the Database
     * PARAMETER:	UserName(sting)
     * 				Password(string)
     */
    public User userAuthentication(String UserName, String Password) throws SQLException {
    	ConnectionManager conManger = new ConnectionManager();
    	Connection con = conManger.getConnection();
    	ResultSet rs = null;
        PreparedStatement stmt = null;
        User usr = new User();
        String sql = "select * from MS_USER where user_name='"+UserName+"' and pwd='"+Password+"'";
        stmt = con.prepareStatement(sql);
        
        rs = stmt.executeQuery();
        String userName = "";
        String password = "";
        String auth = "";
        String id = "";
        if(rs!=null){
	        while (rs.next()) {
	        	id = rs.getString("id");
	        	userName = rs.getString("user_name");
	        	password = rs.getString("pwd");
	        	auth = rs.getString("auth");
	        }
	        usr.setId(id);
	        usr.setUser_name(userName);
	        usr.setPwd(password);
	        usr.setAuth(auth);
	        return usr;
        } else {
        	return usr;
        }

    }     
}

