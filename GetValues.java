import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;


public class GetValues
{
     public static Vector<String> getAuthor()
     {
    	 Vector<String> v=new Vector<String>();
    	 Connection con=DBInfo.getConnection();
    	 String query="select * from author order by name";
    	 try
    	 {
    		 PreparedStatement ps=con.prepareStatement(query);
    		 ResultSet res=ps.executeQuery();
    		 while(res.next())
    		 {
    			v.add(res.getString(2).toUpperCase()); 
    		 } 
    	 }
    	 catch(Exception e1)
    	 {
    		 e1.printStackTrace();
    	 }
    	 System.out.println("vector size is:"+v.size());
    	 System.out.println(v);
    	 return v;
     }
     public static Vector<String> getSubject()
     {
    	 Vector<String> v=new Vector<String>();
    	 Connection con=DBInfo.getConnection();
    	 String query="select * from subject order by name";
    	 try
    	 {
    		 PreparedStatement ps=con.prepareStatement(query);
    		 ResultSet res=ps.executeQuery();
    		 while(res.next())
    		 {
    			v.add(res.getString(2).toUpperCase()); 
    		 } 
    	 }
    	 catch(Exception e1)
    	 {
    		 e1.printStackTrace();
    	 }
    	 System.out.println("vector size is:"+v.size());
    	 System.out.println(v);
    	 return v;
     }
     public static Vector<String> getCategory()
     {
    	 Vector<String> v=new Vector<String>();
    	 Connection con=DBInfo.getConnection();
    	 String query="select * from category order by name";
    	 try
    	 {
    		 PreparedStatement ps=con.prepareStatement(query);
    		 ResultSet res=ps.executeQuery();
    		 while(res.next())
    		 {
    			v.add(res.getString(2).toUpperCase()); 
    		 } 
    	 }
    	 catch(Exception e1)
    	 {
    		 e1.printStackTrace();
    	 }
    	 System.out.println("vector size is:"+v.size());
    	 System.out.println(v);
    	 return v;
     }
     public static Vector<String> getPublication()
     {
    	 Vector<String> v=new Vector<String>();
    	 Connection con=DBInfo.getConnection();
    	 String query="select * from publication order by name";
    	 try
    	 {
    		 PreparedStatement ps=con.prepareStatement(query);
    		 ResultSet res=ps.executeQuery();
    		 while(res.next())
    		 {
    			v.add(res.getString(2).toUpperCase()); 
    		 } 
    	 }
    	 catch(Exception e1)
    	 {
    		 e1.printStackTrace();
    	 }
    	 System.out.println("vector size is:"+v.size());
    	 System.out.println(v);
    	 return v;
     }
}
