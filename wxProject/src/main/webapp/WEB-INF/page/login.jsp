<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0//EN" "w3.org/TR/html4/strict.dtd">
<html>
<head>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="versionId" value="1.0.0.20170904" />
<script type="text/javascript"
	src="${ctx}/static/common/js/System.Business.js"></script>
<script type="text/javascript"
	src="${ctx}/static/common/js/jqueryAjaxJson.js"></script>
<meta http-equiv="Content-type" content="text/html" charset="utf-8" />
<meta name="keywords" content="宏图志愿后台管理系统" />
<meta name="description" content="宏图志愿后台管理系统" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<!-- 为了让 IE 浏览器运行最新的渲染模式下-->
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta name="renderer" content="webkit" />
<title>企业后台管理系统</title>
<link rel="shortcut icon "
	href="${ctx}/static/common/style/login/images/logo.png?version=${versionId}" />
<link rel="stylesheet" type="text/css"
	href="${ctx}/static/common/style/login/style/dome.css?version=${versionId}" />
<link rel="stylesheet" type="text/css"
	href="${ctx}/static/common/bootstrap/css/bootstrap.min.css?version=${versionId}" />
<script type="text/javascript"
	src="${ctx}/static/jquery-easyui-1.5/jquery.min.js?version=${versionId}"></script>
<script type="text/javascript"
	src="${ctx}/static/common/bootstrap/js/bootstrap.min.js?version=${versionId}"></script>
<script src="${ctx}/static/layer/layer.js?version=${versionId}"></script>
<script type="text/javascript">
	$(document).ready(function() {
		//登陆错误消息提示
		if ('${errorMsg}') {
			layer.msg('<div style="color:red;">${errorMsg}<div/>', {
				icon : 3
			}, function() {
			});
			refreshVerCode('codeImg', 'loginCode');
		}
	});
	//切换验证码
	function refreshVerCode(id, verCodeType) {
		$("#" + id).attr(
				'src',
				"${ctx}/static/common/verification/verificationCode.jsp?verCodeType="
						+ verCodeType + "&randNum=" + Math.random() * 11);
	}
</script>
</head>
<body>
	<div class="box">
		<div class="cnt">
			<p id="huanying">
				<span id="cnt_one">企业后台管理系统</span>
			</p>
			<hr />
			<form action="#" method="post" class="bs-example bs-example-form">
				<div>
					<div class="input-group">
						<span class="input-group-addon"><img
							src="${ctx}/static/common/style/login/images/hr_user.png" /></span> <input
							type="text" id="username"  required="true" name="username" class="form-control"
							placeholder="请输入您的账号"  value="admin"/>
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon"><img
							src="${ctx}/static/common/style/login/images/suo.png" /></span> <input
							type="password" id="password" required="true" name="password"
							class="form-control" placeholder="请输入您的密码" value="123456" />
					</div>
					<br>
					<div class="input-group" style="position: absolute;">
						<input type="text" name="code" class="form-control"
							placeholder="请输入验证码" required="true"
							style="position: relative; width: 191px; height: 33px;">
						<img
							src="${ctx}/static/common/verification/verificationCode.jsp?verCodeType=loginCode"
							id="codeImg" onclick="refreshVerCode('codeImg','loginCode');" />

					</div>
					<br>
				</div>
				<div style="margin-top: 40px;">
					<input class="form-control btn btn-info" type="submit"
						id="loginBtn" value="登  录">
				</div>
			</form>
		</div>
	</div>
</body>
</html>