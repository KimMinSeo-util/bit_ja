package day23_ex;

import java.util.ArrayList;
import java.util.List;

public class BookMgr {
	//Book[] 관리 
	List<Book> list = null;
	String fileName;
	
	BookMgr(){
		this("book.dat");
	}
	BookMgr(String fileName){
		this.fileName = fileName;
		list = (List<Book>) MyFile.load(fileName);
		if(list == null) {
			list = new ArrayList<Book>();
		}
		Thread t1 = new AutoSave();
		t1.start();
	}
	
	//CURD
	
	public void add(Book data) {
		list.add(data);
	}
	
	public List<Book> getBookList() {
		return list;
	}
	
	
	public void save() {
		MyFile.save(fileName, list);
	}
	
	class AutoSave extends Thread{
		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(1000*60*2);
				} catch (Exception e) {
					// TODO: handle exception
				}
				save();
				System.out.println("AutoSave() ~~~ ");
				
			}
			
		}
	}
}















