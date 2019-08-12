package day14_ex;

public class ShapeTest {
	public static void main(String[] args) {

		Shape[] shapes={
				new Rectangle(5,6),
				new RecTriangle(6,2)
				};
		
		for(Shape data:shapes) {
			System.out.println("area : "+data.getArea());
			if(data instanceof Resizable) {
				((Resizable) data).resize(0.5);
				System.out.println("new area : "+data.getArea());
				
			}
		}
	}
}
