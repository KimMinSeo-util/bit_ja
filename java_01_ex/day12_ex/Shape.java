package day12_ex;

public abstract class Shape {
	private String name;
	protected double area;

	public Shape() {	}

	public Shape(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public abstract void calculationArea();
	public void print() {
		System.out.println(name+" 의 면적은 "+area);
	}
}
