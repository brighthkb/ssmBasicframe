<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/common/taglib.jsp"%>
<div class="page" id="page_${uuid}">
    <div id="panel_${uuid}" class="easyui-panel infoContent" data-options="footer:'#footer_${uuid}'" style="background-color: transparent;"
    	title="<c:if test="${oper=='view'}">查看</c:if><c:if test="${oper=='add'}">新增</c:if><c:if test="${oper=='edit'}">编辑</c:if>角色信息">
    	<form id="form_${uuid}" method="post">
    		<input type="hidden" id="id_${uuid}" name="id" value="${role.id}">
    		<div class="table2" >
				<div class="form-group">
					<label class="form-label">角色名称：</label>
					<input type="text" class="text2" id="name_${uuid}" name="name" value="${role.name}" maxlength="50">
				</div>
				<div class="form-group">
					<label class="form-label">描述：</label>
					<textarea class="textarea2" id="description_${uuid}" name="description" maxlength="1000">${role.description}</textarea>
				</div>
				<div class="form-group">
					<label class="form-label">权限：</label>
					<ul id="permission_${uuid}" style="width:200px;height: 300px;    overflow: auto;text-align: left;"></ul>
				</div>
			</div>
    	</form>
    </div>
    <div id="footer_${uuid}" class="formFooter">
    	<c:if test="${oper!='view' }">
        	<a id="save_${uuid}" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">保存</a>
		</c:if>
		<a id="cancel_${uuid}" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">
			<c:if test="${oper!='view'}">取消</c:if><c:if test="${oper=='view'}">返回</c:if>
		</a>
    </div>
    
	<script type="text/javascript">
		/**     ======初始化底部图标=====      */
		returnIco($(".formFooter a"));
		/**     ======初始化界面 元素=====      */
		$('#footer_${uuid} .easyui-linkbutton').linkbutton({});
		$('#name_${uuid}').validatebox({required: true});
		$('#permission_${uuid}').tree({
			lines: true,
			animate: true,
			checkbox:true,
		    url: '${ctx}/systemmanage/permission/getPermissionTree',
		    onLoadSuccess:function(){
		    	if("${role.permissionIds}"){
		    		$.each("${role.permissionIds}".split(','), function(i,n){
		    			var node = $('#permission_${uuid}').tree('find', n);
		    			if($('#permission_${uuid}').tree('isLeaf', node.target)){//防止级联选中
			    			$('#permission_${uuid}').tree('check', node.target);
		    			}
		    		});
		    	}
		    	$('#permission_${uuid}').width($('#name_${uuid}').width());
		    	$('#permission_${uuid}').parent().height(pageHeight-205);
		    }
		});
		
		
		$('#cancel_${uuid}').click(function(e){
			e.preventDefault();
			$.jumpPage3('${uuid}');
		});
		//表单提交
		$('#save_${uuid}').click(function(e){
			e.preventDefault();
			
			var param = {};
			//获取选中和半选中状态的节点
			var nodes = $('#permission_${uuid}').tree('getChecked', ['checked','indeterminate']);
			if(nodes && nodes.length>0){
				var permissionIds = [];
				$.each(nodes, function(i,n){
					permissionIds.push(n.id);
	    		});
				param['permissionIds'] = permissionIds.join(',');
			}
			
			var url = "";
			var oper = '${oper}';
			if(oper=='add'){
				url = '${ctx}/systemmanage/role/add';
			}else if(oper=='edit'){
				url = '${ctx}/systemmanage/role/edit';
			}
			$('#form_${uuid}').ajaxSubmit({
				url: url,
				type : 'post',
				dataType : 'json',
				data : param,
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
							$.jumpPage3('${uuid}',qryRoleList);
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
		});	
	
		
		$(document).ready(function(){
			$('#panel_${uuid}').panel({
				fit : true
			});
			
			if('${oper}'=='view'){
				
			}
		});
	</script>
</div>