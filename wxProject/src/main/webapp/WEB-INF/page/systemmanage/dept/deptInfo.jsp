<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/common/taglib.jsp"%>
<div class="page" id="page_${uuid}">
    <div id="panel_${uuid}" class="easyui-panel infoContent" data-options="footer:'#footer_${uuid}'"
    	title="<c:if test="${oper=='view'}">查看</c:if><c:if test="${oper=='add'}">新增</c:if><c:if test="${oper=='edit'}">编辑</c:if>部门信息">
    	<form id="form_${uuid}" method="post">
    		<input type="hidden" id="id_${uuid}" name="id" value="${dept.id}">
    		<div class="table2" >
				<div class="form-group">
					<label class="form-label">部门名称：</label>
					<input type="text" class="text2" id="name_${uuid}" name="name" value="${dept.name}" maxlength="30">
				</div>
				<div class="form-group">
					<label class="form-label">联系人：</label>
					<input type="text" class="text2" id="linkman_${uuid}" name="linkman" value="${dept.linkman}"  maxlength="30">
				</div>
				<div class="form-group">
					<label class="form-label">联系电话：</label>
					<input type="text" class="text2" id="tel_${uuid}" name="tel" value="${dept.tel}"  maxlength="30">
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
		$('#name_${uuid},#name_${uuid}').validatebox({required: true});
		$('#cancel_${uuid}').click(function(e) {
			e.preventDefault();
			$.jumpPage3('${uuid}');
		});
		//表单提交
		$('#save_${uuid}').click(function(e){
			e.preventDefault();
			
			var param = {};
			//获取选择角色
			var url = "";
			var oper = '${oper}';
			if(oper=='add'){
				url = '${ctx}/systemmanage/dept/add';
			}else if(oper=='edit'){
				url = '${ctx}/systemmanage/dept/edit';
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
							$.jumpPage3('${uuid}',qryDeptList);
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
		

		$(document).ready(function() {
			$('#panel_${uuid}').panel({
				fit : true
			});

			if('${oper}'=='view'){

			}
		});
	</script>
</div>