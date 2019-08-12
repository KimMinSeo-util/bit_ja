package day18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class Test03 {
	public static void main(String[] args) {
		Student[] s = new Student[10];
		Student[] sss= {
				new Student("홍순이", 88, 99),
				new Student("차순이", 82, 93),
				new Student("고순이", 80, 91),
				new Student("홍길동",100, 100)
		};
		Arrays.sort(sss);   // 배열 sort
		
		Vector<Student> list = new Vector<Student>(5,10); // 내부에 Student[] 만들어서 관리
		System.out.println("capacity :"+list.capacity());
		System.out.println("size :"+list.size());
		list.add(new Student("홍순이", 88, 99));
		list.add(new Student("차순이", 82, 93));
		list.add(new Student("고순이", 80, 91));
		
		System.out.println("-------------------------------");
		System.out.println("capacity :"+list.capacity());
		System.out.println("size :"+list.size());
		
		
		//System.out.println(list);
		Iterator<Student> it = list.iterator();
		while(it.hasNext()) {
			Student data = it.next();
			if(data.getAvg() >= 90)	System.out.println(data);
		}
		
		// equals() 오버라이딩 되어 있어야 동작.
		System.out.println(list.contains(new Student("고순이", 80, 91))); 

		//C U R D 
		// 홍길동 90 90  등록 
		Student s1 = new Student("홍길동",90, 90);
		boolean flag =  list.add(s1);
		
		if(flag) System.out.println(s1+" 등록되었습니다.");
		else System.out.println(s1+" 등록되었습니다.");
		
		//홍길동 100 100 으로 수정
		it = list.iterator();
        while (it.hasNext()) {
			Student data = it.next();
			if(data.name.equals("홍길동")) {
			   //data.name="홍길동";
			   data.ko=100;
			   data.math=100;
			   data.setAvg();
			   System.out.println(data+" 수정되었습니다.");
			}
		} 		
		
		//list 목록 출력
        System.out.println(" ***** 학생 LIST 정보 출력    **** ");
		it = list.iterator();
        while (it.hasNext()) {
			Student data = it.next();
			System.out.println(data);
		}
        
        //s1 삭제 처리
        System.out.println(" ***** 학생 "+ s1 +"정보삭제    **** ");
        it = list.iterator();
        while (it.hasNext()) {
			Student data = it.next();
			if(data.equals(s1)) {
				it.remove();
				System.out.println(s1+" 삭제 되었습니다.");
			}
		}
        
		Collections.sort(list);     //Collect Sort  수행 
        
      //list 목록 출력
        System.out.println(" ***** 학생 LIST 정보 출력    **** ");
		it = list.iterator();
        while (it.hasNext()) {
			Student data = it.next();
			System.out.println(data);
		}

	}
}

