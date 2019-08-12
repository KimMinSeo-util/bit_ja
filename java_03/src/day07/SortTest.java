package day07;

import java.util.Arrays;

import util.Sort;

public class SortTest {
	public static void main(String[] args) {
		
		int[] src = {5,9,3,77,1,4,6,99}; 
		
		int[] result = Sort.sort(src);
		
		System.out.println(Arrays.toString(src));
		
		System.out.println(Arrays.toString(result));
		
	}

}
