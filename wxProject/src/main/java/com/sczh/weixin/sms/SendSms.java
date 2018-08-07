package com.sczh.weixin.sms;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import com.sczh.weixin.util.HttpUtils;
public class SendSms {

	public static void main(String[] args) {
	    String host = "http://yzx.market.alicloudapi.com";
	    String path = "/yzx/sendSms";
	    String method = "POST";
	    String appcode = "d29aa62d72444656aa63fb73f897db68";
	    Map<String, String> headers = new HashMap<String, String>();
	    headers.put("Authorization", "APPCODE " + appcode);
	    Map<String, String> querys = new HashMap<String, String>();
	    querys.put("mobile", "17313168857");
	    String code = createRandomVcode();
	    querys.put("param", "code:"+code);
	    querys.put("tpl_id", "TP18052412");
	    Map<String, String> bodys = new HashMap<String, String>();


	    try {
	    	HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
//	    	System.out.println(response.toString());
	    	//获取response的body
	    	System.out.println(EntityUtils.toString(response.getEntity()));
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	}
	public static String  sendsms(String phone,HttpServletRequest request) {
		//这里并没有调用发送短信接口，默认验证码123456
		//实际应用时需调用短信接口
	    String code = createRandomVcode();
	    code = "123456";
	    String result ="";
	    try {
	    final HttpSession httpSession=request.getSession();
          httpSession.setAttribute("checkCode",code);
        //TimerTask实现5分钟后从session中删除checkCode
          final Timer timer=new Timer();
          timer.schedule(new TimerTask() {
              @Override
              public void run() {
                  httpSession.removeAttribute("checkCode");
                  timer.cancel();
              }
          },10*60*1000);
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return result;
	}
	/**
     * 随机生成6位随机验证码
      * 方法说明
      * @Discription:扩展说明
      * @return
      * @return String
      * @Author: feizi
      * @Date: 2015年4月17日 下午7:19:02
      * @ModifyUser：feizi
      * @ModifyDate: 2015年4月17日 下午7:19:02
     */
    public static String createRandomVcode(){
        //验证码
        String vcode = "";
        for (int i = 0; i < 6; i++) {
            vcode = vcode + (int)(Math.random() * 9);
        }
        return vcode;
    }

    
    
//    @RequestMapping(value = "sendMessage",method = RequestMethod.GET)
//    public Object sendMessage(final HttpServletRequest request){
//        String phone=request.getParameter("phone");
//        int times=userService.messageSendToday(phone);    //二次验证，单个手机号每日发送上限
//        if(times <= MAX_PER_DAY){
//            String checkCode=GenerateRandomCode.createRandomNumber(6);
//            final HttpSession httpSession=request.getSession();
//            httpSession.setAttribute("checkCode",checkCode);
//            CheckCodeMessage checkCodeMessage=new CheckCodeMessage(phone,checkCode);
//            try {
//                HttpSender.batchSend(checkCodeMessage);
//                //TimerTask实现5分钟后从session中删除checkCode
//                final Timer timer=new Timer();
//                timer.schedule(new TimerTask() {
//                    @Override
//                    public void run() {
//                        httpSession.removeAttribute("checkCode");
//                        System.out.println("checkCode删除成功");
//                        timer.cancel();
//                    }
//                },5*60*1000);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            return "redirect:/index.jsp";
//        }
//    }
    
//  //TimerTask实现5分钟后从session中删除checkCode
//    final Timer timer=new Timer();
//    timer.schedule(new TimerTask() {
//        @Override
//        public void run() {
//            httpSession.removeAttribute("checkCode");
//            System.out.println("checkCode删除成功");
//            timer.cancel();
//        }
//    },5*60*1000);
}
