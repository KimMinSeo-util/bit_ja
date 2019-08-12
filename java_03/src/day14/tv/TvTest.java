package day14.tv;

public class TvTest {
	public static void main(String[] args) {
		// 한 개의 리모컨으로 두 대의 TV를 사용한다.
		// STV user = new STV();

		play(new STV());
		play(new LTV());
		play(new ITV());
	}

	public static void play(TV tv) { //메소드 오버라이딩 기술을 사용하여서 가능하다.다형성
		tv.poweron();
		tv.poweroff();
	}
}
