<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/common/taglib.jsp"%>
<div class="page" id="panel_${uuid}">
	<div>
		<!-- <div class="title">
			<img src="${ctx}/static/common/style/page/images/spot.png" /> 查询结果
		</div> -->
		<!--<div class="page-title">
			安全管理---	权限管理
		</div>-->
	</div>
	<div>
		<table id="tb_${uuid}"></table>
	</div>
	<script type="text/javascript">
		$(document).ready(function(){
			//工具栏操作按钮
			var toolbar = [];
			<shirox:hasAnyPermissions permissionKeys="permissionmanage:add">
				toolbar.push({
					text:'新增',
					iconCls:'icon-add',
					handler:function(){operCol('add');}
				});
				toolbar.push('-');
			</shirox:hasAnyPermissions>
			<shirox:hasAnyPermissions permissionKeys="permissionmanage:edit">
				toolbar.push({
					text:'修改',
					iconCls:'icon-edit',
					handler:function(){operCol('edit');}
				});
				toolbar.push('-');
			</shirox:hasAnyPermissions>
			<shirox:hasAnyPermissions permissionKeys="permissionmanage:delete">
				toolbar.push({
					text:'删除',
					iconCls:'icon-remove',
					handler:function(){operCol('delete');}
				});
				toolbar.push('-');
			</shirox:hasAnyPermissions>
				toolbar.push({
					text:'刷新',
					iconCls:'icon-reload',
					handler:function(){operCol('reload');}
				});
			//操作方法
			function operCol(method){
				if(!method) return;
				
				var row = $('#tb_${uuid}').treegrid('getSelected');
				var id = row?row.id:null;
				if((method!='add' && method!='reload') && !id){
					$.messager.alert('提示信息','请选中表格行数据!','warning');
					return;
				}
				
				if(method=='add'){
					$.jumpPage2('${uuid}',"${ctx}/systemmanage/permission/initDetail",{oper:'add',parentId:id});
				}else if(method=='view'){
					$.jumpPage2('${uuid}',"${ctx}/systemmanage/permission/initDetail",{oper:'view',id:id});
				}else if(method=='edit'){
					$.jumpPage2('${uuid}',"${ctx}/systemmanage/permission/initDetail",{oper:'edit',id:id});
				}else if(method=='reload'){
					$('#tb_${uuid}').treegrid('reload');
				}else if(method=='delete'){
					$.messager.confirm("提示信息","你确定要删除数据吗？",function (isConfirm){
						if(!isConfirm) return;
						$.ajax({
							url:"${ctx}/systemmanage/permission/delete?id="+id,
							type : "POST",
							dataType : "json",
							success : function(result) {
								$.messager.alert('提示信息',result.message,result.success?'info':'error',function(){
									$('#tb_${uuid}').treegrid('reload');//刷新
								});
							},
							error : function(XMLHttpRequest, textStatus, errorThrown){
								$.messager.alert('提示信息',"系统错误:"+XMLHttpRequest.status,'error',function(){});
							}
						 });
					});
				}
			}
			//格式列
			function format_isMenu(value,row,index){
				if(value=="1"){
					return "是";
				}else{
					return "否";
				}
			}
			//加载表格
			$('#tb_${uuid}').treegrid({
				width:pageWidth,
			    height:pageHeight-60,
			   // title:'权限信息列表',
			    //iconCls:'icon-list',
				striped: true,
				singleSelect:true,
				//rownumbers: true,
				fitColumns:true,
			    url:'${ctx}/systemmanage/permission/search',
			    idField:'id',
			    treeField:'name',
			    animate: true,
			    toolbar:toolbar,
			    columns:[[
					{title:'名称',field:'name',width:200,align:'left',halign:'center'},
					{title:'标识',field:'permissionKey',width:200,align:'left',halign:'center'},
					{title:'菜单',field:'isMenu',width:80,align:'center',halign:'center',formatter: format_isMenu},
					{title:'链接',field:'menuUrl',width:200,align:'left',halign:'center'},
					{title:'图标',field:'menuIcon',width:80,align:'center',halign:'center'},
					{title:'排序',field:'orderNo',width:80,align:'center',halign:'center'},
					{title:'父节点ID',field:'_parentId',hidden:true}
			    ]],
			    onDblClickRow: function(rowData){
			    	operCol('view');
				},onLoadSuccess: function () {
					  $('#tb_${uuid}').treegrid('collapseAll');
				}
			});
		});
		
		//查询
		function qryPermissionList(){
			$('#tb_${uuid}').treegrid('load');
		}	
	</script>
</div>