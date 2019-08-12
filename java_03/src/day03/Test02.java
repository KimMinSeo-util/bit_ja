package day03;

public class Test02 {
	public static void main(String[] args) {
		
		int num = -999;
		System.out.println(num > 0 ? "양수" :  "음수");
		// 양수 , 0 , 음수
		System.out.println(num > 0 ? "양수" : (num==0 ? "0": "음수") ); // 첫번째에 양수 음수로 나누고 두번째에 다시 또 0과 음수를 나누어 써주기 위해 괄호에 식을 한번 더 써준다.
		
		String result = num > 0 ? "양수" : (num==0 ? "0": "음수");
		System.out.println(num + ":"+result);
		
	}

}
