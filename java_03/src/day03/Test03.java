package day03;

import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) {

		int jumsu;
		// 키보드로부터 점수 입력 받는다.

		Scanner input = new Scanner(System.in); // input자리는 아무거나 써도 상관없다.
		System.out.println("점수를 입력하세요");

		// jumsu = input.nextInt();//99까지 읽는다.
		// input.nextLine(); //뒤에 있는 데이터가 다 사라진다. //99뒤에 엔터부터 시작한다.

		jumsu = Integer.parseInt(input.nextLine()); //= nextLine에 들어가는 값"90" 따라서 최종들어가는 수는 jumsu = 90;
	
		input.close();
		input = null; //main함수는 종료한다. 따라서 더이상 키보드는 사용하지 않는다.
		
		// 유효성 검사
		if (!(jumsu >= 0 && jumsu <= 100)) {
			System.out.println("유효하지 않은 점수 입니다.");
			return; //현재 수행중인 함수를 종료하고 호출한 자리로 돌아가는 문장
		}

		/*
		 * if( jumsu >= 80 ) { System.out.println("Pass"); }else {
		 * System.out.println("No Pass"); }
		 */

		// 삼항 연산으로 처리
		String result = jumsu >= 80 ? "Pass" : "No Pass";
		System.out.println("점수: " + jumsu + " : " + result);
		
		//A,B,C,D,F 등급처리
		
		String grade = "F";
		if(jumsu >= 90) {
		 grade = "A";
		}else if(jumsu>=80){
			grade = "B";
		}else if(jumsu>=70){
			grade = "C";
		}else if(jumsu>=60){
			grade = "D";
		}
      //System.out.println("점수 :" + jumsu + " : " + result+":"+ grade+"등급");
		System.out.printf("점수 :%s : %s : %s 등급 %n", jumsu,result,grade);
		
		//<과제>삼항연산자로처리
		System.out.println(jumsu >=90? "A": (jumsu >=80? "B":(jumsu >=70? "C":jumsu >=60? "D": "F")));
		// 등급 처리 switch로
		System.out.println("*******등급 처리 switch*******");
		char c = ' ';

		switch (jumsu/10)//jumsu를 10으로 나누었을 때 몫을 통해서 등급을 나눈다. 
		{
		case 10:
		case 9:
			c='A';
			break;
		case 8:
			c='B';
			break;
		case 7:
			c='C';
			break;
		case 6:
			c='D';
			break;
		default:
			c='F';
			break;
		}
		
		System.out.println(jumsu+":"+c);
		return; //생략되어 있다. 
		/*
		 * if(!( jumsu >= 80) ) { System.out.println("No Pass"); }
		 */
		/*
		 * if(jumsu <80) { System.out.println("No Pass"); }
		 */
	}

}
