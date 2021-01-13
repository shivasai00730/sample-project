package com.project.dao.todo;

import java.sql.SQLException;
import java.util.List;

import com.project.bean.todo.Todo;


public interface TodoDao {

 void insertTodo(Todo todo) throws SQLException;

 Todo selectTodo(long todoId);

 List<Todo> selectAllTodos();

 boolean deleteTodo(int id) throws SQLException;

 boolean updateTodo(Todo todo) throws SQLException;

}