package day03;

public class Test04 {
	public static void main(String[] args) {
		
		//for(초기값 ;조건식 ;증감식 )
		int i;
		for( i = 1 ; i<10 ;i++ ) {
			System.out.println("Hello java "+i);
		}
		System.out.println(i);
		
		
		int j = 10; //초기값
		while(j>0)//조건식
			{
			System.out.println("while"+j);
			j--;//증감식
		}
		boolean flag = true;
		while(flag) {
			j++;
			System.out.println("~~~~~~~"+j);
			if(j==5) flag = !flag;
		}
		System.out.println("j : "+j);
		
		while(j<5) {
			System.out.println("do while"); //동작X
		}
		System.out.println("-----------------------");
		do {
			System.out.println("do while"); //동작o
			
		}while(j<5);
	}

}
