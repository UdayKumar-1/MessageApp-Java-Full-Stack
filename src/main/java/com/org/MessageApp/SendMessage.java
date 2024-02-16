package com.org.MessageApp;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.IOException;
import java.util.*;

@WebServlet(urlPatterns = "/sendmessage",loadOnStartup = 2)
@MultipartConfig
public class SendMessage extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Entered send MEssage SErvlet");
		HttpSession s=req.getSession();
		String RecieverUserId=req.getParameter("userId");
		System.out.println("Reciever ID in SendMessage "+RecieverUserId);
		Part MessageImage=req.getPart("ImageParse");
		String MessageValue=req.getParameter("messageType");
//		System.out.println("Reciever User Id Servlet "+RecieverUserId);
		byte[]image=MessageImage.getInputStream().readAllBytes();
		System.out.println("Image Value in sendmessage servlet "+MessageImage);
//			System.out.println("MessageValue "+MessageValue+" ImageValue "+image);

		try {
			int SuserId=(int) s.getAttribute("sendUserId");
			int RuserId=Integer.parseInt(RecieverUserId);
//			System.out.println("Send User Id"+SuserId);
			Message m=new Message();
			m.setSuserid(SuserId);
			m.setRuserid(RuserId);
			m.setMcontent(MessageValue);
			m.setMimage(image);
			MessagesDAO mdao=new MessagesDAO();
			boolean inserted=mdao.InsertMessages(m);
			ArrayList<Message>AllMsgList=(ArrayList<Message>)mdao.getAllMessages();
//				ArrayList<User>AllUsers=(ArrayList<User>)s.getAttribute("usersList");
//				System.out.println(inserted);
			if(inserted) {
				System.out.println("Entered SendMessage Servlet If Block");
				req.setAttribute("RecieverUserId",RuserId);
				req.setAttribute("SenderUserId", SuserId);
				req.setAttribute("MessagesList", AllMsgList);
				String url="http://localhost:8080/MessageApp/rendermessages?user="+ RuserId;
				resp.sendRedirect(url);
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
}
