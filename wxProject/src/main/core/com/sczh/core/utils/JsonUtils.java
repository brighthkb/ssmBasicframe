package com.sczh.core.utils;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
  
/** 
 * json工具类 
 * 
 */  
public final class JsonUtils {  
  
    private static final ObjectMapper objectMapper = new ObjectMapper();
    
    static{
    	//初始化json配置
    	
    }
  
    /** 
     * json字符串转换为Object对象，注意：不支持泛型定义。
     * 
     * <p>(1)转换为JavaBean：toObject(jsonStr, Student.class)</p> 
     * <p>(2)转换为JavaBean数组：toObject(jsonStr, Student[].class)</p> 
     * <p>(3)因不支持泛型定义，可以用Arrays.asList()方法把得到的数组转换为List<Student></p> 
     * @param jsonStr 
     * @param clazz 
     * @return 
     */  
    public static <T> T toObject(String jsonStr, Class<T> clazz) {  
    	try {  
            return objectMapper.readValue(jsonStr, clazz);
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
  
        return null;  
    }  
      
    /** 
     * json字符串转换为Object对象，注意：支持泛型定义。
     * 
     * <p>使用方法：<code> toObject(jsonStr,  new TypeReference<List<Student>>(){}) </code></p>
     * @param jsonStr 
     * @param typeRef 
     * @return 
     */  
    public static <T> T toObject(String jsonStr, TypeReference<T> typeRef){  
        try {  
            return objectMapper.readValue(jsonStr, typeRef);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
  
        return null;  
    }
    
  
    /** 
     * Object对象转换为json字符串 
     *  
     * @param object 可以是javaBean、数组、集合等
     * @return 
     */  
    public static String toJSon(Object object) {  
        try {  
            return objectMapper.writeValueAsString(object);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
  
        return null;  
    }
  
}
