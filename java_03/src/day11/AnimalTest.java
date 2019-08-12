package day11;

import day10.Animal;
import day10.Dog;

public class AnimalTest {
	public static void main(String[] args) {
		Animal d = new Dog("진돗개","쫑이");
		if(d instanceof Dog)((Dog)d).dogPrint(); //Dog타입으로 변화시킬 수 있는가?
		d.breath();
		
		Dog dd = (Dog) d;
		if(d instanceof Fish) {
			Fish ff = (Fish) d;
		}

		d.breath();
		
		Animal f = new Fish("구피");
		if(f instanceof Fish)((Fish)f).fishPrint();
		f.breath();//부모에게 물려받은게 맞지않음(물고기는 폐로 숨쉬지 않는다!) 
		((Fish)f).breath();
		
		
	}

}
