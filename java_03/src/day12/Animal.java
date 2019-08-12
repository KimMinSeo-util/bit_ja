package day12;

public abstract class Animal {
	protected String kind = "동물의 종류"; //protected: 다른패키지에 있어도 상속받은 애까지 가능 ->Dog클래스가 이사해도 에러안남(kind접근가능)

	public Animal() {    } //기본생성자
	public Animal(String kind) { //parameter 1개짜리 생성자
		super();
		this.kind = kind;
	}

	public String getKind() {
		return kind;
	}

	public void setkind(String kind) {
		this.kind = kind;
	}
	public abstract void breath();
	public void print() {
		//System.out.println(kind);
		System.out.printf("Animal kind : %s",kind);
	}
	
	}
	

