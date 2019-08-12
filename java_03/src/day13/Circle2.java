package day13;

public class Circle2 extends Shape implements Drawable {
	Point p; //has a 관계
	int r;
	public Circle2() {
		p = new Point(0,0);
	}

	public Circle2(Point p, int r) {
		super();
		this.p = p;
		this.r = r;
	}

	public Point getP() {
		return p;
	}

	public void setP(Point p) {
		this.p = p;
	}

	@Override
	public String toString() {
		return "Circle02 [p=" + p + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((p == null) ? 0 : p.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Circle2 other = (Circle2) obj;
		if (p == null) {
			if (other.p != null)
				return false;
		} else if (!p.equals(other.p))
			return false;
		return true;
	}

	@Override
	public void draw() {
		System.out.println(getClass().getName()+" draw~~~");
	}

	@Override
	double area() {
		return r*r*Math.PI;
	}
	
}
