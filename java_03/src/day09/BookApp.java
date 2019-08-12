package day09;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class BookApp {
	public static void main(String[] args) {
		BookMgr mgr = new BookMgr(10);
		
		Scanner scanner = new Scanner(System.in);
		String cmd =null;
		while(true) {
		System.out.println("*******    명령 선택    *******");
		System.out.println("                   ");
		System.out.println("1. insert(등록) \n");
		System.out.println("2. delete(삭제) \n");
		System.out.println("3. 목록 출력 \n");
		System.out.println("4. quit(종료) \n");
		System.out.println("*************************** \n\n");
		System.out.println("수행할 명령을 선택하세요! ");
		System.out.println("1 2 3 4 중 하나를 선택하세요.. _ ");
		
		cmd = scanner.nextLine();

		switch (cmd.trim()) {
		case "1":
			System.out.println("insert 작업을 수행하는 기능 호출");
			System.out.println("Book title 입력하세요");
			String title = scanner.nextLine();
			System.out.println("Book price 입력하세요");
			int price = scanner.nextInt();
			scanner.nextLine();
			mgr.addBook(new Book(title, price));
			break;
		case "2":
			System.out.println("delete 작업을 수행하는 기능 호출");
			System.out.println("Book title 입력하세요");
			title = scanner.nextLine();
			mgr.deleteBook(title);
			break;
		case "3":
			System.out.println("목록 출력 작업을 수행하는 기능 호출");
			mgr.bookListPrint();
			break;
		case "4":
			System.out.println("정말 종료 하려면 q/Q 를 입력하세요");
			String quit = scanner.nextLine().trim();
			if (quit.equals("q") || quit.equals("Q")) {
				System.out.println("App 종료");
				scanner.close();
				scanner=null;
				System.exit(0);
			}
			break; 
		default:
			System.out.println("다시 입력하세요 _ ");
			break;
		}
		System.out.println("====================================================");
	}
	}
}
