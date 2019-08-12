package day09;

import java.util.Date;

public class Test03_StringBuffer {

	public static void main(String[] args) {
		String msg = "";
		msg = msg+"hello  "+new java.util.Date()+" java"+" test"+'A'+89; //이렇게 하면 불가능
		System.out.println(msg);

		String msg2 = "";
		
		//StringBuffer sb = new StringBuffer(); //이렇게 해야 가능!
		StringBuilder sb = new StringBuilder();
		sb.append("hello  ");
		sb.append(new Date());
		sb.append("  java");
		sb.append("  test");
		sb.append('A');
		sb.append(89);
		
		//msg2 = sb.toString();
		msg2 = new String(sb);
		System.out.println(msg2);
		
	}

}
