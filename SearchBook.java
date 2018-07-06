import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
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
public class SearchBook extends JFrame implements ActionListener,FocusListener
{
    JLabel l0,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    JTextField t0,t1,t2,t5,t7,t8,t10, t3,t4,t6,t9;;
    JButton b1,b2,b3,b4;
    
  
    
    
    JMenuBar mb;
    JMenu menu1;
    JMenuItem i0,i1,i2,i3,i4;
	
    public SearchBook(String title)
    {
     super(title);
     setLayout(new GridLayout(13,2));
     setSize(400, 400);
     setLocationRelativeTo(this);
     setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    
     l0=new JLabel("BookId");
     l1=new JLabel("Enter BookId");
     l2=new JLabel("Name");
     l3=new JLabel("Subject");
     l4=new JLabel("Category");
     l5=new JLabel("ISBN");
     l6=new JLabel("Publication");
     l7=new JLabel("Price");
     l8=new JLabel("Quantity");
     l9=new JLabel("Author");
     l10=new JLabel("Edition");
     
     
     t0=new JTextField(10);t0.setEditable(false);
     t1=new JTextField(10);
     t2=new JTextField(10);
     
     t3=new JTextField(10);
     
     t4=new JTextField(10);
     t5=new JTextField(10);
     t6=new JTextField(10);
     t7=new JTextField(10);
     t8=new JTextField(10);
     
    
     t9=new JTextField(10);
     t10=new JTextField(10);
     
     
    
     
     b1=new JButton("Search");
     b2=new JButton("RESET");
     b3=new JButton("Update");
     b4=new JButton("Delete");
    
     
     add(l0);add(t0);
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
     
     menu1=new JMenu("Search Book By");
     mb.add(menu1);
     
     
     i0=new JMenuItem("All");
     i1=new JMenuItem("Author");
     i2=new JMenuItem("Subject");
     i3=new JMenuItem("Category");
     i4=new JMenuItem("Publication");
     
     
     menu1.add(i0);
     menu1.addSeparator();
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
     
    t1.addFocusListener(this);
     
    }
    
   @Override
public void focusGained(FocusEvent arg0) {
	// TODO Auto-generated method stub
	
}
   @Override
public void focusLost(FocusEvent e) {
	// TODO Auto-generated method stub
	   String s1=t1.getText();
	  
		Connection con=DBInfo.getConnection();
		String query="select * from book where bookid=?";
		try
		{
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1, s1);
		ResultSet res=ps.executeQuery();
		while(res.next())
		{
			t2.setText(res.getString(2));
			t3.setText(res.getString(3));
			t4.setText(res.getString(4));
			t5.setText(res.getString(5));
			t6.setText(res.getString(6));
			t7.setText(res.getString(7));
			t8.setText(res.getString(8));
			t9.setText(res.getString(9));
			t10.setText(res.getString(10));
		}
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
}
    
    
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
    	if(ae.getSource()==b1)
    	{
    		String s1=t1.getText();
    		t0.setText(s1);
    		Connection con=DBInfo.getConnection();
    		String query="select * from book where bookid=?";
    		try
    		{
    		PreparedStatement ps=con.prepareStatement(query);
    		ps.setString(1, s1);
    		ResultSet res=ps.executeQuery();
    		while(res.next())
    		{
    			t2.setText(res.getString(2));
    			t3.setText(res.getString(3));
    			t4.setText(res.getString(4));
    			t5.setText(res.getString(5));
    			t6.setText(res.getString(6));
    			t7.setText(res.getString(7));
    			t8.setText(res.getString(8));
    			t9.setText(res.getString(9));
    			t10.setText(res.getString(10));
    		}
    		}
    		catch(Exception e)
    		{
    			e.printStackTrace();
    		}
    		
    	}
    	if(ae.getSource()==b2)
    	{
    		t1.setText("");
    		t2.setText("");
    		t3.setText("");
    		t4.setText("");
    		t5.setText("");
    		t6.setText("");
    		t7.setText("");
    		t8.setText("");
    		t9.setText("");
    		t10.setText("");
    		
    	}
    	if(ae.getSource()==b4)
    	{
    		int flag=0;
    		String s1=t1.getText();
    		Connection con=DBInfo.getConnection();
    		String query="delete from book where bookid=?";
    		try
    		{
    		PreparedStatement ps=con.prepareStatement(query);
    		ps.setString(1, s1);
    		flag=ps.executeUpdate();
    		}
    		catch(Exception e)
    		{
    			e.printStackTrace();
    		}
    		
    		if(flag==0)
        	{
        		JOptionPane.showMessageDialog(this, "Book Not Deleted!", "Error", JOptionPane.ERROR_MESSAGE);
        	}
        	if(flag==1)
        	{
        		JOptionPane.showMessageDialog(this, "Book  Deleted", "Deleted", JOptionPane.INFORMATION_MESSAGE);
        		t1.setText("");
        		t2.setText("");
        		t3.setText("");
        		t4.setText("");
        		t5.setText("");
        		t6.setText("");
        		t7.setText("");
        		t8.setText("");
        		t9.setText("");
        		t10.setText("");
        		
        	}		
    	}
    	if(ae.getSource()==b3)
    	{
    		int flag=0;
    		String s1=t0.getText();
    		String s2=t2.getText();
    		String s3=t3.getText();
    		String s4=t4.getText();
    		String s5=t5.getText();
    		String s6=t6.getText();
    		String s7=t7.getText();
    		String s8=t8.getText();
    		String s9=t9.getText();
    		String s10=t10.getText();
    		
    		
    		Connection con=DBInfo.getConnection();
    		String query="update book set name=?,subject=?,category=?,isbn=?,publication=?,price=?,quantity=?,author=?,edition=? where bookid=?";
    		try
    		{
    		PreparedStatement ps=con.prepareStatement(query);
    		ps.setString(1, s2);
    		ps.setString(2, s3);
    		ps.setString(3, s4);
    		ps.setString(4, s5);
    		ps.setString(5, s6);
    		ps.setString(6, s7);
    		ps.setString(7, s8);
    		ps.setString(8, s9);
    		ps.setString(9, s10);
    		ps.setString(10, s1);
    		
    		
    		flag=ps.executeUpdate();
    		}
    		catch(Exception e)
    		{
    			e.printStackTrace();
    		}
    		
    		if(flag==0)
        	{
        		JOptionPane.showMessageDialog(this, "Book Not Updated!", "Error", JOptionPane.ERROR_MESSAGE);
        	}
        	if(flag==1)
        	{
        		JOptionPane.showMessageDialog(this, "Book  Updated", "UPdated", JOptionPane.INFORMATION_MESSAGE);
        		t1.setText("");
        		t2.setText("");
        		t3.setText("");
        		t4.setText("");
        		t5.setText("");
        		t6.setText("");
        		t7.setText("");
        		t8.setText("");
        		t9.setText("");
        		t10.setText("");
        		
        	}		
    	}
    	
    	
    }
    /*public static void main(String[] args) 
    {
	    SearchBook obj=new SearchBook("Search Book");
	    obj.setVisible(true);
	}*/
    
}
