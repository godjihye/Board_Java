package com.example.chap06_ex02;

import java.util.Scanner;

public class BoardMain {
	public static void main(String[] args) {
		// Board print할 boardJob객체
		BoardJob boardJob = new BoardJob();
		// keyboard 입력 받을 scanner 객체
		Scanner sc = new Scanner(System.in);

		// 변수
		boolean exitFlag = false;
		int selectedType = 0;
		int selectedMenu = 0;

		BoardBasic[] boardBasics = new BoardBasic[0];
		BoardEvent[] boardEvents = new BoardEvent[0];
		BoardNotice[] boardNotices = new BoardNotice[0];
		
		int basicCnt = 0;
		int eventCnt = 0;
		int noticeCnt = 0;

		BoardBasic post = new BoardBasic();

		while (true) {

			// 게시판의 종류 선택
			boardJob.printBoardType();
			System.out.print("게시판 선택: ");
			selectedType = boardJob.stringToInt(sc.nextLine());
			if (selectedType == 99) {
				System.out.println("종료합니다..");
				break;
			}
			if (selectedType < 1 || selectedType > 3) {
				System.out.println("올바른 값을 입력하세요.");
				continue;
			}

			// 업무 선택
			boardJob.printMenu(selectedType);
			selectedMenu = boardJob.stringToInt(sc.nextLine());

			if (selectedMenu == 99) {
				selectedMenu = 0;
				continue;
			}
			
			// 1. 등록
			if (selectedMenu == 1) {
				switch (selectedType) {
				case 1:
					boardBasics = boardJob.createBoardBasicList(boardBasics);
					break;
				case 2:
					boardEvents = boardJob.createBoardEventList(boardEvents);
					break;
				case 3:
					boardNotices = boardJob.createBoardNoticeList(boardNotices);
					break;
				default:
					break;
				}
				System.out.println("글 등록이 완료되었습니다.");
			
			// 2. 수정 
			} else if (selectedMenu == 2) {
				switch (selectedType) {
				case 1:
					boardBasics = boardJob.updateBasic(boardBasics);
					break;
				case 2:
					boardEvents = boardJob.updateBasic(boardEvents);
				case 3:
					boardNotices = boardJob.updateBasic(boardNotices);
				default:
					break;
				}

			} else if (selectedMenu == 3) {
				switch (selectedType) {
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				default:
					break;
				}
			} else if (selectedMenu == 4) {
				switch (selectedType) {
				case 1:
					boardJob.printBoardList(boardBasics);
					break;
				case 2:
					boardJob.printBoardList(boardEvents);
					break;
				case 3:
					boardJob.printBoardList(boardNotices);
					break;
				default:
					break;
				}
			} else if (selectedMenu == 5) {
				switch (selectedType) {
				case 1:
					boardBasics = boardJob.createBoardBasicList();
					break;
				case 2:
					boardEvents = boardJob.createBoardEventList();
					break;
				case 3:
					boardNotices = boardJob.createBoardNoticeList();
					break;
				default:
					break;
				}
				System.out.println("글 등록이 완료되었습니다.");
			}
		}
	}

}
