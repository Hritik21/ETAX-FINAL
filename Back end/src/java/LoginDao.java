import java.sql.*;  
  
public class LoginDao {  
public static boolean validate(String uid,String pass){  
boolean status=false;  
try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/etax?useSSL=false", "hritik","hm123");  
      
PreparedStatement ps=con.prepareStatement("select * from contactdetails where UserID=? and Password=?");  
ps.setString(1,uid);  
ps.setString(2,pass);  
      
ResultSet rs=ps.executeQuery();  
status=rs.next();  
          
}catch(Exception e){System.out.println(e);}  
return status;  
}  
}  