<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/common/taglib.jsp"%>

<c:set var="permissions" value="${sessionScope.sys_session_rel_info.session_user_permission_key}"/>
<c:set var="defaultMenuUrl" value="${jumpMenuUrl}"/>
<c:if test="${empty defaultMenuUrl}">
	<c:forEach items="${permissions}" var="permission" varStatus="status">
		<c:if test="${empty defaultMenuUrl}">
			<c:if test="${permission.isMenu eq 1 and not empty permission.menuUrl}">
				<c:set var="defaultMenuUrl" value="${permission.menuUrl}"/>
			</c:if>
		</c:if>
	</c:forEach>
</c:if>

<c:set var="menus" value="${sessionScope.sys_session_rel_info.session_user_menu_tree_key}"/>
<c:forEach items="${menus}" var="menu_1" varStatus="status_1">
	<div title="${menu_1.menu.name}" data-options="iconCls:'icon-application-cascade'" style="padding:5px;">
		<c:if test="${not empty menu_1.children}">
		<ul class="easyui-tree wu-side-tree" style="border: 0px;">
		<c:forEach items="${menu_1.children}" var="menu_2" varStatus="status_2">
			<li iconCls="icon-chart-organisation">
				<a href="javascript:void(0)" data-icon="icon-chart-organisation"  
				iframe="0" data-link="${ctx}${menu_2.menu.menuUrl}">${menu_2.menu.name}</a>
			</li>
		</c:forEach>
		</ul>
		</c:if>
	</div>
</c:forEach>

<script>
</script>
