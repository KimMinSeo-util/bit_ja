package day07;

public class CalcTest {
	public static void main(String[] args) {
		//static은 new를 하지 않아도 메모리에 뜬다 = 따로 객체 생성할 필요가 없다. static을 사용해서 아래가 더이상 쓸일이 없어진다.
		//주소가 없어지므로 (Calc.add)를 써준다.
		//Calc c1 = new Calc();	
		//Calc c2 = new Calc();	
		//Calc c3 = new Calc();	
		//Calc c4 = new Calc();	
		Calc c1 = new Calc();
		System.out.println(c1.add(11, 99));
		
		System.out.println(Calc.sub(11, 99));
		System.out.println(Calc.multi(11, 99));
		System.out.println(Calc.divide(11, 99));

	}
	
}
