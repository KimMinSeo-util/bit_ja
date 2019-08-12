package day11;

public class Dog extends Animal { //앞에 클래스에서 이미 만들었으므로 그대로 가져온다(상속받음)
	private String kind = "강아지 종류";
	private String name= " 강아지 이름";
	
	public Dog() {
		super("강아지과");  //super(): 앞 문장과의 차이점 부모가 Animal의 기본생성자 호출문장, super("Dog")Animal의 parameter1개짜리 생성자
	}
	public Dog(String kind, String name) {
		super("강아지과");
		this.kind = kind;
		this.name = name;
	}
	public Dog(String superkind,String kind, String name) {
		super(superkind);
		//super.kind = superkind;
		this.kind = kind;
		this.name = name;
	}
	
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void dogPrint() {
		System.out.printf("[%s:%s:%s]%n",super.kind,this.kind,this.name);
	}
	
	public String getSuperKind() {
		return super.kind;
	}
	@Override
	public void print() {
		//1번)dogPrint();
		//2번)super.print();//나는 부모가 가지고 있던 print에
		//2번)System.out.printf("   %s : %s %n",kind,name);//자식이 갖고 있는 것을 추가하겠다.
		this.dogPrint();
	}
}
