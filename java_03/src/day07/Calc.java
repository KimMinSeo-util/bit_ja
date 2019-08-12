package day07;

public class Calc {
	//class 변수
	static int data=0; 
	
	//static은 new를 하지 않아도 메모리에 뜬다 = 따로 객체 생성할 필요가 없다.
	//class method
	public static long add(int a, int b) {
	   System.out.println(Calc.data);
	   System.out.println(Math.random());
	   return a+b;
	}
	
	public static long sub(int a, int b) {
		return a-b;
	}
	
	public static long multi(int a, int b) {
		return a * b;
	}
	
	public static long divide(int a, int b) {
		if(b==0) return 0;
		return a/b;
	}
	
}

