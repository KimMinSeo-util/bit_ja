package day09;

public class BookMgr {
	private Book[] bookList;
	int count = 0;

	public BookMgr() {
		this(10);
	}

	public BookMgr(int size) {
		bookList = new Book[size];
	}

	public void setBookList(Book[] bookList) {
		this.bookList = bookList;
	}

	public void addBook(Book book) {
		if (count == bookList.length) {
			Book[] copy = new Book[bookList.length * 2];
			System.arraycopy(bookList, 0, copy, 0, bookList.length);
			bookList = copy;
		}
		bookList[count] = book;
		count++;
	}

	public void bookListPrint() {
		System.out.println("================Book List ================");
		for (int i = 0; i < count; i++) {
			bookList[i].print();
		}
		System.out.println("총"+count+" 권");
		System.out.println("================================");

	}
	public int bookTotalPrice() {
		int sum =0;
		for (int i = 0; i < count; i++) {
			sum += bookList[i].getPrice();
		}
		return sum;
	}
	public void deleteBook(String title) {
		int sb = searchBook(title);
			if (sb == -1) {
				System.out.println("삭제할 수 없습니다.");
			}
			else { 
				System.out.println("삭제되었습니다.");
				for (int i = sb; i < count-1; i++) {
					bookList[i] = bookList[i+1];
				}
					bookList[count-1] = null;
					count--;
				//bookList[sb] = bookList[sb+1];
				//bookList[sb+1] = bookList[sb+2];
			}
		for (int i = 0; i < count; i++) {
			bookList[i].getTitle();
			title.equals(bookList[i].getTitle());
			
		}
	}//toUppercase() : 대소문자전환해준다.
	public int searchBook(String title) {
		for (int i = 0; i < count; i++) {
			bookList[i].getTitle();
			title.equals(bookList[i].getTitle());
			if(title.equalsIgnoreCase(bookList[i].getTitle())) {//equalsIngnoreCase: 대소문자관계없다.
				return i;
			}
		}
			return -1;
	}
}
