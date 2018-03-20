import java.io.IOException;  
import java.io.PrintWriter;  
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
  
public class VarifyUser extends HttpServlet {  

public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
  String utype,fname,mname,lname,resident,pan;
  Date dob ;
  Connection con;
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
          
    String n=request.getParameter("UserID");  
    String p=request.getParameter("pass");  
          
    if(LoginDao.validate(n, p)){  
     try{   
Class.forName("com.mysql.jdbc.Driver");
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/etax?useSSL=false", "hritik","hm123");
String qry="select * from contactdetails where UserID='"+n+"'";
//PreparedStatement ps = con.prepareStatement(qry);
//ps.setString(1,n);
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery(qry);
rs.next();
utype= rs.getString(1);
fname = rs.getString(2);
mname = rs.getString(3);
lname = rs.getString(4);
pan = rs.getString(5);
dob = rs.getDate(6);
resident = rs.getString(7);

out.println("<!DOCTYPE html>");
out.println("<html>");
out.println("<head>");
out.println("<link rel= stylesheet type= text/css href=a.css>");

out.println("</head>");
out.println("<body>");
 out.println("<ul>");
  
  out.println("<li><a href=index.html>LOG OUT</a></li>");
  out.println("<li><a href=contactus.html>CONTACT US</a></li>");
  out.println("<li><a href=aboutus.html>ABOUT US</a></li>");
  out.println("<li><a href=incometax.html>MORE ABOUT INCOME TAX</a></li>");
out.println("</ul>"); 
out.println("<HR>");
out.println("<center><label id=lblName>USERNAME</label>");
out.println("<HR>");
//out.println("<div> <img src=bg - Copy.jpg>   </div>  <br>");
out.println("<details style=background-color:rgba(0,204,204,0.5)");
out.println("<summary>Basic Details</summary>");
out.println("<br><br>");

out.println("User Type :"+utype);	 

out.println (" <pre >");
out.println("First Name         : "+fname);
   
out.println("Middle Name        : "+mname);
   
out.println("Last Name          :"+lname);
   
out.println("PAN                   :"+pan);
		
out.println("Date Of Birth: "+dob);

out.println("Residential Status : "+resident);
   out.println("</pre>");
out.println("<br>");
out.println("<a href=gh.html class=button>CALCULATE INCOME TAX</a>");
out.println("<a href=# class=button>PAY INCOME TAX</a>");
 
    
    
    }  catch(Exception e){
        out.println(e);
    }
    }
    else{  
        out.print("Sorry username or password error");  
        RequestDispatcher rd=request.getRequestDispatcher("index.html");  
        rd.include(request,response);  
    }  
}   
}
            
            
                  


