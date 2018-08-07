package org.apache.jsp.WEB_002dINF.page.systemmanage.role;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class roleInfo_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/WEB-INF/common/taglib.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_set_var_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_set_var_value_nobody.release();
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
      out.write("<div class=\"page\" id=\"page_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("    <div id=\"panel_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"easyui-panel infoContent\" data-options=\"footer:'#footer_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("'\" style=\"background-color: transparent;\"\r\n");
      out.write("    \ttitle=\"");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      if (_jspx_meth_c_if_2(_jspx_page_context))
        return;
      out.write("角色信息\">\r\n");
      out.write("    \t<form id=\"form_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" method=\"post\">\r\n");
      out.write("    \t\t<input type=\"hidden\" id=\"id_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" name=\"id\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${role.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("    \t\t<div class=\"table2\" >\r\n");
      out.write("\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t<label class=\"form-label\">角色名称：</label>\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" class=\"text2\" id=\"name_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" name=\"name\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${role.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" maxlength=\"50\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t<label class=\"form-label\">描述：</label>\r\n");
      out.write("\t\t\t\t\t<textarea class=\"textarea2\" id=\"description_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" name=\"description\" maxlength=\"1000\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${role.description}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</textarea>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t<label class=\"form-label\">权限：</label>\r\n");
      out.write("\t\t\t\t\t<ul id=\"permission_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" style=\"width:200px;height: 300px;    overflow: auto;text-align: left;\"></ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("    \t</form>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div id=\"footer_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"formFooter\">\r\n");
      out.write("    \t");
      if (_jspx_meth_c_if_3(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t<a id=\"cancel_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-cancel'\">\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_c_if_4(_jspx_page_context))
        return;
      if (_jspx_meth_c_if_5(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t</a>\r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t/**     ======初始化底部图标=====      */\r\n");
      out.write("\t\treturnIco($(\".formFooter a\"));\r\n");
      out.write("\t\t/**     ======初始化界面 元素=====      */\r\n");
      out.write("\t\t$('#footer_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" .easyui-linkbutton').linkbutton({});\r\n");
      out.write("\t\t$('#name_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("').validatebox({required: true});\r\n");
      out.write("\t\t$('#permission_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("').tree({\r\n");
      out.write("\t\t\tlines: true,\r\n");
      out.write("\t\t\tanimate: true,\r\n");
      out.write("\t\t\tcheckbox:true,\r\n");
      out.write("\t\t    url: '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/systemmanage/permission/getPermissionTree',\r\n");
      out.write("\t\t    onLoadSuccess:function(){\r\n");
      out.write("\t\t    \tif(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${role.permissionIds}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"){\r\n");
      out.write("\t\t    \t\t$.each(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${role.permissionIds}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\".split(','), function(i,n){\r\n");
      out.write("\t\t    \t\t\tvar node = $('#permission_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("').tree('find', n);\r\n");
      out.write("\t\t    \t\t\tif($('#permission_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("').tree('isLeaf', node.target)){//防止级联选中\r\n");
      out.write("\t\t\t    \t\t\t$('#permission_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("').tree('check', node.target);\r\n");
      out.write("\t\t    \t\t\t}\r\n");
      out.write("\t\t    \t\t});\r\n");
      out.write("\t\t    \t}\r\n");
      out.write("\t\t    \t$('#permission_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("').width($('#name_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("').width());\r\n");
      out.write("\t\t    \t$('#permission_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("').parent().height(pageHeight-205);\r\n");
      out.write("\t\t    }\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$('#cancel_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("').click(function(e){\r\n");
      out.write("\t\t\te.preventDefault();\r\n");
      out.write("\t\t\t$.jumpPage3('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("');\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t//表单提交\r\n");
      out.write("\t\t$('#save_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("').click(function(e){\r\n");
      out.write("\t\t\te.preventDefault();\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar param = {};\r\n");
      out.write("\t\t\t//获取选中和半选中状态的节点\r\n");
      out.write("\t\t\tvar nodes = $('#permission_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("').tree('getChecked', ['checked','indeterminate']);\r\n");
      out.write("\t\t\tif(nodes && nodes.length>0){\r\n");
      out.write("\t\t\t\tvar permissionIds = [];\r\n");
      out.write("\t\t\t\t$.each(nodes, function(i,n){\r\n");
      out.write("\t\t\t\t\tpermissionIds.push(n.id);\r\n");
      out.write("\t    \t\t});\r\n");
      out.write("\t\t\t\tparam['permissionIds'] = permissionIds.join(',');\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar url = \"\";\r\n");
      out.write("\t\t\tvar oper = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${oper}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("';\r\n");
      out.write("\t\t\tif(oper=='add'){\r\n");
      out.write("\t\t\t\turl = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/systemmanage/role/add';\r\n");
      out.write("\t\t\t}else if(oper=='edit'){\r\n");
      out.write("\t\t\t\turl = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/systemmanage/role/edit';\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t$('#form_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("').ajaxSubmit({\r\n");
      out.write("\t\t\t\turl: url,\r\n");
      out.write("\t\t\t\ttype : 'post',\r\n");
      out.write("\t\t\t\tdataType : 'json',\r\n");
      out.write("\t\t\t\tdata : param,\r\n");
      out.write("\t\t\t\tbeforeSubmit : function(formData, jqForm, options) { \r\n");
      out.write("\t\t\t\t\tvar isValid = $('#form_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("').form('validate');\r\n");
      out.write("\t\t\t\t\tif(isValid){\r\n");
      out.write("\t\t\t\t\t\t$(\"#save_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(",#cancel_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\").linkbutton('disable');\r\n");
      out.write("\t\t\t\t\t\tloadIndex = layer.load();\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\treturn isValid;\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tsuccess: function(result){\r\n");
      out.write("\t\t\t\t\tlayer.close(loadIndex);\r\n");
      out.write("\t\t\t\t\tif (result.success) {\r\n");
      out.write("\t\t\t\t\t\t$.messager.alert('提示信息',result.message,'info',function(){\r\n");
      out.write("\t\t\t\t\t\t\t$.jumpPage3('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("',qryRoleList);\r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\t$(\"#save_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(",#cancel_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\").linkbutton('enable');\r\n");
      out.write("\t\t\t\t\t\t$.messager.alert('提示信息',result.message,'error',function(){});\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\terror : function(XMLHttpRequest, textStatus, errorThrown) {\r\n");
      out.write("\t\t\t\t\tlayer.close(loadIndex);\r\n");
      out.write("\t\t\t\t\t$(\"#save_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(",#cancel_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\").linkbutton('enable');\r\n");
      out.write("\t\t\t\t\t$.messager.alert('提示信息',\"系统错误:\"+XMLHttpRequest.status,'error',function(){});\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\t\r\n");
      out.write("\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(document).ready(function(){\r\n");
      out.write("\t\t\t$('#panel_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("').panel({\r\n");
      out.write("\t\t\t\tfit : true\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tif('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${oper}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("'=='view'){\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t</script>\r\n");
      out.write("</div>");
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

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${oper=='view'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write('查');
        out.write('看');
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

  private boolean _jspx_meth_c_if_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent(null);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${oper=='add'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write('新');
        out.write('增');
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

  private boolean _jspx_meth_c_if_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_2.setPageContext(_jspx_page_context);
    _jspx_th_c_if_2.setParent(null);
    _jspx_th_c_if_2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${oper=='edit'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_2 = _jspx_th_c_if_2.doStartTag();
    if (_jspx_eval_c_if_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write('编');
        out.write('辑');
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

  private boolean _jspx_meth_c_if_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_3 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_3.setPageContext(_jspx_page_context);
    _jspx_th_c_if_3.setParent(null);
    _jspx_th_c_if_3.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${oper!='view' }", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_3 = _jspx_th_c_if_3.doStartTag();
    if (_jspx_eval_c_if_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("        \t<a id=\"save_");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-ok'\">保存</a>\r\n");
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

  private boolean _jspx_meth_c_if_4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_4 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_4.setPageContext(_jspx_page_context);
    _jspx_th_c_if_4.setParent(null);
    _jspx_th_c_if_4.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${oper!='view'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_4 = _jspx_th_c_if_4.doStartTag();
    if (_jspx_eval_c_if_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write('取');
        out.write('消');
        int evalDoAfterBody = _jspx_th_c_if_4.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_4);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_4);
    return false;
  }

  private boolean _jspx_meth_c_if_5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_5 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_5.setPageContext(_jspx_page_context);
    _jspx_th_c_if_5.setParent(null);
    _jspx_th_c_if_5.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${oper=='view'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_5 = _jspx_th_c_if_5.doStartTag();
    if (_jspx_eval_c_if_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write('返');
        out.write('回');
        int evalDoAfterBody = _jspx_th_c_if_5.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_5);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_5);
    return false;
  }
}
