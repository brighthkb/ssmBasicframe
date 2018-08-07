<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta content="telephone=no,email=no" name="format-detection">
<meta name="wap-font-scale" content="no">
<title>企业移动平台</title>
<link rel="stylesheet" href="${ctx}/static/winxin/style/wxindex/reset.css" />
<link rel="stylesheet" href="${ctx}/static/winxin/style/wxindex/toup.css" />
<link rel="stylesheet" href="${ctx}/static/winxin/js/wxindex/swiper.min.css" />
<script type="text/javascript" src="${ctx}/static/jquery-easyui-1.5/jquery.min.js?version=${versionId}"></script>
<script type="text/javascript" src="${ctx}/static/common/js/System.Business.js"></script>
<script type="text/javascript" src="${ctx}/static/common/js/jqueryAjaxJson.js"></script>
<script type="text/javascript" src="${ctx}/static/winxin/js/wxindex/fontSize.js"></script>
<script type="text/javascript" src="${ctx}/static/jquery-easyui-1.5/jquery.min.js?version=${versionId}"></script>
<script src="${ctx}/static/jquery-form/jquery.form.3.51.js?version=${versionId}" type="text/javascript"></script>
<script src="${ctx}/static/layer/layer.js?version=${versionId}"></script>
<script src="${ctx}/static/layer/extend/layer.ext.js?version=${versionId}"></script>
</head>
<body>
	<form action="" id="formId">
	</form>
	<!-- <section class="toup" id="t1">
	<div class="swipers">
		<div class="con">
			<h1>lamoda调查问卷</h1>
			<p>感谢光临lamoda体验中心！</p>
			<p>3D时尚定制鞋开创者lamoda是国内领先的鞋类私人订制品牌，致力于为您设计、生产您想要的鞋、舒适的鞋。</p>
			<p>lamoda自推出“DIY自主设计”以来，受到了众多客户朋友的喜爱与追捧，为了让“DIY”能够更好地满足您对鞋子的所有向往，我们非常期待能知道您的想法。</p>
			<p>坐下来，品一杯咖啡，细细地想一想，您心中的lamodaDIY，是什么样的呢？</p>
		</div>
		<a href="javascript:;" class="jion">参加本调查</a>
	</div>
	</section> -->
	<!--
	<section class="toup" id="t2">
		<div class="swipers">-->
		<!-- 上下 -->
		<!--
		<div class="swiper-container">
			<div class="swiper-wrapper">
		
				<c:forEach items="${list}" var ="subject" varStatus="status" begin="0" end ="59">
					<c:if test="${status.index%3==0 }">
						<div class="swiper-slide">
						<div class="scores">
							<div class="f">
								<span>1</span>您愿意从事下列活动吗?
							</div>
							<div class="choose">
					</c:if>
								<div class="input">
									<label for="${subject.id }">${subject.id }. ${subject.title }</label>
								</div>
								<div class="input">
									<table style="width: 100%">
										<tr style="width: 100%">
											<td width="40%"><input type="radio" name="${subject.id }" id="2" value="1"/><label for="2">是 </label></td>
											<td ><input type="radio" name="${subject.id }" id="3" value="0"/><label for="3">否 </label></td>
										</tr>
									</table>
								</div>
							
							<c:if test="${status.index%3==2 }">
								</div>
							</div>
					</div>
				</c:if>
				</c:forEach>
				<c:forEach items="${list}" var ="subject" varStatus="status" begin="60" end ="119">
					<c:if test="${status.index%3==0 }">
						<div class="swiper-slide">
						<div class="scores">
							<div class="f">
								<span>2</span>您具有、擅长或胜任下列活动的能力吗?
							</div>
							<div class="choose">
					</c:if>
								<div class="input">
									<label for="${subject.id }">${subject.id }. ${subject.title }</label>
								</div>
								<div class="input">
									<table  style="width: 100%">
										<tr  style="width: 100%">
											<td width="40%"><input type="radio" name="${subject.id }" id="2" value="1" /><label for="2">是 </label></td>
											<td ><input type="radio" name="${subject.id }" id="3" value="0" /><label for="3">否 </label></td>
										</tr>
									</table>
								</div>
								<c:if test="${status.index%3==2 }">
								</div>
							</div>
					</div>
				</c:if>
				</c:forEach>
				
			</div>
			<div class="preNexts">
				<div class="swiper-button-prev">
					<div class="pre"></div>
					上一题
				</div>
				<div class="swiper-button-next">
					<div class="next"></div>
					下一题
				</div>
			</div>
		</div>-->
		<!-- 上下end -->
		<!--
	</div>
	<div class="swipers">
		<a href="javascript:;" class="tijiao"  id="submit">提交调查</a>
	</div>
	</section>
	<section class="toup" id="t3">
	<div class="swipers">
		<div class="con con1">
			<div class="smile">
				<p>您的测评结果为：</p>
				<p id="result"></p>
			</div>
		</div>
	</div>
	</section>
	-->
	<div>
		头像:<img alt="微信头像" src="${ sessionScope.wxuser.headimgurl}"><br/>
		昵称：${ sessionScope.wxuser.nickname}<br/>
		电话号码：${ sessionScope.wxuser.phone}
	</div>
	<script type="text/javascript" src="${ctx}/static/winxin/js/wxindex/swiper.min.js"></script>
	<script type="text/javascript">
		var mySwiper = new Swiper('.swiper-container', {
			//pagination : '.swiper-pagination',
			nextButton : '.swiper-button-next',
			prevButton : '.swiper-button-prev',
			slidesPerView : 1,
			paginationClickable : false,
			spaceBetween : 30,
			loop : true,
			onReachEnd : function(swiper) {
				//$("#t2").hide();
				//$("#t3").show();
			}
		});
		$("#t3").hide();
		$("#t2").show();
		$("a.jion").on("click", function() {
			$("#t1").hide();
			$("#t2").show();
		});
		/* $(".swiper-container label,.swiper-container").click(function() {
			var this_active = $(this).parents(".swiper-slide").index();
			setTimeout(function() {
				mySwiper.slideTo(this_active + 1, 1000)
			}, 500);

		}); */
		/* $('.swiper-button-next').click(function() {
			if (mySwiper.isEnd) {
				$("#t2").hide();
				$("#t3").show();
			}
		}) */
		
		
		$('#submit').click(function(e){
			var R=0;var A=0;var I=0;var S=0;
			var E=0;var C=0;
			for (var i = 1; i <= 120; i++) {
				var val = $('input[name='+i+']:checked').val();
				if(val == undefined){
					//alert('第'+i+'道题没有选择');
					continue;
				}
				if(i<=10 || (i<=70 && i>60)){//1-10
					R += Number(val);
				}
				if((i<=20 && i>10) || (i<=80 && i>70)){//10-20
					A += Number(val);
				}
				if((i<=30 && i>20) || (i<=90 && i>80)){//20-30
					I += Number(val);
				}
				if((i<=40 && i>30) || (i<=100 && i>90)){//30-40
					S += Number(val);
				}
				if((i<=50 && i>40) || (i<=110 && i>100)){//40-50 //100-110
					E += Number(val);
				}
				if((i<=60 && i>50) ||(i<=120 && i>110)){//50-60
					C += Number(val);
				}
			}
			var loadIndex = layer.load();
			var param = {R:R,A:A,I:I,S:S,E:E,C:C};
			var url = '${ctx}/test/add';
			 $('#formId').ajaxSubmit({
				url: url,
				type : 'post',
				data : param,
				dataType : "json",
				success: function(result){
					layer.close(loadIndex);
					if (result.success) {
						 $('#result').html(result.message);
						 $("#t2").hide();
						 $("#t3").show();
					}else{
						alert(result.message);
					}
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					layer.close(loadIndex);
					alert("系统错误:"+XMLHttpRequest.status);
				}
			}); 
		});
	</script>
</body>
</html>