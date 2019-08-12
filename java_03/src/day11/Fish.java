package day11;

import day10.Animal;

public class Fish extends Animal {
	private String name;

	public Fish() {
		super("물고기");
	}
	public Fish(String name) {
		super("물고기");
	    this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	} 	
	public void fishPrint() {
		System.out.printf("[%s : %s] %n",kind,name);
	}
	
	//메소드 오버라이딩: 부모로 부터 물려 받은 기능을 다시 재정의 하는 것
	@Override //부모로 부터 받은 것 중에서 Error난 경우 찾아줌
	public void breath() { //부모의 선언부를 그대로 가져옴
		System.out.println(kind+" : 아가미로 숨쉬기 ~~~");
	}
	@Override
	public void print() {
		//1번) fishPrint();
		//2번) super.print();
		//2번) System.out.printf(" %s :  %n",name);
		this.fishPrint();
	}
}

