package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.test.webapp.constants.CommonConstants;

public final class Addorgans_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Add Organs</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link href=\"bootstrap/css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\" media=\"screen\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js\"></script>\n");
      out.write("  <script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Welocme to Add organs!</h1>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <nav class=\"navbar navbar-inverse\">\n");
      out.write("  <div class=\"container-fluid\">\n");
      out.write("    <div class=\"navbar-header\">\n");
      out.write("        <a class=\"navbar-brand\" href=\"#\">Organdonationlive</a> \n");
      out.write("    </div>\n");
      out.write("        \n");
      out.write("       <div>\n");
      out.write("        <ul class=\"nav navbar-nav\">\n");
      out.write("          <li><a href=\"home.jsp\">Home</a></li>\n");
      out.write("          <li ><a href=\"Donor.jsp\">Donor</a></li>\n");
      out.write("          <li class =\"active\"><a href=\"Hospital.jsp\">Hospital</a></li>\n");
      out.write("          <li><a href=\"Custodian.jsp\">Custodian</a></li>\n");
      out.write("          <li><a href=\"#\">Contact</a></li>        \n");
      out.write("          <li><a href=\"#\">FAQ</a></li>\n");
      out.write("         \n");
      out.write("        </ul>\n");
      out.write("       </div>     \n");
      out.write("      </nav>\n");
      out.write("        ");
 
            
            String addorganValid = (String)request.getAttribute("addorganValid");
            if(null != addorganValid && (CommonConstants.TRUE).equalsIgnoreCase(addorganValid)){
        
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"alert alert-success fade in\">\n");
      out.write("\n");
      out.write("                <a href=\"#\" class=\"close\" data-dismiss=\"alert\">&times;</a>\n");
      out.write("\n");
      out.write("                <strong>Success!</strong> Hospital Registration Successful.\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        ");
     
            }else if(("false").equalsIgnoreCase(addorganValid)){
        
      out.write("\n");
      out.write("            \n");
      out.write("\n");
      out.write("            <div class=\"alert alert-danger fade in\">\n");
      out.write("\n");
      out.write("                <a href=\"#\" class=\"close\" data-dismiss=\"alert\">&times;</a>\n");
      out.write("\n");
      out.write("                <strong>Error!</strong> A problem has been occurred while submitting your data.\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        ");

            }else{}
            
        
      out.write("\n");
      out.write("        \n");
      out.write("        <div class=\"container\">\n");
      out.write("            <h4> Organs </h4>\n");
      out.write("            <p>The organs of the body that can be transplanted at the current time are kidneys, heart, lungs, liver, pancreas, and the intestines. Kidney/pancreas transplants, heart/lung transplants, and other combined organ transplants also are performed. Organs cannot be stored and must be used within hours of removing them from the donor's body. Most donated organs are from people who have died, but a living individual can donate a kidney, part of the pancreas, part of a lung, part of the liver, or part of the intestine.</p>\n");
      out.write("  <h2>Enter the Harvested organ details:</h2>\n");
      out.write("  <form class=\"form-horizontal\" role=\"form\" action=\"HospitalLoginServlet\" method=\"post\">\n");
      out.write("      <input type=\"hidden\" name=\"action\" value=\"addorgans\">\n");
      out.write("      <div class=\"form-group\">\n");
      out.write("        <label class=\"control-label col-sm-2\" for=\"HospitalID\">Hospital ID</label>\n");
      out.write("        <div class=\"col-sm-3\">\n");
      out.write("            <input type=\"text\" class=\"form-control\" name=\"HospitalID\" id=\"HospitalID\" placeholder=\"Hospital ID\">\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("      <div class=\"form-group\">\n");
      out.write("        <label class=\"control-label col-sm-2\" for=\"DonorID\">DONOR ID</label>\n");
      out.write("        <div class=\"col-sm-3\">\n");
      out.write("            <input type=\"text\" class=\"form-control\" name=\"DonorID\" id=\"DonorID\" placeholder=\"DONOR ID\">\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("      <div class=\"form-group\">\n");
      out.write("        <label class=\"control-label col-sm-2\" for=\"OrganName\">Organ-Name</label>\n");
      out.write("        <div class=\"col-sm-3\"> \n");
      out.write("        <select class=\"form-control\" name =\"OrganName\" id=\"OrganName\">\n");
      out.write("    <option>SELECT ORGAN</option>        \n");
      out.write("    <option>Kidneys</option>\n");
      out.write("    <option>Heart</option>\n");
      out.write("    <option>Lungs</option>\n");
      out.write("    <option>Liver</option>\n");
      out.write("    <option>Pancreas</option>\n");
      out.write("    <option>Intestines</option>\n");
      out.write("    <option>Eyes</option>\n");
      out.write("    \n");
      out.write("  </select>\n");
      out.write("        </div>\n");
      out.write("     </div>\n");
      out.write("      <div class=\"form-group\">\n");
      out.write("        <label class=\"control-label col-sm-2\" for=\"Blood Group\">Blood Group</label>\n");
      out.write("        <div class=\"col-sm-3\"> \n");
      out.write("        <select class=\"form-control\" name =\"BloodGroup\" id=\"Blood Group\">\n");
      out.write("    <option>SELECT VALUES</option>        \n");
      out.write("    <option>A</option>\n");
      out.write("    <option>B</option>\n");
      out.write("    <option>AB</option>\n");
      out.write("    <option>AB</option>\n");
      out.write("  </select>\n");
      out.write("        </div>\n");
      out.write("     </div>  \n");
      out.write("      <div class=\"form-group\">\n");
      out.write("        <label class=\"control-label col-sm-2\" for=\"Rh factor\">Rh factor</label>\n");
      out.write("        <div class=\"col-sm-3\"> \n");
      out.write("        <select class=\"form-control\" name =\"Rhfactor\" id=\"Rh factor\">\n");
      out.write("    <option>SELECT VALUES</option>        \n");
      out.write("    <option>Positive</option>\n");
      out.write("    <option>Negative</option>\n");
      out.write("    \n");
      out.write("  </select>\n");
      out.write("        </div>\n");
      out.write("     </div>\n");
      out.write("      <br>\n");
      out.write("      \n");
      out.write("      <div class=\"form-group\">        \n");
      out.write("      <div class=\"col-sm-offset-2 col-sm-10\">\n");
      out.write("          <input type=\"submit\" class=\"btn btn-default\" value=\"submit\">\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("      \n");
      out.write("  </form>\n");
      out.write("   \n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
