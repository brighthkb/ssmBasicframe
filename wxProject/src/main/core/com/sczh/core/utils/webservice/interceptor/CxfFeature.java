package com.sczh.core.utils.webservice.interceptor;

import org.apache.cxf.Bus;
import org.apache.cxf.feature.AbstractFeature;
import org.apache.cxf.interceptor.InterceptorProvider;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;

public class CxfFeature extends AbstractFeature {

	@Override
	protected void initializeProvider(InterceptorProvider provider, Bus bus) {
		provider.getInInterceptors().add(new LoggingInInterceptor());
		provider.getInInterceptors().add(new CxfServerLoginAuthInterceptor());
		provider.getOutInterceptors().add(new LoggingOutInterceptor());
	}
}