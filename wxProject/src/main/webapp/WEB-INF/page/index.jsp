<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head> <%@ include file="/WEB-INF/common/public.jsp"%>
<link rel="stylesheet" type="text/css" href="${ctx}/static/jquery-easyui-1.5/themes/bootstrap/easyui.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/static/jquery-easyui-1.5/css/wu.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/static/jquery-easyui-1.5/css/icon.css" />
<link type="text/css" rel="stylesheet" href="${ctx}/static/common/style/index/style/style.css?version=${versionId}" />
<link type="text/css" rel="stylesheet" href="${ctx}/static/common/style/page/style/style.css?version=${versionId}" />
<script type="text/javascript" src="${ctx}/static/common/js/LodopFuncs.js"></script>
<script type="text/javascript" src="${ctx}/static/common/js/setbottombtn.js"></script>
<script type="text/javascript">
	//自定义密码验证规则
	$.extend($.fn.validatebox.defaults.rules, {
		equals: {
			validator: function(value,param){
				return value == $(param[0]).val();
			},
			message: '确认密码必须与新密码一致！'
	    },
		notEquals: {
			validator: function(value,param){
				return value != $(param[0]).val();
			},
			message: '新密码不能与旧密码一致！'
	    }
	});
	//修改密码
	function modifyPassword(){
		$('#originalPassword_${uuid}').validatebox({required: true,validType:['length[6,30]']});
		$('#password_1_${uuid}').validatebox({required: true,validType:['length[6,30]',"notEquals['#originalPassword_${uuid}']"]});
		$('#password_2_${uuid}').validatebox({required: true,validType:['length[6,30]',"equals['#password_1_${uuid}']"]});
		$('#form_${uuid}').form("reset");
		$('#dialog_${uuid}').dialog({
		    title: '修改密码',
		    width: 400,
		    height: 250,
		    closed: false,
		    modal: true,
		    buttons:[{
		    	id:'save_${uuid}',
				text:'保存',
				iconCls:'icon-ok',
				handler:function(){
					$('#form_${uuid}').ajaxSubmit({
						url: '${ctx}/systemmanage/user/modifyPassword',
						type : 'post',
						dataType : 'json',
						data : {'userId':currUserId},
						beforeSubmit : function(formData, jqForm, options) { 
							var isValid = $('#form_${uuid}').form('validate');
							if(isValid){
								$("#save_${uuid},#cancel_${uuid}").linkbutton('disable');
								loadIndex = layer.load();
							}
							
							return isValid;
						},
						success: function(result){
							layer.close(loadIndex);
							if (result.success) {
								$.messager.alert('提示信息',result.message,'info',function(){
									window.top.location.href='${ctx}/logout';
								});
							}else{
								$("#save_${uuid},#cancel_${uuid}").linkbutton('enable');
								$.messager.alert('提示信息',result.message,'error',function(){});
							}
						},
						error : function(XMLHttpRequest, textStatus, errorThrown) {
							layer.close(loadIndex);
							$("#save_${uuid},#cancel_${uuid}").linkbutton('enable');
							$.messager.alert('提示信息',"系统错误:"+XMLHttpRequest.status,'error',function(){});
						}
					});
				}
			},{
				id:'cancel_${uuid}',
				text:'取消',
				iconCls:'icon-cancel',
				handler:function(){
					$('#dialog_${uuid}').dialog('close');
				}
			}]
		});
	}
	
	$(document).ready(function(){
	});
function reload(){
	location.reload();
}
</script>
</head>
<body class="easyui-layout">
	<!-- begin of header -->
	<div class="wu-header" data-options="region:'north',border:false,split:true">
    	<div class="wu-header-left">
        	<h1 style="float: left;"><img class="logo-img" style="width:380px" src="${ctx}/static/common/style/index/images/newlogo.png" /></h1>
        </div>
        <div class="wu-header-right" style="right:20px;top:16px;">
        	 <p><strong class="easyui-tooltip" title="欢迎使用！">${sessionScope.sys_session_rel_info.session_user_key.name}</strong>,欢迎您！&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;登录时间：<fmt:formatDate value="${sessionScope.sys_session_rel_info.session_user_login_time_key}" pattern="yyyy-MM-dd HH:mm"/></p>
        	 <p>
        	  	<div class="head-l" style="margin-top:0px;margin-left: 120px;">
        	  		<a  href="javascript:void(0)"  onclick="modifyPassword()" class="but but-little">修改密码</a>
        	   		 &nbsp;&nbsp;<a class="but but-little" href="javascript:void(0)"  onclick="window.top.location.href='${ctx}/logout'"><span class="icon-power-off"></span> 退出登录</a> 
        	   	</div>
        	 </p>
        </div>
    </div>
    <!-- end of header -->
    <!-- begin of sidebar -->
	<div class="wu-sidebar" data-options="region:'west',split:true,border:true,title:'导航菜单'"> 
    	<div class="easyui-accordion" data-options="border:false,fit:true"> 
	       <%@ include file="/WEB-INF/common/menu.jsp"%>
        </div>
    </div>	
    <!-- end of sidebar -->    
    <!-- begin of main -->
    <div class="wu-main" data-options="region:'center'">
        <div id="wu-tabs" class="easyui-tabs" data-options="border:false,fit:true">  
            <div title="我的首页" data-options="href:'${ctx}/welcome',closable:false,iconCls:'icon-tip',cls:'pd3'"></div>
        </div>
    </div>
    <!-- end of main --> 
    <!-- begin of footer -->
	<div class="wu-footer" data-options="region:'south',border:true,split:true">
    	&copy; 版权信息
    </div>
    <!-- end of footer -->  
    
    <!-- 修改密码界面 -->
	<div id="dialog_${uuid}" style="display: none;">
		<form id="form_${uuid}" method="post">
			<table class="table1">
				<tr>
					<th style="width:3%">旧密码：</th>
					<td><input class="easyui-validatebox" style="width:80%;height:22px;" type="password" name="originalPassword" id="originalPassword_${uuid}" style="" /></td>
				</tr>
				<tr>
					<th style="width:3%">新密码：</th>
					<td><input class="easyui-validatebox" style="width:80%;height:22px;"  type="password" name="password" id="password_1_${uuid}"/></td>
					
				</tr>
				<tr>
					<th style="width:3%">确认密码：</th>
					<td><input class="easyui-validatebox"  style="width:80%;height:22px;" type="password" id="password_2_${uuid}"/></td>
				</tr>
			</table>
		</form>
	</div>
    <script type="text/javascript">
		$(function(){
			$('.wu-side-tree a').bind("click",function(){
				var title = $(this).text();
				var url = $(this).attr('data-link');
				var iconCls = $(this).attr('data-icon');
				var iframe = $(this).attr('iframe')==1?true:false;
				addTab(title,url,iconCls,iframe);
			});	
		})
		
		/**
		* Name 载入树形菜单 
		*/
		$('#wu-side-tree').tree({
			url:'temp/menu.php',
			cache:false,
			onClick:function(node){
				var url = node.attributes['url'];
				if(url==null || url == ""){
					return false;
				}
				else{
					addTab(node.text, url, '', node.attributes['iframe']);
				}
			}
		});
		
		/**
		* Name 选项卡初始化
		*/
		$('#wu-tabs').tabs({
			tools:[{
				iconCls:'icon-reload',
				border:false,
				handler:function(){
					refreshTab();
				}
			}]
		});
			
		/**
		* Name 添加菜单选项
		* Param title 名称
		* Param href 链接
		* Param iconCls 图标样式
		* Param iframe 链接跳转方式（true为iframe，false为href）
		*/	
		function addTab(title, href, iconCls, iframe){
			var tabPanel = $('#wu-tabs');
			if(!tabPanel.tabs('exists',title)){
				var content = '<iframe scrolling="auto" frameborder="0"  src="'+ href +'" style="width:100%;height:100%;"></iframe>';
				if(iframe){
					tabPanel.tabs('add',{
						title:title,
						content:content,
						iconCls:iconCls,
						fit:true,
						cls:'pd3',
						closable:true
					});
				}
				else{
					tabPanel.tabs('add',{
						title:title,
						href:href,
						iconCls:iconCls,
						fit:true,
						cls:'pd3',
						closable:true,
						tools:[{
								iconCls:'icon-mini-refresh',
								handler:function(){
									refreshTab();
								}
						    }]
					});
				}
			}
			else
			{
				tabPanel.tabs('close',title);  
				tabPanel.tabs('add',{
					title:title,
					href:href,
					iconCls:iconCls,
					fit:true,
					cls:'pd3',
					closable:true,
					tools:[{
							iconCls:'icon-mini-refresh',
							handler:function(){
								refreshTab();
							}
					    }]
				});
			}
		}
		/**
		* Name 移除菜单选项
		*/
		function removeTab(){
			var tabPanel = $('#wu-tabs');
			var tab = tabPanel.tabs('getSelected');
			if (tab){
				var index = tabPanel.tabs('getTabIndex', tab);
				tabPanel.tabs('close', index);
			}
		}
		
		
		function refreshTab(){
			var currTab =  self.parent.$('#wu-tabs').tabs('getSelected'); //获得当前tab
		    var url = $(currTab.panel('options').content).attr('src');
		    currTab.panel('open').panel('refresh',url); 	
		}
	</script>
</body>
</html>
