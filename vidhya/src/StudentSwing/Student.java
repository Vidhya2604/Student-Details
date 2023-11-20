package StudentSwing;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;

public class Student extends JFrame {
	
	
	JButton b1;
	JButton b2;
	JButton b3;
	JButton b4;
	JButton b5;
	JPanel panel;
	JLabel head;
	JLabel rvs;
	public Student()
	{
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(panel);
		panel.setLayout(null);
		rvs = new JLabel("RVS CAS");
		rvs.setFont(new Font("Tahoma",Font.BOLD,50));
		rvs.setBounds(600,10,1000,100);
		panel.add(rvs);
		head = new JLabel("Student Details");
		head.setFont(new Font("Tahoma",Font.BOLD,40));
		head.setBounds(560,40,1000,150);
		panel.add(head);
		
		setVisible(true);
		setSize(1500,750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		b1 = new JButton("Register Student");
		b1.setFont(new Font("Tahoma",Font.PLAIN,20));
		b1.setBounds(300,200,250,65);
	    panel.add(b1);
		
		b2 = new JButton("Show Student Details");
		b2.setFont(new Font("Tahoma",Font.PLAIN,20));
		b2.setBounds(850,200,250,65);
		panel.add(b2);
		
		b3 = new JButton("Delete Student Details");
		b3.setFont(new Font("Tahoma",Font.PLAIN,20));
		b3.setBounds(570,450,250,65);
		panel.add(b3);
		
		
			
		b1.addActionListener(e ->
		{
			new Studentreg();
			dispose();
			
		});
		
		b2.addActionListener(e ->
		{
			new ShowStudent();
			dispose();
		});
		b3.addActionListener(e ->
		{
			new DeleteStudent();
			dispose();
		});
		
		
		
	}
	
}
