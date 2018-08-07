package com.sczh.systemmanage.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang3.time.DateUtils;
/**
 * 日期帮助类
 * <p>DateUtil </p>
 * @author tjun
 * @创建时间：2018-2-22 下午7:48:29   
 * @修改历史：
 * @修改内容:
 * @修改时间:
 *
 */
public class DateUtil extends DateUtils {
	
	public static final String YYYY = "yyyy";
	public static final String YYYYMMDD = "yyyy-MM-dd";
	public static final String YYYYMMDDWHOLE = "yyyyMMdd";
	public static final String YYYYMMWHOLE = "yyyyMM";
	public static final String YYYYMMDDHHMM = "yyyy-MM-dd HH:mm";
	public static final String YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";
	public static final String YYYYMM = "yyyy-MM";
	

	/**
	 * 字符串转日期
	 * @param str 日期字符串
	 * @param fmt 日期格式
	 * @return
	 */
	public static Date stringToDate(String str,String fmt){
		try {
			//后期要改成SimpleDateFormat,传入格式字符串
			SimpleDateFormat sdf = new SimpleDateFormat(fmt); //用这种方法，则转换的日期格式必须相同
			Date date = sdf.parse(str);			
			return date;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 日期转字符串
	 * @param date
	 * @param fmt 日期格式
	 * @return
	 */
	public static String getFormatDate(Date date, String fmt) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(fmt);
			String str = sdf.format(date);
			return str;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 将传入Date格式化为 指定格式str_format
	 * @param dt
	 * @param str_format
	 * @return
	 */
	public static String formatDate(Date dt,String str_format){
		if(null == dt){
			return "";
		}
		SimpleDateFormat sf = new SimpleDateFormat(str_format);
		return sf.format(dt);
	}
	
	/**
	 * 日期转字符串
	 * @param date
	 * @param fmt 日期格式
	 * @return
	 */
	public static Date getFormatToDate(Date date, String fmt) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(fmt);
			String str = sdf.format(date);
			return stringToDate(str,fmt);
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 将时间字符串按指定格式返回
	 * @param strDate
	 * @param str_format
	 * @return
	 */
	public static String formatDateByString(String strDate,String str_format){
		if(!StringUtil.isBlank(strDate)){
			GregorianCalendar gc = new GregorianCalendar();
			Date dt = formatDateByString(strDate);
			gc.setTime(dt);
			return DateUtil.formatDate(gc.getTime(),str_format);
		}else{
			return "";
		}
	}
	/**
	 * 将字符串转换成Date
	 * @param strDate
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static Date formatDateByString(String strDate){
		if("".equals(formatString(strDate, ""))){
			return null;
		}
		strDate = strDate.replace("-", "/");
		int tmp = strDate.lastIndexOf(".");
		if(-1 != tmp){
			strDate = strDate.substring(0, tmp);
		}
		return new Date(strDate);
	}
	/**
	 * 如果传入对象为空或除去空字符串后长度为0，返回 str，否则返回obj.toString().trim()
	 * @param obj
	 * @param str
	 * @return
	 */
	public static String formatString(Object obj,String str){
		return obj == null?str:(obj.toString().trim().length()>0?obj.toString().trim():str);
	}
	
	/**
	 * 
	* @Title: getNextDay 
	* @Description: TODO 给定日期的下一天 
	* @param @param str
	* @param @return
	* @return String    返回类型 
	* @throws
	 */
	public static String getNextDay(String str) throws ParseException { 
		Date date = stringToDate(str, YYYYMMDD);
		date =addDays(date, 1);
		return getFormatDate(date, YYYYMMDD);
	}
	/**
	 * 给定日期的一个月之前
	 * @param date
	 * @return
	 */
	public static Date getNextDay(Date date) {  
        Calendar calendar = Calendar.getInstance();  
        calendar.setTime(date);  
        calendar.add(Calendar.DAY_OF_MONTH, -30);  
        date = calendar.getTime();  
        return date;  
    }
	
	/**
	 * 是否超时
	 * @param repyDate
	 * @return
	 * @throws ParseException
	 */
	public static boolean isTimeOutFun(String shouldDate,String repyDate) throws ParseException{
		Date date = stringToDate(repyDate,YYYYMMDD);//实际回复日期	
		Date nowDate = stringToDate(shouldDate,YYYYMMDD);//要求回复事件
		int result = date.compareTo(nowDate);
		if(result>0){
			return true;//超时
		}
		return false;//没超时
	}
	  public static int compare_date(String DATE1, String DATE2) {
	        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	        try {
	            Date dt1 = df.parse(DATE1);
	            Date dt2 = df.parse(DATE2);
	            if (dt1.getTime() > dt2.getTime()) {
	                System.out.println("dt1大于dt2");
	                return 1;
	            } else if (dt1.getTime() < dt2.getTime()) {
	                System.out.println("dt1小于dt2");
	                return -1;
	            } else {
	            	System.out.println("dt1不大于也不小于dt2");
	                return 0;
	            }
	        } catch (Exception exception) {
	            exception.printStackTrace();
	        }
	        return 0;
	    }
	  
	  public static int differentDays(Date date1,Date date2)
	    {
	        java.util.Calendar cal1 = java.util.Calendar.getInstance();
	        cal1.setTime(date1);
	        
	        java.util.Calendar cal2 = java.util.Calendar.getInstance();
	        cal2.setTime(date2);
	       int day1= cal1.get(java.util.Calendar.DAY_OF_YEAR);
	        int day2 = cal2.get(java.util.Calendar.DAY_OF_YEAR);
	        
	        int year1 = cal1.get(java.util.Calendar.YEAR);
	        int year2 = cal2.get(java.util.Calendar.YEAR);
	        if(year1 != year2)   //同一年
	        {
	            int timeDistance = 0 ;
	            for(int i = year1 ; i < year2 ; i ++)
	            {
	                if(i%4==0 && i%100!=0 || i%400==0)    //闰年            
	                {
	                    timeDistance += 366;
	                }
	                else    //不是闰年
	                {
	                    timeDistance += 365;
	                }
	            }
	            
	            return timeDistance + (day2-day1) ;
	        }
	        else    //不同年
	        {
	            return day2-day1;
	        }
	    }
	  
	  	/**
	  	 * 计算两个时间之间相差的天数
	  	 * @param date1
	  	 * @param date2
	  	 * @return
	  	 * @throws ParseException
	  	 */
	    public static int getDateSpace(String date1, String date2,String dateFormat)
	            throws ParseException {
            SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
            Date date_1 = sdf.parse(date1);
            Date date_2 = sdf.parse(date2);
            System.out.println(date1+"*****"+date2);
	        Calendar calst = Calendar.getInstance();;
	        Calendar caled = Calendar.getInstance();

	        calst.setTime(date_1);
	        caled.setTime(date_2);
	 
	         //设置时间为0时   
	         calst.set(Calendar.HOUR_OF_DAY, 0);   
	         calst.set(Calendar.MINUTE, 0);   
	         calst.set(Calendar.SECOND, 0);   
	         caled.set(Calendar.HOUR_OF_DAY, 0);   
	         caled.set(Calendar.MINUTE, 0);   
	         caled.set(Calendar.SECOND, 0);   
	        //得到两个日期相差的天数   
	         int days = ((int)(caled.getTime().getTime()/1000)-(int)(calst.getTime().getTime()/1000))/3600/24;   
	         
	        return days;   
	    }
	  
	    
	  public static void main(String[] args){
		 
		  String startDate = "2017-12-25";
		  String endDate = "2018-01-08";
		  
		  SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.YYYYMMDD);
		  int maxDay = 10;
		  String startDate_new = startDate;
		  String endDate_new = endDate;
		  
		  try {
			int dateSpace = getDateSpace(startDate,endDate,DateUtil.YYYYMMDD);
			if(dateSpace>maxDay){
				Date dat = DateUtil.addDays(sdf.parse(startDate_new), maxDay);//开始时间加xx天做为结束时间
				endDate_new = DateUtil.getFormatDate(dat, DateUtil.YYYYMMDD);
				System.out.println(startDate_new+"----"+endDate_new);
				//循环的条件：当前时间大于endDate_new
				while(DateUtil.compare_date(formatDate(new Date(), DateUtil.YYYYMMDD), endDate_new)==1){
					dat = DateUtil.addDays(sdf.parse(startDate_new), maxDay);//开始时间加10天做为结束时间
					endDate_new = DateUtil.getFormatDate(dat, DateUtil.YYYYMMDD);
					System.out.println("自动分时段取数据任务"+startDate_new+"******"+endDate_new);
					startDate_new = endDate_new;//将结束时间作为下一次任务的开始时间
				}
				
			}else{
				System.out.println("不分时段取数据任务"+startDate+"******"+endDate);
			}
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	  }
	      
}
