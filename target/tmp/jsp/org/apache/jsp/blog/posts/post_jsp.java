/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: jetty/9.4.5.v20170502
 * Generated at: 2022-11-03 14:44:20 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.blog.posts;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.blog.Entities.Post;
import com.blog.Entities.Comment;
import com.blog.DAO.PostDAO;
import com.blog.DAO.CommentDAO;
import java.util.List;

public final class post_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("com.blog.DAO.CommentDAO");
    _jspx_imports_classes.add("com.blog.DAO.PostDAO");
    _jspx_imports_classes.add("com.blog.Entities.Post");
    _jspx_imports_classes.add("com.blog.Entities.Comment");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
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

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"UTF-8\" />\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\r\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js\" integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("        <title>Blog</title>\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar-light bg-light mb-3\">\r\n");
      out.write("            <ul class=\"navbar-nav\">\r\n");
      out.write("              <li class=\"nav-item active\">\r\n");
      out.write("                <a class=\"nav-link\" href=\"/index.jsp\">Blog</a>\r\n");
      out.write("              </li>\r\n");
      out.write("              <li class=\"nav-item\">\r\n");
      out.write("                <a class=\"nav-link\" href=\"/autenticar/login.jsp\">Entrar</a>\r\n");
      out.write("              </li>\r\n");
      out.write("              <li class=\"nav-item\">\r\n");
      out.write("                <a class=\"nav-link\" href=\"/autenticar/registrar.jsp\">Cadastrar-se</a>\r\n");
      out.write("              </li>\r\n");
      out.write("              <li class=\"nav-item dropdown admin-element\">\r\n");
      out.write("                  <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdownMenuLink\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\r\n");
      out.write("                    Administrar\r\n");
      out.write("                  </a>\r\n");
      out.write("                  <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdownMenuLink\">\r\n");
      out.write("                    <a class=\"dropdown-item\" href=\"/blog/posts/create.jsp\">Criar nova postagem</a>\r\n");
      out.write("                    <a class=\"dropdown-item\" href=\"/blog/posts/listAll.jsp\">Listar/editar todas as postagem</a>\r\n");
      out.write("                    <a class=\"dropdown-item\" href=\"/blog/comments/comments.jsp\">Aprovar coment??rios</a>\r\n");
      out.write("                  </div>\r\n");
      out.write("              </li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </nav>\r\n");
      out.write("\r\n");
      out.write("        ");

            String postId = request.getParameter("id");
            Post p = PostDAO.getById(postId);
        
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class='card mb-2'>\r\n");
      out.write("            <div class=\"card-header\">\r\n");
      out.write("                <h2>");
      out.print(p.getTitle().toUpperCase());
      out.write("<h2>\r\n");
      out.write("                <form action=\"update.jsp\" method=\"GET\" class=\"admin-element\">\r\n");
      out.write("                    <input type=\"hidden\" name=\"id\" value=\"");
      out.print(postId);
      out.write("\" readonly />\r\n");
      out.write("                    <button class=\"btn btn-warning\">Editar</button>\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class='card-body'>\r\n");
      out.write("                ");
      out.print(p.getBody());
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class='card mb-2'>\r\n");
      out.write("            <div class='card-header'><h5>Coment??rios<h5></div>\r\n");
      out.write("            <div class='card-body'>\r\n");
      out.write("                ");

                    List<Comment> comments = CommentDAO.listAllApprovedByPostId(postId);
                    if (comments.size() < 1) {
                        out.write("<p class='card-text'>Ainda n??o h?? coment??rios. Seja o primeiro a comentar.</p>");
                    } else {
                        for (Comment c : comments) {
                            out.write("<p class='card-text'>" + c.getBody() + "</p>");
                            out.write("<hr class='mb-3'>");
                        }
                    }
                
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <h5 class=\"ml-3\">Deixar um coment??rio</h5>\r\n");
      out.write("        <p class=\"visitor-only-element ml-3\">Para deixar um coment??rio ?? necess??rio estar logado.\r\n");
      out.write("        <a href=\"/autenticar/login.jsp\">Entre</a> ou\r\n");
      out.write("        <a href=\"/autenticar/registrar.jsp\">Registre-se</a>.\r\n");
      out.write("        </p>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <form class=\"user-only-element ml-3\" action=\"/blog/comments/save.jsp\" method=\"POST\">\r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("                <textarea class=\"form-control\" name=\"commentBody\" id=\"comment-body\" required></textarea>\r\n");
      out.write("                <input type=\"hidden\" name=\"userId\" id=\"userId\" value=\"1\">\r\n");
      out.write("                <input type=\"hidden\" name=\"postId\" id=\"userId\" value=");
      out.print(postId);
      out.write(">\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("                <button class=\"btn btn-primary\">Comentar</button>\r\n");
      out.write("            </div>\r\n");
      out.write("        </form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("    <script src=\"/main.js\"></script>\r\n");
      out.write("    <script>\r\n");
      out.write("        document.getElementById(\"userId\").value = sessionStorage.getItem(\"userId\");\r\n");
      out.write("    </script>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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
