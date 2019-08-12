package day02;

import java.util.Scanner;

public class Test05 {
	public static void main(String[] args) {
		
		//System.out.printf("",name,score); 초기화가 안돼서 생기는 에러
	
		Scanner input = new Scanner(System.in);
		
		System.out.println("학생 이름을 입력하세요:_");
		String name = input.nextLine();
		
		System.out.println("점수를 입력하세요:ex)90");
		int score = input.nextInt();
		
		System.out.printf("이름 : %s,점수 : %d %n",name,score);
		
		input = null;
	}

}
