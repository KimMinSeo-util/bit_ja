package day08;

public class P164_Test {

	public static void main(String[] args) {
		System.out.println(Count.count);
		System.out.println("강사님....오늘 제발plz 과제 쉬운거로 내주세요>▼<");
		Count c1 = new Count();
		Count c2 = new Count();
		Count c3 = new Count();
		Count c4 = new Count();

	}

}

	class Count {
		int c;
		static int count; // 클래스변수 선언
		public Count() {
			c++;
			count++;
	}
}
