package day21_ex;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// Book 만든후 BookMgr을 Collection 기반으로 바꾸어서 CURD 가 다 되도록 만든다.

public class BookMgr2 {

	Map<Integer,Book> map = null;
	public BookMgr2() {
		map = new HashMap<Integer,Book>();
	}
	public void addBook(Book book) {
		map.put(book.getIsbn(),book);
	}
	public void deleteBook(String title) {
		 Iterator<Integer> it = map.keySet().iterator();
		 while (it.hasNext()) {
			Integer isbn = it.next();
			Book data = map.get(isbn);
			if(data.getTitle().equals(title)) {
				System.out.println(data+" 삭제됩니다.");
				//map.remove(isbn);
				it.remove();
			}
		}
	}
	public void searchTitleBook(String title) {
		System.out.println("제목 "+title + " 검색 결과 ");
		Iterator<Integer> it = map.keySet().iterator();
        while (it.hasNext()) {
			Integer isbn = it.next();
			Book data = map.get(isbn);
			if (data.getTitle().toUpperCase().contains(title.toUpperCase())) {
				System.out.println(data);
			}
		} 
		System.out.println("----------------------------");
	}
	public void bookListPrint() {
		System.out.println("=========Book List  foreach 기반 ==========");
		map.forEach((k, v) ->System.out.println(v));
		System.out.println("=============================");
	}
}








