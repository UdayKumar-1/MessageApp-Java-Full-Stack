package com.org.MessageApp;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.*;

import com.MessageApp.Connection.Connector;

public class MessagesDAO {
	public static boolean DeleteMessage(int Mid) {
		Connection con=null;
		PreparedStatement ps=null;
		String query="DELETE FROM MESSAGEDATA WHERE MID=?";
		int res=0;
		try {
			con=Connector.requestConnection();
			ps=con.prepareStatement(query);
			ps.setInt(1,Mid);
			res=ps.executeUpdate();
			if(res>0) {
				return true;
			}
			else {
				return false;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	public static List getAllMessages() {
		Message m=null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String query="SELECT * FROM MESSAGEDATA";
		ArrayList<Message>messageList=new ArrayList<Message>();
		try {
			con=Connector.requestConnection();
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()) {
				m=new Message();
				m.setMid(rs.getInt(1));
				m.setSuserid(rs.getInt(2));
				m.setRuserid(rs.getInt(3));
				m.setMcontent(rs.getString(4));
				m.setMimage(rs.getBytes(5));
				messageList.add(m);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return messageList;
	}
	public static boolean InsertMessages(Message m) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String query="INSERT INTO MESSAGEDATA(SUSERID,RUSERID,MCONTENT,MIMAGE)VALUES(?,?,?,?)";
		int res=0;
		try {
			con=Connector.requestConnection();
			ps=con.prepareStatement(query);
			ps.setInt(1,m.getSuserid());
			ps.setInt(2, m.getRuserid());
			ps.setString(3,m.getMcontent());
			ps.setBytes(4,m.getMimage());
			res=ps.executeUpdate();
			if(res>0) {
				return true;
			}
			else {
				return false;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	public static List getAllUserRecords() {
		User u=null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String query="SELECT * FROM USER";
		ArrayList<User>AllUserList=new ArrayList<User>();
		int res=0;
		try {
			con=Connector.requestConnection();
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()) {
				u=new User();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setDescr(rs.getString(3));
				u.setImage(rs.getBytes(4));
				u.setMobile(rs.getLong(5));
				u.setPassword(rs.getString(6));
				AllUserList.add(u);
			}
			
		} catch (ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}
		return AllUserList;
	}
	public static User getUserRecord(long mobileno) {
		System.out.println("Entered Start getUserRecord");
		User u=null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String query="SELECT * FROM USER WHERE MOBILENO=?";
		try {
			con=Connector.requestConnection();
			ps=con.prepareStatement(query);
			ps.setLong(1, mobileno);
			rs=ps.executeQuery();
//			System.out.println("Entered GetUserMethod");
			if(rs.next()) {
				u=new User();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setDescr(rs.getString(3));
				u.setImage(rs.getBytes(4));
				u.setMobile(rs.getLong(5));
				u.setPassword(rs.getString(6));
//				System.out.println("User Found");
				return u;
			}
			else {
				return null;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static boolean InsertUserRecord(User u) {
		Connection con=null;
		PreparedStatement ps=null;
		String query="INSERT INTO USER(NAMEE,DESCR,IMAGE,MOBILENO,PASSWORD)VALUES(?,?,?,?,?)";
		int res=0;
		try {
			con=Connector.requestConnection();
			ps=con.prepareStatement(query);
			ps.setString(1, u.getName());
			ps.setString(2, u.getDescr());
			ps.setBinaryStream(3,new ByteArrayInputStream(u.getImage()),u.getImage().length);
			ps.setLong(4, u.getMobile());
			ps.setString(5,u.getPassword());
			res=ps.executeUpdate();
			if(res>0) {
				return true;
			}
			else {
				return false;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	public static boolean InsertRecord(User u) {
		Connection con=null;
		PreparedStatement ps=null;
		String query="INSERT INTO MESSAGEDATA(NAMEE,DESCR,IMAGE,MOBILENO,PASSWORD)VALUES(?,?,?,?,?)";
		int res=0;
		try {
			con=Connector.requestConnection();
			ps=con.prepareStatement(query);
			ps.setString(1,u.getName());
			ps.setString(2,u.getDescr());
			ps.setBinaryStream(3, new ByteArrayInputStream(u.getImage()));
			ps.setLong(4, u.getMobile());
			ps.setString(5,u.getPassword());
			res=ps.executeUpdate();
			if(res>0) {
				return true;
			}
			else {
				return false;
			}
		} catch (ClassNotFoundException | SQLException  e) {
			e.printStackTrace();
		}
		return false;
	}
}
