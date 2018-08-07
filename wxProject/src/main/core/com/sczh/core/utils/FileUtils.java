package com.sczh.core.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 陈涛
 * @version 1.0
 */
@SuppressWarnings("all")
public class FileUtils {	
	private static Logger log = LoggerFactory.getLogger(FileUtils.class);

    /**
     * 判断文件夹是否存在
     * @param directoryPath String 文件目录路径
     * @return boolean
     */
    public static boolean verdictDirectoryExist(String directoryPath) {
        boolean Exist = false;
        if (directoryPath == null || directoryPath.length() <= 0) {
            log.error( "调用verdictFileExist()方法出错！参数directoryPath为空！");
            return Exist;
        }
        File file = new File(directoryPath);
        if (file.exists() && file.isDirectory()) {
            Exist = true;
        } else {
            Exist = false;
        }
        return Exist;
    }

    /**
     * 判断文件是否存在
     * @param FilePath String
     * @return boolean
     */
    public static boolean verdictFileExist(String FilePath) {
        boolean Exist = false;
        if (FilePath == null || FilePath.length() <= 0) {
        	log.error("verdictFileExist()方法出错！参数FilePath为空！");
            return Exist;
        }
        File file = new File(FilePath);
        if (file.exists() && file.isFile()) {
            Exist = true;
        } else {
            Exist = false;
        }
        return Exist;
    }
    /**
     * 根据路径生成文件夹
     * @param dirPath
     * @return
     */
    public static boolean CreateDir(String dirPath){
    	if (dirPath == null || dirPath.length() <= 0) {
        	log.error("生成文件夹时出错:传递参数文件路径为空!");
            return false;
        }
    	 boolean createPath = false;
    	 //按照目录分开一级级建立
        List pathList = getStrArray(dirPath, File.separator);
        String pathTemp = "";
        String dir = "";
        if (pathList != null && pathList.size() > 0) {
            for (int i = 0; i < pathList.size(); i++) {
                pathTemp += (String) pathList.get(i)+File.separator;
                dir = pathTemp;
                //建立目录
                if(dir.endsWith(File.separator)){
                	dir = dir.substring(0,dir.lastIndexOf(File.separator));
                }
                File d = new File(dir); //建立代表Sub目录的File对象，并得到它的一个引用                
                //目录不存在则生成
                if (!d.exists()) {
                	if(!d.canRead()){
                		d.setReadable(true);
                	}
                	if(!d.canWrite()){
                		d.setWritable(true);
                	}
                    createPath = d.mkdir(); //建立Sub目录
                    if (!createPath) {
                    	log.error("根据路径:" + pathTemp + "生成路径出错!");
                        return false;
                    }
                }
            }
        }
    	return true;
    }

    /**
     * 根据文件路径\名称 生成文件
     * @param filePath  路径
     * @param fileName  名称
     * @return
     */
    public static boolean CreateFile(String filePath, String fileName) {
    	if(!CreateDir(filePath)){
    		return false;
    	}
        if (fileName == null || fileName.length() <= 0) {
        	log.error("生成文件时出错:传递参数文件名称为空!");
            return false;
        }       
        boolean createFile = false;       
        File f = new File(filePath, fileName);
        //如果该文件已经存在
        if (f.exists()&&f.isFile()) {
            f.delete(); //删除文件
        }
        //文件不存在
        try {
            createFile = f.createNewFile(); //在当前目录下建立一个文件
        } catch (IOException ex) {
        }
        if (!createFile) {
        	log.error("根据路径:" +filePath + "文件名:" + fileName +"生成文件时出错!");
            return false;
        }
        return true;
    }

    /**
     * 得到一个目录下所有的文件的绝对路径链表
     * @param directoryPath String
     * @return List
     */
    public static List getFiles(String directoryPath) {
        if (directoryPath == null || directoryPath.length() <= 0) {
        	log.error("getFiles()方法出错！参数directoryPath为空！");
            return null;
        }
        List FilesPath = null;
        File file = new File(directoryPath);
        File files[] = file.listFiles(); //列出目录下所有文件
        if(files!=null && files.length>0){
        	FilesPath = new ArrayList();
        	for (int i = 0; i < files.length; i++) {
        		File fi = files[i];        		
        		if(fi.isFile()){        			
        			FilesPath.add(fi.getAbsolutePath());
        		}else{
        			List list = getFiles(fi.getAbsolutePath());
        			if(list != null && list.size()>0){
        				for(int j = 0 ; j < list.size(); j ++){
        					FilesPath.add(list.get(j));
        				}
        			}
        		}
        	}
        }
        return FilesPath;
    }
    /**
     * 得到一个目录下所有的文件夹的绝对路径链表
     * @param directoryPath String
     * @return List
     */
    public static List getDirs(String directoryPath) {
        if (directoryPath == null || directoryPath.length() <= 0) {
        	log.error("getFiles()方法出错！参数directoryPath为空！");
            return null;
        }
        List FilesPath = null;
        File file = new File(directoryPath);
        File files[] = file.listFiles(); //列出目录下所有文件
        if(files!=null && files.length>0){
        	FilesPath = new ArrayList();
        	for (int i = 0; i < files.length; i++) {
        		File fi = files[i];        		
        		if(fi.isDirectory()){
        			FilesPath.add(fi.getAbsolutePath());
        			List list = getDirs(fi.getAbsolutePath());
        			if(list != null && list.size()>0){
        				for(int j = 0 ; j < list.size(); j ++){
        					FilesPath.add(list.get(j));
        				}
        			}
        		}
        	}
        }
        return FilesPath;
    }
    /**
     * 截取字符串
     * @param str   被截取字符串
     * @param strChar  截取字符串标识
     * @return
     */
    public static List getStrArray(String str, String strChar) {
        if (str == null || str.equals("") || strChar == null ||
            strChar.equals("")) {
            return null;
        }
        List strAryList = null;
        strAryList = new ArrayList();
        int indexStart = 0;
        int indexEnd = 0;
        while (true) {
            indexEnd = str.indexOf(strChar, indexStart);
            if (indexEnd > 0) {
                strAryList.add(str.substring(indexStart, indexEnd));
                indexStart = indexEnd + 1;
            } else {
                strAryList.add(str.substring(indexStart));
                break;
            }
        }
        return strAryList;
    }

    /**
     * 根据源文件路径\目的文件路径\目的文件名写文件
     * @param srcpath String
     * @param dstpath String
     * @param fileName String
     * @return boolean
     */
    public static boolean writeFile(String srcpath, String dstpath, String fileName) {
        if (srcpath == null || srcpath.equals("") || dstpath == null ||
            dstpath.equals("") || fileName == null || fileName.equals("")) {
            return false;
        }
        if (!verdictDirectoryExist(srcpath)) {
            return false;
        }
        if (!CreateFile(dstpath, fileName)) {
            return false;
        }
        try {
            File file1 = new File(srcpath);
            File file2 = new File(dstpath);
            File aFile3 = new File(file2, fileName);
            FileInputStream in3 = new FileInputStream(file1);
            FileOutputStream out3 = new FileOutputStream(aFile3);
            BufferedInputStream bin3 = new BufferedInputStream(in3);
            BufferedOutputStream bout3 = new BufferedOutputStream(out3);
            int length3;
            byte buf3[] = new byte[1024];
            while ((length3 = bin3.read(buf3)) != -1) {
                bout3.write(buf3, 0, length3);
            }
            bin3.close();
            bout3.close();
            in3.close();
            out3.close();
        } catch (Exception ex) {
        	log.error("根据源文件路径-目的文件路径-目的文件名写文件失败。");
        }
        return true;
    }

    /**
     * 根据字符串\目的文件路径\目的文件名写文件
     * @param contant String
     * @param dstpath String
     * @param fileName String
     * @return boolean
     */
    public static boolean writeFileByStr(String contant, String dstpath, String fileName) {
        if (contant == null || contant.equals("") || dstpath == null ||
            dstpath.equals("") || fileName == null || fileName.equals("")) {
            return false;
        }
        if (!CreateFile(dstpath, fileName)) {
            return false;
        }
        File file1 = new File(dstpath, fileName);
        try {
            FileOutputStream fout = new FileOutputStream(file1); // 创建文件输出流
            FileChannel fch = fout.getChannel(); // 创建文件输出流通道
            byte[] temp = contant.getBytes(); //装载数据到缓存
            ByteBuffer byteBuff = ByteBuffer.allocate(temp.length); //分配缓存
            byteBuff.put(temp);
            byteBuff.flip();
            int f = fch.write(byteBuff); // 写缓存到通道
            if (f == 0) {
                fch.close(); // 关闭操作系统的I/O流和通道
            }
        } catch (Exception ex) {
        	log.error("根据字符串-目的文件路径-目的文件名写文件写文件失败。");
        }
        return true;
    }
    /**
     * 根据文件夹绝对路径删除文件夹
     * @param filePath String
     * @return boolean
     */
    public static boolean delDir(String dirPath) {
        if(dirPath == null || dirPath.equals("")){
        	log.error("delDir()方法出错！参数dirPath为空！");
            return false;
        }
        boolean exev = true;
        if(verdictDirectoryExist(dirPath)){
        	List list = getFiles(dirPath);
        	if(list != null && list.size()>0){
        		for(int i=0;i<list.size();i++){
        			String filepath = list.get(i).toString();
        			boolean bool = delFile(filepath);
        			if(bool == false){
        				return false;
        			}
        		}
        	}
        	List dirlist = getDirs(dirPath);
        	if(dirlist != null && dirlist.size()>0){
        		for(int i=(dirlist.size()-1);i>=0;i--){
        			String filepath = dirlist.get(i).toString();        			
        			File file = new File(filepath);        			
        			boolean exevf = file.delete();
        			if(exevf == false){
        				return false;
        			}
        		}
        	}
        	File file = new File(dirPath);
        	exev = file.delete();
        }else{
        	log.error("文件夹不存在");
        }
        return exev;
    }
    /**
     * 根据文件绝对路径删除文件
     * @param filePath String
     * @return boolean
     */
    public static boolean delFile(String filePath) {
        if(filePath == null || filePath.equals("")){
        	log.error("delFile()方法出错！参数filePath为空！");
            return false;
        }
        File file1 = new File(filePath);
        boolean bool = false;
        if(!file1.isFile()){ //根据文件路径判断是否为文件
        	log.error("delFile()方法出错！参数filePath不是文件的绝对地址路径！");
            return false;
        }else{
             bool =  file1.delete();
        }
        if(bool == false){
            return false;
        }
        return true;
    }

	 /**   
     *   将文件名中的汉字转为UTF8编码的串,以便下载时能正确显示另存的文件名.   
     *   @param   s   原文件名   
     *   @return   重新编码后的文件名   
     */  
	public static String toUtf8String(String s){   
		StringBuffer sb = new StringBuffer();   
		for(int i = 0 ; i < s.length() ; i++){   
			char c = s.charAt(i);   
			if(c >= 0 && c <= 255){   
				sb.append(c);   
			}else{   
				byte[] b;   
				try{   
					b = Character.toString(c).getBytes("utf-8");   
				}catch(Exception ex){   
					ex.printStackTrace();
					b = new byte[0];   
				}   
				for(int j = 0; j < b.length; j++){   
					int k = b[j];   
					if(k < 0)
						k += 256;   
					sb.append("%" + Integer.toHexString(k).toUpperCase());   
				}   
			}   
		}   
		return sb.toString();   
   }   

}

