package com.sczh.core.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.util.WebUtils;

import com.sczh.core.config.ConfigUtils;

@SuppressWarnings("all")
public class AttachmentUtils{
	private static Logger log = LoggerFactory.getLogger(AttachmentUtils.class);
	//将上传文件保存在内存还是磁盘临时文件夹的临界值 :1024*1024*20=20M
	private static final int DEFAULT_UPLOAD_FILE_THRESHOLD_SIZE = 20971520;
	//上传文件最大值 :1024*1024*100=100M
	private static final int DEFAULT_UPLOAD_FILE_MAX_SIZE = 104857600;
	
	/**
	 * 获取form表单参数(包含附件)
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public static Param getParam(HttpServletRequest request) throws Exception{
		if(ClassUtils.isInterface(request.getClass(), MultipartHttpServletRequest.class.getName())){
			return parsingSpringRequest((MultipartHttpServletRequest)request);
		}else{
			return parsingRequest(request);
		}
	}
	
	public static class Param {
		private Map formParam;//表单参数
		private List<AttachmentVo> attachments;//附件参数		

		public Param(Map formParam, List<AttachmentVo> attachments) {
			this.formParam = formParam;
			this.attachments = attachments;
		}
		
		public Map getFormParam() {
			return formParam;
		}
		public void setFormParam(Map formParam) {
			this.formParam = formParam;
		}
		public List<AttachmentVo> getAttachments() {
			return attachments;
		}
		public void setAttachments(List<AttachmentVo> attachments) {
			this.attachments = attachments;
		}
	}
	
	public static class AttachmentVo {
		private String formName;
		private String filePath;
		private String fileName;
		private long fileSize;
		private String fileType;
		private String fileDesc;
		private InputStream inputStream;
		
		public AttachmentVo(String filePath, long fileSize, InputStream inputStream) throws Exception{
			//文件路径(有可能是一个文件名，不包含目录路径)
			if(StringUtils.isBlank(filePath)){
				throw new Exception("文件路径名为空");
			}else{
				//文件路径
				this.filePath = filePath;
				//文件名
				if(this.filePath.lastIndexOf(File.separator)!=-1){
					this.fileName = this.filePath.substring(this.filePath.lastIndexOf(File.separator)+1);
				}else{
					this.fileName = this.filePath;
				}
				//文件类型
				this.fileType = this.filePath.substring(this.filePath.lastIndexOf("."));
				if(StringUtils.isBlank(this.fileType)){
					throw new Exception("文件路径名格式错误，不存在文件后缀名");
				}
			}
			//文件内容大小
			if(fileSize<=0){
				throw new Exception("文件大小为空或者值无效");
			}else{
				this.fileSize = fileSize;
			}
			//文件二进制流
			if(inputStream!=null && inputStream.available()>0){
				this.inputStream = inputStream;
			}else{
				throw new Exception("文件不能为空");
			}
		}
		
		public AttachmentVo(String formName, String filePath, long fileSize, InputStream inputStream) throws Exception{
			this(filePath, fileSize, inputStream);
			//form表单name名称
			this.formName = formName;
		}
		
		public AttachmentVo(String formName, String filePath, long fileSize, String fileDesc, InputStream inputStream) throws Exception{
			this(formName, filePath, fileSize, inputStream);
			//文件描述
			this.fileDesc = fileDesc;
		}
		
		
		public String getFormName() {
			return formName;
		}
		public void setFormName(String formName) {
			this.formName = formName;
		}
		public String getFilePath() {
			return filePath;
		}
		public void setFilePath(String filePath) {
			this.filePath = filePath;
		}
		public String getFileName() {
			return fileName;
		}
		public void setFileName(String fileName) {
			this.fileName = fileName;
		}
		public long getFileSize() {
			return fileSize;
		}
		public void setFileSize(long fileSize) {
			this.fileSize = fileSize;
		}
		public String getFileType() {
			return fileType;
		}
		public void setFileType(String fileType) {
			this.fileType = fileType;
		}
		public String getFileDesc() {
			return fileDesc;
		}
		public void setFileDesc(String fileDesc) {
			this.fileDesc = fileDesc;
		}
		public InputStream getInputStream() {
			return inputStream;
		}
		public void setInputStream(InputStream inputStream) {
			this.inputStream = inputStream;
		}
		
		@Override
		public String toString() {
			return "附件信息：" + 
					(StringUtils.isBlank(formName) ? "" : "formName="+formName+", ") +
					"filePath=" + this.filePath + ", " +
					"fileSize=" + this.fileSize + "(byte)";
		}
	}
	
	/**
	 * 解析request参数
	 * @param request
	 * @return
	 * @throws Exception
	 */
	private static Param parsingRequest(HttpServletRequest request) throws Exception{
		int uploadFileThresholdSize = NumberUtils.toInt(
				ConfigUtils.getConfig("upload_file_threshold_size", null),
				DEFAULT_UPLOAD_FILE_THRESHOLD_SIZE);
		int uploadFileMaxSize = NumberUtils.toInt(
				ConfigUtils.getConfig("upload_file_max_size", null),
				DEFAULT_UPLOAD_FILE_MAX_SIZE);
	
		/*           附件上传参数设置                               */
		DiskFileItemFactory factory=new DiskFileItemFactory();
		factory.setSizeThreshold(uploadFileThresholdSize);//用于将上传文件保存在内存还是磁盘临时文件夹的临界值
		//当上传文件大于临界值时使用的临时文件夹，默认采用系统临时文件路径，
		//可以通过系统属性 java.io.tmpdir获取。如下代码： System.getProperty("java.io.tmpdir");
		factory.setRepository(new File(WebUtils.getRealPath(request.getServletContext(), "/tmp")));
		ServletFileUpload upload=new ServletFileUpload(factory);		
		upload.setSizeMax(uploadFileMaxSize);//设置该次上传最大值 
		
		/*           读取form参数值(包含附件)          */
    	Map req = new HashMap();
    	List<AttachmentVo> attachments = null;
    	//解析并获取参数
   	    List items= upload.parseRequest(request);
		for(Iterator it =items.iterator();it.hasNext();){
			FileItem item=(FileItem)it.next();
			if(item.isFormField()){
				//读取FORM表单参数
				String name=item.getFieldName();
				String value=item.getString("UTF-8");
				req.put(name, value);
			}else{
				if(attachments==null) 
					attachments = new ArrayList<AttachmentVo>();
				//读取上传附件
				InputStream is = null;
				if(item.isInMemory()){
					is = new ByteArrayInputStream(item.get());
				}else{
					is = item.getInputStream();
				}
				AttachmentVo attachment = new AttachmentVo(item.getFieldName(), item.getName(),
						item.getSize(), request.getParameter("fileDesc_"+item.getFieldName()), is);
				attachments.add(attachment);
				log.info(attachment.toString());
			}
		}
		log.info("form表单参数："+req.toString());
			
		 return new Param(req, attachments);
	}
	
	/**
	 * 解析request参数(spring mvc支持文件上传，默认使用spring mvc配置的上传设置参数)
	 * 注意：spring mvc里配置CommonsMultipartResolver时，会调用此方法，否则，如上解析方式是获取不到任何参数的。
	 * @param request
	 * @return
	 * @throws Exception
	 */
	private static Param parsingSpringRequest(MultipartHttpServletRequest request) throws Exception{
		Map req = new HashMap();
		//读取FORM表单参数
		Map params = request.getParameterMap();
		Set keys = params.keySet();
		for (Iterator iterator = keys.iterator(); iterator.hasNext();) {
			Object key = iterator.next();
			Object[] value = (Object[]) params.get(key);
			if(value!=null && value.length==1){
				req.put(key, value[0]);
			}else{
				req.put(key, value);
			}
		}
		log.info("form表单参数："+req.toString());
		
		//读取上传附件
		List<AttachmentVo> attachments = null;
		Map<String, MultipartFile> multipartFiles =request.getFileMap();
		if(multipartFiles!=null && multipartFiles.size()>0){	
			attachments = new ArrayList<AttachmentVo>();
			//解析并获取附件
			Collection<MultipartFile> files = multipartFiles.values();			
			for (Iterator iterator = files.iterator(); iterator.hasNext();) {
				MultipartFile file = (MultipartFile) iterator.next();
				if(file!=null && !file.isEmpty()){
					AttachmentVo attachment = new AttachmentVo(file.getName(), file.getOriginalFilename(),
							file.getSize(), request.getParameter("fileDesc_"+file.getName()), file.getInputStream());
					attachments.add(attachment);
					log.info(attachment.toString());
				}
			}
		}
		
        return new Param(req, attachments);
	}
	

	
	public static void destroy(AttachmentVo attachment){
		if(attachment!=null){
			IOUtils.closeQuietly(attachment.getInputStream());
			attachment.setInputStream(null);
		}
	}
	
	public static void destroy(List<AttachmentVo> attachments){
		if(attachments!=null && !attachments.isEmpty()){
			for (Iterator iterator = attachments.iterator(); iterator.hasNext();) {
				AttachmentVo attachment = (AttachmentVo) iterator.next();
				if(attachment!=null){
					IOUtils.closeQuietly(attachment.getInputStream());
					attachment.setInputStream(null);
				}
			}
			
			attachments.clear();
		}
	}
}
