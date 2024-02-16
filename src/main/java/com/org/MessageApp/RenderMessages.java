package com.org.MessageApp;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
@WebServlet(urlPatterns = "/rendermessages",loadOnStartup = 2)
@MultipartConfig
public class RenderMessages extends HttpServlet {
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException { 
	     String MessageValue=req.getParameter("MessageData");
	     System.out.println("MessageData In RenderMessage Do Post "+MessageValue);
	     String RecievedUserId=req.getParameter("user");
	     int RUserId=Integer.parseInt(RecievedUserId);
	     HttpSession s=req.getSession();
	     try {
	    	 
    		 int MessageId=Integer.parseInt(MessageValue); 
    		 System.out.println("User value in my renderedMessage Servlet is "+RUserId);
	         MessagesDAO mdao=new MessagesDAO();
	         boolean Deleted=mdao.DeleteMessage(MessageId);
			 ArrayList<Message>AllMessages=(ArrayList<Message>)mdao.getAllMessages();
			 ArrayList<User>AllUsers=(ArrayList<User>)mdao.getAllUserRecords();
			 System.out.println("Deleted MEssage Boolean "+Deleted);
			 if(Deleted) {
				 req.setAttribute("RUserId", RUserId);
				 System.out.print("RUser Id In REnderMessageServlet "+RUserId);
				 req.setAttribute("AllMsg", AllMessages); req.setAttribute("AllUsersRecords",AllUsers); 
				 String RDeletedUrl="http://localhost:8080/MessageApp/rendermessages";
				 resp.sendRedirect(RDeletedUrl); 
		     } 
			 else {
				  RequestDispatcher rd=req.getRequestDispatcher("MessageApp.jsp"); 
				  rd.forward(req, resp); 
			 }
    	 }
		  catch(Exception e) {
			  e.printStackTrace(); 
		  } 
	  }
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Entered RenderMessa Servlet");
		HttpSession s=req.getSession();
		String UserIdToPath=req.getParameter("user");
		try {
				int RUserId=Integer.parseInt(UserIdToPath);
				MessagesDAO mdao=new MessagesDAO();
				ArrayList<Message>AllMessages=(ArrayList<Message>)mdao.getAllMessages();
				ArrayList<User>AllUsers=(ArrayList<User>)mdao.getAllUserRecords();
				req.setAttribute("RUserId", RUserId);
				System.out.print("RUser Id In REnderMessageServlet "+RUserId);
				req.setAttribute("AllMsg", AllMessages);
				req.setAttribute("AllUsersRecords", AllUsers);
				RequestDispatcher rd=req.getRequestDispatcher("MessageApp.jsp");
				rd.forward(req, resp);	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
