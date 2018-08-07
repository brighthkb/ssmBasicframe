<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/common/taglib.jsp"%>
<style>
	.clearparentnode{background:#02124e;color:#fff;border-radius:5px;cursor:pointer;}
</style>
<div class="page" id="page_${uuid}">
    <div id="panel_${uuid}" class="easyui-panel infoContent" data-options="footer:'#footer_${uuid}'" style="background-color: transparent;"
    	title="<c:if test="${oper=='view'}">查看</c:if><c:if test="${oper=='add'}">新增</c:if><c:if test="${oper=='edit'}">编辑</c:if>菜单信息">
    	<form id="form_${uuid}" method="post">
    		<input type="hidden" id="id_${uuid}" name="id" value="${permission.id}">
    		<div class="table2" >
				<div class="form-group">
					<label class="form-label">权限名称：</label>
					<input type="text" class="text2" id="name_${uuid}" name="name" value="${permission.name}" maxlength="30">
				</div>
				<div class="form-group">
					<label class="form-label">权限标识：</label>
					<input type="text" class="text2" id="permissionKey_${uuid}" name="permissionKey" value="${permission.permissionKey}" maxlength="30">
				</div>
				<div class="form-group">
					<label class="form-label">是否是菜单：</label>
					<div id="isMenu_${uuid}" style="width:30%;text-align: left;line-height: 30px;"></div>
				</div>
				<div class="form-group">
					<label class="form-label">菜单链接：</label>
					<input type="text" class="text2" id="menuUrl_${uuid}" name="menuUrl" value="${permission.menuUrl}" maxlength="100">
				</div>
				<div class="form-group">
					<label class="form-label">菜单图标：</label>
					<input type="text" class="text2" id="menuIcon_${uuid}" name="menuIcon" value="${permission.menuIcon}" maxlength="30">
				</div>
				<div class="form-group">
					<label class="form-label">排序：</label>
					<input type="text" class="text2" id="orderNo_${uuid}" name="orderNo" value="${permission.orderNo}" maxlength="5" style="height: 30px;">
				</div>
				<div class="form-group">
					<label class="form-label">上级节点：</label>
					<input type="text" class="text2" id="parentId_${uuid}" name="parentId"  style="width:10%;height: 30px;">
				</div>
				<div class="form-group">
					<label class="form-label"> </label>
					<input type="button" value="清空上级节点" class="reset-btn clearparentnode" onclick="$('#parentId_${uuid}').combotree('clear')">
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
		$('#name_${uuid},#permissionKey_${uuid}').validatebox({required: true});
		$('#isMenu_${uuid}').initRadio("permission_isMenu", "isMenu", function(radios){
			$.each(radios,function(i,n){
				$(n).click(function(){
					var chkVal = $("#isMenu_${uuid} :radio:checked").val();
					if(chkVal=='1'){
						$("#menuUrl_${uuid},#menuIcon_${uuid}").prop("disabled", false);
					}else{
						$("#menuUrl_${uuid},#menuIcon_${uuid}").prop("disabled", true);
					}
				});
			});
			
			if("${permission.isMenu}"){
				$("#isMenu_${uuid} :radio[value='${permission.isMenu}']").prop("checked", true).click();
			}else{
				$(radios.get(0)).prop("checked", true).click();
			}
		});
		$('#orderNo_${uuid}').numberbox({
			width:$('#name_${uuid}').width()+5,
		    min:0,
		    max:10000,
		    precision:0,
		    required: true
		});
		$('#parentId_${uuid}').combotree({
			//editable:true,
			lines: true,
			animate: true,
			width:$('#name_${uuid}').width()+5,
		    url: '${ctx}/systemmanage/permission/getPermissionTree',
		    //required: true,
		    onLoadSuccess:function(){
		    	if("${permission.parentId}"){
		    		$('#parentId_${uuid}').combotree('setValue', "${permission.parentId}");
		    	}
		    	if("${param.parentId}"){
		    		$('#parentId_${uuid}').combotree('setValue', "${param.parentId}");
		    	}
		    }
		});
		
		
		$('#cancel_${uuid}').click(function(e){
			e.preventDefault();
			$.jumpPage3('${uuid}');
		});
		//表单提交
		$('#save_${uuid}').click(function(e){
			e.preventDefault();
			
			var url = "";
			var oper = '${oper}';
			if(oper=='add'){
				url = '${ctx}/systemmanage/permission/add';
			}else if(oper=='edit'){
				url = '${ctx}/systemmanage/permission/edit';
			}
			$('#form_${uuid}').ajaxSubmit({
				url: url,
				type : 'post',
				dataType : 'json',
				data : {},
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
							$.jumpPage3('${uuid}',qryPermissionList);
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
			$('#panel_${uuid}').panel({fit:true});
			
			if('${oper}'=='view'){
				
			}
		});
	</script>
</div>