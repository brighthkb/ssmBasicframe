package com.sczh.core.utils;

@SuppressWarnings("all")
public class ClassUtils extends org.apache.commons.lang3.ClassUtils{
	
	/**
     * 判断对象o实现的所有接口中是否有szInterface 
     * 修正多继承中判断接口的功能，以及修正接口继承后的判断功能
     */ 
	 public static boolean isInterface(Class c, String szInterface)
     {
         Class[] face = c.getInterfaces();
         for (int i = 0, j = face.length; i < j; i++) 
         {
             if(face[i].getName().equals(szInterface))
             {
                 return true;
             }
             else
             { 
                 Class[] face1 = face[i].getInterfaces();
                 for(int x = 0; x < face1.length; x++)
                 {
                         if(face1[x].getName().equals(szInterface))
                         {
                                 return true;
                         }
                         else if(isInterface(face1[x], szInterface))
                         {
                                 return true;
                         }
                 }
             }
         }
         if (null != c.getSuperclass())
         {
                 return isInterface(c.getSuperclass(), szInterface);
         }
         return false;
     }
}
