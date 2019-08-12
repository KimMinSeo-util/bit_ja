package day13;

public class SigletonTest {
	public static void main(String[] args) {
		// Singleton s1 = new Singleton();
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		Singleton s3 = Singleton.getInstance();

	}
}

class Singleton {
	private static Singleton s = new Singleton();

	private Singleton() { // private 외부에서 객체생성 불가능
		System.out.println("Singleton() 생성");
	}

	public static Singleton getInstance() {
		return s;
	}
}