package org.apache.jsp.WEB_002dINF.page;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var_value_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_set_var_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_set_var_value_nobody.release();
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"w3.org/TR/html4/strict.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      if (_jspx_meth_c_set_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_set_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/common/js/System.Business.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/common/js/jqueryAjaxJson.js\"></script>\r\n");
      out.write("<meta http-equiv=\"Content-type\" content=\"text/html\" charset=\"utf-8\" />\r\n");
      out.write("<meta name=\"keywords\" content=\"扬帆远航工程管理系统\" />\r\n");
      out.write("<meta name=\"description\" content=\"扬帆远航工程管理系统\" />\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\" /> <!-- 为了让 IE 浏览器运行最新的渲染模式下-->\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\r\n");
      out.write("<meta name=\"renderer\" content=\"webkit\" />\r\n");
      out.write("<title>扬帆远航工程管理系统</title>\r\n");
      out.write("<link rel= \"shortcut icon \" href= \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/common/style/login/images/logo.png?version=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${versionId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/common/style/login/style/style.css\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/jquery-easyui-1.5/jquery.min.js?version=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${versionId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/layer/layer.js?version=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${versionId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(document).ready(function() {\r\n");
      out.write("\t\t//登陆错误消息提示\r\n");
      out.write("\t\tif ('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${errorMsg}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("') {\r\n");
      out.write("\t\t\tlayer.msg('<div style=\"color:red;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${errorMsg}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("<div/>', {\r\n");
      out.write("\t\t\t\ticon : 3\r\n");
      out.write("\t\t\t}, function() {\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\trefreshVerCode('codeImg', 'loginCode');\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("\t//切换验证码\r\n");
      out.write("\tfunction refreshVerCode(id, verCodeType) {\r\n");
      out.write("\t\t$(\"#\" + id).attr(\r\n");
      out.write("\t\t\t\t'src',\r\n");
      out.write("\t\t\t\t\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/common/verification/verificationCode.jsp?verCodeType=\"\r\n");
      out.write("\t\t\t\t\t\t+ verCodeType + \"&randNum=\" + Math.random() * 11);\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id=\"large-header\" class=\"large-header\">\r\n");
      out.write("\t\t<div class=\"login-box\">\r\n");
      out.write("\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/common/style/login/images/newlogo.png\"\r\n");
      out.write("\t\t\t\tclass=\"loginlogo\" alt=\"\" />\r\n");
      out.write("\t\t\t<div class=\"main-agileits\">\r\n");
      out.write("\t\t\t\t<!--form-stars-here-->\r\n");
      out.write("\t\t\t\t<div class=\"form-w3-agile\">\r\n");
      out.write("\t\t\t\t\t<form action=\"#\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t\t<img class=\"userImg\" style=\"width: 20px;\"\r\n");
      out.write("\t\t\t\t\t\t\t\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/common/style/login/images/l_ico1.png\" alt=\"\" />\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" required=\"true\" class=\"\" id=\"username\"\r\n");
      out.write("\t\t\t\t\t\t\t\tname=\"username\" placeholder=\"请输入用户名\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${username}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" />\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t\t<img class=\"userImg\" style=\"width: 20px;\"\r\n");
      out.write("\t\t\t\t\t\t\t\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/common/style/login/images/l_ico2.png\" alt=\"\" />\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"password\" required=\"true\" class=\"\" id=\"password\"\r\n");
      out.write("\t\t\t\t\t\t\t\tname=\"password\" placeholder=\"请输入密码\" />\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t\t<img class=\"userImg\" style=\"width: 20px;\"\r\n");
      out.write("\t\t\t\t\t\t\t\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/common/style/login/images/l_ico3.png\" alt=\"\" />\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" required=\"true\" name=\"code\"\r\n");
      out.write("\t\t\t\t\t\t\t\tplaceholder=\"请输入验证码\" /> <img\r\n");
      out.write("\t\t\t\t\t\t\t\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/common/verification/verificationCode.jsp?verCodeType=loginCode\"\r\n");
      out.write("\t\t\t\t\t\t\t\tid=\"codeImg\" onclick=\"refreshVerCode('codeImg','loginCode');\"\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"yzm-code\" alt=\"\" />\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"submit-w3l\" style=\"background: none\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"submit\" id=\"loginBtn\" value=\"登  录\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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

  private boolean _jspx_meth_c_set_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_0.setPageContext(_jspx_page_context);
    _jspx_th_c_set_0.setParent(null);
    _jspx_th_c_set_0.setVar("ctx");
    _jspx_th_c_set_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_0 = _jspx_th_c_set_0.doStartTag();
    if (_jspx_th_c_set_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
    return false;
  }

  private boolean _jspx_meth_c_set_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_1 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_1.setPageContext(_jspx_page_context);
    _jspx_th_c_set_1.setParent(null);
    _jspx_th_c_set_1.setVar("versionId");
    _jspx_th_c_set_1.setValue(new String("1.0.0.20170904"));
    int _jspx_eval_c_set_1 = _jspx_th_c_set_1.doStartTag();
    if (_jspx_th_c_set_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_1);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_1);
    return false;
  }
}
