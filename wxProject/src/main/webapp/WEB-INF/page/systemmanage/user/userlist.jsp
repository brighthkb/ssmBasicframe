<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/common/taglib.jsp"%>
<style>
	.kuangxian span.textbox.combo.datebox{width:150px!important;}
</style>
<div class="page" id="panel_${uuid}">
	<div>
	<!--<div class="page-title">
		安全管理---用户管理
	</div>-->
		<%-- <div class="title">
			<img src="${ctx}/static/common/style/page/images/spot.png" /> 查询条件
		</div> --%>
		<div class="kuangxian">
			<table class="table1"> 
				<tr>
					<th style="width:2.8%;">用户名：</th>
					<td><input type="text" class="text1" id="loginName_${uuid}"></td>
					<th style="width:2.8%;">用户状态：</th>
					<td><select class="select1" id="state_${uuid}"></select></td>
					
				</tr>
				<tr>
					<th style="width:2.8%;">创建时间：</th>
					<td colspan="3" style="width: 15%;">
						<input type="text" class="text1" style="height: 30px;" id="createDate_start_${uuid}">
						&nbsp;至&nbsp;
						<input type="text" class="text1" style="height: 30px;" id="createDate_end_${uuid}">
					</td>
					<th style="width:2.8%;">所属部门：</th>
					<td><input type="text" class="text1" id="dept_${uuid}"><input class="button" type="button" value="查询" onclick="qryUserList();"/></td>
<!-- 					<td><input class="button" type="button" value="查询" onclick="qryUserList();"/></td> -->
				</tr>
			</table>
		</div>
	</div>
	<div>
		<%-- <div class="title">
			<img src="${ctx}/static/common/style/page/images/spot.png"/> 查询结果
		</div> --%>
		<table id="tb_${uuid}"></table>
	</div>

	<script type="text/javascript">	
		$(document).ready(function(){
			//初始化查询条件
			$('#state_${uuid}').initSelectOption("user_state", "--请选择--", null);
			$('#createDate_start_${uuid}').datebox({
			    //required:true
			});
			$('#createDate_end_${uuid}').datebox({
			    //required:true
			});
			
			//工具栏操作按钮
			var toolbar = [];
			<shirox:hasAnyPermissions permissionKeys="usermanage:add">
				toolbar.push({
					text:'新增',
					iconCls:'icon-add',
					handler:function(){operCol('add');}
				});
				toolbar.push('-');
			</shirox:hasAnyPermissions>
			<shirox:hasAnyPermissions permissionKeys="usermanage:edit">
				toolbar.push({
					text:'修改',
					iconCls:'icon-edit',
					handler:function(){operCol('edit');}
				});
				toolbar.push('-');
			</shirox:hasAnyPermissions>
			<shirox:hasAnyPermissions permissionKeys="usermanage:delete">
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
					$.jumpPage2('${uuid}',"${ctx}/systemmanage/user/initDetail",{oper:'add'});
				}else if(method=='view'){
					$.jumpPage2('${uuid}',"${ctx}/systemmanage/user/initDetail",{oper:'view',id:id});
				}else if(method=='edit'){
					$.jumpPage2('${uuid}',"${ctx}/systemmanage/user/initDetail",{oper:'edit',id:id});
				}else if(method=='reload'){
					$('#tb_${uuid}').datagrid('reload');
				}else if(method=='delete'){
					$.messager.confirm("提示信息","你确定要删除数据吗？",function (isConfirm){
						if(!isConfirm) return;
						$.ajax({
							url:"${ctx}/systemmanage/user/delete?id="+id,
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
			    // title:'用户信息列表',
			    //iconCls:'icon-list',
				striped: true,
				singleSelect:true,
				// rownumbers: true,
				fitColumns:true,
				pagination: true,
				pagePosition: 'bottom',
				pageNumber:1,
				pageSize:20,
				pageList:[10,20,50,100],
			    url:'${ctx}/systemmanage/user/search',
			    idField:'id',
			    toolbar:toolbar,
			    columns:[[
					{title:'用户名',field:'loginName',width:60,align:'center',halign:'center'},
					{title:'姓名',field:'name',width:60,align:'center',halign:'center'},
					{title:'所属地市',field:'city',width:60,align:'center',halign:'center'},
					{title:'所属部门',field:'dept',width:120,align:'center',halign:'center'},
					{title:'电话',field:'tel',width:60,align:'center',halign:'center'},
					{title:'E-mail',field:'email',width:60,align:'center',halign:'center'},
					{title:'已选角色ID',field:'roleIds',hidden:true},
					{title:'已选角色',field:'roleNames',width:120,align:'center',halign:'center'},
					{title:'创建时间',field:'createDate',width:60,align:'center',halign:'center'},
					{title:'创建人ID',field:'creator',hidden:true},
					{title:'创建人',field:'creatorName',width:60,align:'center',halign:'center'},
					{title:'用户状态',field:'state',width:60,align:'center',halign:'center'}
			    ]],
			    onDblClickRow: function(rowData){
			    	operCol('view');
				}
			});
		});
		
		//查询
		function qryUserList(){
			$('#tb_${uuid}').datagrid('load', {
				loginName: $('#loginName_${uuid}').val(),
				state: $('#state_${uuid}').val(),
				createDate_start: $('#createDate_start_${uuid}').datebox('getValue'),
				createDate_end: $('#createDate_end_${uuid}').datebox('getValue'),
				dept: $('#dept_${uuid}').val()
			});
		}
	</script>
</div>