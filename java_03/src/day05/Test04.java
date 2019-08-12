package day05;

import java.util.Arrays;

public class Test04 {
	public static void main(String[] args) {
		// 난수 발생
		// System.out.println((int)(Math.random()*10));
		// String[] args = { };
		// String[] args = {"5"};

		if (args.length == 0) {
			System.out.println("배열의 사이즈 정보를 실행 매개변수로 넘겨주세요..");
			System.out.println("실행예) java day05.Test04 5");
			return;
		}

		int[] nums = new int[Integer.parseInt(args[0])];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = (int) (Math.random() * 45) + 1; // 1~45 사이의 정수
		}
		System.out.println(Arrays.toString(nums));

		// 정렬  내림차순 SORT

		System.out.println("---------------------------------------");
		System.out.println(Arrays.toString(nums));
		int count =0;
		for (int i = 1; i < nums.length - 1; i++) {
			//Arrays.sort(nums);
			for (int j = 0; j < nums.length-i; j++) { // j=0: 회전수당 줄어드는 연산표현, j<nums.length-1: 마지막 자리는 비교할 필요가 없다(자동지정) 
				if (nums[i] > nums[j]) {
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
					count++; //교체작업이 일어날 때마다 몇번 바뀌었는지 횟수를 센다.
				}
			}
			System.out.println(Arrays.toString(nums)); //이곳에 위치하므로 중간결과값을 알려줌
		}
		
		//<과제> 스와핑 작업을 최소한 수행하게 코드 수정합니다.
		
		System.out.println("count = > "+ count);
		 System.out.println("-------  정렬    -------");
		//System.out.println(Arrays.toString(nums)); //이곳에 위치하므로 최종결과값을 알려줌
	}
}
