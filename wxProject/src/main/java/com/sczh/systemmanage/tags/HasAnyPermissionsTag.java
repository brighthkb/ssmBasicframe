package com.sczh.systemmanage.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.sczh.core.utils.WebUtils;
import com.sczh.systemmanage.utils.PermissionUtils;

/**
 * 当前用户是否有权限
 * 
 * @author chentao
 */
public class HasAnyPermissionsTag extends TagSupport{
	private static final long serialVersionUID = -4786931833148680306L;
	
	private String permissionKeys = null;

	public String getPermissionKeys() {
		return permissionKeys;
	}
	public void setPermissionKeys(String permissionKeys) {
		this.permissionKeys = permissionKeys;
	}

	@Override
	public int doStartTag() throws JspException {
		boolean show = showTagBody(getPermissionKeys());
		if (show) {
			return TagSupport.EVAL_BODY_INCLUDE;
		} else {
			return TagSupport.SKIP_BODY;
		}
	}

	protected boolean showTagBody(String permissionKeys) {
		HttpServletRequest request = WebUtils.getRequest();
		return PermissionUtils.hasAnyPermissions(request, permissionKeys);
	}
}
