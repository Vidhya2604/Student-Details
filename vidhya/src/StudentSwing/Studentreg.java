package StudentSwing;
import javax.swing.*;

import javax.swing.border.EmptyBorder;



import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import java.sql.Connection;
public class Studentreg extends JFrame {
	
	
	JTextField stu_id;
	JTextField stu_name;
	JTextField stu_dept;
	JRadioButton jc1;
	JRadioButton jc2;
	JTextField stu_phno;
	JTextField Event_Name;
	JButton button;
	JPanel panel;
	JLabel Result;
	
	public Studentreg()
	{	
		setLayout(new FlowLayout());
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(panel);
		panel.setLayout(null);
		setVisible(true);
		setSize(1500,750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel head = new JLabel("Student Registeration Form");
		head.setFont(new Font("Tahoma",Font.BOLD,40));
		head.setBounds(430,40,1000,150);
		panel.add(head);
		
		JLabel stu_idl = new JLabel("Student id ");
		stu_idl.setFont(new Font("Tahoma",Font.PLAIN,20));
		stu_idl.setBounds(140,190,200,95);
		panel.add(stu_idl);
		
		JLabel stu_namel = new JLabel("Student Name ");
		stu_namel.setFont(new Font("Tahoma",Font.PLAIN,20));
		stu_namel.setBounds(140,300,200,95);
		panel.add(stu_namel);
		
		JLabel stu_deptl = new JLabel("Student Department ");
		stu_deptl.setFont(new Font("Tahoma",Font.PLAIN,20));
		stu_deptl.setBounds(140,410,200,95);
		panel.add(stu_deptl);
		
		JLabel stu_genderl = new JLabel("Student Gender ");
		stu_genderl.setFont(new Font("Tahoma",Font.PLAIN,20));
		stu_genderl.setBounds(730,180,200,100);
		panel.add(stu_genderl);
		
		JLabel stu_phnol = new JLabel("Student Phone Number ");
		stu_phnol.setFont(new Font("Tahoma",Font.PLAIN,20));
		stu_phnol.setBounds(730,280,240,115);
		panel.add(stu_phnol);
		
		JLabel Event_namel = new JLabel("Event Name ");
		Event_namel.setFont(new Font("Tahoma",Font.PLAIN,20));
		Event_namel.setBounds(730,380,200,135);
		panel.add(Event_namel);
		
		stu_id = new JTextField(20);
		stu_id.setFont(new Font("Tahoma",Font.PLAIN,20));
		stu_id.setBounds(380,210,280,50);
		panel.add(stu_id);
		stu_id.setColumns(10);
		
		stu_name = new JTextField(20);
		stu_name.setFont(new Font("Tahoma",Font.PLAIN,20));
		stu_name.setBounds(380,320,280,50);
		panel.add(stu_name);
		stu_name.setColumns(10);
		
		stu_dept = new JTextField(20);
		stu_dept.setFont(new Font("Tahoma",Font.PLAIN,20));
		stu_dept.setBounds(380,430,280,50);
		panel.add(stu_dept);
		stu_dept.setColumns(10);
		
		jc1 = new JRadioButton("Male");
		jc2 = new JRadioButton("Female");
		ButtonGroup stu_gender = new ButtonGroup();
		stu_gender.add(jc1);
		stu_gender.add(jc2);
		jc1.setFont(new Font("Tahoma",Font.PLAIN,20));
		jc2.setFont(new Font("Tahoma",Font.PLAIN,20));
		jc1.setBounds(1000,205,100,50);
		jc2.setBounds(1100,205,140,50);
		panel.add(jc1);
		panel.add(jc2);
		
		stu_phno = new JTextField(20);
		stu_phno.setFont(new Font("Tahoma",Font.PLAIN,20));
		stu_phno.setBounds(1000,320,280,50);
		panel.add(stu_phno);
		stu_phno.setColumns(10);
		
		Event_Name = new JTextField(20);
		Event_Name.setFont(new Font("Tahoma",Font.PLAIN,20));
		Event_Name.setBounds(1000,420,280,50);
		panel.add(Event_Name);
		Event_Name.setColumns(10);
		
		button = new JButton("Register");
		button.setFont(new Font("Tahoma",Font.PLAIN,20));
		button.setBounds(650,570,170,50);
		panel.add(button);
		button.addActionListener(e ->
		{
			String id = stu_id.getText();
			String Name = stu_name.getText();
			String Department = stu_dept.getText();
			String Gender1 = jc1.getText();
			String Gender2 = jc2.getText();
			String PhoneNumber = stu_phno.getText();
			String EventName = Event_Name.getText();
			String msg = " ";
			int len = PhoneNumber.length();
			
			if(jc1.isSelected())
			{
				msg = jc1.getText();
			}
			else
			{
				msg = jc2.getText();
			}
			
			if(len!=10)
			{
			JOptionPane.showMessageDialog(button, "Enter a Valid Number");
			}
			
			try {
				
			Connection con =DBConnection.createConnetion();
			Statement st = con.createStatement();
			String Query = "insert into student values('" + id + "','"+ Name + "','"  +  Department + "','" + msg + "'," + PhoneNumber + ",'" + EventName + "')"; 
			int rows = st.executeUpdate(Query);
			
			System.out.println("Data inserted Successfully");
			
			con.close();
			}
			catch(Exception e1)
			{
				System.out.println(e1);
			}
			Result = new JLabel("Data are Registered Successfully");
		});
	
		
		
	}
	
	
	
}
