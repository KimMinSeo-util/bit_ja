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

public class Test03 {
	public static void main(String[] args) {
       new UI_3();
	}
}

class UI_3 extends Frame implements ActionListener{
	Button red,blue,exit;
	
	Panel p1;
	
	UI_3(){
	   super("awt UI Test ~~");
	   p1 = new Panel();
	   p1.add(red = new Button("RED"));
	   p1.add(blue = new Button("BLUE"));
	   p1.add(exit = new Button("종료"));
	   add(p1,BorderLayout.SOUTH);
	   
	   setSize(300, 300);
	   setVisible(true);
	   
	   red.addActionListener(this);
	   blue.addActionListener(this);
	   exit.addActionListener(this);
	   
	  // f1.addWindowListener(new WindowEventP());
	   addWindowListener(new WindowAdapter() {
		   public void windowClosing(WindowEvent e) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
	   });
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "RED":
			p1.setBackground(Color.red);
			break;
		case "BLUE":
			p1.setBackground(Color.BLUE);
			break;
		case "종료":
			System.exit(0);
		default:
			break;
		}
	}
	
}












