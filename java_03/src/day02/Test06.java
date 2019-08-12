package day02;

public class Test06 {
	public static void main(String[] args) {
		
		int num = 100;
		
		System.out.println(++num);
		System.out.println(num);
		
		System.out.println(6%4); //나머지
		
		int x = 100, y = 100;
		System.out.println(x>y);
		System.out.println(x>=y);
		System.out.println(x!=y);
		
		int score = 99;
		
		//boolean result = 0<= score & score <= 100;
		boolean result = 0<= score && score <= 100;
		System.out.println("score 유효성 검증 결과 : "+result);
		
		System.out.println(3&4);
		//3은 00011
		//4는 00100
		//두개의 합은 00000
		System.out.println(3|4); //or연산
		//3은 00011
		//4는 00100
		//00111

		System.out.println(4<<2);
		// 이진수4: 00000100 -> 0010000 4->16
		System.out.println(16>>2);
		// 이진수16: 0010000 -> 0000100 16->4
	}

}
