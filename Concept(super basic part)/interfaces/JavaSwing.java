package kr.ac.sejong.db.java_test.interfaces;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JavaSwing extends JFrame{
	public JavaSwing() {
		
		Container c = getContentPane();
		JButton b = new JButton("Click me");
		c.add(b);
		
		setTitle("Hello Java Swing");
		setSize(300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new JavaSwing();
	}
}
