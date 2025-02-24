package com.example.chap06_ex02;

public class BoardEvent extends BoardBasic {
	public String eventDate;

	public BoardEvent() {
	}

	public BoardEvent(String title, String name, String regDate, String eventDate) {
		super(title, name, regDate);
		this.eventDate = eventDate;
	}

	public BoardEvent(int No, String title, String name, String regDate, String eventDate) {
		this(title, name, regDate, eventDate);
		this.No = No;
	}

	public BoardEvent(int idx, int No, String title, String name, String regDate, String eventDate) {
		this(No, title, name, regDate, eventDate);
		this.No = No;
	}

	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}
	
	@Override
	public String toString() {
		return this.idx + ", " + this.No + ", " + this.title + ", " + this.name + ", " + this.regDate + ", " + this.eventDate;
	}
}
