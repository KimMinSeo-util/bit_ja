package day03_ex;

import java.util.Scanner;

public class BookApp {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String cmd = null;
		while (true) {
			System.out.println("*******  명령 선택   ********");
			System.out.println("                  ");
			System.out.println("1. insert(등록) \n");
			System.out.println("2. delete(삭제) \n");
			System.out.println("3. update(수정) \n");
			System.out.println("4. quit(종료)   \n");
			System.out.println("**************************** \n\n");
			System.out.println("수행할 명령을 선택하세요! ");
			System.out.print("1 2 3 4 중 하나를 선택하세요.. _ ");

			cmd = scanner.nextLine().trim();

			switch (cmd.trim()) {  //문자열의 공백 제거
			case "1":
				System.out.println("insert 작업을 수행하는 기능 호출");
				break;
			case "2":
				System.out.println("delete 작업을 수행하는 기능 호출");

				break;
			case "3":
				System.out.println("update 작업을 수행하는 기능 호출");

				break;
			case "4":
				System.out.println("정말 종료 하려면 q/Q 를 입력하세요");
				String quit =  scanner.nextLine().trim();
				if(quit.equals("q") || quit.equals("Q") ) {
					System.out.println("App 종료");
					scanner.close();
					scanner=null;
					//return; //현재의 함수 종료 의미
					System.exit(0); // App 종료 
				}
				break;
			default:
				System.out.println("다시입력하세요 _ ");
				break;
			}

			System.out.println("=======================================");
		}
	}
}
