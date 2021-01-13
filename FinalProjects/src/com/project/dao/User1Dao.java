package com.project.dao;

import java.sql.SQLException;
import java.util.List;

import com.project.bean.User1;

public interface User1Dao {

 void insertUser1(User1 user1) throws SQLException;

 User1 selectUser1(long user1Id);

 List<User1> selectAllUsers();

 boolean deleteUser1(int id) throws SQLException;

 boolean updateUser1(User1 user1) throws SQLException;

}