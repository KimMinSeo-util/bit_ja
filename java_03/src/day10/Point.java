package day10;

public class Point { //그룹으로 묶어주기위해
		int x;
		int y;
		
		public Point() {
			super();
		}
		
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
		
		public void print() {
			System.out.printf("Point(x:%2d,y:%2d)%n",x,y);
		}
	}