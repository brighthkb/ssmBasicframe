package org.apache.jsp.WEB_002dINF.page.systemmanage.role;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class rolelist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/WEB-INF/common/taglib.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_shirox_hasAnyPermissions_permissionKeys;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_set_var_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_shirox_hasAnyPermissions_permissionKeys = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_set_var_value_nobody.release();
    _jspx_tagPool_shirox_hasAnyPermissions_permissionKeys.release();
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
      out.write("<div class=\"page\" id=\"panel_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t<div>\r\n");
      out.write("\t\t<!-- <div class=\"title\">\r\n");
      out.write("\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/common/style/page/images/spot.png\" /> 查询条件\r\n");
      out.write("\t\t</div> -->\r\n");
      out.write("\t\t<!--<div class=\"page-title\">\r\n");
      out.write("\t\t\t安全管理---角色管理\r\n");
      out.write("\t\t</div>-->\r\n");
      out.write("\t\t<div class=\"kuangxian\">\r\n");
      out.write("\t\t\t<table class=\"table1\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th style=\"width:1%;\">角色名称：<input type=\"text\" class=\"text1\" id=\"name_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"><input class=\"button\" type=\"button\" value=\"查询\" onclick=\"qryRoleList();\"/></th>\r\n");
      out.write("<!-- \t\t\t\t\t<td></td> -->\r\n");
      out.write("\r\n");
      out.write("<!-- \t\t\t\t\t<td><input class=\"button\" type=\"button\" value=\"查询\" onclick=\"qryRoleList();\"/></td> -->\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div>\r\n");
      out.write("\t\t<!-- <div class=\"title\">\r\n");
      out.write("\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/common/style/page/images/spot.png\" /> 查询结果\r\n");
      out.write("\t\t</div> -->\r\n");
      out.write("\t\t<table id=\"tb_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></table>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t$(document).ready(function(){\r\n");
      out.write("\t\t\t//工具栏操作按钮\r\n");
      out.write("\t\t\tvar toolbar = [];\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_shirox_hasAnyPermissions_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_shirox_hasAnyPermissions_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_shirox_hasAnyPermissions_2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\ttoolbar.push({\r\n");
      out.write("\t\t\t\t\ttext:'刷新',\r\n");
      out.write("\t\t\t\t\ticonCls:'icon-reload',\r\n");
      out.write("\t\t\t\t\thandler:function(){operCol('reload');}\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t//工具栏操作按钮\r\n");
      out.write("\t\t\tfunction operCol(method){\r\n");
      out.write("\t\t\t\tif(!method) return;\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tvar row = $('#tb_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("').datagrid('getSelected');\r\n");
      out.write("\t\t\t\tvar id = row?row.id:null;\r\n");
      out.write("\t\t\t\tif((method!='add' && method!='reload') && !id){\r\n");
      out.write("\t\t\t\t\t$.messager.alert('提示信息','请选中表格行数据!','warning');\r\n");
      out.write("\t\t\t\t\treturn;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tif(method=='add'){\r\n");
      out.write("\t\t\t\t\t$.jumpPage2('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("',\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/systemmanage/role/initDetail\",{oper:'add'});\r\n");
      out.write("\t\t\t\t}else if(method=='view'){\r\n");
      out.write("\t\t\t\t\t$.jumpPage2('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("',\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/systemmanage/role/initDetail\",{oper:'view',id:id});\r\n");
      out.write("\t\t\t\t}else if(method=='edit'){\r\n");
      out.write("\t\t\t\t\t$.jumpPage2('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("',\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/systemmanage/role/initDetail\",{oper:'edit',id:id});\r\n");
      out.write("\t\t\t\t}else if(method=='reload'){\r\n");
      out.write("\t\t\t\t\t$('#tb_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("').datagrid('reload');\r\n");
      out.write("\t\t\t\t}else if(method=='delete'){\r\n");
      out.write("\t\t\t\t\t$.messager.confirm(\"提示信息\",\"你确定要删除数据吗？\",function (isConfirm){\r\n");
      out.write("\t\t\t\t\t\tif(!isConfirm) return;\r\n");
      out.write("\t\t\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\t\t\turl:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/systemmanage/role/delete?id=\"+id,\r\n");
      out.write("\t\t\t\t\t\t\ttype : \"POST\",\r\n");
      out.write("\t\t\t\t\t\t\tdataType : \"json\",\r\n");
      out.write("\t\t\t\t\t\t\tsuccess : function(result) {\r\n");
      out.write("\t\t\t\t\t\t\t\t$.messager.alert('提示信息',result.message,result.success?'info':'error',function(){\r\n");
      out.write("\t\t\t\t\t\t\t\t\t$('#tb_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("').datagrid('reload');//刷新\r\n");
      out.write("\t\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\t\terror : function(XMLHttpRequest, textStatus, errorThrown){\r\n");
      out.write("\t\t\t\t\t\t\t\t$.messager.alert('提示信息',\"系统错误:\"+XMLHttpRequest.status,'error',function(){});\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t });\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t//加载表格\r\n");
      out.write("\t\t\t$('#tb_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("').datagrid({\r\n");
      out.write("\t\t\t\twidth:pageWidth,\r\n");
      out.write("\t\t\t    height:pageHeight-109,\r\n");
      out.write("\t\t\t    //title:'角色信息列表',\r\n");
      out.write("\t\t\t    //iconCls:'icon-list',\r\n");
      out.write("\t\t\t\tstriped: true,\r\n");
      out.write("\t\t\t\tsingleSelect:true,\r\n");
      out.write("\t\t\t\t//rownumbers: true,\r\n");
      out.write("\t\t\t\tfitColumns:true,\r\n");
      out.write("\t\t\t\tpagination: true,\r\n");
      out.write("\t\t\t\tpagePosition: 'bottom',\r\n");
      out.write("\t\t\t\tpageNumber:1,\r\n");
      out.write("\t\t\t\tpageSize:20,\r\n");
      out.write("\t\t\t\tpageList:[10,20,50,100],\r\n");
      out.write("\t\t\t    url:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/systemmanage/role/search',\r\n");
      out.write("\t\t\t    idField:'id',\r\n");
      out.write("\t\t\t    toolbar:toolbar,\r\n");
      out.write("\t\t\t    columns:[[\r\n");
      out.write("\t\t\t\t\t{title:'角色名称',field:'name',width:100,align:'center',halign:'center'},\r\n");
      out.write("\t\t\t\t\t{title:'描述',field:'description',width:300,align:'center',halign:'center'}\r\n");
      out.write("\t\t\t    ]],\r\n");
      out.write("\t\t\t    onDblClickRow: function(rowData){\r\n");
      out.write("\t\t\t    \toperCol('view');\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//查询\r\n");
      out.write("\t\tfunction qryRoleList(){\r\n");
      out.write("\t\t\t$('#tb_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("').datagrid('load', {\r\n");
      out.write("\t\t\t\tname: $('#name_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("').val()\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
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

  private boolean _jspx_meth_shirox_hasAnyPermissions_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shirox:hasAnyPermissions
    com.sczh.systemmanage.tags.HasAnyPermissionsTag _jspx_th_shirox_hasAnyPermissions_0 = (com.sczh.systemmanage.tags.HasAnyPermissionsTag) _jspx_tagPool_shirox_hasAnyPermissions_permissionKeys.get(com.sczh.systemmanage.tags.HasAnyPermissionsTag.class);
    _jspx_th_shirox_hasAnyPermissions_0.setPageContext(_jspx_page_context);
    _jspx_th_shirox_hasAnyPermissions_0.setParent(null);
    _jspx_th_shirox_hasAnyPermissions_0.setPermissionKeys("rolemanage:add");
    int _jspx_eval_shirox_hasAnyPermissions_0 = _jspx_th_shirox_hasAnyPermissions_0.doStartTag();
    if (_jspx_eval_shirox_hasAnyPermissions_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\ttoolbar.push({\r\n");
        out.write("\t\t\t\t\ttext:'新增',\r\n");
        out.write("\t\t\t\t\ticonCls:'icon-add',\r\n");
        out.write("\t\t\t\t\thandler:function(){operCol('add');}\r\n");
        out.write("\t\t\t\t});\r\n");
        out.write("\t\t\t\ttoolbar.push('-');\r\n");
        out.write("\t\t\t");
        int evalDoAfterBody = _jspx_th_shirox_hasAnyPermissions_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shirox_hasAnyPermissions_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_shirox_hasAnyPermissions_permissionKeys.reuse(_jspx_th_shirox_hasAnyPermissions_0);
      return true;
    }
    _jspx_tagPool_shirox_hasAnyPermissions_permissionKeys.reuse(_jspx_th_shirox_hasAnyPermissions_0);
    return false;
  }

  private boolean _jspx_meth_shirox_hasAnyPermissions_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shirox:hasAnyPermissions
    com.sczh.systemmanage.tags.HasAnyPermissionsTag _jspx_th_shirox_hasAnyPermissions_1 = (com.sczh.systemmanage.tags.HasAnyPermissionsTag) _jspx_tagPool_shirox_hasAnyPermissions_permissionKeys.get(com.sczh.systemmanage.tags.HasAnyPermissionsTag.class);
    _jspx_th_shirox_hasAnyPermissions_1.setPageContext(_jspx_page_context);
    _jspx_th_shirox_hasAnyPermissions_1.setParent(null);
    _jspx_th_shirox_hasAnyPermissions_1.setPermissionKeys("rolemanage:edit");
    int _jspx_eval_shirox_hasAnyPermissions_1 = _jspx_th_shirox_hasAnyPermissions_1.doStartTag();
    if (_jspx_eval_shirox_hasAnyPermissions_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\ttoolbar.push({\r\n");
        out.write("\t\t\t\t\ttext:'修改',\r\n");
        out.write("\t\t\t\t\ticonCls:'icon-edit',\r\n");
        out.write("\t\t\t\t\thandler:function(){operCol('edit');}\r\n");
        out.write("\t\t\t\t});\r\n");
        out.write("\t\t\t\ttoolbar.push('-');\r\n");
        out.write("\t\t\t");
        int evalDoAfterBody = _jspx_th_shirox_hasAnyPermissions_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shirox_hasAnyPermissions_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_shirox_hasAnyPermissions_permissionKeys.reuse(_jspx_th_shirox_hasAnyPermissions_1);
      return true;
    }
    _jspx_tagPool_shirox_hasAnyPermissions_permissionKeys.reuse(_jspx_th_shirox_hasAnyPermissions_1);
    return false;
  }

  private boolean _jspx_meth_shirox_hasAnyPermissions_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shirox:hasAnyPermissions
    com.sczh.systemmanage.tags.HasAnyPermissionsTag _jspx_th_shirox_hasAnyPermissions_2 = (com.sczh.systemmanage.tags.HasAnyPermissionsTag) _jspx_tagPool_shirox_hasAnyPermissions_permissionKeys.get(com.sczh.systemmanage.tags.HasAnyPermissionsTag.class);
    _jspx_th_shirox_hasAnyPermissions_2.setPageContext(_jspx_page_context);
    _jspx_th_shirox_hasAnyPermissions_2.setParent(null);
    _jspx_th_shirox_hasAnyPermissions_2.setPermissionKeys("rolemanage:delete");
    int _jspx_eval_shirox_hasAnyPermissions_2 = _jspx_th_shirox_hasAnyPermissions_2.doStartTag();
    if (_jspx_eval_shirox_hasAnyPermissions_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\ttoolbar.push({\r\n");
        out.write("\t\t\t\t\ttext:'删除',\r\n");
        out.write("\t\t\t\t\ticonCls:'icon-remove',\r\n");
        out.write("\t\t\t\t\thandler:function(){operCol('delete');}\r\n");
        out.write("\t\t\t\t});\r\n");
        out.write("\t\t\t\ttoolbar.push('-');\r\n");
        out.write("\t\t\t");
        int evalDoAfterBody = _jspx_th_shirox_hasAnyPermissions_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shirox_hasAnyPermissions_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_shirox_hasAnyPermissions_permissionKeys.reuse(_jspx_th_shirox_hasAnyPermissions_2);
      return true;
    }
    _jspx_tagPool_shirox_hasAnyPermissions_permissionKeys.reuse(_jspx_th_shirox_hasAnyPermissions_2);
    return false;
  }
}
