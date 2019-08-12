package day06;

public class Test03 {
	public static void main(String[] args) {
		//int num;
		//String name;
		Employee emp1 = new Employee(); 
		emp1.display();
		
		Employee emp2 = new Employee();
		//emp2.age=201901;
		emp2.setAge(31);
		emp2.setName("홍길동");
		emp2.setDept("인사부");
		emp2.display();
		
		Employee emp3 = new Employee();
		//emp3.age=201902;
		emp3.setAge(27);
		emp3.setName("고길동");
		emp3.setDept("기술부");
		emp3.setSingle(true);
		emp3.display();
		
	}
}
