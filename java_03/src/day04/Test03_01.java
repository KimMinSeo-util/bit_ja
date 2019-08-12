package day04;

public class Test03_01 {
	public static void main(String[] args) {
		//break와 continue 차이
		//OUT을 통해 원하는 곳에서 빠져나올 수 있다.<라벨링작업> 
		OUT: for(int i=1;i<=9;i++) {
			for(int j=2;j<=9;j++) {
			  if(j==5) break OUT;
			//if(j==5) continue;
			System.out.printf("%d*%d= %2d | ",j,i,i*j );//2d는 자릿수로 2자리를 뜻한다.
			}
			System.out.println();
		}

	}

}
