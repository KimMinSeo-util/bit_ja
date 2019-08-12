package day11;

public class Test02 {

	public static void main(String[] args) {
		//is a
		Person[] p = {  new Student("홍길동", 20, 200201),
						new Teacher("이순신", 30, "JAVA"),
						new Employee("유관순", 40, "교무과")
		};

		for (Person data :p) {
			// data.printA(); //부모Person() 영역의 자원을 접근할 때는 바로 접근가능
			System.out.println();
		}
		System.out.println("=============================================");
		
		for (Person data :p) {
			//자식 영역의 자원을 접근할때는 다운 캐스팅 필요
			//반드시 하단부에 어떤 객체가 바인딩 되어 있는지 타입 체크 필요
			//<과제> 캐스팅없이 동작하도록
//			if(data instanceof Student) ((Student)data).print();
//			if(data instanceof Teacher) ((Teacher)data).print();
//			if(data instanceof Employee) ((Employee)data).print();

		}
	}
}
