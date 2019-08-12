package day07;
/**
 * 
 * @author kms
 * @since 2019 07월16
 * @version 1.0
 *
 */
public class Employee {
		private String name;
		private String dept;
		private boolean single;

		public Employee() {
			//초기화 작업을 주로합니다.
			System.out.println("Employee() call");
			name = "사원이름";
			dept = "OOO 부서";
			single = true;
			
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
		System.out.printf("[사원명:%s ,근무부서:%s ,single:%b]%n",this.getName(),getDept(),single);
		
		}
		
}
