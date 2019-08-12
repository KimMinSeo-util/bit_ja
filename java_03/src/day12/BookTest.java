package day12;

public class BookTest {
	public static void main(String[] args) {
			String msg1 = "hello";
			String msg2 = "hello";
			System.out.println(msg1.toString());
			System.out.println(msg1.equals(msg2));
			System.out.println(msg2);

			Book b1 = new Book("java",2200);
			Book b2 = new Book("java",2200);
			System.out.println(b1.toString());
			System.out.println(b1.equals(b2));
			System.out.println(b2);
			
			
			//msg1 = null;
			//System.out.println(b1.equals(msg1));
			
			b1.close();
			b2.close();
			b1=null;
			b2=null; //null을 하지 않으면 메모리 누수가 일어남(다쓰고 나면 null을 써야한다)
			
			//System.gc(); //강제호출: 메모리 정리를 해라
			
			System.out.println("=== main end ===");
			
	}
			
}
	
