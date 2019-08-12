package day06_ex;

public class Animal {
	boolean live;
	int age;
	String name;
	
	public boolean isLive() {
		return live;
	}
	public void setLive(boolean live) {
		this.live = live;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void print() {
		System.out.println(name+": "+age+": "+live );
	}
	public static void main(String[] args) {
	       Animal a = new Animal();
	       a.name ="~~~";  //instance varable
		   a.print();      //instance method
	} 
}




