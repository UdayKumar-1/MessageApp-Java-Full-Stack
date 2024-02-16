package com.org.MessageApp;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.*;
@WebServlet(urlPatterns = "/login",loadOnStartup = 2)
public class Login extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession s=req.getSession();
		String userName=req.getParameter("UserName");
		String MobileNum=req.getParameter("MobileNum");
		String password=req.getParameter("loginPassword");
		try {
			long PhoneNum=Long.parseLong(MobileNum);
			MessagesDAO mdao=new MessagesDAO();
//			System.out.println("GOing to Execute");
			User u=mdao.getUserRecord(PhoneNum);
			s.setAttribute("sendUserId",u.getId());
			String LoginUseId=u.getName();
			s.setAttribute("senderUserId", LoginUseId);
//			System.out.println("Executed getUserRecord Method");
			if(u!=null) {
				if(u.getName().toLowerCase().equalsIgnoreCase(userName)&&u.getPassword().toLowerCase().equalsIgnoreCase(password)) {
					System.out.println("Entered To Login If Block");
					ArrayList<User>AllUsers=(ArrayList<User>) mdao.getAllUserRecords();
					s.setAttribute("usersList",AllUsers);
					RequestDispatcher rd=req.getRequestDispatcher("MessageApp.jsp");
					rd.forward(req, resp);	
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
