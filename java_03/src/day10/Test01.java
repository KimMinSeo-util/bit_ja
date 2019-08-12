package day10;

public class Test01 {
	public static void main(String[] args) {
		System.out.println("java progRamING".equals("java progRamING")); //두 문자열이 완벽하게 같아야 T
		System.out.println("java progRamING".equals("JAVA progRamING")); //F
		System.out.println("java progRamING".equalsIgnoreCase("JAVA progRamING"));//대소문자 구분하지 않는다.
		System.out.println("java progRamING".equalsIgnoreCase("JAVA"));
		System.out.println("java progRamING".contains("JAVA")); //앞 문자 중에 뒤에 문자열이 포함되어있는지, 단 대소문자 구분한다.
		System.out.println("java progRamING".toLowerCase().contains("JAVA"));
		System.out.println("java progRamING".toLowerCase().contains("JAVA".toLowerCase()));//

	}

}
