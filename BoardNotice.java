package com.example.chap06_ex02;

public class BoardNotice extends BoardBasic {
	public String noticeFile;
	public BoardNotice() {}
	public BoardNotice(String title, String name, String regDate, String noticeFile) {
		super(title, name, regDate);
		this.noticeFile = noticeFile;
	}
	public BoardNotice(int No, String title, String name, String regDate, String noticeFile) {
		this(title, name, regDate, noticeFile);
		this.No = No;
	}
	public BoardNotice(int idx, int No, String title, String name, String regDate, String noticeFile) {
		this(No, title, name, regDate, noticeFile);
		this.idx = idx;
	}
	
	public String getNoticeFile() {
		return noticeFile;
	}
	public void setNoticeFile(String noticeFile) {
		this.noticeFile = noticeFile;
	}
	@Override
	public String toString() {
		return this.idx + ", " + this.No + ", " + this.title + ", " + this.name + ", " + this.regDate + ", " + this.noticeFile;
	}
}

