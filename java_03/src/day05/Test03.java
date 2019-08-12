package day05;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Test03 {
	public static void main(String[] args) {
		String msg = "hello JAVA ~~~ ";
		String msg2 = "hi ~~~ SQL  ";

		//char[] c = {'h','e','1'}; 
		
		char[] c = new char[msg.length()];
		for(int i =0; i<msg.length(); i++) {
			c[i] = msg.charAt(i);
		}
		
		char[] cc = msg.toCharArray(); //char를 String으로 변환
		cc[0]= 'Q';
		
		String ne = new String(cc);//String을 다시 char로 변환
		//결론 char과 String은 서로 호환된다.(왔다갔다 할 수 있다))
		
		System.out.println(msg);
		System.out.println(Arrays.toString(c));
		System.out.println(Arrays.toString(cc));
		System.out.println(ne);

	}
}
