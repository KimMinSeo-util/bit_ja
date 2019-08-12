package day10_ex;

public class Prob10 {
	public static void main(String[] args) {
       
		Student  a =	new Student("홍길동", 20, 2012001);
		a.print();
		Teacher  t =new Teacher("이순신", 30, "JAVA");
		t.print();
		Employee e =new Employee("유관순", 40, "교무과");
		e.print();
		
	}
}


class Person{
	private String name;
	private int age;
	
	public Person() {
		super();
	}
	public Person(String name, int age) {
		super();
		this.name = name;
		this.setAge(age);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void printA() {
		System.out.printf("이름 : %s , 나이 : %2d ",this.name,this.age);
	}
	
	
}

class Student extends Person{
	private int id;
	
	public Student() {}
	public Student(String name,int age,int id) {
		super(name,age);
//		super.setName(name);
//		super.setAge(age);
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	} 
	public void print() {
        super.printA();
		System.out.printf("학번 : %s %n",id);
	}
}
class Teacher extends Person{
	private String subject;

	public Teacher() {
		super();
	}
	public Teacher(String name, int age,String subject) {
		super(name, age);
		this.subject=subject;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	public void print() {
        super.printA();
		System.out.printf("담당과목 : %s %n",subject);
	}
	
}
class Employee extends Person{
	private String dept;
	
	public Employee() {
		super();
	}

	public Employee(String name, int age) {
		this(name, age, null);
	}
	public Employee(String name, int age,String dept) {
		super(name, age);
		this.dept = dept;
	}
	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	public void print() {
        super.printA();
		System.out.printf("부서 : %s %n",dept);
	}
}



