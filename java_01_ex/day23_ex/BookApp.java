package day23_ex;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BookApp {
	
	public static void main(String[] args) {
		new Gui();
	}
}

class Gui extends JFrame{
	static int num=0;
    BookMgr mgr;
    JButton add,list,delete,search,exit;
    TextField title,price,isbn;
    TextArea output;
	
    Gui(){
    	mgr = new BookMgr();
    	
    	Panel p1 = new Panel();
    	p1.add(add = new JButton("ADD"));
    	p1.add(list = new JButton("List"));
    	p1.add(delete = new JButton("삭제"));
    	p1.add(search = new JButton("검색"));
    	p1.add(exit = new JButton("종료"));
    	add(p1,BorderLayout.SOUTH);
    	
    	Panel p2 = new Panel();
    	p2.setLayout(new GridLayout(3,2));
    	p2.add(new JLabel("   ISBN   "));
    	p2.add(isbn = new TextField(20));
    	p2.add(new JLabel("  제      목   "));
    	p2.add(title = new TextField(20));
    	p2.add(new JLabel("  가      격  "));
    	p2.add(price = new TextField(20));
    	add(p2,BorderLayout.NORTH);
    	
    	add(output= new TextArea(15, 40));
    	output.setFont(new Font(null,1,20));
    	
    	pack();
    	setVisible(true);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	add.addActionListener(e -> {
    		mgr.add(new Book(title.getText(),Integer.parseInt(price.getText())));
    	});
    	
    	exit.addActionListener(e-> {
    	    mgr.save();
    		System.exit(0);
    	});
    	
    	list.addActionListener(e -> {
    		output.setText(" BookList  \n");
    		mgr.getBookList().forEach(i -> {
    			output.append(i+"\n"); 
    		} );
    	});
    	
    	
    	
    	
    }
	
}








