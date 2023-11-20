package StudentSwing;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import StudentSwing.DBConnection;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ShowStudent extends JFrame {

	 JTable jt;
	public ShowStudent()
	{
		setVisible(true);
		setSize(1500,750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		Connection con=DBConnection.createConnetion();
        String query="select * from student";
       
        try{
            Statement stmt=con.createStatement();
            ResultSet result= stmt.executeQuery(query);
            DefaultTableModel model = new DefaultTableModel();
            
            jt = new JTable(model);
            model.addColumn("Student id");
            model.addColumn("Student name");
            model.addColumn("Student department");
            model.addColumn("Student gender");
            model.addColumn("Student phonenumber");
            model.addColumn("Eventname");
            model.addRow(new Object[] {"Student id","Student name","Student department","Student gender","Student phonenumber","eventname"});
            while (result.next()){
               
                String id = result.getString(1);
                String name = result.getString(2);
                String dept = result.getString(3);
                String gender = result.getString(4);
                long phno = result.getLong(5);
                String eventname = result.getString(6);
                
                model.addRow(new Object[] {id,name,dept,gender,phno,eventname});
                add(jt);
               
            }
            System.out.println("datas are");
            
        }catch (Exception ex){
            ex.printStackTrace();
        }
	}
}