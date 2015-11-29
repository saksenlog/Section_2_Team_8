package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AddBlood_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        \n");
      out.write("        <div class=\"container\">\n");
      out.write("            <h4> Blood and Platelets </h4>\n");
      out.write("            <p>Blood and platelets are formed by the body, go through a life cycle, and are continuously replaced throughout life. This means that you can donate blood and platelets more than once. It is safe to donate blood every 56 days and platelets every four weeks.</p>\n");
      out.write("            <p1>Blood is stored in a blood bank according to type (A, B, AB, or O) and Rh factor (positive or negative). Blood can be used whole, or separated into packed red cells, plasma, and platelets, all of which have different lifesaving uses. It takes only about 10 minutes to collect a unit (one pint) of blood, although the testing and screening process means that you will be at the donation center close to an hour.</p1> <br> <br>\n");
      out.write("            <p2>Platelets are tiny cell fragments that circulate throughout the blood and aid in blood clotting. Platelets can be donated without donating blood. When a specific patient needs platelets, but does not need blood, a matching donor is found and platelets are separated from the rest of the blood which is returned to the donor. The donor's body will replace the missing platelets within a few hours.</p2><br>\n");
      out.write("            \n");
      out.write("  <h3>Enter the Donated Blood details details:</h3>\n");
      out.write("  <form class=\"form-horizontal\" role=\"form\" action=\"HospitalLoginServlet\" method=\"post\">\n");
      out.write("      <input type=\"hidden\" name=\"action\" value=\"addblood\">\n");
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
      out.write("        <select class=\"form-control\" name =\"Rh factor\" id=\"Rh factor\">\n");
      out.write("    <option>SELECT VALUES</option>        \n");
      out.write("    <option>Positive</option>\n");
      out.write("    <option>Negative</option>\n");
      out.write("    \n");
      out.write("  </select>\n");
      out.write("        </div>\n");
      out.write("     </div>  \n");
      out.write("      <br>\n");
      out.write("      \n");
      out.write("      <div class=\"form-group\">        \n");
      out.write("      <div class=\"col-sm-offset-2 col-sm-10\">\n");
      out.write("          <input type=\"Submit\" class=\"btn btn-default\" value=\"Submit\">\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("      \n");
      out.write("  </form>\n");
      out.write("  \n");
      out.write("  \n");
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
