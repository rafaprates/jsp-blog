/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: jetty/9.4.5.v20170502
 * Generated at: 2022-11-03 14:44:21 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.blog.posts;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.blog.Entities.Post;
import com.blog.DAO.PostDAO;

public final class update_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("com.blog.DAO.PostDAO");
    _jspx_imports_classes.add("com.blog.Entities.Post");
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
      out.write("        <title>Editar Post</title>\r\n");
      out.write("        </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");

            String postId = request.getParameter("id");
            Post p = PostDAO.getById(postId);
            String title = p.getTitle();
            String body = p.getBody();

            if (request.getMethod() == "POST") {
                String newTitle = request.getParameter("title");
                String newBody = request.getParameter("body");
                p.setTitle(newTitle);
                p.setBody(newBody);
                PostDAO.updatePost(p);
                response.sendRedirect("/index.jsp");
            }
        
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar-light bg-light mb-3\">\r\n");
      out.write("            <ul class=\"navbar-nav\">\r\n");
      out.write("              <li class=\"nav-item\">\r\n");
      out.write("                <a class=\"nav-link\" href=\"/index.jsp\">Blog</a>\r\n");
      out.write("              </li>\r\n");
      out.write("              <li class=\"nav-item\">\r\n");
      out.write("                <a class=\"nav-link\" href=\"/autenticar/login.jsp\">Entrar</a>\r\n");
      out.write("              </li>\r\n");
      out.write("              <li class=\"nav-item\">\r\n");
      out.write("                <a class=\"nav-link\" href=\"/autenticar/registrar.jsp\">Cadastrar-se</a>\r\n");
      out.write("              </li>\r\n");
      out.write("              <li class=\"nav-item dropdown admin-element active\">\r\n");
      out.write("                  <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdownMenuLink\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\r\n");
      out.write("                    Administrar\r\n");
      out.write("                  </a>\r\n");
      out.write("                  <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdownMenuLink\">\r\n");
      out.write("                    <a class=\"dropdown-item\" href=\"/blog/posts/create.jsp\">Criar nova postagem</a>\r\n");
      out.write("                    <a class=\"dropdown-item\" href=\"/blog/posts/listAll.jsp\">Listar/editar todas as postagem</a>\r\n");
      out.write("                    <a class=\"dropdown-item\" href=\"/blog/comments/comments.jsp\">Aprovar comentários</a>\r\n");
      out.write("                  </div>\r\n");
      out.write("              </li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </nav>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <form class=\"mb-5\"  action=\"update.jsp\" method=\"POST\">\r\n");
      out.write("                <input type='text' name='id' value='");
      out.print(postId);
      out.write("' style='display:none' readonly/>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"form-group mt-5\">\r\n");
      out.write("                    <label for=\"title\">Título</label>\r\n");
      out.write("                    <input\r\n");
      out.write("                    class=\"form-control\"\r\n");
      out.write("                    type=\"text\"\r\n");
      out.write("                    name=\"title\"\r\n");
      out.write("                    id=\"title\"\r\n");
      out.write("                    value=\"");
      out.print(title);
      out.write("\"\r\n");
      out.write("                    required\r\n");
      out.write("                    />\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"form-group\">\r\n");
      out.write("                    <label for=\"body\">Corpo</label>\r\n");
      out.write("                    <textarea class=\"form-control\" name=\"body\" id=\"body\" rows=\"15\">");
      out.print(body);
      out.write("</textarea>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"form-group\">\r\n");
      out.write("                    <label for=\"user\">Usuário</label>\r\n");
      out.write("                    <input class=\"form-control\" type=\"number\" name=\"userId\" id=\"userId\" value=1 readonly>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"from-group d-flex gap-3\">\r\n");
      out.write("                    <form action=\"/blog/posts/update.jsp\" method=\"POST\">\r\n");
      out.write("                        <input type='text' name='id' value='");
      out.print(postId);
      out.write("' style='display:none' readonly/>\r\n");
      out.write("                        <button class=\"btn btn-warning mr-3\">Modificar Post</button>\r\n");
      out.write("                    </form>\r\n");
      out.write("\r\n");
      out.write("                    <form action=\"/blog/posts/delete.jsp\" method=\"POST\">\r\n");
      out.write("                        <input type='text' name='id' value='");
      out.print(postId);
      out.write("' style='display:none' readonly/>\r\n");
      out.write("                        <button class=\"btn btn-danger\">Excluir</button>\r\n");
      out.write("                    </form>\r\n");
      out.write("                </div>\r\n");
      out.write("            </form>\r\n");
      out.write("        </div>\r\n");
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
