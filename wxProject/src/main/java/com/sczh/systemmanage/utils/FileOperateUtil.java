package com.sczh.systemmanage.utils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

 /**
  * 
  * 
  * <p>FileOperateUtil </p>
  * @author tjun
  * @创建时间：Jul 15, 2014 3:41:26 PM   
  * @修改历史：
  * @修改内容:
  * @修改时间:
  *
  */
public class FileOperateUtil {  
	private static final Log log = LogFactory.getLog(FileOperateUtil.class);
  
    /**
     * 将文件上传的文件重命名
     * rename方法
     * <p>TODO</p>
     * @param rename
     * @return String
     * @author tjun
     * Jul 15, 2014 3:41:31 PM
     */
    private static String rename(String name) {  
  
        Long now = Long.parseLong(new SimpleDateFormat("yyyyMMddHHmmss")  
                .format(new Date()));  
        Long random = (long) (Math.random() * now);  
        String fileName = now + "" + random;  
  
        if (name.indexOf(".") != -1) {  
            fileName += name.substring(name.lastIndexOf("."));  
        }  
  
        return fileName;  
    }  
 
    /**
     * 压缩后的文件名
     * zipName方法
     * <p>TODO</p>
     * @param zipName
     * @return String
     * @author tjun
     * Jul 15, 2014 3:41:59 PM
     */
    private static String zipName(String name) {  
        String prefix = "";  
        if (name.indexOf(".") != -1) {  
            prefix = name.substring(0, name.lastIndexOf("."));  
        } else {  
            prefix = name;  
        }  
        return prefix + ".zip";  
    }  
  
    
    
    /**
     * 上传文件
     * upload方法
     * <p>TODO</p>
     * @param upload
     * @return List<Map<String,Object>>
     * @author tjun
     * Jul 15, 2014 3:42:17 PM
     */
    public static List<Map<String, String>> uploadNew(HttpServletRequest request,String filePath)   {  
        MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;  
        Map<String, MultipartFile> fileMap = mRequest.getFileMap();  
        String fileNameStr = null;  
        String fileName =null;
        int i = 0;  
        List<Map<String, String>> fileNames = new ArrayList<Map<String, String>>(); 
        for (Iterator<Map.Entry<String, MultipartFile>> it = fileMap.entrySet()  
                .iterator(); it.hasNext(); i++) {  
            Map.Entry<String, MultipartFile> entry = it.next();  
//            String entryName = entry.getKey();
            MultipartFile mFile = entry.getValue();  
            fileName = mFile.getOriginalFilename(); 
            String fileNameNew = fileName.substring(fileName.lastIndexOf(".") + 1);
            File targetFile = null;
        	targetFile = new File(filePath,fileName);  
        	if(null!=fileNameNew&&!fileNameNew.equals("")){
        		fileNameStr = filePath + "/" +fileName;
        	}else{
        		fileNameStr = null;
        	}
            if (!targetFile.exists()) {  
            	targetFile.mkdirs();  
            }  
            try {
            	mFile.transferTo(targetFile);
	 		} catch (IllegalStateException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		} catch (IOException e) {
	 			// TODO Auto-generated catch block
	 			fileNameStr = null;
	 			e.printStackTrace();
	 		} 
	 		Map<String, String> mp = new HashMap<String,String>();
	 		mp.put("fileName", fileName);
	 		mp.put("filePath", fileNameStr);
	 		fileNames.add(mp);
        }  
        return fileNames;
    }  
    
    /**
     * download方法
     * <p>下载文件</p>
     * @param download
     * @return void
     * @author tjun
     * Jul 3, 2017 4:37:33 PM
     */
	public static void download(HttpServletRequest request,  
            HttpServletResponse response, String path, String contentType,String realName) throws Exception {  
    	 response.setContentType("text/html;charset=UTF-8");  
         request.setCharacterEncoding("UTF-8");  
         BufferedInputStream bis = null;  
         BufferedOutputStream bos = null;  
         String downLoadPath = path;  
   
         long fileLength = new File(downLoadPath).length();  
   
         response.setContentType(contentType);  
         response.setHeader("Content-disposition", "attachment; filename="  
                 + new String(realName.getBytes("gbk"), "iso8859-1"));  
         response.setHeader("Content-Length", String.valueOf(fileLength));  
         bis = new BufferedInputStream(new FileInputStream(downLoadPath));  
         bos = new BufferedOutputStream(response.getOutputStream());  
         byte[] buff = new byte[2048];  
         int bytesRead;  
         while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {  
             bos.write(buff, 0, bytesRead);  
         }  
         bis.close();  
         bos.close();  
    }  
    
    /**
	 * 删除文件（夹）
	 * 
	 * @param file
	 *            文件（夹）
	 */
	public static boolean delete(File file) {
		boolean isDeleteFile = false;
		if (!file.exists()) {
			log.info("当前路径文件不存在，请确认文件路径下是否存在！");
			return false;
		}
		if (file.isFile()) {// 是文件
			isDeleteFile = file.delete();
			if (!isDeleteFile) {
				log.info("当前路径文件删除成功！");
			}
			return isDeleteFile;
		} else {// 文件夹
			for (File f : file.listFiles()) {
				delete(f);// 文件夹下的文件
			}
			isDeleteFile = file.delete();// 在删除文件夹
			if (!isDeleteFile) {
				log.info("当前路径文件夹的文件及目录删除成功！");
			}
			return false;
		}
	}
}  
