package day19;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Test04 {
	public static void main(String[] args) {
		// HashMap 구조를 이용하여  Employee 객체관리 
        Map<Integer, Employee> map = new HashMap<Integer, Employee>();
        
        map.put(2017002, new Employee(2017002, "김씨", "마케팅부"));
        map.put(2017009, new Employee(2017009, "김씨", "마케팅부"));
        map.put(2017012, new Employee(2017012, "홍씨", "영업부"));
        map.put(2018002, new Employee(2018002, "박씨", "마케팅부"));
        map.put(2019002, new Employee(2019002, "김씨", "영업부"));
        
        // 사원 조회 사번을 입력 하세요   2018002
        System.out.println(" 2018002 사번의 사원 조회 내역 ");
        System.out.println(map.get(2018002));
        
        //마케팅부 사원 목록 출력
        System.out.println(" 마케팅부 사원 목록 출력 ");
        Iterator<Integer> it =  map.keySet().iterator();
        while (it.hasNext()) {
			Integer num =  it.next();
			Employee emp = map.get(num);
			if(emp.dept.equals("마케팅부")) {
				System.out.println(emp);
			}
		}
        
        // 삭제 사번기준 삭제  2018002
        System.out.println(" 2018002 사번의 사원 삭제(퇴사처리) ");
        System.out.println("삭제 정보 : "+map.remove(2018002));
        System.out.println("2018002 사원 정보 => "+map.get(2018002));

        
	}
}




