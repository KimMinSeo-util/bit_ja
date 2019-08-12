package day10;

public class P243_CellPhone {
	String model;
	String number;
	int chord;
	
	public P243_CellPhone() {
		super();
	}
	
	public P243_CellPhone(String model, String number, int chord) {
		super();
		this.model = model;
		this.number = number;
		this.chord = chord;
	}

	public void setNumber(String n) {
		number = n;
	}
	public String getModel() {
		return model;
	}
	public int getChord() {
		return chord;
	}
	public String getNumber() {
		return number;
	}

	
}
