package day04;

public class Test03 {
	public static void main(String[] args) {
		//구구단 2~9단
		for(int i=1;i<=9;i++) {
			for(int j=2;j<=9;j++) {
			System.out.printf("%d*%d= %2d | ",j,i,i*j );//2d는 자릿수로 2자리를 뜻한다.
			}
			System.out.println();
		}

	}
	}
