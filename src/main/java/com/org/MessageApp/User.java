package com.org.MessageApp;

public class User {
	private int id;
	private String Name;
	private String descr;
	private byte[]image;
	private long mobile;
	private String password;
	public User(int id, String name, String descr, byte[] image, long mobile, String password) {
		super();
		this.id = id;
		Name = name;
		this.descr = descr;
		this.image = image;
		this.mobile = mobile;
		this.password = password;
	}
	public User() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
