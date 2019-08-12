package day21_ex;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

// Book 만든후 BookMgr을 Collection 기반으로 바꾸어서 CURD 가 다 되도록 만든다.

public class BookMgr {

	List<Book> list = null;

	public BookMgr() {
		//list = new LinkedList<Book>();
		//list = new Vector<Book>();
		list = new ArrayList<Book>();
	}

	public BookMgr(List<Book> list) {
		this.list = list;
	}

	public boolean addBook(Book book)  {
		  return list.add(book);
	}
	public void deleteBook(String title) {
		Iterator<Book> it = list.iterator();
		while (it.hasNext()) {
			Book data = it.next();
			if(data.getTitle().equals(title)) {
				System.out.println(data+" => 삭제됩니다.");
				it.remove();
			}
		}
	}
	public List<Book> searchTitleBook(String title) {
		List<Book> slist = new ArrayList<Book>();
		Iterator<Book> it = list.iterator();
		while (it.hasNext()) {
			Book data = it.next();
			if (data.getTitle().toUpperCase().contains(title.toUpperCase())) {
				slist.add(data);
			}
		}
		return slist;
	}
	public List<Book> bookList() {
		return list;
	}
}









