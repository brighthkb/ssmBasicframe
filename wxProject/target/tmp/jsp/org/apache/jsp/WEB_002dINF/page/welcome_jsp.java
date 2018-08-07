package org.apache.jsp.WEB_002dINF.page;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class welcome_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/WEB-INF/common/taglib.jsp");
    _jspx_dependants.add("/WEB-INF/common/public.jsp");
  }

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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_c_set_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_set_1(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_set_2(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_set_3(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/common/js/System.Business.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/common/js/jqueryAjaxJson.js\"></script>");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML>\r\n");
      out.write("<html lang=\"zh-CN\">\r\n");
      out.write("  <head>\r\n");
      out.write("    <title>主页</title>\r\n");
      out.write("     ");
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_c_set_4(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_set_5(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_set_6(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_set_7(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/common/js/System.Business.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/common/js/jqueryAjaxJson.js\"></script>");
      out.write("\r\n");
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
      out.write("<!-- 引用easyui前端框架和对应的jquery版本  -->\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/jquery-easyui-1.5/themes/default/easyui.css?version=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${versionId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/jquery-easyui-1.5/themes/icon.css?version=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${versionId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/jquery-easyui-1.5/jquery.min.js?version=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${versionId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/jquery-easyui-1.5/jquery.easyui.min.js?version=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${versionId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/jquery-easyui-1.5/locale/easyui-lang-zh_CN.js?version=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${versionId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></script>\r\n");
      out.write("<!-- form表单提交【不用easyui form组件，因为submit提交有问题】-->\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/jquery-form/jquery.form.3.51.js?version=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${versionId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" type=\"text/javascript\"></script>\r\n");
      out.write("<!-- 弹出框、提示框JS组件【只使用load方法】 -->\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/layer/layer.js?version=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${versionId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/layer/extend/layer.ext.js?version=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${versionId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></script>\r\n");
      out.write("<!-- 公用js方法  -->\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/common/js/public.js?version=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${versionId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></script>\r\n");
      out.write("<!-- 扩展easyui组件  -->\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/common/js/extentEasyui.js?version=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${versionId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tvar ctx = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("';\r\n");
      out.write("\tvar currUserId = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${currUserId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("';\r\n");
      out.write("\tvar currUserCity = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${currUserCity}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("';\r\n");
      out.write("\t$.extend($.fn.validatebox.defaults.rules, {\r\n");
      out.write("\t\tdatevalidate: {\r\n");
      out.write("\t\t\tvalidator: function(value, param){\r\n");
      out.write("\t\t\t\treturn /^\\d{4}\\-\\d{2}\\-\\d{2}$/.test(value);\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tmessage: '请填写合法的时间格式！'\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\tdoublevalidate:{\r\n");
      out.write("\t\t\tvalidator: function(value, param){\r\n");
      out.write("\t\t\t\treturn /^(:?(:?\\d+.\\d{1,2})|(:?\\d+))$/.test(value);\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tmessage: '请填写合法的金额格式！'\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\tintvalidate:{\r\n");
      out.write("\t\t\tvalidator: function(value, param){\r\n");
      out.write("\t\t\t\treturn /^[0-9]*[1-9][0-9]*$/.test(value);\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tmessage: '请填写合法的数字格式！'\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\tintandzimuvalidate:{\r\n");
      out.write("\t\t\tvalidator: function(value, param){\r\n");
      out.write("\t\t\t\treturn /^[0-9a-zA-Z]{12}$/.test(value);\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tmessage: '请填写数字加字母的12位格式！'\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\tintorcodevalidate:{\r\n");
      out.write("\t\t\tvalidator: function(value, param){\r\n");
      out.write("\t\t\t\treturn /^\\d{7}$/.test(value);\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tmessage: '请填写7位的数字格式！'\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("\tvar pageWidth,pageHeight;\r\n");
      out.write("\tfunction isPublisher(useridp,useridl){\r\n");
      out.write("\t\tif(useridp==useridl){\r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\t$.messager.alert('提示信息','您选中的合同您没有权限编辑!','warning');\r\n");
      out.write("\t\t\treturn false;\t\t\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\t<meta http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"expires\" content=\"0\">    \r\n");
      out.write("\t<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\r\n");
      out.write("\t<meta http-equiv=\"description\" content=\"This is my page\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t <style>\r\n");
      out.write("  \t.homewrap{width:98%;height:auto;background:#fff;padding:1%;}\r\n");
      out.write("  \t.wraptop{width:100%;height:100px;overflow: hidden;}\r\n");
      out.write("  \t.welcomeimg{width:680px;float:left;}\r\n");
      out.write("  \t.willdoingnum{width:475px;height:40px;line-height:40px;padding:30px 0; text-align:center;float:right; cursor: pointer;background:#d2d2d3;}\r\n");
      out.write("  \t.wicon{width: 3em; height: 3em;color:#ec4e00;vertical-align: middle;fill: currentColor;overflow: hidden;position:relative;top:-5px;}\r\n");
      out.write("  \t.willdotxt{font-size:20px;color:#3b3b3b;}\r\n");
      out.write("  \t.willdonum{font-size:30px;color:#02124e;}\r\n");
      out.write("  \t.counttable{border-collapse: collapse;width: 100%; font-size:14px;}\r\n");
      out.write("  \t.counttable td,.counttable th{border:solid 1px #ddd;padding:0.8em 0; text-align: center;}\r\n");
      out.write("  \t.counttable th{background:#f5f5f5;}\r\n");
      out.write("  \t.counttit{height:50px;line-height:50px;text-align: center;font-size:20px;}\r\n");
      out.write("  \t</style>\r\n");
      out.write("\t <div class=\"homewrap\">\r\n");
      out.write("\t\t<div class=\"wraptop\">\r\n");
      out.write("\t\t\t<div class=\"welcomeimg\">\r\n");
      out.write("\t\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/common/style/index/images/welcomen.jpg\" />\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"willdoingnum\" id=\"willdoNum\" onclick=\"sub('我待办流程','");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/processtype/processtypelistdealt')\">\r\n");
      out.write("\t\t\t\t<svg t=\"1524576650833\" class=\"wicon\" viewBox=\"0 0 1024 1024\" version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" p-id=\"985\"><path d=\"M120.76 892.532V127.648c0-4.252 3.447-7.714 7.699-7.714h643.527c4.252 0 7.714 3.462 7.714 7.714V436.24h55.82V127.648c0-35.024-28.496-63.534-63.534-63.534H128.459c-35.024 0-63.52 28.51-63.52 63.534v764.884c0 35.024 28.496 63.534 63.52 63.534h360.27v-55.82h-360.27c-4.252 0-7.7-3.462-7.7-7.714z\" p-id=\"986\"></path><path d=\"M287.66 552.786c-15.413 0-27.91 12.484-27.91 27.91s12.497 27.91 27.91 27.91h111.45c15.414 0 27.91-12.483 27.91-27.91s-12.496-27.91-27.91-27.91H287.66zM636.538 429.7c0-15.427-12.496-27.91-27.91-27.91H287.661c-15.414 0-27.91 12.483-27.91 27.91s12.496 27.91 27.91 27.91h320.966c15.414 0 27.91-12.483 27.91-27.91z m-27.91-173.403H287.661c-15.414 0-27.91 12.483-27.91 27.91s12.496 27.91 27.91 27.91h320.966c15.414 0 27.91-12.483 27.91-27.91s-12.496-27.91-27.91-27.91z m211.765 462.452H764.75v-90.272c0-15.427-12.496-27.91-27.91-27.91s-27.91 12.483-27.91 27.91v118.182c0 15.427 12.497 27.91 27.91 27.91h83.554c15.414 0 27.91-12.483 27.91-27.91s-12.497-27.91-27.91-27.91z\"  p-id=\"987\"></path><path d=\"M738.67 515.126c-121.258 0-219.56 98.3-219.56 219.56s98.301 219.56 219.56 219.56c121.26 0 219.562-98.3 219.562-219.56s-98.301-219.56-219.561-219.56z m0 383.3c-90.285 0-163.739-73.454-163.739-163.741 0-90.286 73.454-163.74 163.74-163.74 90.286 0 163.74 73.454 163.74 163.74 0 90.287-73.453 163.74-163.74 163.74z\" p-id=\"988\" data-spm-anchor-id=\"a313x.7781069.0.i0\"></path></svg>\r\n");
      out.write("\t\t\t\t<span class=\"willdotxt\">待办流程</span>\r\n");
      out.write("\t\t\t\t<span class=\"willdonum\" id=\"needtocountSapn\"></span>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"counttit\">统计详情</div>\r\n");
      out.write("\t\t<table id=\"tb_count_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"counttable\"></table>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\twindow.onload=function(){\r\n");
      out.write("\t\tvar countNum=document.getElementById(\"willdoNum\");\r\n");
      out.write("\t\tcountNum.style.width=countNum.parentNode.clientWidth-690+\"px\";\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tjsonAjax(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/processtype/processquerylist/needtocount_pc.action\",{userid:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("'},\"json\",\r\n");
      out.write("\t\t\t  \tfunction(data){\r\n");
      out.write("\t\t var needtocountvar=data;\r\n");
      out.write("\t\t\t$(\"#needtocountSapn\").text(needtocountvar+\"件\");\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction sub(title,url){\r\n");
      out.write("\t\tvar tabPanel = $('#wu-tabs');\r\n");
      out.write("\t\ttabPanel.tabs('close',title);  \r\n");
      out.write("\t\ttabPanel.tabs('add',{\r\n");
      out.write("\t\t\ttitle:title,\r\n");
      out.write("\t\t\thref:url,\r\n");
      out.write("\t\t\tfit:true,\r\n");
      out.write("\t\t\tcls:'pd3',\r\n");
      out.write("\t\t\tclosable:true,\r\n");
      out.write("\t\t\ttools:[{\r\n");
      out.write("\t\t\t\t\ticonCls:'icon-mini-refresh',\r\n");
      out.write("\t\t\t\t\thandler:function(){\r\n");
      out.write("\t\t\t\t\t\trefreshTab();\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t    }]\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction refreshTab(){\r\n");
      out.write("\t\tvar currTab =  self.parent.$('#wu-tabs').tabs('getSelected'); //获得当前tab\r\n");
      out.write("\t    var url = $(currTab.panel('options').content).attr('src');\r\n");
      out.write("\t    currTab.panel('open').panel('refresh',url); \t\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t$(document).ready(function(){\r\n");
      out.write("\t\t//加载表格\r\n");
      out.write("\t\t$('#tb_count_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("').datagrid({\r\n");
      out.write("\t\t\twidth:pageWidth,\r\n");
      out.write("\t\t    height:pageHeight-109,\r\n");
      out.write("\t\t    title:'项目利润统计',\r\n");
      out.write("\t\t\tstriped: true,\r\n");
      out.write("\t\t\tsingleSelect:true,\r\n");
      out.write("\t\t\tfitColumns:true,\r\n");
      out.write("\t\t\tpagination: true,\r\n");
      out.write("\t\t\tpagePosition: 'bottom',\r\n");
      out.write("\t\t\tpageNumber:1,\r\n");
      out.write("\t\t\tpageSize:20,\r\n");
      out.write("\t\t\tpageList:[10,20,50,100],\r\n");
      out.write("\t\t    url:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/statistical/statisticaltype/search',\r\n");
      out.write("\t\t    idField:'id',\r\n");
      out.write("\t\t    columns:[[\r\n");
      out.write("\t\t\t\t{title:'项目名称',field:'pmname',width:60,align:'center',halign:'center'},\r\n");
      out.write("\t\t\t\t{title:'项目经理',field:'pmmname',width:60,align:'center',halign:'center'},\r\n");
      out.write("\t\t\t\t{title:'合同甲方',field:'contractfirst',width:120,align:'center',halign:'center'},\r\n");
      out.write("\t\t\t\t{title:'施工图预算',field:'sgtnum',width:60,align:'center',halign:'center'},\r\n");
      out.write("\t\t\t\t{title:'施工预算',field:'sgnum',width:60,align:'center',halign:'center'},\r\n");
      out.write("\t\t\t\t{title:'合同预算',field:'htyu',width:60,align:'center',halign:'center'},\r\n");
      out.write("\t\t\t\t{title:'入库金额',field:'rkje',width:60,align:'center',halign:'center'},\r\n");
      out.write("\t\t\t\t{title:'利润总价',field:'lr',width:60,align:'center',halign:'center'},\r\n");
      out.write("\t\t    ]],\r\n");
      out.write("\t\t    onDblClickRow: function(rowData){\r\n");
      out.write("\t\t    \tvar row = $('#tb_count_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("').datagrid('getSelected');\r\n");
      out.write("\t\t    \tvar id = row?row.id:null;\r\n");
      out.write("\t\t    \tsub('查询统计','");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/statistical/statisticaltype/toStatisticalDetail?contract_id='+id)\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
    _jspx_th_c_set_1.setVar("currUserId");
    _jspx_th_c_set_1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.sys_session_rel_info.session_user_key.id}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_1 = _jspx_th_c_set_1.doStartTag();
    if (_jspx_th_c_set_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_1);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_1);
    return false;
  }

  private boolean _jspx_meth_c_set_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_2 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_2.setPageContext(_jspx_page_context);
    _jspx_th_c_set_2.setParent(null);
    _jspx_th_c_set_2.setVar("currUserCity");
    _jspx_th_c_set_2.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.sys_session_rel_info.session_user_key.city}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_2 = _jspx_th_c_set_2.doStartTag();
    if (_jspx_th_c_set_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_2);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_2);
    return false;
  }

  private boolean _jspx_meth_c_set_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_3 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_3.setPageContext(_jspx_page_context);
    _jspx_th_c_set_3.setParent(null);
    _jspx_th_c_set_3.setVar("versionId");
    _jspx_th_c_set_3.setValue(new String("1.0.0.20170904"));
    int _jspx_eval_c_set_3 = _jspx_th_c_set_3.doStartTag();
    if (_jspx_th_c_set_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_3);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_3);
    return false;
  }

  private boolean _jspx_meth_c_set_4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_4 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_4.setPageContext(_jspx_page_context);
    _jspx_th_c_set_4.setParent(null);
    _jspx_th_c_set_4.setVar("ctx");
    _jspx_th_c_set_4.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_4 = _jspx_th_c_set_4.doStartTag();
    if (_jspx_th_c_set_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_4);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_4);
    return false;
  }

  private boolean _jspx_meth_c_set_5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_5 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_5.setPageContext(_jspx_page_context);
    _jspx_th_c_set_5.setParent(null);
    _jspx_th_c_set_5.setVar("currUserId");
    _jspx_th_c_set_5.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.sys_session_rel_info.session_user_key.id}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_5 = _jspx_th_c_set_5.doStartTag();
    if (_jspx_th_c_set_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_5);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_5);
    return false;
  }

  private boolean _jspx_meth_c_set_6(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_6 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_6.setPageContext(_jspx_page_context);
    _jspx_th_c_set_6.setParent(null);
    _jspx_th_c_set_6.setVar("currUserCity");
    _jspx_th_c_set_6.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.sys_session_rel_info.session_user_key.city}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_6 = _jspx_th_c_set_6.doStartTag();
    if (_jspx_th_c_set_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_6);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_6);
    return false;
  }

  private boolean _jspx_meth_c_set_7(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_7 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_7.setPageContext(_jspx_page_context);
    _jspx_th_c_set_7.setParent(null);
    _jspx_th_c_set_7.setVar("versionId");
    _jspx_th_c_set_7.setValue(new String("1.0.0.20170904"));
    int _jspx_eval_c_set_7 = _jspx_th_c_set_7.doStartTag();
    if (_jspx_th_c_set_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_7);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_7);
    return false;
  }
}
