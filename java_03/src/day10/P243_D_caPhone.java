package day10;

public class P243_D_caPhone extends P243_CellPhone {
	String pixel;
	public P243_D_caPhone (String model, String num, int chord, String pixel) {
		
		super(model,num,chord);
		
		//super.model = model;
		//super.number = num;
		
		//this.model = model;
		//number = num;
		//this.chord = chord;
		this.pixel = pixel;
	}
}
