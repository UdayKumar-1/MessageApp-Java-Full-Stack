package com.org.MessageApp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
@WebServlet(urlPatterns = "/signup",loadOnStartup = 2)
@MultipartConfig
public class Signup extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("userName");
		String userdesc=req.getParameter("userBio");
		String userPhone=req.getParameter("userNumber");
		String userPass=req.getParameter("userPassword");
		String usercnfPass=req.getParameter("userCnfPassword");
		try {
			Part userImage=req.getPart("userImage");
			byte[] image = userImage.getInputStream().readAllBytes();
//			System.out.println(username+""+userdesc+""+image+""+userPhone+""+userPass);
			long phoneNo=Long.parseLong(userPhone);
			if(userPass!=null && userPass.equals(usercnfPass)) {
				User user1=new User();
				user1.setName(username);
				user1.setDescr(userdesc);
				user1.setImage(image);
				user1.setMobile(phoneNo);
				user1.setPassword(userPass);
				MessagesDAO mdao=new MessagesDAO();
				boolean inserted=mdao.InsertUserRecord(user1);
				if(inserted) {
					resp.sendRedirect("Login.jsp");
				}
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
