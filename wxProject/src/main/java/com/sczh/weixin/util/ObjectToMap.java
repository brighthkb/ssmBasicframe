package com.sczh.weixin.util;
import java.util.Map;
/**
 * Map转换Object
 * @author tjun
 *
 */
public class ObjectToMap {
	public static Object mapToObject(Map<String, Object> map, Class<?> beanClass) throws Exception {
		if (map == null)
			return null;
		Object obj = beanClass.newInstance();
		org.apache.commons.beanutils.BeanUtils.populate(obj, map);
		return obj;
	}

	public static Map<?, ?> objectToMap(Object obj) {
		if (obj == null)
			return null;
		return new org.apache.commons.beanutils.BeanMap(obj);
	}
}
