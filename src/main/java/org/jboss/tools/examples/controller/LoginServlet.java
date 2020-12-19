package org.jboss.tools.examples.controller;

import org.jboss.tools.examples.model.LoginBean;
import org.jboss.tools.examples.data.LoginDAO;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private LoginDAO loginDao;
	
	
	public void init() {
		loginDao = new LoginDAO();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        LoginBean loginBean = new LoginBean();
        loginBean.setUsername(username);
        loginBean.setPassword(password);
        
        try {
            if (loginDao.validate(loginBean)) {
             //   HttpSession session = request.getSession();
             //   session.setAttribute("username",username);
                response.sendRedirect("index.html");
            } else {
             //   HttpSession session = request.getSession();
             //   session.setAttribute("username", username);
                response.sendRedirect("login.jsp");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
	}

}
