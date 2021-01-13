package com.project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.bean.LoginBean;
import com.project.dao.LoginDao;
 

public class LoginServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
 
public LoginServlet() {
}
 
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
    String username = request.getParameter("username");
    String password = request.getParameter("password");
   String utype = request.getParameter("utype");
 
    LoginBean loginBean = new LoginBean();
 
    loginBean.setUsername(username);
    loginBean.setPassword(password);
    loginBean.setUtype(utype);
 
    LoginDao loginDao = new LoginDao();
 
    try
    {
        String userValidate = loginDao.authenticateUser(loginBean);
 
        if(userValidate.equals("Admin_Role"))
        {
            System.out.println("Admin's Home");
 
            HttpSession session = request.getSession(); //Creating a session
            session.setAttribute("Admin", username); //setting session attribute
            request.setAttribute("username", username);
            request.setAttribute("password", password);
 
            request.getRequestDispatcher("/JSP/Admin.jsp").forward(request, response);
            request.getRequestDispatcher("/todo/todo-form.jsp").forward(request, response);
        }
        else if(userValidate.equals("Leader_Role"))
        {
            System.out.println("Project Leader's Home");
 
            HttpSession session = request.getSession();
            session.setAttribute("Leader", username);
            request.setAttribute("username", username);
            request.setAttribute("password", password);
 
            request.getRequestDispatcher("/Leader/Leader.jsp").forward(request, response);
        }
        else if(userValidate.equals("Member_Role"))
        {
            System.out.println("Member's Home");
 
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(10*60);
            session.setAttribute("Member", username);
            request.setAttribute("username", username);
           request.setAttribute("password", password);
 
            request.getRequestDispatcher("/JSP/Member.jsp").forward(request, response);
        }
        else
        {
            System.out.println("Error message = "+userValidate);
            request.setAttribute("errMessage", userValidate);
 
            request.getRequestDispatcher("/JSP/login.jsp").forward(request, response);
        }
    }
   
    catch (IOException e1)
    {
        e1.printStackTrace();
    }
    catch (Exception e2)
    {
        e2.printStackTrace();
    }
} //End of doPost()
}
