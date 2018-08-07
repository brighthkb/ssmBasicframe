<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/common/taglib.jsp"%>
<div class="page" id="panel_${uuid}">
	<div>
		<!--<div class="page-title">
			安全管理---字典管理
		</div>-->
		 
		<div class="kuangxian">
			<table class="table1">
				<tr>
					<th style="width: 10%;padding-left: 30px">字典名称：<input type="text" class="text1" id="name_${uuid}"></th>
<%-- 					<td  style="width: 10%"><input type="text" class="text1" id="name_${uuid}"></td> --%>
					<th style="width: 10%;padding-left: 30px">字典值：<input type="text" class="text1" id="datadicval_${uuid}"></th>
<%-- 					<td  style="width: 10%"><input type="text" class="text1" id="datadicval_${uuid}"></td> --%>
					<th style="width: 10%;padding-left: 30px">字典表达式：<input type="text" class="text1" id="expr_${uuid}"><input class="button" type="button" value="查询" onclick="qryDeptList();"/></th>
<%-- 					<td  style="width: 10%"><input type="text" class="text1" id="expr_${uuid}"><input class="button" type="button" value="查询" onclick="qryDeptList();"/></td> --%>
<!-- 					<td><input class="button" type="button" value="查询" onclick="qryDeptList();"/></td> -->
				</tr>
			</table>
		</div>
	</div>
	<div>
		<table id="tb_${uuid}"></table>
	</div>

	<script type="text/javascript">	
		$(document).ready(function(){
			//工具栏操作按钮
			var toolbar = [];
			<shirox:hasAnyPermissions permissionKeys="dictionarymanage:add">
				toolbar.push({
					text:'新增',
					iconCls:'icon-add',
					handler:function(){operCol('add');}
				});
				toolbar.push('-');
			</shirox:hasAnyPermissions>
			<shirox:hasAnyPermissions permissionKeys="dictionarymanage:edit">
				toolbar.push({
					text:'修改',
					iconCls:'icon-edit',
					handler:function(){operCol('edit');}
				});
				toolbar.push('-');
			</shirox:hasAnyPermissions>
			<shirox:hasAnyPermissions permissionKeys="dictionarymanage:delete">
				toolbar.push({
					text:'删除',
					iconCls:'icon-remove',
					handler:function(){operCol('delete');}
				});
				toolbar.push('-');
			</shirox:hasAnyPermissions>
			<shirox:hasAnyPermissions permissionKeys="dictionarymanage:syncmenu">
				toolbar.push({
					text:'自定义微信菜单同步',
					iconCls:'icon-update',
					handler:function(){
						jsonAjax("${ctx}/systemmanage/dictionary/synchronousUpdateMenu.do",null,"json",
							  	function(data){
							alert(data.message);
						});
						
					}
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
					$.jumpPage2('${uuid}',"${ctx}/systemmanage/dictionary/initDetail",{oper:'add'});
				}else if(method=='view'){
					$.jumpPage2('${uuid}',"${ctx}/systemmanage/dictionary/initDetail",{oper:'view',id:id});
				}else if(method=='edit'){
					$.jumpPage2('${uuid}',"${ctx}/systemmanage/dictionary/initDetail",{oper:'edit',id:id});
				}else if(method=='reload'){
					$('#tb_${uuid}').datagrid('reload');
				}else if(method=='delete'){
					$.messager.confirm("提示信息","你确定要删除数据吗？",function (isConfirm){
						if(!isConfirm) return;
						$.ajax({
							url:"${ctx}/systemmanage/dictionary/delete?id="+id,
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
			    //title:'字典信息列表',
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
			    url:'${ctx}/systemmanage/dictionary/search',
			    idField:'id',
			    toolbar:toolbar,
			    columns:[[
							{title:'字典名称',field:'name',width:60,align:'center',halign:'center',
								formatter: function(value,row,index){
									var nameVar = subStringStrObj(value,20);
				            		return "<span title='"+value+"'>"+nameVar+"</span>";
								}
							},
							{title:'字典值',field:'datadicval',width:30,align:'center',halign:'center'},
							{title:'字典表达式',field:'expr',width:30,align:'center',halign:'center'},
							{title:'排序',field:'taxis',width:20,align:'center',halign:'center'},
							{title:'字典索引',field:'allName',width:120,align:'center',halign:'center',
								formatter: function(value,row,index){
									var allNameVar = subStringStrObj(value,40);
				            		return "<span title='"+value+"'>"+allNameVar+"</span>";
								}
							},
							{title:'备注',field:'remark',width:100,align:'left',halign:'center',
								formatter: function(value,row,index){
									var remarkVar = subStringStrObj(value,32);
				            		return "<span title='"+value+"'>"+remarkVar+"</span>";
								}
							}
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
				datadicval: $('#datadicval_${uuid}').val(),
				expr: $('#expr_${uuid}').val()
			});
		}
	</script>
</div>