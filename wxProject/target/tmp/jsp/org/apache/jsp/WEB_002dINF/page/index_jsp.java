package org.apache.jsp.WEB_002dINF.page;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(5);
    _jspx_dependants.add("/WEB-INF/common/public.jsp");
    _jspx_dependants.add("/WEB-INF/common/taglib.jsp");
    _jspx_dependants.add("/WEB-INF/tlds/shirox.tld");
    _jspx_dependants.add("/WEB-INF/tlds/utils.tld");
    _jspx_dependants.add("/WEB-INF/common/menu.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_fmt_formatDate_value_pattern_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_varStatus_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_fmt_formatDate_value_pattern_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_set_var_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_forEach_varStatus_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_fmt_formatDate_value_pattern_nobody.release();
    _jspx_tagPool_c_set_var_value_nobody.release();
    _jspx_tagPool_c_forEach_varStatus_var_items.release();
    _jspx_tagPool_c_if_test.release();
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

      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
      out.write("<head> ");
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
      out.write("\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/jquery-easyui-1.5/themes/bootstrap/easyui.css\" />\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/jquery-easyui-1.5/css/wu.css\" />\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/jquery-easyui-1.5/css/icon.css\" />\n");
      out.write("<link type=\"text/css\" rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/common/style/index/style/style.css?version=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${versionId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" />\n");
      out.write("<link type=\"text/css\" rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/common/style/page/style/style.css?version=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${versionId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" />\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/common/js/LodopFuncs.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/common/js/setbottombtn.js\"></script>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\t//自定义密码验证规则\n");
      out.write("\t$.extend($.fn.validatebox.defaults.rules, {\n");
      out.write("\t\tequals: {\n");
      out.write("\t\t\tvalidator: function(value,param){\n");
      out.write("\t\t\t\treturn value == $(param[0]).val();\n");
      out.write("\t\t\t},\n");
      out.write("\t\t\tmessage: '确认密码必须与新密码一致！'\n");
      out.write("\t    },\n");
      out.write("\t\tnotEquals: {\n");
      out.write("\t\t\tvalidator: function(value,param){\n");
      out.write("\t\t\t\treturn value != $(param[0]).val();\n");
      out.write("\t\t\t},\n");
      out.write("\t\t\tmessage: '新密码不能与旧密码一致！'\n");
      out.write("\t    }\n");
      out.write("\t});\n");
      out.write("\t//修改密码\n");
      out.write("\tfunction modifyPassword(){\n");
      out.write("\t\t$('#originalPassword_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("').validatebox({required: true,validType:['length[6,30]']});\n");
      out.write("\t\t$('#password_1_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("').validatebox({required: true,validType:['length[6,30]',\"notEquals['#originalPassword_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("']\"]});\n");
      out.write("\t\t$('#password_2_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("').validatebox({required: true,validType:['length[6,30]',\"equals['#password_1_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("']\"]});\n");
      out.write("\t\t$('#form_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("').form(\"reset\");\n");
      out.write("\t\t$('#dialog_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("').dialog({\n");
      out.write("\t\t    title: '修改密码',\n");
      out.write("\t\t    width: 400,\n");
      out.write("\t\t    height: 250,\n");
      out.write("\t\t    closed: false,\n");
      out.write("\t\t    modal: true,\n");
      out.write("\t\t    buttons:[{\n");
      out.write("\t\t    \tid:'save_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("',\n");
      out.write("\t\t\t\ttext:'保存',\n");
      out.write("\t\t\t\ticonCls:'icon-ok',\n");
      out.write("\t\t\t\thandler:function(){\n");
      out.write("\t\t\t\t\t$('#form_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("').ajaxSubmit({\n");
      out.write("\t\t\t\t\t\turl: '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/systemmanage/user/modifyPassword',\n");
      out.write("\t\t\t\t\t\ttype : 'post',\n");
      out.write("\t\t\t\t\t\tdataType : 'json',\n");
      out.write("\t\t\t\t\t\tdata : {'userId':currUserId},\n");
      out.write("\t\t\t\t\t\tbeforeSubmit : function(formData, jqForm, options) { \n");
      out.write("\t\t\t\t\t\t\tvar isValid = $('#form_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("').form('validate');\n");
      out.write("\t\t\t\t\t\t\tif(isValid){\n");
      out.write("\t\t\t\t\t\t\t\t$(\"#save_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(",#cancel_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\").linkbutton('disable');\n");
      out.write("\t\t\t\t\t\t\t\tloadIndex = layer.load();\n");
      out.write("\t\t\t\t\t\t\t}\n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\treturn isValid;\n");
      out.write("\t\t\t\t\t\t},\n");
      out.write("\t\t\t\t\t\tsuccess: function(result){\n");
      out.write("\t\t\t\t\t\t\tlayer.close(loadIndex);\n");
      out.write("\t\t\t\t\t\t\tif (result.success) {\n");
      out.write("\t\t\t\t\t\t\t\t$.messager.alert('提示信息',result.message,'info',function(){\n");
      out.write("\t\t\t\t\t\t\t\t\twindow.top.location.href='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/logout';\n");
      out.write("\t\t\t\t\t\t\t\t});\n");
      out.write("\t\t\t\t\t\t\t}else{\n");
      out.write("\t\t\t\t\t\t\t\t$(\"#save_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(",#cancel_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\").linkbutton('enable');\n");
      out.write("\t\t\t\t\t\t\t\t$.messager.alert('提示信息',result.message,'error',function(){});\n");
      out.write("\t\t\t\t\t\t\t}\n");
      out.write("\t\t\t\t\t\t},\n");
      out.write("\t\t\t\t\t\terror : function(XMLHttpRequest, textStatus, errorThrown) {\n");
      out.write("\t\t\t\t\t\t\tlayer.close(loadIndex);\n");
      out.write("\t\t\t\t\t\t\t$(\"#save_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(",#cancel_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\").linkbutton('enable');\n");
      out.write("\t\t\t\t\t\t\t$.messager.alert('提示信息',\"系统错误:\"+XMLHttpRequest.status,'error',function(){});\n");
      out.write("\t\t\t\t\t\t}\n");
      out.write("\t\t\t\t\t});\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t},{\n");
      out.write("\t\t\t\tid:'cancel_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("',\n");
      out.write("\t\t\t\ttext:'取消',\n");
      out.write("\t\t\t\ticonCls:'icon-cancel',\n");
      out.write("\t\t\t\thandler:function(){\n");
      out.write("\t\t\t\t\t$('#dialog_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("').dialog('close');\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t}]\n");
      out.write("\t\t});\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\t$(document).ready(function(){\n");
      out.write("\t});\n");
      out.write("function reload(){\n");
      out.write("\tlocation.reload();\n");
      out.write("}\n");
      out.write("</script>\n");
      out.write("</head>\n");
      out.write("<body class=\"easyui-layout\">\n");
      out.write("\t<!-- begin of header -->\n");
      out.write("\t<div class=\"wu-header\" data-options=\"region:'north',border:false,split:true\">\n");
      out.write("    \t<div class=\"wu-header-left\">\n");
      out.write("        \t<h1 style=\"float: left;\"><img class=\"logo-img\" style=\"width:380px\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/common/style/index/images/newlogo.png\" /></h1>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"wu-header-right\" style=\"right:20px;top:16px;\">\n");
      out.write("        \t <p><strong class=\"easyui-tooltip\" title=\"欢迎使用！\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.sys_session_rel_info.session_user_key.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</strong>,欢迎您！&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;登录时间：");
      if (_jspx_meth_fmt_formatDate_0(_jspx_page_context))
        return;
      out.write("</p>\n");
      out.write("        \t <p>\n");
      out.write("        \t  \t<div class=\"head-l\" style=\"margin-top:0px;margin-left: 120px;\">\n");
      out.write("        \t  \t\t<a  href=\"javascript:void(0)\"  onclick=\"modifyPassword()\" class=\"but but-little\">修改密码</a>\n");
      out.write("        \t   \t\t &nbsp;&nbsp;<a class=\"but but-little\" href=\"javascript:void(0)\"  onclick=\"window.top.location.href='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/logout'\"><span class=\"icon-power-off\"></span> 退出登录</a> \n");
      out.write("        \t   \t</div>\n");
      out.write("        \t </p>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <!-- end of header -->\n");
      out.write("    <!-- begin of sidebar -->\n");
      out.write("\t<div class=\"wu-sidebar\" data-options=\"region:'west',split:true,border:true,title:'导航菜单'\"> \n");
      out.write("    \t<div class=\"easyui-accordion\" data-options=\"border:false,fit:true\"> \n");
      out.write("\t       ");
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
      out.write("\r\n");
      if (_jspx_meth_c_set_8(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_set_9(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_c_set_11(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_forEach_1(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </div>\t\n");
      out.write("    <!-- end of sidebar -->    \n");
      out.write("    <!-- begin of main -->\n");
      out.write("    <div class=\"wu-main\" data-options=\"region:'center'\">\n");
      out.write("        <div id=\"wu-tabs\" class=\"easyui-tabs\" data-options=\"border:false,fit:true\">  \n");
      out.write("            <div title=\"我的首页\" data-options=\"href:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/welcome',closable:false,iconCls:'icon-tip',cls:'pd3'\"></div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <!-- end of main --> \n");
      out.write("    <!-- begin of footer -->\n");
      out.write("\t<div class=\"wu-footer\" data-options=\"region:'south',border:true,split:true\">\n");
      out.write("    \t&copy; 成都昊天鼎力科技有限公司技术支持\n");
      out.write("    </div>\n");
      out.write("    <!-- end of footer -->  \n");
      out.write("    \n");
      out.write("    <!-- 修改密码界面 -->\n");
      out.write("\t<div id=\"dialog_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" style=\"display: none;\">\n");
      out.write("\t\t<form id=\"form_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" method=\"post\">\n");
      out.write("\t\t\t<table class=\"table1\">\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<th style=\"width:3%\">旧密码：</th>\n");
      out.write("\t\t\t\t\t<td><input class=\"easyui-validatebox\" style=\"width:80%;height:22px;\" type=\"password\" name=\"originalPassword\" id=\"originalPassword_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" style=\"\" /></td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<th style=\"width:3%\">新密码：</th>\n");
      out.write("\t\t\t\t\t<td><input class=\"easyui-validatebox\" style=\"width:80%;height:22px;\"  type=\"password\" name=\"password\" id=\"password_1_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/></td>\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<th style=\"width:3%\">确认密码：</th>\n");
      out.write("\t\t\t\t\t<td><input class=\"easyui-validatebox\"  style=\"width:80%;height:22px;\" type=\"password\" id=\"password_2_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/></td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t</table>\n");
      out.write("\t\t</form>\n");
      out.write("\t</div>\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("\t\t$(function(){\n");
      out.write("\t\t\t$('.wu-side-tree a').bind(\"click\",function(){\n");
      out.write("\t\t\t\tvar title = $(this).text();\n");
      out.write("\t\t\t\tvar url = $(this).attr('data-link');\n");
      out.write("\t\t\t\tvar iconCls = $(this).attr('data-icon');\n");
      out.write("\t\t\t\tvar iframe = $(this).attr('iframe')==1?true:false;\n");
      out.write("\t\t\t\taddTab(title,url,iconCls,iframe);\n");
      out.write("\t\t\t});\t\n");
      out.write("\t\t})\n");
      out.write("\t\t\n");
      out.write("\t\t/**\n");
      out.write("\t\t* Name 载入树形菜单 \n");
      out.write("\t\t*/\n");
      out.write("\t\t$('#wu-side-tree').tree({\n");
      out.write("\t\t\turl:'temp/menu.php',\n");
      out.write("\t\t\tcache:false,\n");
      out.write("\t\t\tonClick:function(node){\n");
      out.write("\t\t\t\tvar url = node.attributes['url'];\n");
      out.write("\t\t\t\tif(url==null || url == \"\"){\n");
      out.write("\t\t\t\t\treturn false;\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t\telse{\n");
      out.write("\t\t\t\t\taddTab(node.text, url, '', node.attributes['iframe']);\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t}\n");
      out.write("\t\t});\n");
      out.write("\t\t\n");
      out.write("\t\t/**\n");
      out.write("\t\t* Name 选项卡初始化\n");
      out.write("\t\t*/\n");
      out.write("\t\t$('#wu-tabs').tabs({\n");
      out.write("\t\t\ttools:[{\n");
      out.write("\t\t\t\ticonCls:'icon-reload',\n");
      out.write("\t\t\t\tborder:false,\n");
      out.write("\t\t\t\thandler:function(){\n");
      out.write("\t\t\t\t\trefreshTab();\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t}]\n");
      out.write("\t\t});\n");
      out.write("\t\t\t\n");
      out.write("\t\t/**\n");
      out.write("\t\t* Name 添加菜单选项\n");
      out.write("\t\t* Param title 名称\n");
      out.write("\t\t* Param href 链接\n");
      out.write("\t\t* Param iconCls 图标样式\n");
      out.write("\t\t* Param iframe 链接跳转方式（true为iframe，false为href）\n");
      out.write("\t\t*/\t\n");
      out.write("\t\tfunction addTab(title, href, iconCls, iframe){\n");
      out.write("\t\t\tvar tabPanel = $('#wu-tabs');\n");
      out.write("\t\t\tif(!tabPanel.tabs('exists',title)){\n");
      out.write("\t\t\t\tvar content = '<iframe scrolling=\"auto\" frameborder=\"0\"  src=\"'+ href +'\" style=\"width:100%;height:100%;\"></iframe>';\n");
      out.write("\t\t\t\tif(iframe){\n");
      out.write("\t\t\t\t\ttabPanel.tabs('add',{\n");
      out.write("\t\t\t\t\t\ttitle:title,\n");
      out.write("\t\t\t\t\t\tcontent:content,\n");
      out.write("\t\t\t\t\t\ticonCls:iconCls,\n");
      out.write("\t\t\t\t\t\tfit:true,\n");
      out.write("\t\t\t\t\t\tcls:'pd3',\n");
      out.write("\t\t\t\t\t\tclosable:true\n");
      out.write("\t\t\t\t\t});\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t\telse{\n");
      out.write("\t\t\t\t\ttabPanel.tabs('add',{\n");
      out.write("\t\t\t\t\t\ttitle:title,\n");
      out.write("\t\t\t\t\t\thref:href,\n");
      out.write("\t\t\t\t\t\ticonCls:iconCls,\n");
      out.write("\t\t\t\t\t\tfit:true,\n");
      out.write("\t\t\t\t\t\tcls:'pd3',\n");
      out.write("\t\t\t\t\t\tclosable:true,\n");
      out.write("\t\t\t\t\t\ttools:[{\n");
      out.write("\t\t\t\t\t\t\t\ticonCls:'icon-mini-refresh',\n");
      out.write("\t\t\t\t\t\t\t\thandler:function(){\n");
      out.write("\t\t\t\t\t\t\t\t\trefreshTab();\n");
      out.write("\t\t\t\t\t\t\t\t}\n");
      out.write("\t\t\t\t\t\t    }]\n");
      out.write("\t\t\t\t\t});\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\telse\n");
      out.write("\t\t\t{\n");
      out.write("\t\t\t\ttabPanel.tabs('close',title);  \n");
      out.write("\t\t\t\ttabPanel.tabs('add',{\n");
      out.write("\t\t\t\t\ttitle:title,\n");
      out.write("\t\t\t\t\thref:href,\n");
      out.write("\t\t\t\t\ticonCls:iconCls,\n");
      out.write("\t\t\t\t\tfit:true,\n");
      out.write("\t\t\t\t\tcls:'pd3',\n");
      out.write("\t\t\t\t\tclosable:true,\n");
      out.write("\t\t\t\t\ttools:[{\n");
      out.write("\t\t\t\t\t\t\ticonCls:'icon-mini-refresh',\n");
      out.write("\t\t\t\t\t\t\thandler:function(){\n");
      out.write("\t\t\t\t\t\t\t\trefreshTab();\n");
      out.write("\t\t\t\t\t\t\t}\n");
      out.write("\t\t\t\t\t    }]\n");
      out.write("\t\t\t\t});\n");
      out.write("\t\t\t}\n");
      out.write("\t\t}\n");
      out.write("\t\t/**\n");
      out.write("\t\t* Name 移除菜单选项\n");
      out.write("\t\t*/\n");
      out.write("\t\tfunction removeTab(){\n");
      out.write("\t\t\tvar tabPanel = $('#wu-tabs');\n");
      out.write("\t\t\tvar tab = tabPanel.tabs('getSelected');\n");
      out.write("\t\t\tif (tab){\n");
      out.write("\t\t\t\tvar index = tabPanel.tabs('getTabIndex', tab);\n");
      out.write("\t\t\t\ttabPanel.tabs('close', index);\n");
      out.write("\t\t\t}\n");
      out.write("\t\t}\n");
      out.write("\t\t\n");
      out.write("\t\t\n");
      out.write("\t\tfunction refreshTab(){\n");
      out.write("\t\t\tvar currTab =  self.parent.$('#wu-tabs').tabs('getSelected'); //获得当前tab\n");
      out.write("\t\t    var url = $(currTab.panel('options').content).attr('src');\n");
      out.write("\t\t    currTab.panel('open').panel('refresh',url); \t\n");
      out.write("\t\t}\n");
      out.write("\t</script>\n");
      out.write("</body>\n");
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

  private boolean _jspx_meth_fmt_formatDate_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatDate
    org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag _jspx_th_fmt_formatDate_0 = (org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag) _jspx_tagPool_fmt_formatDate_value_pattern_nobody.get(org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag.class);
    _jspx_th_fmt_formatDate_0.setPageContext(_jspx_page_context);
    _jspx_th_fmt_formatDate_0.setParent(null);
    _jspx_th_fmt_formatDate_0.setValue((java.util.Date) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.sys_session_rel_info.session_user_login_time_key}", java.util.Date.class, (PageContext)_jspx_page_context, null));
    _jspx_th_fmt_formatDate_0.setPattern("yyyy-MM-dd HH:mm");
    int _jspx_eval_fmt_formatDate_0 = _jspx_th_fmt_formatDate_0.doStartTag();
    if (_jspx_th_fmt_formatDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_formatDate_value_pattern_nobody.reuse(_jspx_th_fmt_formatDate_0);
      return true;
    }
    _jspx_tagPool_fmt_formatDate_value_pattern_nobody.reuse(_jspx_th_fmt_formatDate_0);
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

  private boolean _jspx_meth_c_set_8(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_8 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_8.setPageContext(_jspx_page_context);
    _jspx_th_c_set_8.setParent(null);
    _jspx_th_c_set_8.setVar("permissions");
    _jspx_th_c_set_8.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.sys_session_rel_info.session_user_permission_key}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_8 = _jspx_th_c_set_8.doStartTag();
    if (_jspx_th_c_set_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_8);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_8);
    return false;
  }

  private boolean _jspx_meth_c_set_9(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_9 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_9.setPageContext(_jspx_page_context);
    _jspx_th_c_set_9.setParent(null);
    _jspx_th_c_set_9.setVar("defaultMenuUrl");
    _jspx_th_c_set_9.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${jumpMenuUrl}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_9 = _jspx_th_c_set_9.doStartTag();
    if (_jspx_th_c_set_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_9);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_9);
    return false;
  }

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${empty defaultMenuUrl}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t");
        if (_jspx_meth_c_forEach_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_0, _jspx_page_context))
          return true;
        out.write('\r');
        out.write('\n');
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_forEach_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_varStatus_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_0);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${permissions}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("permission");
    _jspx_th_c_forEach_0.setVarStatus("status");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t");
          if (_jspx_meth_c_if_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\r\n");
          out.write("\t");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_varStatus_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_if_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${empty defaultMenuUrl}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t");
        if (_jspx_meth_c_if_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_1, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
          return true;
        out.write("\r\n");
        out.write("\t\t");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
    return false;
  }

  private boolean _jspx_meth_c_if_2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_2.setPageContext(_jspx_page_context);
    _jspx_th_c_if_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_1);
    _jspx_th_c_if_2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${permission.isMenu eq 1 and not empty permission.menuUrl}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_2 = _jspx_th_c_if_2.doStartTag();
    if (_jspx_eval_c_if_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t");
        if (_jspx_meth_c_set_10((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_2, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
          return true;
        out.write("\r\n");
        out.write("\t\t\t");
        int evalDoAfterBody = _jspx_th_c_if_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
    return false;
  }

  private boolean _jspx_meth_c_set_10(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_2, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_10 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_10.setPageContext(_jspx_page_context);
    _jspx_th_c_set_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_2);
    _jspx_th_c_set_10.setVar("defaultMenuUrl");
    _jspx_th_c_set_10.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${permission.menuUrl}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_10 = _jspx_th_c_set_10.doStartTag();
    if (_jspx_th_c_set_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_10);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_10);
    return false;
  }

  private boolean _jspx_meth_c_set_11(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_11 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_11.setPageContext(_jspx_page_context);
    _jspx_th_c_set_11.setParent(null);
    _jspx_th_c_set_11.setVar("menus");
    _jspx_th_c_set_11.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.sys_session_rel_info.session_user_menu_tree_key}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_11 = _jspx_th_c_set_11.doStartTag();
    if (_jspx_th_c_set_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_11);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_11);
    return false;
  }

  private boolean _jspx_meth_c_forEach_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_varStatus_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_1.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_1.setParent(null);
    _jspx_th_c_forEach_1.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${menus}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_1.setVar("menu_1");
    _jspx_th_c_forEach_1.setVarStatus("status_1");
    int[] _jspx_push_body_count_c_forEach_1 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_1 = _jspx_th_c_forEach_1.doStartTag();
      if (_jspx_eval_c_forEach_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t<div title=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${menu_1.menu.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" data-options=\"iconCls:'icon-application-cascade'\" style=\"padding:5px;\">\r\n");
          out.write("\t\t");
          if (_jspx_meth_c_if_3((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_1, _jspx_page_context, _jspx_push_body_count_c_forEach_1))
            return true;
          out.write("\r\n");
          out.write("\t</div>\r\n");
          int evalDoAfterBody = _jspx_th_c_forEach_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_1.doFinally();
      _jspx_tagPool_c_forEach_varStatus_var_items.reuse(_jspx_th_c_forEach_1);
    }
    return false;
  }

  private boolean _jspx_meth_c_if_3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_3 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_3.setPageContext(_jspx_page_context);
    _jspx_th_c_if_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_1);
    _jspx_th_c_if_3.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not empty menu_1.children}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_3 = _jspx_th_c_if_3.doStartTag();
    if (_jspx_eval_c_if_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t<ul class=\"easyui-tree wu-side-tree\" style=\"border: 0px;\">\r\n");
        out.write("\t\t");
        if (_jspx_meth_c_forEach_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_3, _jspx_page_context, _jspx_push_body_count_c_forEach_1))
          return true;
        out.write("\r\n");
        out.write("\t\t</ul>\r\n");
        out.write("\t\t");
        int evalDoAfterBody = _jspx_th_c_if_3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_3);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_3);
    return false;
  }

  private boolean _jspx_meth_c_forEach_2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_3, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_2 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_varStatus_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_2.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_3);
    _jspx_th_c_forEach_2.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${menu_1.children}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_2.setVar("menu_2");
    _jspx_th_c_forEach_2.setVarStatus("status_2");
    int[] _jspx_push_body_count_c_forEach_2 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_2 = _jspx_th_c_forEach_2.doStartTag();
      if (_jspx_eval_c_forEach_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t<li iconCls=\"icon-chart-organisation\">\r\n");
          out.write("\t\t\t\t<a href=\"javascript:void(0)\" data-icon=\"icon-chart-organisation\"  \r\n");
          out.write("\t\t\t\tiframe=\"0\" data-link=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('/');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${menu_2.menu.menuUrl}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${menu_2.menu.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</a>\r\n");
          out.write("\t\t\t</li>\r\n");
          out.write("\t\t");
          int evalDoAfterBody = _jspx_th_c_forEach_2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_2[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_2.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_2.doFinally();
      _jspx_tagPool_c_forEach_varStatus_var_items.reuse(_jspx_th_c_forEach_2);
    }
    return false;
  }
}
