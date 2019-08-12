package day04;

import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		System.out.println("알파벳 아스키 코드 값 확인");
		
		char a = 'a', b='A';
		
		for(int i=0; i<26 ;i++) {
		System.out.println(a+": "+(int)a++ +" , "+b+": "+(int)b++);
		}
		System.out.println("============================\n");
		/*
		 * 변수 ch에 저장된 문자가 대문자인 경우에만 소문자로 변경하는 코드를 완성합니다.
		 */
		Scanner scanner = new Scanner(System.in);
		System.out.println("문자열을 입력하세요");
		String msg = scanner.nextLine();
		
		for(int i1 = 0; i1<msg.length(); i1++) {
		char ch = msg.charAt(i1);
		char s = (ch>='A' && ch <='Z') ? (char)(ch+32) : (ch>='a' && ch <='z') ?(char)(ch-32): ch ; //<과제> 소문자->대문자, 대문자->소문자 (삼항연산자)	
		//System.out.print(ch +" => " +s);
		System.out.print(s);
		}

		
	}
 }
