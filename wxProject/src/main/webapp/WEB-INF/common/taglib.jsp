<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="shirox" uri="http://shirox.sczh.com/tags" %>
<%@ taglib prefix="utils" uri="http://utils.sczh.com/functions" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:set var="currUserId" value="${sessionScope.sys_session_rel_info.session_user_key.id}"/>
<c:set var="currUserCity" value="${sessionScope.sys_session_rel_info.session_user_key.city}"/>
<c:set var="versionId" value="1.0.0.20170904"/>
<script type="text/javascript" src="${ctx}/static/common/js/System.Business.js"></script>
<script type="text/javascript" src="${ctx}/static/common/js/jqueryAjaxJson.js"></script>