package util;

import java.util.Arrays;
import java.util.Random;

public class MyUtil {
	// method 오버로딩
	/*public static long add(int a, int b) {
		return a+b;
	} //위 아래 이름은 동일 파라메터에 타입,개수가 다르면 구분가능하므로 쓸 수 있다.
	public static double add(double a, double b) {
		return a+b;
	}
	public static double add(double a, double b, double c) {
			return (a+b+c);//프로모션이 발생하므로 마지막C를 따로 int로 처리하지 않아도 된다.
		}*/
	
	//가변인자, 항상 제일 마지막 위치만 허용(...nums는 double형으로 배열처리(몇개 올지 모를 때) 
	public static double add(double ...nums) { 
		
		double sum=0;
		
		for(double data :nums) {
			sum += data;
		}
		
		return sum;
	}
	/* public static double add(double[] a) {
	   double sum=0;
	   for(double data :a){
	   sum +=data;
	  }
       return sum;
	}*/
		//leftPad
		public static String leftPad(String str, int size, char padChar) {
		if (str.length() > size) {
			return str;
		}
		int count = size-str.length();
		for (int i = 0; i < count; i++) {
			str = padChar+str;
}	
		return str;
}

		//rightPad
		public static String rightPad(String str, int size, char padChar) {
			 if (str.length() > size) {
				return str;
			}
			 int count = size-str.length();
			 for (int i=0; i<count; i++) {
				str = str+padChar;
			}	
			 return str;
	}
		//Sort
		public static int [] sort(int[] nums) {
		int[]copy = new int[nums.length];
		System.arraycopy(nums, 0, copy, 0 ,nums.length);
		
		int[] num = copy;
		for(int i=0; i<copy.length-1;i++) {
			for(int j=i+1; j<copy.length; j++) {
				if(copy[i] > copy[j]) {
					int temp = copy[i];
					copy[i] = copy[j];
					copy[j] = copy[i];
			}
		}
	}
		return copy;
		}
		//숫자를 넘겨받아 그 중 가장 큰 수를 리턴하는 함수 max
		public static int max(int ... a) {
			int max = Integer.MIN_VALUE; //int중에서 임의의 제일 작은 값(0은 불가능)
			for (int data:a) {
				if(max < data) max = data;
			}
			    return max;
			} 
		//<과제>숫자를 넘겨받아 그 중 가장 작은 수를 리턴하는 함수 min
		public static int min(int ... a) {
			int min = Integer.MIN_VALUE; //int중에서 임의의 제일 작은 값(0은 불가능)
			for (int data:a) {
				if(min < data) min = data;
			}
			    return min;
			} 
		}

