package com.sczh.systemmanage.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
/**
 * String帮助类
 * <p>StringUtil </p>
 * @author tjun
 * @创建时间：2018-2-22 下午7:49:27   
 * @修改历史：
 * @修改内容:
 * @修改时间:
 *
 */
public class StringUtil extends StringUtils {

	/**
	 * 
	 * newUUID方法
	 * <p>
	 * 生成一个新的UUID
	 * </p>
	 * 
	 * @return
	 * @author tjun 2018-2-22 
	 */
	public static String newUUID() {
		return UUID.randomUUID().toString();
	} 
	
	
   /**
    * 功能说明:
    * @param code String 项目代码后面几位
    * @return String
    */
  
    public static final synchronized String makePKCode(String code,String start,String dayalltime){
     
      String formatted = Integer.toString(1);
      StringBuffer buf = new StringBuffer(start);
      buf.replace(start.length()-formatted.length(), start.length(), formatted);
      return code + dayalltime + buf.toString();
    }  

	/**
	 * 
	 * objectToString方法
	 * <p>
	 * 将ToStringBuilder.toString的头部与尾部去掉
	 * </p>
	 * 
	 * @param obj
	 * @return
	 * @author tjun 2018-2-22
	 */
	public static String objectToString(Object obj) {
		if (null == obj) {
			return null;
		}
		String str = obj.toString();
		int begin = str.indexOf("[");
		int end = str.lastIndexOf("]");
		if (begin <= 0) {
			begin = 0;
		} else {
			begin++;
		}
		if (end <= 0) {
			end = str.length();
		}
		str = str.substring(begin, end);
		return str.trim();
	}

	/**
	 * 
	 * msgCountSplit方法
	 * <p>
	 * 字符串拆分成多个
	 * </p>
	 * 
	 * @param msgCount
	 *            字符串
	 * @param len
	 *            拆分长度
	 * @return
	 * @author tjun 2018-2-22
	 */
	public static List<String> msgCountSplit(String msgCount, int len) {
		if (isEmpty(msgCount)) {
			return null;
		}
		List<String> list = new ArrayList<String>();
		char[] chars = msgCount.toCharArray();
		int charLen = chars.length;
		if (len >= charLen) {
			list.add(msgCount);
		} else {
			int index = 0;
			do {
				int llen = index + len;
				char[] chart = new char[(llen >= charLen) ? (charLen - index)
						: len];
				System.arraycopy(chars, index, chart, 0, chart.length);
				list.add(new String(chart));
				index = llen;
			} while (index <= charLen);
		}
		return list;
	}

	public static String getEncoding(String str) {      
	          
		String  encode = "ISO-8859-1";
	      try {      
	          if (str.equals(new String(str.getBytes(encode), encode))) {      
	               String s = encode;      
	              return s;      
	           }      
	       } catch (Exception exception) {      
	       }      
	       encode = "GB2312";    
	      try {      
	          if (str.equals(new String(str.getBytes(encode), encode))) {      
	               String s1 = encode;      
	              return s1;      
	           }      
	       } catch (Exception exception1) {      
	       }      
	       encode = "GBK";      
	      try {      
	          if (str.equals(new String(str.getBytes(encode), encode))) {      
	               String s2 = encode;      
	              return s2;      
	           }      
	       } catch (Exception exception2) {      
	       }      
	       encode = "UTF-8";      
	      try {      
	          if (str.equals(new String(str.getBytes(encode), encode))) {      
	               String s3 = encode;      
	              return s3;      
	           }      
	       } catch (Exception exception3) {      
	       }      
	      return "";      
	   } 
}
