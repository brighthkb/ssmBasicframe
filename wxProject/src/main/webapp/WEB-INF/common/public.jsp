<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/common/taglib.jsp"%>
<meta http-equiv="Content-type" content="text/html" charset="utf-8" />
<meta name="keywords" content="宏图志愿后台管理系统" />
<meta name="description" content="宏图志愿后台管理系统" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" /> <!-- 为了让 IE 浏览器运行最新的渲染模式下-->
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta name="renderer" content="webkit" />
<title>业务后台管理系统</title>
<!-- <link rel= "shortcut icon " href= "${ctx}/static/common/style/login/images/logo.png?version=${versionId}" /> -->
<!-- 引用easyui前端框架和对应的jquery版本  -->
<link rel="stylesheet" type="text/css" href="${ctx}/static/jquery-easyui-1.5/themes/default/easyui.css?version=${versionId}" />
<link rel="stylesheet" type="text/css" href="${ctx}/static/jquery-easyui-1.5/themes/icon.css?version=${versionId}" />
<script type="text/javascript" src="${ctx}/static/jquery-easyui-1.5/jquery.min.js?version=${versionId}"></script>
<script type="text/javascript" src="${ctx}/static/jquery-easyui-1.5/jquery.easyui.min.js?version=${versionId}"></script>
<script type="text/javascript" src="${ctx}/static/jquery-easyui-1.5/locale/easyui-lang-zh_CN.js?version=${versionId}"></script>
<!-- form表单提交【不用easyui form组件，因为submit提交有问题】-->
<script src="${ctx}/static/jquery-form/jquery.form.3.51.js?version=${versionId}" type="text/javascript"></script>
<!-- 弹出框、提示框JS组件【只使用load方法】 -->
<script src="${ctx}/static/layer/layer.js?version=${versionId}"></script>
<script src="${ctx}/static/layer/extend/layer.ext.js?version=${versionId}"></script>
<!-- 公用js方法  -->
<script type="text/javascript" src="${ctx}/static/common/js/public.js?version=${versionId}"></script>
<!-- 扩展easyui组件  -->
<script type="text/javascript" src="${ctx}/static/common/js/extentEasyui.js?version=${versionId}"></script>
<script type="text/javascript">
	var ctx = '${ctx}';
	var currUserId = '${currUserId}';
	var currUserCity = '${currUserCity}';
	$.extend($.fn.validatebox.defaults.rules, {
		datevalidate: {
			validator: function(value, param){
				return /^\d{4}\-\d{2}\-\d{2}$/.test(value);
			},
			message: '请填写合法的时间格式！'
		},
		doublevalidate:{
			validator: function(value, param){
				return /^(:?(:?\d+.\d{1,2})|(:?\d+))$/.test(value);
			},
			message: '请填写合法的金额格式！'
		},
		intvalidate:{
			validator: function(value, param){
				return /^[0-9]*[1-9][0-9]*$/.test(value);
			},
			message: '请填写合法的数字格式！'
		},
		intandzimuvalidate:{
			validator: function(value, param){
				return /^[0-9a-zA-Z]{12}$/.test(value);
			},
			message: '请填写数字加字母的12位格式！'
		},
		intorcodevalidate:{
			validator: function(value, param){
				return /^\d{7}$/.test(value);
			},
			message: '请填写7位的数字格式！'
		}
	});
	var pageWidth,pageHeight;
	function isPublisher(useridp,useridl){
		if(useridp==useridl){
			return true;
		}else{
			$.messager.alert('提示信息','您选中的合同您没有权限编辑!','warning');
			return false;				
		}
	}
</script>
