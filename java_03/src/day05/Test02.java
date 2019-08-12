package day05;

import java.util.Arrays;

public class Test02 {
	public static void main(String[] args) {
		
		int[] scores = {77,99,100,85,91};
		int[] sc = new int[scores.length*2]; //scores 사이즈를 2배만큼 만들고 싶을 때

		System.arraycopy(scores, 0, sc, 0, scores.length);// 2) 0번째부터,4) 0번째위치로
		//↑ 은행에서 계좌번호 입금하고 싶을 때(무엇인가 기능을 수행하고 싶을 때, 필요한 정보 입력) : 매개변수
		//↑ 모든 주소는 object라고 한다.                                                       
		System.out.println(Arrays.toString(scores));
		System.out.println(Arrays.toString(sc));
		
		String[] names = {"홍길동","박길동","고길동","최길동"};
		String[] ns = new String[names.length*2];

		System.arraycopy(names, 0, ns, ns.length-names.length, names.length); // 4)0번째 말고 원하는 위치 지정
		System.out.println(Arrays.toString(names));
		System.out.println(Arrays.toString(ns));
	}
}
