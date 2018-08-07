<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/common/taglib.jsp"%>
<div class="page" id="page_${uuid}">
    <div id="panel_${uuid}" class="easyui-panel infoContent" data-options="footer:'#footer_${uuid}'"
    	title="<c:if test="${oper=='view'}">查看</c:if><c:if test="${oper=='add'}">新增</c:if><c:if test="${oper=='edit'}">编辑</c:if>字典信息">
    	<form id="form_${uuid}" method="post">
    		<input type="hidden" id="id_${uuid}" name="id" value="${dictry.id}">
    		<div class="table2" >
				<div class="form-group">
					<label class="form-label">字典名称：</label>
					<input type="text" class="text2"  id="name_${uuid}" name="name" value="${dictry.name}" maxlength="30">
					<label class="form-label">字典值：</label>
					<input type="text" class="text2" id="datadicval_${uuid}" name="datadicval" value="${dictry.datadicval}" maxlength="30">
				</div>
				<div class="form-group">
					<label class="form-label">字典表达式：</label>
					<input type="text" class="text2" id="expr_${uuid}" name="expr" value="${dictry.expr}" maxlength="30">
					<label class="form-label">排序：</label>
					<input type="text" class="text2" style="" id="taxis_${uuid}" name="taxis" value="${dictry.taxis}"
						 onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" 
						 	maxlength="5">
				</div>
				<div class="form-group">
					<label class="form-label">上级节点：</label>
					<select class="easyui-combotree" style="height:30px;width:30%;" id="parentId_${uuid}" name="parentIdName"/>
					<input type="hidden" name="superId" />
					<label class="form-label">备注：</label>
					<textarea id="remark_${uuid}" name="remark" placeholder="简要说明">${dictry.remark}</textarea>
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
		$('#name_${uuid},#datadicval_${uuid},expr_${uuid}').validatebox({required: true});
		$('#cancel_${uuid}').click(function(e) {
			e.preventDefault();
			$.jumpPage3('${uuid}');
		});
		
		$('#parentId_${uuid}').combotree({  
            url: "${ctx}/systemmanage/dictionary/getDictionaryTree",  
            method: 'get',  
            loadFilter: function (rows) {
                return convert(rows.userdata);  
            },  
            onLoadSuccess:function(node,data){   
    			var parentId = "${dictry.superId}";
                $("#parentId_${uuid}").combotree('setValue',parentId); 
             }   
        });
	    $("#parentId_${uuid}").combotree({
            onChange:function(){
    		    var tree = $('#parentId_${uuid}').combotree('tree'); 
    		    var data = tree.tree('getSelected');
    		    $("[name=superId]").val(data.id);
            }
        });
	    function convert(rows) { 
            var nodes = [];  
            var children = []; 
            for (var i = 0; i < rows.length; i++) {
                var row = rows[i]; 
                for (var j = 0; j < row.children.length; j++) {
                	var child = row.children[j];
                	children.push({  
                        id: child.id,  
                        text: child.text  
                    });  
                }
                nodes.push({  
                    id: row.id,  
                    text: row.text,
                    children : children
                });
            }  
            return nodes;  
        }
		//表单提交
		$('#save_${uuid}').click(function(e){
			e.preventDefault();
			
			var param = {};
			//获取选择角色
			var url = "";
			var oper = '${oper}';
			if(oper=='add'){
				url = '${ctx}/systemmanage/dictionary/add';
			}else if(oper=='edit'){
				url = '${ctx}/systemmanage/dictionary/edit';
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