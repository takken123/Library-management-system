import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class Login extends JFrame implements ActionListener
{
    JLabel l1,l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2,b3;
	
    public Login(String title)
    {
     super(title);
     setLayout(new GridLayout(4,2));
     setSize(300, 200-50);
     setLocationRelativeTo(this);
     setDefaultCloseOperation(EXIT_ON_CLOSE);
    
     
     l1=new JLabel("Enter UserName(Email)");
     l2=new JLabel("Enter Password");
     
     t1=new JTextField(10);
     t2=new JPasswordField(10);
     
     b1=new JButton("Login");
     b2=new JButton("RESET");
     b3=new JButton("NewUser SignUp");
    
     add(l1);add(t1);
     add(l2);add(t2);
     add(b1);add(b2);
     add(b3);
     
     
     b1.addActionListener(this);
     b2.addActionListener(this);
     b3.addActionListener(this);
     
     
   
    }
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
    	if(ae.getSource()==b3)
    	{
    		GeneralRegistrationPage obj=new GeneralRegistrationPage("Registration page");
    		obj.setVisible(true);
    	}
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
    public static void main(String[] args) 
    {
	    Login obj=new Login("Login Page");
	    obj.setVisible(true);
	}
    
}
