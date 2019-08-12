package day10;

public class P245_CellPhoneTest {

	public static void main(String[] args) {
		P243_D_caPhone dca = new P243_D_caPhone("IN-7600","011-9XXX-9XXXX",60,"400만");
		P244_MP3Phone mp = new P244_MP3Phone("KN-600","011-9XXX-9XXXX",60,256);
		
		System.out.println(dca.getModel()+","+dca.getChord()+","+dca.getNumber());
	}
}
