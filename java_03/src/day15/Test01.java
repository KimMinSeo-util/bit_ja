package day15;

import day14.Circle;
import day14.Point;

public class Test01 {
	public static void main(String[] args) throws Exception {
		Point p1 = new Point(5,5);
		Point p2 = p1.clone(); //p1과p2는 다른주소(다른곳을 본다)
		
		Point p3 = p2;//p2와p3는 같은주소(같은 곳을 본다)
		
		p2.setX(0);//x자리에 0을 놓아라(set)
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);

		System.out.println("=============================================");

		Circle c1 = new Circle(new Point(7,7),2);
		Circle c2 = c1.clone(); //복제 가능하도록 만들어 보세요.
		c2.r=0;
		c2.p.setX(0);
		System.out.println(c1);
		System.out.println(c2);
		
	}


}
