import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class RegistrationPage extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5,l6;
    JTextField t1,t4,t5;
    JPasswordField t2,t3;
    JComboBox<String> t6;
    JButton b1,b2,b3;
	
    public RegistrationPage(String title)
    {
     super(title);
     setLayout(new GridLayout(8,2));
     setSize(400-40, 400-40);
     setLocationRelativeTo(this);
     setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    
     
     l1=new JLabel("Enter Name");
     l2=new JLabel("Enter Email");
     l3=new JLabel("Enter Password");
     l4=new JLabel("Confirm Password");
     l5=new JLabel("Enter Mobile");
     l6=new JLabel("Enter Usertype");
     
     
     t1=new JTextField(10);
     t2=new JPasswordField(10);
     t3=new JPasswordField(10);
     t4=new JTextField(10);
     t5=new JTextField(10);
     
     String type[]={"Admin","Student","Faculty","Other"};
     t6=new JComboBox<String>(type);
     
     
     b1=new JButton("Save");
     b2=new JButton("RESET");
     b3=new JButton();
     
    
     add(l1);add(t1);
     add(l2);add(t2);
     add(l3);add(t3);
     add(l4);add(t4);
     add(l5);add(t5);
     add(l6);add(t6);
     
     add(b1);add(b2);
     add(b3);
     
     
     b1.addActionListener(this);
     b2.addActionListener(this);
     b3.addActionListener(this);
     
     
   
    }
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
      if(ae.getSource()==b1)
      {
    	int flag=0;
    	String s1=t1.getText();
    	String s2=t2.getText();
    	String usertype="";
    	System.out.println(s1+":"+s2);
    	
    	Connection con=DBInfo.getConnection();
    	String query="select * from registration where email=? and password=?";
    	  try
    	  {
    		PreparedStatement ps=con.prepareStatement(query);
    		ps.setString(1, s1);
    		ps.setString(2, s2);
    		ResultSet res=ps.executeQuery();
    		while(res.next())
    		{
    			flag=1;
    			usertype=res.getString(5);
    			break;
    		}
    	  }
    	  catch(Exception e)
    	  {
    		  e.printStackTrace();
    		  
    	  }
    	  
    	  if(flag==1)
    	  {
    		 if(usertype.equalsIgnoreCase("admin"))
    		 {
    			 AdminPage obj=new AdminPage("Admin Page");
    			 obj.setVisible(true);
    			 
    			 t1.setText("");
    			 t2.setText(""); 
    		 }
    		 if(usertype.equalsIgnoreCase("student"))
    		 {
    			 StudentPage obj=new StudentPage("Student Page");
    			 obj.setVisible(true);
    			 
    			 t1.setText("");
    			 t2.setText("");
    		 }
    			 
    	  }
    	  if(flag==0)
    	  {
    		 JOptionPane.showMessageDialog(this, "Wrong username or password!", "Error", JOptionPane.ERROR_MESSAGE);
    	  }
    	  
      }
      
      if(ae.getSource()==b2)
      {
    	  t1.setText(null);
    	  t2.setText(null);
      }
      
      if(ae.getSource()==b3)
      {
    	  
      }
    	
    }
    /*public static void main(String[] args) 
    {
	    RegistrationPage obj=new RegistrationPage("Login Page");
	    obj.setVisible(true);
	}*/
    
}
