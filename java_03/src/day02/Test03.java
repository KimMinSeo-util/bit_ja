package day02;

public class Test03 {
	public static void main(String[] args) {
		int x=600, y = 700;
		System.out.println("x="+x+", y="+y);
		//string에서 +연산을 자주 쓰는 것은 안좋은 코드이다.
		//버퍼 임시기억공간... 위에 대신에 사용하는 것으로 string 버퍼,빌더: 문자열을 자꾸 수정하면서 사용할 수 있는 것
		System.out.printf("x=%d, y=%d %n\n",x,y); // %d는 정수형... %s(String),%c(character) //f는 포맷(형식) // %n 줄 바꿈 처리
		// x=y 대입문, 양쪽 모두 int 이므로 y가 가진 값을 x에 대입. 따라서 x가 가진 600값은 사라진다.
		
		int temp = x;
		x=y;
		y=temp;
		
		System.out.printf("x=%d, y=%d %n",x,y);
		System.out.println("---------------------------------------");
		
		double d1 = 99.15689, d2=77.3467;
		//System.out.printf("d1=%f, d2=%5.2f %n",d1,d2);
		System.out.printf("d1=%5.2f, d2=%5.2f %n",d1,d2); //5.2는 소수점 두번째자리까지 5는 전체 자리수
		
		double temp2 = d1; //d는 
		d1=d2;
		d2=temp2;
		
		System.out.printf("d1=%f, d2=%5.2f %n",d1,d2);
	}

}
