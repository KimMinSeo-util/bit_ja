package day08;

/**
 * 
 * @author kms
 * @since 2019 07월16
 * @version 1.0
 *
 */
public class Employee {
	static String cName = "BIT";
	private String name;
	private String dept;
	private boolean single;

	public Employee() { //디폴트(기본)생성자
		this("사원이름","OOO부서",true); //나의 또다른 생성자 함수
		// 초기화 작업을 주로합니다.
		//System.out.println("Employee() call");
		//this.name = "사원이름";
		//this.dept = "OOO 부서";
		//this.single = true;
	}
	
	public Employee(String name, String dept) { //single정보 안써도 에러가 안난다
		//super(); 여기서는 에러 first statement만 가능함 this()도 first statement만 가능하기때문에 같이 있으면 에러가 난다
		this(name,dept,false);
		//System.out.printf("Employee(%s,%s) call%n", name,dept);
		//this.name = name;
		//this.dept = dept;
	}
	
	public Employee(String name, String dept, boolean single) { 
		//System.out.printf("Employee(%s,%s,%s) call%n", name,dept,single);
		super();
		this.name = name;
		this.dept = dept;
		this.single = single;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public boolean isSingle() {
		return single;
	}

	/**
	 * 
	 * @param single 미혼인지 ?
	 */
	public void setSingle(boolean single) {
		this.single = single;
	}

	/**
	 * Employee 정보출력
	 */
	public void print() {
		//System.out.println("화사명: "+cName);
		System.out.printf("[사원명:%s ,근무부서:%s ,single:%b]%n",
								this.getName(), getDept(), single);
	}

}
