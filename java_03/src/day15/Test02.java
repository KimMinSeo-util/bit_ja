package day15;

public class Test02 {
	public static void main(String[] args) {
		// A a = new A();
		// a.p();

		A.B b = new A().new B();
		b.print();
		
		//A.C c = new A().new C();
		//c.print();
		
		A.C.print();
		
	}
}

//inner class부분
class A {
	String name = "A";
	public A() {}
	public A(String name) {
		super();
		this.name = name;
	}
	void p() {
		System.out.println("A에서 호출");
		new B().print();
	}

	// has a관계 //extends A하면 is a관계
	class B {
		String name = "B";

		// A a;
		// String name = "B";
		void print() {
			System.out.println(this.name);
			System.out.println(A.this.name);
		}
	}
	static class C {
		static void print() {
			System.out.println("~~~~~~~~~~");
		}
	}
	class D{
		void p() {
			class E{
				
			}
		}
	}

}
