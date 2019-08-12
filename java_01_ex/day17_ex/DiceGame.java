package day17_ex;

public class DiceGame {
	public static void main(String args[]){
	 	DiceGame game = new DiceGame ();
			 
	 	int result1 = 0;
		try {
			result1 = game.countSameEye(10);
		} catch (Exception e) {
			e.printStackTrace();
		}
	 	System.out.println("면의 개수가 8개인 주사위 2개를  던져서 같은 눈이 나온 횟수 : " + result1);
	 
		int result2 = 0;
		try {
			result2 = game.countSameEye(-10);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("면의 개수가 8개인 주사위 2개를  던져서 같은 눈이 나온 횟수 : " + result2);
	 
	 
 	}
	public int countSameEye(int n) throws Exception {
		
		if(n < 0) throw new Exception("음수안됨");
			
		
		Dice d1 = new Dice(8);
		Dice d2 = new Dice(8);
		int count = 0;
		
		while(n > 0) {
			if(d1.play() == d2.play()) count++;
			n--;
		}
		
		return count;
	}
}





