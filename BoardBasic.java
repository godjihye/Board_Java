package com.example.chap06_ex02;

public class BoardBasic {

	public BoardBasic() {}
	public BoardBasic(String title, String name, String regDate) {
		this.title = title;
		this.name = name;
		this.regDate = regDate;
		setIdx();
	}
	public BoardBasic(int No, String title, String name, String regDate) {
		this(title, name, regDate);
		this.No = No;
	}
	public BoardBasic(int idx, int No, String title, String name, String regDate) {
		this(No, title, name, regDate);
		this.idx = idx;
	}
	
	public int idx = 0;
	public int No;
	public String title;
	public String name;
	public String regDate;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx() {
		this.idx = this.idx++;
	}
	public int getNo() {
		return No;
	}
	public void setNo(int no) {
		No = no;
	}
	@Override
	public String toString() {
		return this.title + "\t| " + this.name + "\t| " + this.regDate;
	}
}
