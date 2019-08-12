package day05;

import java.util.Arrays;

public class Test01 {
	public static void main(String[] args) {
		int num1 = 99;
		int num2 = num1;
		System.out.println("num1="+num1+", num2="+num2);
		num1 = 77;
		System.out.println("num1="+num1+", num2="+num2);
		// <용어정리>
		//call by value
		//call by reference
		
		int[] n1 = {11,22,33,44,55,66,77};
		int[] n2 = n1;
		
		int[] n3 = new int[n1.length]; // n3d =배열의 방 생성, 16행)n1.length는  n1 안에 숫자가 더 늘어날 수 있기 때문에
		for (int i = 0; i < n1.length; i++) {
			n3[i] = n1[i];//<array copy 배열카피 >
		}
		
		System.out.println(Arrays.toString(n1));
		System.out.println(Arrays.toString(n2));
		System.out.println(Arrays.toString(n3));
		n1[2] = 0;
		System.out.println(Arrays.toString(n1));
		System.out.println(Arrays.toString(n2));
		System.out.println(Arrays.toString(n3));
	}

}
