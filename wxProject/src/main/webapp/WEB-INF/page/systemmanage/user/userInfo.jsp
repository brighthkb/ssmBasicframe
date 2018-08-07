<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/common/taglib.jsp"%>
<style>
	.selectmoveoption{width:70%!important;}
</style>
<div class="page" id="page_${uuid}">
    <div id="panel_${uuid}" class="easyui-panel infoContent" data-options="footer:'#footer_${uuid}'"
    	title="<c:if test="${oper=='view'}">查看</c:if><c:if test="${oper=='add'}">新增</c:if><c:if test="${oper=='edit'}">编辑</c:if>用户信息">
    	<form id="form_${uuid}" method="post">
    		<input type="hidden" id="id_${uuid}" name="id" value="${user.id}">
    		<div class="table2" >
				<div class="form-group">
					<label class="form-label">用户名：</label>
					<input type="text" class="text2" id="loginName_${uuid}" name="loginName" value="${user.loginName}" maxlength="30">
					<label class="form-label">姓名：</label>
					<input type="text" class="text2" id="name_${uuid}" name="name" value="${user.name}" maxlength="30">
				</div>
				<div class="form-group">
					<label class="form-label">密码：</label>
					<input type="password" class="text2" id="password_${uuid}" name="password" value="" maxlength="30">
					<label class="form-label">用户状态：</label>
					<select class="select2" id="state_${uuid}" name="state" style="width: 30%;height: 30px;"></select>
				</div>
				<div class="form-group">
					<label class="form-label">所属地市：</label>
					<select class="select2" id="city_${uuid}" name="city" style="width: 30%;height: 30px;"></select>
					<label class="form-label">所属部门：</label>
					<select class="select2" id="dept_${uuid}" name="dept" maxlength="100" style="width: 30%;height: 30px;">
						<option>--请选择--</option>
						<c:forEach var="dept" items="${depts}">
							<option value="${dept.id }" <c:if test="${dept.id == user.dept}"> selected="selected"</c:if> > ${dept.name}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group">
					<label class="form-label">电话：</label>
					<input type="text" class="text2" id="tel_${uuid}" name="tel" value="${user.tel}" maxlength="13">
					<label class="form-label">E-mail：</label>
					<input type="text" class="text2" id="email_${uuid}" name="email" value="${user.email}" maxlength="50">
				</div>
				<div class="form-group">
					<label class="form-label">选择角色：</label>
					
						<table style="border: 0;border-spacing: 0px;width:70%!important" id="tb_setupRole_${uuid}" class="selectmoveoption">
							<tr>
								<td style="text-align: left;">
									<select style="padding-top: 5px;" class="select2" multiple size="12" id="allRole_${uuid}"
										ondblclick="moveOption($('#allRole_${uuid}').get(0), $('#selectRole_${uuid}').get(0))">
									</select>
								</td>
								<td style="text-align: center;">
									<input type="button" value="&gt;&gt;" 
										onclick="moveOption($('#allRole_${uuid}').get(0), $('#selectRole_${uuid}').get(0))">
									<br/>
									<br/> 
									<input type="button" value="&lt;&lt;" 
										onclick="moveOption($('#selectRole_${uuid}').get(0), $('#allRole_${uuid}').get(0))">
								</td>
								<td style="text-align: left;">
									<select style="padding-top: 5px;" class="select2" multiple size="12" id="selectRole_${uuid}"
										ondblclick="moveOption($('#selectRole_${uuid}').get(0), $('#allRole_${uuid}').get(0))">
									</select>
								</td>
							</tr>
						</table>
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
		$('#loginName_${uuid},#name_${uuid}').validatebox({required: true});
		$('#password_${uuid}').validatebox({validType:['length[6,30]']});
		$('#state_${uuid}').initSelectOption("user_state", null, "${user.state}");
		$('#city_${uuid}').initSelectOption("user_city", "--请选择--", "${user.city}");
		////////////////初始化角色选择列表--开始
		$('#tb_setupRole_${uuid}').width($('#name_${uuid}').width()*2+50).height(200);
		$('#allRole_${uuid},#selectRole_${uuid}').width($('#name_${uuid}').width()).height(200);
		$.ajax({
			url : '${ctx}/systemmanage/role/findRole',
			data : {},
			type : "POST",
			dataType : "json",
			success : function(result) {
				if(result.success){
					var selectedRoleIds="${user.roleIds}"?"${user.roleIds}".split(','):null;
					var htmlOptions_allRole = "";
					var htmlOptions_selectRole = "";
					//拼接字典option
					$.each(result.userdata, function(i,n){
						var option = '<option value="'+n.id+'">'+n.name+'</option>';
						if(selectedRoleIds && jQuery.inArray(n.id, selectedRoleIds)!=-1){
							htmlOptions_selectRole+=option;
						}else{
							htmlOptions_allRole+=option;
						}
					});
					//添加到select元素中
					$('#allRole_${uuid}').html(htmlOptions_allRole);
					$('#selectRole_${uuid}').html(htmlOptions_selectRole);
				}else{
					$.messager.alert('提示信息',result.message,'error',function(){});
				}
			}
		});
		//移动select option元素
		function moveOption(e1, e2) {
			for ( var i = 0; i < e1.options.length; i++) {
				var e = e1.options[i];
				if (e1.options[i].selected && OptionExists(e2, e.value)) {
					e2.options.add(new Option(e.text, e.value));
					e1.remove(i);
					i = i - 1;
				}
			}
		}
		//查询是否已经存在角色
		function OptionExists(list, optValue) {
			var find = true;
			for (i = 0; i < list.options.length; i++) {
				if (list.options[i].value == optValue) {
					find = false;
					break;
				}
			}
			return find;
		}
		////////////////初始化角色选择列表--结束
		
		
		$('#cancel_${uuid}').click(function(e) {
			e.preventDefault();
			$.jumpPage3('${uuid}');
		});
		//表单提交
		$('#save_${uuid}').click(function(e){
			e.preventDefault();
			
			var param = {};
			//获取选择角色
			var options = $('#selectRole_${uuid} option');
			if(options && options.length>0){
				var roleIds = [];
				$.each(options, function(i,n){
					roleIds.push($(n).val());
				});
				param['roleIds'] = roleIds.join(',');
			}
			var deptValue = $("#dept_${uuid}").val();
			if(null == deptValue || '--请选择--' == deptValue){
				$.messager.alert('提示信息',"请选择部门");
				return;
			}
			var url = "";
			var oper = '${oper}';
			if(oper=='add'){
				url = '${ctx}/systemmanage/user/add';
			}else if(oper=='edit'){
				url = '${ctx}/systemmanage/user/edit';
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
							$.jumpPage3('${uuid}',qryUserList);
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