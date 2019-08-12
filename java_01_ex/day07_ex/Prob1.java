package day07_ex;

public class Prob1 {

	public String rightPad(String str, int size, char padChar) {
		if(str.length() > size) {
			return str;
		}
		int count = size-str.length();
		for(int i=0; i<count;i++) {
			str = str+padChar;
		}
		return str;
	}

	public String leftPad(String str, int size, char padChar) {
		if(str.length() > size) {
			return str;
		}
		int count = size-str.length();
		for(int i=0; i<count;i++) {
			str = padChar+str;
		}
		return str;
	}
	
	public static void main(String[] args) {
		Prob1 p = new Prob1();
		System.out.println(p.leftPad("bit", 6, '#')); //###bit
		System.out.println(p.rightPad("bit", 6, '#')); //###bit
		System.out.println(p.leftPad("bit", 5, '$')); //$$bit
		System.out.println(p.rightPad("bit", 5, '$')); //$$bit
		System.out.println(p.leftPad("bit", 2, '&'));
		System.out.println(p.rightPad("bit", 2, '&'));
		
	}

}
