/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.82
 * Generated at: 2017-11-29 11:53:34 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Presupuesto</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form action=\"Presupuesto2\" method=\"post\">\n");
      out.write("        <table>\n");
      out.write("                \n");
      out.write("        <tr><td colspan= \"4\"><p id=\"center\"><b>Presupuestos de alquiler </b></p></td></tr>  \n");
      out.write("        <tr><td>Pares de esquis</td><td colspan= \"2\"><input type=\"number\" min=\"0\" max=\"255\" value=\"0\" name=\"esquis\"></td><td></td></tr> \n");
      out.write("        <tr><td>Pares de palos</td><td colspan= \"2\"><input type=\"number\" min=\"0\" max=\"255\" value=\"0\" name=\"palos\"></td><td></td></tr> \n");
      out.write("        <tr><td>Pares de botas</td><td colspan= \"2\"><input type=\"number\" min=\"0\" max=\"255\" value=\"0\" name=\"botas\"></td><td></td></tr> \n");
      out.write("        <tr><td>Tablas de Snowboard</td><td colspan= \"2\"><input type=\"number\" min=\"0\" max=\"255\" value=\"0\" name=\"tablas\"></td><td></td></tr> \n");
      out.write("        <tr><td>Dias Alquiler</td><td colspan= \"2\"><input type=\"number\" min=\"1\" max=\"365\" required name=\"dias\"></td><td></td></tr> \n");
      out.write("        \n");
      out.write("        <tr>\n");
      out.write("        <td align=\"right\" colspan= \"2\"><input type=\"reset\" name=\"vaciar\" value=\"Reset\"/></td>\n");
      out.write("        <td colspan= \"2\"><input type=\"submit\" name=\"submit\" value=\"Calcular\"/></td>\n");
      out.write("        </tr>    \n");
      out.write("        </table>\n");
      out.write("        </form> \n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
