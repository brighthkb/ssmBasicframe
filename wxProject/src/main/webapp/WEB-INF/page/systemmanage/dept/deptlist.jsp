<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/common/taglib.jsp"%>
<div class="page" id="panel_${uuid}">
	<div>
		<!-- <div class="title">
			<img src="${ctx}/static/common/style/page/images/spot.png" /> 查询条件
		</div> -->
		<!--<div class="page-title">
			安全管理---部门管理
		</div>-->
		<div class="kuangxian">
			<table class="table1">
				<tr>
					<th style="padding-left: 30px">部门名称：<input type="text" class="text1" id="name_${uuid}"><input class="button" type="button" value="查询" onclick="qryDeptList();"/></th>
<%-- 					<td  style="width: 30%"><input type="text" class="text1" id="name_${uuid}"></td> --%>
<!-- 					<td><input class="button" type="button" value="查询" onclick="qryDeptList();"/></td> -->
				</tr>
			</table>
		</div>
	</div>
	<div>
		<!-- <div class="title">
			<img src="${ctx}/static/common/style/page/images/spot.png"/> 查询结果
		</div> -->
		<table id="tb_${uuid}"></table>
	</div>

	<script type="text/javascript">	
		$(document).ready(function(){
			//工具栏操作按钮
			var toolbar = [];
			<shirox:hasAnyPermissions permissionKeys="deptmanage:add">
				toolbar.push({
					text:'新增',
					iconCls:'icon-add',
					handler:function(){operCol('add');}
				});
				toolbar.push('-');
			</shirox:hasAnyPermissions>
			<shirox:hasAnyPermissions permissionKeys="deptmanage:edit">
				toolbar.push({
					text:'修改',
					iconCls:'icon-edit',
					handler:function(){operCol('edit');}
				});
				toolbar.push('-');
			</shirox:hasAnyPermissions>
			<shirox:hasAnyPermissions permissionKeys="deptmanage:delete">
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
				
				var row = $('#tb_${uuid}').datagrid('getSelected');
				var id = row?row.id:null;
				if((method!='add' && method!='reload') && !id){
					$.messager.alert('提示信息','请选中表格行数据!','warning');
					return;
				}
				
				if(method=='add'){
					$.jumpPage2('${uuid}',"${ctx}/systemmanage/dept/initDetail",{oper:'add'});
				}else if(method=='view'){
					$.jumpPage2('${uuid}',"${ctx}/systemmanage/dept/initDetail",{oper:'view',id:id});
				}else if(method=='edit'){
					$.jumpPage2('${uuid}',"${ctx}/systemmanage/dept/initDetail",{oper:'edit',id:id});
				}else if(method=='reload'){
					$('#tb_${uuid}').datagrid('reload');
				}else if(method=='delete'){
					$.messager.confirm("提示信息","你确定要删除数据吗？",function (isConfirm){
						if(!isConfirm) return;
						$.ajax({
							url:"${ctx}/systemmanage/dept/delete?id="+id,
							type : "POST",
							dataType : "json",
							success : function(result) {
								$.messager.alert('提示信息',result.message,result.success?'info':'error',function(){
									$('#tb_${uuid}').datagrid('reload');//刷新
								});
							},
							error : function(XMLHttpRequest, textStatus, errorThrown){
								$.messager.alert('提示信息',"系统错误:"+XMLHttpRequest.status,'error',function(){});
							}
						 });
					});
				}
			}
			//加载表格
			$('#tb_${uuid}').datagrid({
				width:pageWidth,
			    height:pageHeight-109,
			    //title:'用户信息列表',
			    //iconCls:'icon-list',
				striped: true,
				singleSelect:true,
				//rownumbers: true,
				fitColumns:true,
				pagination: true,
				pagePosition: 'bottom',
				pageNumber:1,
				pageSize:20,
				pageList:[10,20,50,100],
			    url:'${ctx}/systemmanage/dept/search',
			    idField:'id',
			    toolbar:toolbar,
			    columns:[[
					{title:'部门名称',field:'name',width:60,align:'center',halign:'center'},
					{title:'联系人',field:'linkman',width:60,align:'center',halign:'center'},
					{title:'联系电话',field:'tel',width:60,align:'center',halign:'center'}
			    ]],
			    onDblClickRow: function(rowData){
			    	operCol('view');
				}
			});
		});
		
		//查询
		function qryDeptList(){
			$('#tb_${uuid}').datagrid('load', {
				name: $('#name_${uuid}').val(),
			});
		}
	</script>
</div>