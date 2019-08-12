package day21;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Test04 {
	public static void main(String[] args) {
       new UI_4();
	}
}

class UI_4 extends JFrame implements ActionListener{
	JButton red,blue,exit;
	
	Panel p1;
	
	UI_4(){
	   super("awt UI Test ~~");
	   p1 = new Panel();
	   p1.add(red = new JButton("RED"));
	   p1.add(blue = new JButton("BLUE"));
	   p1.add(exit = new JButton("종료"));
	   add(p1,BorderLayout.SOUTH);
	   
	   setSize(300, 300);
	   setVisible(true);
	   
	   red.addActionListener(this);
	   blue.addActionListener(this);
	   exit.addActionListener(this);
	   
	  // f1.addWindowListener(new WindowEventP());
//	   addWindowListener(new WindowAdapter() {
//		   public void windowClosing(WindowEvent e) {
//				setVisible(false);
//				dispose();
//				System.exit(0);
//			}
//	   });
	   
	   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   
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












