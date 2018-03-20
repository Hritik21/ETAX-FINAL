
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculateTax extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            float itax=0;
            int age = Integer.parseInt(request.getParameter("age"));
            int amt=Integer.parseInt(request.getParameter("salary"));
            int FDR=Integer.parseInt(request.getParameter("fdr"));
            int LIC = Integer.parseInt(request.getParameter("lic"));
            int TDS = Integer.parseInt(request.getParameter("tds"));
            int pf = Integer.parseInt(request.getParameter("pf"));
                    if(age>18&&age<80){
                if(amt>250000&&amt<=500000){
                itax=(5/100)*amt;
                        }else if(amt>=500001&&amt<=1000000){
                            itax=(20/100)*amt +12500;
                        }else if(amt>1000000){
                            itax=(30/100)*amt+100000+12500; 
                        }
            }
            if(FDR>251&&FDR<=150000){
                itax = (float) (itax+(7.5/100)*FDR);
            }
            if(LIC<0){
                itax = itax+10000;
            }
            if(TDS>1){
                itax=itax+TDS;
            }if(pf<15000){
                itax = itax+15000;
            }
            out.println("<h3>Total Tax payable : "+itax+"</h3>");
            out.println("<h3><a href=https://onlineservices.tin.egov-nsdl.com/etaxnew/tdsnontds.jsp >Click here to pay</a></h3>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
