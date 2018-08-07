package com.sczh.core.exception;

import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

public class MySimpleMappingExceptionResolver extends
		SimpleMappingExceptionResolver {//HandlerExceptionResolver  

	protected org.springframework.web.servlet.ModelAndView doResolveException(//HandlerExceptionResolver  
			javax.servlet.http.HttpServletRequest request,
			javax.servlet.http.HttpServletResponse response, Object obj,
			Exception e) {
		String viewName = determineViewName(e, request);
		
		if (viewName != null) {// JSP格式返回
			/*if (!(request.getHeader("accept").indexOf("application/json") > -1 || (request
					.getHeader("X-Requested-With") != null && request
					.getHeader("X-Requested-With").indexOf("XMLHttpRequest") > -1))) {*/
				// 如果不是异步请求&&
				// Apply HTTP status code for error views, if specified.
				// Only apply it if we're processing a top-level request.
				Integer statusCode = determineStatusCode(request, viewName);
				if (statusCode != null) {
					applyStatusCodeIfPossible(request, response, statusCode);
				}
				return getModelAndView(viewName, e, request);
			/*} else {// JSON格式返回
				PrintExpJsonUtils.printExpJson(response, e);
				try {
					PrintWriter out = response.getWriter();
					response.addHeader("Content-Type", "application/json;charset=UTF-8");
					StringBuffer sb = new StringBuffer();
					sb.append("{\"resInfo\": {\"exception\": \""+e.getMessage()+"\"},\"stateCode\": 301}");
					out.write(sb.toString());
					out.flush();
					out.close();
				} catch (IOException ie) {
					ie.printStackTrace();
				}
				return null;

			}*/
		} else {
			//PrintExpJsonUtils.printExpJson(response, e);
			return null;
		}
	};
}
