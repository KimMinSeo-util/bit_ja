package day04;

import java.util.Arrays;

public class Test04 {
	public static void main(String[] args) {
		// Array : 같은 타입의 기억공간을 하나의 타입으로 연결하는 것 
		
		int[] scores; //배열 선언 scores뒤에 와도 상관없다.
		scores = new int[5]; //배열생성. int타입으로 10개의 방을 생성하세요(new)
				
		for(int i=0; i<5 ;i++) {
		System.out.print(scores[i]+"    ");
		}
		System.out.println();
		
		String[] names = new String[5];
		for(int i =0; i<5 ; i++) {
		System.out.print(names[i]+"   ");
		}
		System.out.println("\n============================");
	
		scores[0] = 99;
		scores[1] = 100;
		scores[2] = 69;
		scores[3] = 79;
		scores[4] = 89;
		
		names[0] = "홍길동";
		names[1] = "고길동";
		names[2] = "박길동";
		names[3] = "김길동";
		names[4] = "강길동";
		
		double avg = 0.0;
		double sum = 0;
		for(int i=0; i< scores.length ;i++) {
			sum += scores[i];
		}
		avg = sum/scores.length;
		
		System.out.println(Arrays.toString(scores));
		System.out.println(Arrays.toString(names));
		
		System.out.println("평균 : "+avg);
		System.out.println("==================================");
		
		// 결과: 홍** 99점 평균이상
		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i].charAt(0)+"**  "+scores[i]+(scores[i] >=avg?"   평균이상" :"   평균미달" ));
			
		}
		
	}
}

