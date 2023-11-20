package StudentSwing;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.sql.*;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;
public class DeleteStudent extends JFrame {
		JLabel Stu_idl;
		JTextField Stu_id;
		
		JPanel panel;
		JButton button;
		
		public DeleteStudent()
		{
			setVisible(true);
			setLayout(new FlowLayout());
			setSize(1500,750);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			panel = new JPanel();
			panel.setBorder(new EmptyBorder(5,5,5,5));
			setContentPane(panel);
			panel.setLayout(null);
			Stu_idl = new JLabel("Student id");
			Stu_idl.setFont(new Font("Tahoma",Font.PLAIN,30));
			Stu_idl.setBounds(400,180,300,75);
			panel.add(Stu_idl);
			
			Stu_id = new JTextField(20);
			Stu_id.setFont(new Font("Tahoma",Font.PLAIN,30));
			Stu_id.setBounds(600,180,300,75);
			panel.add(Stu_id);
			
			button = new JButton("Done");
			button.setBounds(670,300,150,75);
			panel.add(button);
			button.addActionListener(e ->{
				Connection con=DBConnection.createConnetion();
				
				
		        try{
		        	
		        	Statement st = con.createStatement();
		       
		        	String id  = Stu_id.getText();
					
					String query="delete  from student where stu_id = '" + id + "'";
					
		            int cnt= st.executeUpdate(query);
		            
		            if(cnt!=0) {
		            	JOptionPane.showMessageDialog(button, "Data deleted successfully");
		                System.out.println("Student Deleted Successfully!!! "+id);
		               
		                
			         }
		            else
		            {
		            	JOptionPane.showMessageDialog(button, "ID is not found");
		            }
		            //Result.setFont(new Font("Tahoma",Font.PLAIN,30));
	    			//Result.setBounds(600,300,300,75);
		            
	    			
		            
		           
		        }
		        
		        catch(Exception e1)
		        {
		        	System.out.println(e1);
		        }
			
			});
			
			
			
			
			
	}
}
