package day08;

public class Card {
	final static int WIDTH = 100; //final: 더이상 수정 불가능함
	final static int HEIGHT = 250;
	String kind = "다이아몬드";
	int number;
	
	public static void main(String[] args) {
		// Card.width=0; 위에서 final을 사용하여서 에러가 난다
		System.out.println(WIDTH+" * "+HEIGHT);
		System.out.println(new Card().kind);
		//System.out.println(kind); 주소가 다르기 때문에 에러가 난다
	}
}
