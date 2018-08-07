<%@ page language="java" import="java.util.*,com.sczh.core.config.ConfigUtils,com.sczh.weixin.model.WxUser" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/public_winxin.jsp"%>
<%
	String appid = ConfigUtils.getConfig("WINXIN_APPID");
	String winxinUrl = ConfigUtils.getConfig("WINXIN_URL");
	Map<String,String> wxuseropp=null;
	WxUser wxuserse=null;
	Object wxuseroppObj=session.getAttribute("wxuseropp");
	Object wxuserseObj=session.getAttribute("wxuser");
	if(null!=wxuseroppObj&&!"".equals(wxuseroppObj)){
		wxuseropp= (Map<String,String>)wxuseroppObj;
	}
	if(null!=wxuserseObj&&!"".equals(wxuserseObj)){
		wxuserse= (WxUser)wxuserseObj;
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<c:set var="appidstr" value="<%=appid %>"/>
<c:set var="winxinurlstr" value="<%=winxinUrl %>"/>
<c:set var="wxuseropp" value="<%=wxuseropp %>"/>
<c:set var="wxuserse" value="<%=wxuserse %>"/>
<meta http-equiv="Pragma" content="no-cache">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
<meta name="format-detection" content="telephone=no">
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<link rel="stylesheet" href="${ctx}/static/winxin/style/bindingwechart/bindingwechart.css" />
<script type="text/javascript" src="${ctx}/static/winxin/js/bindingwechart.js"></script>
<title>手机注册</title>
<script type="text/javascript">
var issubmit=true;
var openid ="";
$(function(){
	$("#initload").hide();
	openid = '${wxuseropp.openid}';
 	if(openid==''){ 
 		location.href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=${appidstr}&redirect_uri=${winxinurlstr}/weinxin/wxindexmain/getwxuserinfo.do?response_type=code&scope=snsapi_base&state=1#wechat_redirec";
 	}else{
 		$("#initload").show();
 		var openidwx = '${wxuserse.openid}';
 		if(openidwx==''){
 			jsonAjax(ctxjsurl+"/weinxin/wxindexmain/queryuserInfo.do",{openid:openid},"json",
 				  	function(data){
 		 		if(data.wxuser!=null){
 		 			location.href="${ctx}/weinxin/wxindexmain/towxindex.action";
 		 		}
 		 		$("#initload").hide();
 	 		},false); 			
 		}else{
 			location.href="${ctx}/weinxin/wxindexmain/towxindex.action";
 		}
 	}
});
/**
 * 提交登录信息
 */
function searchwxuserObj(){
	$("#initload").show();
	var feildsBool=true;
	var arr=new Array('username','phone','code');
	var dotMapArr = {"username":"账号","phone":"手机号码","code":"验证码"};
	if(feildsBool){ //验证非空
		var i=0;
		for(var temp in arr){ 
			var newTemp = arr[temp];
			var tempBool= cleanClickIS(newTemp);
			if(!tempBool){
				feildsBool=false;
				var messageErrorVar =dotMapArr[newTemp]+'不能为空！';
				$.toptip(messageErrorVar, 'error');
				break;
			} 
	     }
	  }
	if(feildsBool&&issubmit){
		$("#initload").show();
		var param = {code:$("#code").val(),phone:$("#phone").val(),openid:openid,nickname:'${wxuser.nickname}',name:$("#username").val(),sex:'${wxuser.sex}',sex:'${wxuser.sex}',headimgurl:'${wxuser.headimgurl}',subscribe:'${wxuser.subscribe}'};
		issubmit=false;
		jsonAjax(ctxjsurl+"/weinxin/wxindexmain/bindinguserInfo.do",param,"json",
			  	function(data){
			$("#initload").hide();
			var islogin = data.islogin;
			issubmit=true;
			$("#initload").hide();
			if(islogin){
				var messagebinding="您好，恭喜您微信账户登陆成功！";
				$.alert(messagebinding, function() {
						location.href="${ctx}/weinxin/wxindexmain/towxindex.action"; 	
				});
			}else{
				var errorMsg =data.errorMsg; 
				$.toptip(errorMsg, 'error');
			}
		});
	} 
} 
</script>
</head>
<body>
	<!--主体-->
	<header class="wy-header">
	<div class="wy-header-icon-back">
		<span></span>
	</div>
	<div class="wy-header-title">手机注册</div>
	</header>
	<div class="weui-content">
		<div class="weui-cells weui-cells_form wy-address-edit">
			<div class="weui-cell">
				<div class="weui-cell__hd">
					<label class="weui-label wy-lab">姓&nbsp;&nbsp;名</label>
				</div>
				<div class="weui-cell__bd">
					<input class="weui-input" type="text" name="username" id="username"    placeholder="请输入姓名" /> 
				</div>
			</div>
			<div class="weui-cell weui-cell_vcode">
				<div class="weui-cell__hd">
					<label class="weui-label wy-lab">手机号</label>
				</div>
				<div class="weui-cell__bd">
					<input class="weui-input" id="phone" name="phone" type="number" oninput="if(value.length>11)value=value.slice(0,11)"  placeholder="请输入手机号" />
				</div>
				<div class="weui-cell__ft">
					<button class="weui-vcode-btn sentTime" onclick="sendCodetell(this);">获取验证码</button>
					<button class="weui-vcode-btn getTime" style="color: #666;"></button>
				</div>
			</div>
			<div class="weui-cell">
				<div class="weui-cell__hd">
					<label class="weui-label wy-lab">验证码</label>
				</div>
				<div class="weui-cell__bd">
					<input class="weui-input" name="code" id="code"  type="number" pattern="[0-9]*" value="123456"
						placeholder="请输入验证码" oninput="if(value.length>6)value=value.slice(0,6)" />
				</div>
			</div>
		</div>
		<div class="weui-btn-area">
			<a href="javascript:void(0);"  onclick="searchwxuserObj();" class="weui-btn weui-btn_warn" >注册并登陆</a>
		</div>
		<div class="weui-cells__tips t-c font-12">登陆账号为您输入的手机号码</div>
	</div>
</body>
</html>