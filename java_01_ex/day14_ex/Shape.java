package day14_ex;

public abstract class Shape {
	private int numSides;
    
	public Shape(int numSides) {
		super();
		this.numSides = numSides;
	}

	public int getNumSides() {
		return numSides;
	}

	public void setNumSides(int numSides) {
		this.numSides = numSides;
	}
	abstract double getArea();
}

interface Resizable {
	void resize(double s);
}

class RecTriangle extends Shape {
	 private double width;
	 private double hight;
	
	 public RecTriangle( double width, double hight) {
		super(3);
		this.width = width;
		this.hight = hight;
	 }

	double getArea() {
	   return width*hight*1/2;	 
	 };

}

class Rectangle extends Shape implements Resizable {
	private double width;
	private double hight;
	
	public Rectangle( double width, double hight) {
		super(4);
		this.width = width;
		this.hight = hight;
	}

	@Override
	public void resize(double s) {
        width *= s;
        hight *= s;
	}

	@Override
	double getArea() {
		// TODO Auto-generated method stub
		return width*hight;
	}
	
	
	
}






