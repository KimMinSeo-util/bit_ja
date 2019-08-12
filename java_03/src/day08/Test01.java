package day08;

import util.MyUtil;

public class Test01 {

	// 숫자를 넘겨받아 그 중 가장 큰 수를 리턴하는 함수 max
	public static void main(String[] args) {
		
		System.out.println(MyUtil.max(5,6,88,-999,-4444));
		System.out.println(MyUtil.max(5,6,88,-999,-4444));
		System.out.println(MyUtil.max(5,6,88,-999,-4444));
		System.out.println(MyUtil.max(new int[]{5,6,88,-999,-4444}));
		
	}

}
