package com.project.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.bean.User1;
import com.project.dao.User1Dao;
import com.project.dao.User1DaoImpl;


/**
 * ControllerServlet.java This servlet acts as a page controller for the
 * application, handling all requests from the todo.
 * 
 */

@WebServlet("/")
public class User1Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private User1Dao user1DAO;

    public void init() {
        user1DAO = (User1Dao) new User1DaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertUser1(request, response);
                    break;
                case "/delete":
                    deleteUser1(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateUser1(request, response);
                    break;
                case "/lists":
                    listsUser1(request, response);
                    break;
                default:
                    RequestDispatcher dispatcher = request.getRequestDispatcher("JSP/login.jsp");
                    dispatcher.forward(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listsUser1(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        List < User1 > listsUser1 = user1DAO.selectAllUsers();
        request.setAttribute("listsUser1", listsUser1);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user1/user-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user1/user-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User1 existingUser1 = user1DAO.selectUser1(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user1/user-form.jsp");
        request.setAttribute("users2", existingUser1);// users2 is name of table
        dispatcher.forward(request, response);

    }

    private void insertUser1(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

        String fullname = request.getParameter("fullname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String utype = request.getParameter("utype");
    
        User1 newUser1 = new User1(fullname, username, password, utype);
        user1DAO.insertUser1(newUser1);
        response.sendRedirect("lists");
    }

    private void updateUser1(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        long id = Integer.parseInt(request.getParameter("id"));

        String fullname = request.getParameter("fullname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String utype = request.getParameter("utype");
        
        User1 updateUser1 = new User1(id, fullname, username, password, utype);

        user1DAO.updateUser1(updateUser1);

        response.sendRedirect("lists");
    }

    private void deleteUser1(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        user1DAO.deleteUser1(id);
        response.sendRedirect("lists");
    }
}