package day08_ex;

public class BookMgr {
    private Book[] bookList;
    int count = 0;
    
    public BookMgr() {
    	this(10);
    	//bookList = new Book[10];
    }
    public BookMgr(int size) {
    	bookList = new Book[size];
    }
	public Book[] getBookList() {
		return bookList;
	}
	public void setBookList(Book[] bookList) {
		this.bookList = bookList;
	}
     
	public void addBook(Book book) {
		bookList[count] = book;
		count++;
	}
     
}
