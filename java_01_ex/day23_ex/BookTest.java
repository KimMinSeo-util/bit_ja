package day23_ex;

public class BookTest {
	public static void main(String[] args) {
		BookMgr bookMgr = new BookMgr();

//		bookMgr.add(new Book("java", 900) );
//		bookMgr.add(new Book("jsp", 2900) );
//		bookMgr.add(new Book("dbp", 200) );
//		
		
//		bookMgr.save();
		
		bookMgr.getBookList().forEach(i -> System.out.println(i));
		
		//bookMgr.add(new Book("~~~~~", 0));
		
		bookMgr.save();
	}
}
