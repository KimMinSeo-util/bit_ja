package day14;

public class Test01 {
	public static void main(String[] args) {
		Circle c1 = new Circle(new Point(4,4),3);
		//주석처리한 부분 = Shape배열 부분
		//System.out.println(c1);
		//c1.move(1);
		//System.out.println(c1);
		//c1.draw();
		
		Rectangle r1 = new Rectangle(new Point(11,11),3,7);
		//System.out.println(r1);
		//r1.move(3);
		//System.out.println(r1);
		//r1.draw();
		
		Shape[] shapes = {c1,r1};
		for (Shape data : shapes) {
			System.out.println(data.area());
			data.move(1);
			data.draw();
			System.out.println(data);
		}
	}

}
