
 import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
 import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/Etax"})
public class RegisterUser extends HttpServlet {
    HttpServletRequest req; HttpServletResponse resp;
   
        
           
   
   public Connection con ;public PreparedStatement pstmt;
    public void init(){
        try{     
Class.forName("com.mysql.jdbc.Driver");
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/etax?useSSL=false", "hritik","hm123");
String qry="insert into contactdetails values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

pstmt = con.prepareStatement(qry);
//ps = con.prepareStatement(qrr);
    }catch(ClassNotFoundException e){
     e.printStackTrace();
    }catch(SQLException e){
     //pwrite.println(e);
    }
    }
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        try( PrintWriter out = response.getWriter();) {
            
         String utype = request.getParameter("usertype");
        String fname =request.getParameter("fname");
            String mname =request.getParameter("mname");
            String lname =request.getParameter("lname");
            String pan =request.getParameter("pan");     
        java.util.Date dt = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dob"));
        
java.sql.Date sqldate = new java.sql.Date(dt.getTime());
         
      //   java.sql.Timestamp date=new java.sql.Timestamp(new java.util.Date().getTime());
         
        String resident =request.getParameter("resident");
       String userid =request.getParameter("UserID");
        String password =request.getParameter("password");
          
   //    String image =request.getParameter("pic");
    //   InputStream inputstream  = new FileInputStream(new File(image));
       
      String secque = request.getParameter("SecQue");
      String secans =request.getParameter("SecAns");
      
      String LandLine=request.getParameter("ln");
        String MobileNo =request.getParameter("mn");
       String AltCont = request.getParameter("AltCont");
        String AlterNateMob = request.getParameter("amn");
    
        String Email = request.getParameter("mail");
        String AltEmail = request.getParameter("amail");
        String Fax = request.getParameter("fax");
        String Flat = request.getParameter("add1");
        String Street=request.getParameter("add2");
        String Area =request.getParameter("add3");
        String District=request.getParameter("add4");
       String PIN=request.getParameter("add5");
        String   State = request.getParameter("State");
        String Country = request.getParameter("Country");
  try{      

        
      
pstmt.setString(1,utype);
pstmt.setString(2,fname);
pstmt.setString(3,mname);
pstmt.setString(4,lname);
pstmt.setString(5,pan);
pstmt.setDate(6,sqldate);
pstmt.setString(7, resident);
pstmt.setString(8,userid);
pstmt.setString(9,password);
pstmt.setString(10,secque);
pstmt.setString(11,secans); 
pstmt.setString(12,LandLine);
pstmt.setString(13,MobileNo);
pstmt.setString(14,AltCont);
pstmt.setString(15,AlterNateMob);
pstmt.setString(16, Email);
pstmt.setString(17, AltEmail);
pstmt.setString(18,Fax);
pstmt.setString(19,Flat);
pstmt.setString(20,Street);
pstmt.setString(21,Area);
pstmt.setString(22,District);
pstmt.setString(23,PIN);
pstmt.setString(24,State);
pstmt.setString(25,Country);
        
pstmt.executeUpdate();

out.println("Data Inserted");

}catch(SQLException e){
    out.println(e);
}                 
        
            
            /* TODO output your page here. You may use following sample code. */
           /* out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Etax</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Etax at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");*/

        }
    }
    @Override
    public void destroy(){
        try{
      con.close();
        }catch(SQLException e){
           e.printStackTrace();
        }
    }

    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(RegisterUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(RegisterUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
