package com.duanle.model;

public class Mess_reply {
  private String ID;
  public String getID() {
	return ID;
}
public void setID(String iD) {
	ID = iD;
}
public String getUser_id() {
	return user_id;
}
public void setUser_id(String user_id) {
	this.user_id = user_id;
}
public String getUser_face() {
	return user_face;
}
public void setUser_face(String user_face) {
	this.user_face = user_face;
}
public String getMess_reply_content() {
	return mess_reply_content;
}
public void setMess_reply_content(String mess_reply_content) {
	this.mess_reply_content = mess_reply_content;
}
public String getMess_reply_date() {
	return mess_reply_date;
}
public void setMess_reply_date(String mess_reply_date) {
	this.mess_reply_date = mess_reply_date;
}
private String user_id;
  private String user_face;
  private String mess_reply_content;
  private String mess_reply_date;

}
