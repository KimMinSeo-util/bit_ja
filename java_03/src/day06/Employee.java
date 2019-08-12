package day06;

public class Employee {
	//데이터(변수//명사)+기능(메소드//동사)
	private String name; //기본 String name일 때 : 같은 패키지에 있어야 접근가능, 패키지를 이동할경우 접근 X//public:어디서든 접근가능// private:같은 class에 있어야 접근가능
	private String dept;
	private int age;   //201901(가정한다)
	
	private boolean single;
	
	public void display() { /*return 뒤에 데이터(값)가 없는게 void. 그냥 돌아가는 것*/
		System.out.printf("[나이:%-10s, 이름:%-10s, 부서:%-10s, 싱글:%b ]%n"
				    					,getAge(),this.getName(),this.getDept(),this.isSingle());
		//member자원에 접근할 때 this사용
		//-옵션은 왼쪽으로 정렬시켜준다
		return;
	}
	
		public void setAge(int age) {
			if (!(age>0 && age <=100)) {
				System.out.println("age(나이) 정보가 올바르지 X");
				return;
			}
			this.age = age;
			return;
		}
		public int getAge() {
			return age;
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

		public void setSingle(boolean single) {
			this.single = single;
		}
		
		
}