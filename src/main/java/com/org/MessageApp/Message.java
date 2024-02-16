package com.org.MessageApp;

public class Message {
	private int mid;
	private int suserid;
	private int ruserid;
	private String mcontent;
	private byte[] mimage;

	public Message() {
		super();
	}
	public Message(int mid, int suserid, int ruserid, String mcontent, byte[] mimage) {
		super();
		this.mid = mid;
		this.suserid = suserid;
		this.ruserid = ruserid;
		this.mcontent = mcontent;
		this.mimage = mimage;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public int getSuserid() {
		return suserid;
	}
	public void setSuserid(int suserid) {
		this.suserid = suserid;
	}
	public int getRuserid() {
		return ruserid;
	}
	public void setRuserid(int ruserid) {
		this.ruserid = ruserid;
	}
	public String getMcontent() {
		return mcontent;
	}
	public void setMcontent(String mcontent) {
		this.mcontent = mcontent;
	}
	public byte[] getMimage() {
		return mimage;
	}
	public void setMimage(byte[] mimage) {
		this.mimage = mimage;
	}
	
}
