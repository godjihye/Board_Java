package com.example.chap06_ex02;

import java.util.Arrays;
import java.util.Scanner;

public class BoardJob {
	
	// 게시판 저장을 위한 임시 String 객체
	String[] boardTemp = new String[4];
	Scanner sc = new Scanner(System.in);

	private static final int BOARD_MAX_SIZE = 1000;

	
	// 게시판 종류 메뉴 출력 
	public void printBoardType() {
		System.out.println("\n==========게시판==========");
		System.out.println("    1. 게시판");
		System.out.println("    2. 이벤트 게시판");
		System.out.println("    3. 공지 게시판");
		System.out.println("    99. 종료 ");
		System.out.println("========================");
	}
	
	// 업무 출력 
	public void printMenu(int type) {
		String boardTypeName = "";
		switch (type) {
		case 1:
			boardTypeName = "게시판";
			break;
		case 2:
			boardTypeName = "이벤트 게시판";
			break;
		case 3:
			boardTypeName = "공지사항 게시판";
			break;
		default:
			boardTypeName = "";
			break;
		}
		System.out.println(boardTypeName + "을 선택하셨습니다.");
		System.out.println("\n=========업무선택=========");
		System.out.println("   1. 등록");
		System.out.println("   2. 수정");
		System.out.println("   3. 삭제");
		System.out.println("   4. 목록 출력 ");
		System.out.println("   5. 1000개의 Mock 데이터 입력 ");
		System.out.println("   99. 이전메뉴 ");
		System.out.println("========================");
		System.out.println(boardTypeName + "> ");
	}
	
	// 게시글 출력 
	public void printBoardList(BoardBasic[] boardList) {
		int start = 0;
		int pages = boardList.length / 10 - 1;
		while (true) {
			if (boardList.length == 0) {
				return;
			}
			printBoardListOnly(boardList, start, pages);
			System.out.println("\n1. 게시글 조회 | 2. 첫 페이지로 이동 | 3. 이전 10개 | 4. 페이지로 이동 | 5. 다음 10개 | 6. 마지막 페이지로 이동 ");
			String p = sc.nextLine();
			if (p.equals("1")) {
				System.out.println("1 게시글 조회를 선택하셨습니다.");
				System.out.print("조회할 게시글 번호를 선택하세요.");
			} else if (p.equals("2")) {
				System.out.println("2. 첫 페이지로 이동을 선택하셨습니다.");
				start = 0;
			} else if (p.equals("3")) {
				System.out.println("3. 이전 10개를 선택하셨습니다.");
				if (start > 10)
					start -= 10;
			} else if (p.equals("4")) {
				System.out.println("4. 페이지로 이동을 선택하셨습니다. ");
				System.out.print("이동할 페이지를 입력하세요: ");
				start = stringToInt(sc.nextLine()) - 1;
			} else if (p.equals("5")) {
				System.out.println("5. 다음 10개를 선택하셨습니다.");
				if (start < pages) {
					start+=10;
				}
			} else if (p.equals("6")) {
				System.out.println("6. 마지막 페이지로 이동을 선택하셨습니다.");
				start = pages;
			} else {
				System.out.println("게시글 목록 출력을 종료합니다.");
				return;
			}
		}
	}
	
	// 게시글 삭제 
	public BoardBasic[] removeOne(BoardBasic[] origin) {
		System.out.println();
		System.out.print("삭제할 글의 인덱스를 입력하세요: ");
		int idx = stringToInt(sc.nextLine()) - 1;
		System.out.println(idx+"를 삭제합니다.");
		BoardBasic[] newBoard = new BoardBasic[origin.length - 1];
		// 첫 번째 부분 복사 (idx 이전 요소들)
	    System.arraycopy(origin, 0, newBoard, 0, idx);
	    // 두 번째 부분 복사 (idx 이후 요소들)
	    System.arraycopy(origin, idx + 1, newBoard, idx, origin.length - idx - 1);
		System.out.println("삭제가 완료되었습니다.");
		return newBoard;
	}
	public BoardNotice[] removeOne(BoardNotice[] origin) {
		System.out.println();
		System.out.print("삭제할 글의 인덱스를 입력하세요: ");
		int idx = stringToInt(sc.nextLine()) - 1;
		System.out.println(idx+"를 삭제합니다.");
		BoardNotice[] newBoardNotice = new BoardNotice[origin.length - 1];
		// 첫 번째 부분 복사 (idx 이전 요소들)
	    System.arraycopy(origin, 0, newBoardNotice, 0, idx);
	    // 두 번째 부분 복사 (idx 이후 요소들)
	    System.arraycopy(origin, idx + 1, newBoardNotice, idx, origin.length - idx - 1);
		System.out.println("삭제가 완료되었습니다.");
		return newBoardNotice;
	}
	public BoardEvent[] removeOne(BoardEvent[] origin) {
		System.out.println();
		System.out.print("삭제할 글의 인덱스를 입력하세요: ");
		int idx = stringToInt(sc.nextLine()) - 1;
		System.out.println(idx+"를 삭제합니다.");
		BoardEvent[] newBoard = new BoardEvent[origin.length - 1];
		// 첫 번째 부분 복사 (idx 이전 요소들)
	    System.arraycopy(origin, 0, newBoard, 0, idx);
	    // 두 번째 부분 복사 (idx 이후 요소들)
	    System.arraycopy(origin, idx + 1, newBoard, idx, origin.length - idx - 1);
		System.out.println("삭제가 완료되었습니다.");
		return newBoard;
	}
	
	// 게시글 수정
	public BoardBasic[] updateBasic(BoardBasic[] basics) {
		Scanner sc = new Scanner(System.in);
		System.out.print("수정할 글의 인덱스를 입력하세요: ");
		int idx = stringToInt(sc.nextLine());
		basics[idx] = createBoardBasic();
		return basics;
	}
	public BoardNotice[] updateBasic(BoardNotice[] basics) {
		Scanner sc = new Scanner(System.in);
		System.out.print("수정할 글의 인덱스를 입력하세요: ");
		int idx = stringToInt(sc.nextLine());
		basics[idx] = createBoardNotice();
		return basics;
	}
	public BoardEvent[] updateBasic(BoardEvent[] basics) {
		Scanner sc = new Scanner(System.in);
		System.out.print("수정할 글의 인덱스를 입력하세요: ");
		int idx = stringToInt(sc.nextLine());
		basics[idx] = createBoardEvent();
		return basics;
	}
	
	// 게시글 배열에 게시글 추가
	public BoardBasic[] createBoardBasicList(BoardBasic[] oldBoardBasic) {
		int size = oldBoardBasic.length;
		BoardBasic[] newArrBoardBasic = Arrays.copyOf(oldBoardBasic, size + 1);
		newArrBoardBasic[size] = createBoardBasic();
		return newArrBoardBasic;
	}
	public BoardEvent[] createBoardEventList(BoardEvent[] oldBoardEvent) {
		int size = oldBoardEvent.length;
		BoardEvent[] newArrBoardEvent = Arrays.copyOf(oldBoardEvent, size + 1);
		newArrBoardEvent[size] = createBoardEvent();
		return newArrBoardEvent;
	}
	public BoardNotice[] createBoardNoticeList(BoardNotice[] oldBoardNotice) {
		int size = oldBoardNotice.length;
		BoardNotice[] newArrBoardNotice = Arrays.copyOf(oldBoardNotice, size + 1);
		newArrBoardNotice[size] = createBoardNotice();
		return newArrBoardNotice;
	}
	public BoardBasic[] createBoardBasicList() {
		BoardBasic[] bb = new BoardBasic[BOARD_MAX_SIZE];
		for (int i = 0; i < BOARD_MAX_SIZE; i++) {
			bb[i] = new BoardNotice("title" + i, "name" + i, "reg" + i, "file" + i);
		}
		return bb;
	}
	public BoardEvent[] createBoardEventList() {
		BoardEvent[] bb = new BoardEvent[BOARD_MAX_SIZE];
		for (int i = 0; i < BOARD_MAX_SIZE; i++) {
			bb[i] = new BoardEvent("title" + i, "name" + i, "reg" + i, "file" + i);
		}
		return bb;
	}
	public BoardNotice[] createBoardNoticeList() {
		BoardNotice[] bb = new BoardNotice[BOARD_MAX_SIZE];
		for (int i = 0; i < BOARD_MAX_SIZE; i++) {
			bb[i] = new BoardNotice("title" + i, "name" + i, "reg" + i, "file" + i);
		}
		return bb;
	}

	
	/// helper methods
	
	// 페이지에 따른 게시글 출력 메서드
	private void printBoardListOnly(BoardBasic[] boardList, int start, int pages) {
		String[] headers = { "No", "idx", "제목", "이름", "등록일", "이벤트날짜", "첨부파일명" };
		if (boardList[0] instanceof BoardNotice) {
			System.out.printf("  %-5s |  %-5s |  %-20s |  %-10s |  %-10s |  %-10s\n", headers[0], headers[1],
					headers[2], headers[3], headers[4], headers[6]);
		} else if (boardList[0] instanceof BoardEvent) {
			System.out.printf("  %-5s |  %-5s |  %-20s |  %-10s |  %-10s |  %-10s\n", headers[0], headers[1],
					headers[2], headers[3], headers[4], headers[5]);
		} else {
			System.out.printf("  %-5s |  %-5s |  %-20s |  %-10s |  %-10s \n", headers[0], headers[1], headers[2],
					headers[3], headers[4]);
		}
		System.out.print("*********************************************************************");
		for (int i = start * 10; i < boardList.length && i < start * 10 + 10; i++) {
			System.out.printf("\n  %-5d |  %-5d |  %-20s |  %-10s |  %-10s|", (i + 1), boardList[i].getIdx(),
					boardList[i].getTitle(), boardList[i].getName(), boardList[i].getRegDate());

			if (boardList[0] instanceof BoardNotice) {
				BoardNotice notice = (BoardNotice) boardList[i];
				System.out.printf("  %-10s", notice.getNoticeFile());
			}
			if (boardList[0] instanceof BoardEvent) {
				BoardEvent notice = (BoardEvent) boardList[i];
				System.out.printf("  %-10s", notice.getEventDate());
			} 
			
		}

		System.out.println("\n*********************************************************************");
		System.out.print("<<        <  ");
		int pageStartNo = (start / 10) * 10;
		for (int i = pageStartNo; i < pageStartNo + 10 && i <= pages + 1; i++) {
			if (i == start) {
				// System.out.print("'"+ i+1 + "'"); 문자열 다음 숫자는 문자열숫자
				System.out.print(" '");
				System.out.print(i+1);
				System.out.print("' ");
			} else {
				System.out.print(i+1 + " ");
			}
		}
		System.out.print("  >        >>");
	}
	
	// 게시글 1개 생성 관련 helper 메서드 
	private BoardBasic createBoardBasic() {
		System.out.print("1. 제목: ");
		boardTemp[0] = sc.nextLine();
		System.out.print("2. 이름: ");
		boardTemp[1] = sc.nextLine();
		System.out.print("3. 등록일: ");
		boardTemp[2] = sc.nextLine();
		BoardBasic bb = new BoardBasic(boardTemp[0], boardTemp[1], boardTemp[2]);
		return bb;
	}
	private BoardNotice createBoardNotice() {
		BoardNotice bn = (BoardNotice) createBoardBasic();
		System.out.print("4. 첨부파일명: ");
		bn.setNoticeFile(sc.nextLine());
		return bn;
	}
	private BoardEvent createBoardEvent() {
		BoardEvent be = (BoardEvent) createBoardBasic();
		System.out.print("4. 이벤트 날짜: ");
		be.setEventDate(sc.nextLine());
		return be;
	}
	
	// 숫자 문자열을 int로 바꾸는 메서드 
	int stringToInt(String str) {
		try {
			return Integer.parseInt(str);
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
	}
	
}
