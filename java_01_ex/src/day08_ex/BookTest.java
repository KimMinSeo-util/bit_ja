package day08_ex;

import java.util.Arrays;

public class BookTest {
	public static void main(String[] args) {
        BookMgr mgr = new BookMgr(5);
        
        
        System.out.println(Arrays.toString(mgr.getBookList()));
        
//        for(Book data :mgr.getBookList()) {
//        	System.out.println(data);
//        }
        
        
	}
}
