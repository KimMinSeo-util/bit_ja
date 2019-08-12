package day11;

public class AnimalTest01 {
	public static void main(String[] args) {
		
		Animal a1 = new Animal(); //디폴트로 생성
		a1.breath();
		
		Animal a2 = new Animal("Dog"); 
		a2.breath();
		
		Animal a3 = new Animal("고양이"); 
		a3.breath();
		
		//Dog d1 = new Dog();
		Dog d1 = new Dog("시베리안허스키","케리");
		d1.breath();
		d1.dogPrint();
		Dog d2 = new Dog("Dog","진돗개","쫑이");
		d2.dogPrint();
		
		String animalKind = d2.getSuperKind(); //static영역에서는 super,this 사용불가
		System.out.println(animalKind);
		
	}

}
