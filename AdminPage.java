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
public class AdminPage extends JFrame implements ActionListener
{
   
    JButton b1,b2,b3,b4;
	
    public AdminPage(String title)
    {
     super(title);
     setLayout(new GridLayout(2,2));
     setSize(400, 200+50);
     setLocationRelativeTo(this);
     setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    
     
     
     
     b1=new JButton("AddNew Book");
     b2=new JButton("Search Book");
     b3=new JButton("Delete/Update Book");
     b4=new JButton("Create New Account");
    
    
     add(b1);add(b2);
     add(b3);add(b4);
     
     
     b1.addActionListener(this);
     b2.addActionListener(this);
     b3.addActionListener(this);
     b4.addActionListener(this);
     
     
   
    }
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
      if(ae.getSource()==b1)
      {
    	  AddNewBook obj=new AddNewBook("Add new Book");
    	  obj.setVisible(true);
      }
      if(ae.getSource()==b2)
      {
    	  SearchBook obj=new SearchBook("Search  Book");
    	  obj.setVisible(true);
      }
      if(ae.getSource()==b3)
      {
    	  SearchBook obj=new SearchBook("Delete/Update  Book");
    	  obj.setVisible(true);
      }
    	if(ae.getSource()==b4)
    	{
    		RegistrationPage obj=new RegistrationPage("Registration Page");
    		obj.setVisible(true);
    	}
    	
    }
    public static void main(String[] args) 
    {
	    AdminPage obj=new AdminPage("Login Page");
	    obj.setVisible(true);
	}
    
}
