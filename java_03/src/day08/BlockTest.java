package day08;

public class BlockTest {
	public static void main(String[] args) {
		Block b1 = new Block();
		b1.print();
		Block b4 = new Block();
		b4.print();
	}	
}
//우리가 하는 일 들을 생성자 함수에 반복적으로 하는일들을 이곳으로 꺼낼 수 있다.
class Block{
	int i;
	int j;
	static String name;
	static{ //한번만 수행
		//System.out.println("static  {    }");
			name = "~~~";
	}
	
	{
		//System.out.println("{     }");
		this.j = 99;
	}
	public Block() {
		//this.j=99;
		//System.out.println("생성자");
	}
	public Block(int i) {
		this.j =99;
		this.i = i;
		//system.out.println("생성자");
	}
	public void print() {
		System.out.printf("i=%s , j=%s,name=%s %n",i,j,name);
	}
}
