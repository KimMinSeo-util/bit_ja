package day06;

public class Test04 {
	public static void main(String[] args) {
		Employee emp1 = new Employee();
		emp1.setAge(32);
		emp1.setName("최길동");
		emp1.setDept("인사부");
		
		Employee emp2 = new Employee();
		emp2.setAge(31);
		emp2.setName("홍길동");
		emp2.setDept("인사부");
		
		Employee emp3 = new Employee();
		emp3.setAge(28);
		emp3.setName("고길동");
		emp3.setDept("영업부");
		emp3.setSingle(true);
		
		Employee emp4 = new Employee();
		emp4.setAge(27);
		emp4.setName("김길동");
		emp4.setDept("영업부");
		
		Employee[] emp = {emp1,emp2,emp3,emp4}; //모아서 한꺼번에 관리해 주는 것
		System.out.println("== 영업부에 근무하는 사원 목록 ==");
		double sum =0;
		int count=0;
		
		for(Employee data : emp) {
			//System.out.println(data.getDept());
			if(data.getDept() !=null && data.getDept().equals("영업부")) {//영업부에 있는 사람만 알려줘
				sum += data.getAge();
				count++;
				data.display();
			} // for(int i=0; i<emp.length; i++){
			 // if(emp[i].get!=null && emp[i].getDept().equals("영업부")			 
			 // sum += emp[i].getAge();
		    //   }
		}
	
		System.out.printf("영업부 평균나이 = %.2f %n",sum/count);
		System.out.println("== Single인 사원 목록 ==");
		for (int i = 0; i < emp.length; i++) {
			//System.out.println(emp[i].isSingle());
			if (emp[i].isSingle()) {
			emp[i].display();
			}

		}
	}

}
