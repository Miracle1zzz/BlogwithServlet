package com.duanle.model;

public class InfoList {
	private int ID;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	private String title;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitleimage() {
		return titleimage;
	}
	public void setTitleimage(String titleimage) {
		this.titleimage = titleimage;
	}
	public String getIntroduced_per() {
		return introduced_per;
	}
	public void setIntroduced_per(String introduced_per) {
		this.introduced_per = introduced_per;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getIntroduced_date() {
		return introduced_date;
	}
	public void setIntroduced_date(String introduced_date) {
		this.introduced_date = introduced_date;
	}
	public String getMaintext() {
		return Maintext;
	}
	public void setMaintext(String maintext) {
		Maintext = maintext;
	}
	private String titleimage;//图片
	private String introduced_per;
	private String category;//类别
	private String introduced_date;
	private String Maintext;//正文

}
