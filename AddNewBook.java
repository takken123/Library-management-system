import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class AddNewBook extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    JTextField t1,t2,t5,t7,t8,t10;
    JButton b1,b2,b3,b4;
    
    JComboBox<String>  t3,t4,t6,t9;
    
    
    JMenuBar mb;
    JMenu menu1;
    JMenuItem i1,i2,i3,i4;
	
    public AddNewBook(String title)
    {
     super(title);
     setLayout(new GridLayout(12,2));
     setSize(400, 400);
     setLocationRelativeTo(this);
     setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    
     
     l1=new JLabel("BookId");
     l2=new JLabel("Name");
     l3=new JLabel("Subject");
     l4=new JLabel("Category");
     l5=new JLabel("ISBN");
     l6=new JLabel("Publication");
     l7=new JLabel("Price");
     l8=new JLabel("Quantity");
     l9=new JLabel("Author");
     l10=new JLabel("Edition");
     
     t1=new JTextField(10);
     t2=new JTextField(10);
     
     t3=new JComboBox<String>(GetValues.getSubject());
     
     t4=new JComboBox<String>(GetValues.getCategory());
     t5=new JTextField(10);
     t6=new JComboBox<String>(GetValues.getPublication());
     t7=new JTextField(10);
     t8=new JTextField(10);
     
    
     t9=new JComboBox<String>(GetValues.getAuthor());
     t10=new JTextField(10);
     
     
    
     
     b1=new JButton("SAVE");
     b2=new JButton("RESET");
     b3=new JButton("");
     b4=new JButton("");
    
     add(l1);add(t1);
     add(l2);add(t2);
     add(l3);add(t3);
     add(l4);add(t4);
     add(l5);add(t5);
     add(l6);add(t6);
     add(l7);add(t7);
     add(l8);add(t8);
     add(l9);add(t9);
     add(l10);add(t10);
     
     add(b1);add(b2);
     add(b3);add(b4);
     
     
     mb=new JMenuBar();
     setJMenuBar(mb);
     
     menu1=new JMenu("Add New");
     mb.add(menu1);
     
     i1=new JMenuItem("Author");
     i2=new JMenuItem("Subject");
     i3=new JMenuItem("Category");
     i4=new JMenuItem("Publication");
     
     menu1.add(i1);
     menu1.addSeparator();
     menu1.add(i2);
     menu1.addSeparator();
     menu1.add(i3);
     menu1.addSeparator();
     menu1.add(i4);
     
     
     
     
     
     
     
     
     b1.addActionListener(this);
     b2.addActionListener(this);
     b3.addActionListener(this);
     
     i1.addActionListener(this);
     i2.addActionListener(this);
     i3.addActionListener(this);
     i4.addActionListener(this);
     
    
     t1.setText(bookId());
     t1.setEditable(false);
    }
    
    public String bookId()
    {
    	 String id="";
         for(int i=0;i<8;i++)
         {
         id+=(int)(Math.random()*9)+1;
         System.out.println(id);
         }
         return id;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
    	if(ae.getSource()==i1)
    	{
    		int flag=0;
    		String str=JOptionPane.showInputDialog("Enter author Name");
    		System.out.println(str);
    		Connection con=DBInfo.getConnection();
    		try
    		{
    			String query="insert into author(name) values(?)";
    			PreparedStatement ps=con.prepareStatement(query);
    			
    			ps.setString(1,str.toUpperCase());
    			flag=ps.executeUpdate();
    			
    					
    		}
    		catch(Exception e)
    		{
    			e.printStackTrace();
    		}
    		if(flag==1)
    		{
    			JOptionPane.showMessageDialog(this, "Value Added");
    			
    			dispose();
    			AddNewBook obj=new AddNewBook("Add New Book");
    			obj.setVisible(true);
    		}
    		if(flag==0)
    		{
    			JOptionPane.showMessageDialog(this, "Value not added", "Error", JOptionPane.ERROR_MESSAGE);
    		}
    		
    	}
    	if(ae.getSource()==i2)
    	{
    		int flag=0;
    		String str=JOptionPane.showInputDialog("Enter Subject Name");
    		System.out.println(str);
    		Connection con=DBInfo.getConnection();
    		try
    		{
    			String query="insert into subject(name) values(?)";
    			PreparedStatement ps=con.prepareStatement(query);
    			
    			ps.setString(1,str.toUpperCase());
    			flag=ps.executeUpdate();
    			
    					
    		}
    		catch(Exception e)
    		{
    			e.printStackTrace();
    		}
    		if(flag==1)
    		{
    			JOptionPane.showMessageDialog(this, "Value Added");
    			dispose();
    			AddNewBook obj=new AddNewBook("Add New Book");
    			obj.setVisible(true);
    		}
    		if(flag==0)
    		{
    			JOptionPane.showMessageDialog(this, "Value not added", "Error", JOptionPane.ERROR_MESSAGE);
    		}
    		
    	}
    	if(ae.getSource()==i3)
    	{
    		int flag=0;
    		String str=JOptionPane.showInputDialog("Enter category Name");
    		System.out.println(str);
    		Connection con=DBInfo.getConnection();
    		try
    		{
    			String query="insert into category(name) values(?)";
    			PreparedStatement ps=con.prepareStatement(query);
    			
    			ps.setString(1,str.toUpperCase());
    			flag=ps.executeUpdate();
    			
    					
    		}
    		catch(Exception e)
    		{
    			e.printStackTrace();
    		}
    		if(flag==1)
    		{
    			JOptionPane.showMessageDialog(this, "Value Added");
    			dispose();
    			AddNewBook obj=new AddNewBook("Add New Book");
    			obj.setVisible(true);
    		}
    		if(flag==0)
    		{
    			JOptionPane.showMessageDialog(this, "Value not added", "Error", JOptionPane.ERROR_MESSAGE);
    		}
    		
    	}
    	if(ae.getSource()==i4)
    	{
    		int flag=0;
    		String str=JOptionPane.showInputDialog("Enter publication Name");
    		System.out.println(str);
    		Connection con=DBInfo.getConnection();
    		try
    		{
    			String query="insert into publication(name) values(?)";
    			PreparedStatement ps=con.prepareStatement(query);
    			
    			ps.setString(1,str.toUpperCase());
    			flag=ps.executeUpdate();
    			
    					
    		}
    		catch(Exception e)
    		{
    			e.printStackTrace();
    		}
    		if(flag==1)
    		{
    			JOptionPane.showMessageDialog(this, "Value Added");
    			dispose();
    			AddNewBook obj=new AddNewBook("Add New Book");
    			obj.setVisible(true);
    		}
    		if(flag==0)
    		{
    			JOptionPane.showMessageDialog(this, "Value not added", "Error", JOptionPane.ERROR_MESSAGE);
    		}
    		
    	}
      if(ae.getSource()==b1)
      {
    	 String s1=t1.getText();
    	 String s2=t2.getText();
    	 String s3=(String)t3.getSelectedItem();
    	 String s4=(String)t4.getSelectedItem();
    	 String s5=t5.getText();
    	 String s6=(String)t6.getSelectedItem();
    	 String s7=t7.getText();
    	 String s8=t8.getText();
    	 String s9=(String)t9.getSelectedItem();
    	 String s10=t10.getText();
    	 
    	 Connection con=DBInfo.getConnection();
    	 String str="insert into book values(?,?,?,?,?,?,?,?,?,?)";
    	 int flag=0;
    	 try 
    	 {
			PreparedStatement ps=con.prepareStatement(str);
			ps.setString(1, s1);
			ps.setString(2, s2);
			ps.setString(3, s3);
			ps.setString(4, s4);
			ps.setString(5, s5);
			ps.setString(6, s6);
			ps.setString(7, s7);
			ps.setString(8, s8);
			ps.setString(9, s9);
			ps.setString(10,s10);
			flag=ps.executeUpdate();
			
			
		}
    	 catch (SQLException e) 
    	 {
		
			e.printStackTrace();
		}
    	if(flag==0)
    	{
    		JOptionPane.showMessageDialog(this, "Book not Added", "Error", JOptionPane.ERROR_MESSAGE);
    	}
    	if(flag==1)
    	{
    		JOptionPane.showMessageDialog(this, "Book  Added", "Added", JOptionPane.INFORMATION_MESSAGE);
    		
    		t1.setText(bookId());
    		t2.setText(null);
    		t3.setSelectedIndex(0);
    		t4.setSelectedIndex(0);
    		t5.setText(null);
    		t6.setSelectedIndex(0);
    		t7.setText(null);
    		t8.setText(null);
    		t9.setSelectedIndex(0);
    		t10.setText(null);
    		
    	}
    	 
    	  
      }
      
      if(ae.getSource()==b2)
      {
    	  t1.setText(bookId());
  		t2.setText(null);
  		t3.setSelectedIndex(0);
  		t4.setSelectedIndex(0);
  		t5.setText(null);
  		t6.setSelectedIndex(0);
  		t7.setText(null);
  		t8.setText(null);
  		t9.setSelectedIndex(0);
  		t10.setText(null);
      }
      
      if(ae.getSource()==b3)
      {
    	  
      }
    	
    }
   /* public static void main(String[] args) 
    {
	    AddNewBook obj=new AddNewBook("Add New Book");
	    obj.setVisible(true);
	}*/
    
}
