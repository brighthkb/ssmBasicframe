package com.sczh.core.utils.encrypt;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
* MD5加密工具类
* @date 2014.10.29
* @author chentao
*/
public class Md5Utils {
    
    /**
     * md5加密方法
     * @param str
     * @param charSet
     * @return
     */
    public synchronized static final String getMD5Str(String str,String charSet) { //md5加密
		MessageDigest messageDigest = null;  
		try {  
			messageDigest = MessageDigest.getInstance("MD5");  
			messageDigest.reset(); 
			if(charSet==null){
				messageDigest.update(str.getBytes());
			}else{
				messageDigest.update(str.getBytes(charSet));  
			}			
		} catch (NoSuchAlgorithmException e) {  
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {  
			e.printStackTrace();
		}  
		
		byte[] byteArray = messageDigest.digest();  
		StringBuffer md5StrBuff = new StringBuffer();  
		for (int i = 0; i < byteArray.length; i++) {              
			if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)  
				md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));  
			else  
				md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));  
		}  
		return md5StrBuff.toString();  
	}
    
    /** 
     * 获取文件MD5值 
     * @param file 
     * @return 
     */ 
    public static String getMd5ByFile(File file) {  
        String value = null;  
        FileInputStream in = null;  
        try {  
            in = new FileInputStream(file);  
            MappedByteBuffer byteBuffer = in.getChannel().map(FileChannel.MapMode.READ_ONLY, 0,  
                    file.length());  
            MessageDigest md5 = MessageDigest.getInstance("MD5");  
            md5.update(byteBuffer);  
            BigInteger bi = new BigInteger(1, md5.digest());  
            value = bi.toString(16);  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            if (null != in) {  
                try {  
                    in.close();  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            }  
        }  
        return value;  
    }
}
