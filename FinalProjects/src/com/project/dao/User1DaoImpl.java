package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.bean.User1;
import com.project.util.DBConnection;


/**
 * This DAO class provides CRUD database operations for the table todos in the
 * database.
 * 
 *
 */

public class User1DaoImpl implements User1Dao {

    private static final String INSERT_USERS_SQL = "INSERT INTO users2" +
        "  (fullname, username, password, utype) VALUES " + " ( ?, ?, ?, ?);";

    private static final String SELECT_USER_BY_ID = "select id, fullname, username, password, utype from users2 where id =?";
    private static final String SELECT_ALL_USERS = "select * from users2";
    private static final String DELETE_USER_BY_ID = "delete from users2 where id = ?;";
    private static final String UPDATE_USER = "update users2 set fullname = ?, username= ?, password =?, utype =? where id = ?;";


    @Override
    public void insertUser1(User1 user1) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = DBConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user1.getFullname());
            preparedStatement.setString(2, user1.getUsername());
            preparedStatement.setString(3, user1.getPassword());
            preparedStatement.setString(4, user1.getUtype());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            DBConnection.printSQLException(exception);
        }
    }

    @Override
    public User1 selectUser1(long user1Id) {
        User1 user1 = null;
        // Step 1: Establishing a Connection
        try (Connection connection = DBConnection.getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setLong(1, user1Id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
            	long id = rs.getLong("id");
                String fullname = rs.getString("fullname");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String utype = rs.getString("utype");
               
                user1 = new User1(id, fullname, username, password, utype);
            }
        } catch (SQLException exception) {
        	DBConnection.printSQLException(exception);
        }
        return user1;
    }

    @Override
    public List<User1> selectAllUsers() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List < User1 > users = new ArrayList < > ();

        // Step 1: Establishing a Connection
        try (Connection connection = DBConnection.getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
            	long id = rs.getLong("id");
            	 String fullname = rs.getString("fullname");
                 String username = rs.getString("username");
                 String password = rs.getString("password");
                 String utype = rs.getString("utype");
               
          
                users.add(new User1(id, fullname, username, password, utype));
            }
        } catch (SQLException exception) {
            DBConnection.printSQLException(exception);
        }
        return users;
    }

   // @Override
    public boolean deleteUser1(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = DBConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_USER_BY_ID);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

   // @Override
    public boolean updateUser1(User1 user1) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = DBConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_USER);) {
        	
            statement.setString(1, user1.getFullname());
            statement.setString(2, user1.getUsername());
            statement.setString(3, user1.getPassword());
            statement.setString(4, user1.getUtype());
            statement.setLong(5, user1.getId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }


}