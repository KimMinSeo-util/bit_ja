package day11;

import day10.Animal; //다른 패키지에 있을 경우 써준다~(Error나면 자동으로 나옴)
import day10.Dog;

public class AnimalTest2 {
	public static void main(String[] args) {
		Animal[] animals = { 
				new Dog("진돗개", "쫑이"), 
				new Fish("구피"), 
				new Dog("시베리안허스키", "케리"), 

			};
		
//		for (Animal data : animals) {
//			data.breath();
//			data.print();//1)Animal 타입이므로 Animal에 print가 있어야 한다. 
			             // 2)자식class에서 각각 print를 만들어서  Dog 또는 fish에 맞게 출력하도록 한다.
//		}
		Dog a1 = new Dog("진돗개","쫑이");
		Fish f1 = new Fish("구피");
		callD(animals[0]); //아래 callD에 Dog타입만 썻기때문에 dog만 가능//아래 Fish d 쓴 후에는 가능하다
		callD(animals[1]);
	}
	//메세지 오버로딩 부분
	public static void callD(Animal d) {
		d.breath();
	}
//	public static void callD(Dog d) {
//		d.breath();
//	}
//	public static void callD(Fish d) {
//		d.breath();
//	}
}
