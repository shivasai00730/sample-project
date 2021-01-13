package com.project.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.project.bean.LoginBean;
import com.project.util.DBConnection;

//import finalproject.util.JDBCUtils;
 

 
public class LoginDao {
 
public String authenticateUser(LoginBean loginBean)
{
    String username = loginBean.getUsername();
    String password = loginBean.getPassword();
    String utype = loginBean.getUtype();
 
    Connection con = null;
    Statement statement = null;
    ResultSet resultSet = null;
 
    String usernameDB = "";
    String passwordDB = "";
    String utypeDB = "";
 
    try
    {
        con = DBConnection.getConnection();
        statement = con.createStatement();
        resultSet = statement.executeQuery("select username,password,utype from users2");
 
        while(resultSet.next())
        {
            usernameDB = resultSet.getString("username");
            passwordDB = resultSet.getString("password");
            utypeDB = resultSet.getString("utype");
 
            if(username.equals(usernameDB) && password.equals(passwordDB) && utype.equals(utypeDB))
            return "Admin_Role";
            else if(username.equals(usernameDB) && password.equals(passwordDB) && utype.equals(utypeDB))
            return "Leader_Role";
            else if(username.equals(usernameDB) && password.equals(passwordDB) && utype.equals(utypeDB))
            return "Member_Role";
        }
    }
    catch(SQLException e)
    {
        e.printStackTrace();
    }
    return "Invalid user credentials";
}

}