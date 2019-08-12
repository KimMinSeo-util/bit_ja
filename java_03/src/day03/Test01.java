package day03;

public class Test01 {
	public static void main(String[] args) {
		// == : 기본형의 값이 같은지 비교(주소형일 경우) 주소가 같아서 그 자리에서 비교가능
		// equals() : 참조형 데이터가 같은지 비교, 데이터는 같지만 주소가 다르다.
		
		int num1 = 99;
		int num2 = 99;
		
		String name1 = "홍길동";
		String name2 = "홍길동";
		
		String msg1 = new String("Hello");
		String msg2 = new String("Hello java");
		
		
		System.out.println("num1==num2 => "+ (num1==num2)); //산술연산자 먼저 처리 그다음 비교연산자 //괄호를 넣어서 먼저계산할 연산자를 정할 수 있다
		
	  //System.out.println("name1==name2 => "+(name1==name2)); 
		System.out.println("name1==name2 => "+name1.equals(name2)); //String은 reference가 맞기때문에 .equals사용한다
		
		System.out.println("msg1==msg2 => "+(msg1.equals(msg2)));
		
		msg1 = msg2; //대입문, msg1에 들어가던 주소가 msg2를 가르키게 되므로 원래 msg1에 있던 것은 garbage대상에 들어간다.
		
		
	}

}
