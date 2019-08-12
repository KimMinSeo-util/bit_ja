package day21;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Test02 {
	public static void main(String[] args) {
       new UI_2();
	}
}

class UI_2 extends Frame{
	//Frame f1;
	Button red,blue,exit;
	
	Panel p1;
	
	UI_2(){
	   //f1 = new Frame("awt UI Test ~~");
	   super("awt UI Test ~~");
	   p1 = new Panel();
	   p1.add(red = new Button("RED"));
	   p1.add(blue = new Button("BLUE"));
	   p1.add(exit = new Button("EXIT"));
	   add(p1,BorderLayout.SOUTH);
	   
	   setSize(300, 300);
	   setVisible(true);
	   
	   
	   red.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p1.setBackground(Color.RED);
			}
	   });
	   blue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p1.setBackground(Color.blue);
			}
	   });
	   exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
	   });
	   
	   exit.addActionListener(e->System.exit(0));

	  // f1.addWindowListener(new WindowEventP());
	   addWindowListener(new WindowAdapter() {
		   public void windowClosing(WindowEvent e) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
	   });
	}
	
}












