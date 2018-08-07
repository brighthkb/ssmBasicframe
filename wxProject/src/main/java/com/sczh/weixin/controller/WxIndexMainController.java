package com.sczh.weixin.controller;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hp.hpl.sparta.ParseException;
import com.sczh.core.web.dto.Paging;
import com.sczh.function.test.model.Subject;
import com.sczh.function.test.service.ITestService;
import com.sczh.weixin.core.base.model.WeixinAccount;
import com.sczh.weixin.core.base.service.impl.WechatService;
import com.sczh.weixin.core.util.WeixinUtil;
import com.sczh.weixin.menu.Button;
import com.sczh.weixin.menu.ClickButton;
import com.sczh.weixin.menu.Menu;
import com.sczh.weixin.menu.ViewButton;
import com.sczh.weixin.model.WxUser;
import com.sczh.weixin.service.IWxUserService;
import com.sczh.weixin.sms.SendSms;

import net.sf.json.JSONObject;
/**
 * 
 * 微信首页及我的页面
 * @author tjun
 *
 */
@SuppressWarnings("unchecked")
@Controller
@RequestMapping("/weinxin/wxindexmain")
public class WxIndexMainController {
	
	private static final Log log = LogFactory.getLog(WxIndexMainController.class);
	@Autowired
	private IWxUserService wxUserService;
	@Autowired
	private WechatService wechatService;
	@Autowired
    private ITestService testService;
	/**
	 * 跳转到首页页面
	 * @param classcode
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "towxindex")
	public ModelAndView towxindex(HttpServletRequest request,String classcode,HttpSession session) throws Exception {
		ModelAndView model = new ModelAndView();
		WxUser wxuser = (WxUser) session.getAttribute("wxuser");
		if(null==wxuser||"".equals(wxuser)) {
			Map<String,String> mp = (Map<String, String>) session.getAttribute("wxuseropp");
			if(null!=mp&&!"".equals(mp)) {
				WxUser wxuserN= new WxUser();
				wxuserN.setOpenid(mp.get("openid"));
				wxuser=wxUserService.selectByInfo(wxuserN);
				session.setAttribute("wxuser", wxuser);
			}
		}
		 Map<String, Object> mapQuery = new HashMap<String, Object>();
//		 List<Subject> list = testService.getSubjectList(new Paging(),mapQuery);//业务代码
//		model.addObject("list", list);
		model.setViewName("weixinViews/wxindex");
		return model;
	} 
	/**
	 * 跳转到微信账号绑定页面
	 * @param classcode
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "tobindingwechart")
	public ModelAndView tobindingwechart() throws Exception {
		ModelAndView model = new ModelAndView();
		model.setViewName("weixinViews/bindingwechart");
		return model;
	}
	
	/**
	 * 获取手机验证码
	 * @param phone
	 */
	@RequestMapping(value = "checkrandomVcode")
	public void checkrandomVcode(HttpServletRequest request,String phone){
		SendSms.sendsms(phone,request);
	}
	/**
	 * 获取微信公众号用户相关信息
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getwxuserinfo")
	public ModelAndView getwxuserinfo(HttpServletRequest request,HttpSession session) throws Exception{
		ModelAndView modelView = new ModelAndView();
		String code = request.getParameter("code");
		System.out.println(code);
		Map<String,String> mp = OAuthGetOpenid(code);
		modelView.addObject("wxuser",mp);
		if(session.getAttribute("wxuseropp")==null){
			session.setAttribute("wxuseropp", mp);
		}
		modelView.setViewName("weixinViews/bindingwechart");
		return modelView;
	}
	
	
	/**
	 * 获取微信绑定用户信息
	 * @param wxuser
	 * @return
	 */
	@RequestMapping(value = "queryuserInfo")
	public @ResponseBody  Map<String, Object> queryuserInfo(HttpServletRequest request,WxUser wxuser,HttpSession session){
		Map<String, Object> mp = new HashMap<String,Object>();
		wxuser=wxUserService.selectByInfo(wxuser);
		if(null!=wxuser&&!"".equals(wxuser)) {
			if(session.getAttribute("wxuser")==null||"".equals(wxuser)){
				session.setAttribute("wxuser", wxuser);
			}
		}
		mp.put("wxuser", wxuser);
		return mp;
	}
	
	/**
	 * 绑定用户信息
	 * @param wxuser
	 * @return
	 */
	@RequestMapping(value = "bindinguserInfo")
	public @ResponseBody  Map<String, Object> bindinguserInfo(WxUser wxuser,HttpSession session,@RequestParam(value = "code", required = false) String code){
		Map<String, Object> mp = new HashMap<String,Object>();
		//系统生成验证码
		Object checkCode = session.getAttribute("checkCode");
		session.removeAttribute("checkCode");// 移除掉session
		String checkCodeStr = "";
		String errorMsg = "";
		boolean islogin=false;
//		System.out.println("seesion验证码"+checkCode.toString());
//		System.out.println("code验证码"+code.toString());
		if (null != checkCode && !"".equals(checkCode)) {
			checkCodeStr = checkCode.toString();
		}
		if (null != checkCodeStr && !"".equals(checkCodeStr)&& null != code && checkCodeStr.equalsIgnoreCase(code)) {
			WxUser wxuserb = new WxUser();
			wxuserb.setOpenid(wxuser.getOpenid());
			WxUser wxuserBak=wxUserService.selectByInfo(wxuserb);
			if(null!=wxuserBak&&!"".equals(wxuserBak)) {
				islogin=false;
				errorMsg= "您好，您当前登陆的账号，已登陆，请先退出再登陆！";
			}else {
				try {
					wxUserService.insert(wxuser);
					islogin=true;
					if(session.getAttribute("wxuser")==null){
						session.setAttribute("wxuser", wxuser);
					}
				}catch(Exception e) {
					islogin=false;
					errorMsg ="您好，您微信账户登陆失败，请再次登陆！";
					log.error("用户【{"+wxuser.getPhone()+"}】用户帐号登陆失败！");
				}
			}
		}else{
			errorMsg = "验证码有误，请重新登录！";
		}
		mp.put("errorMsg", errorMsg);
		mp.put("islogin", islogin);
		return mp;
	}
	/**
	 * 通过页面OAuth授权,用code获取openid
	 * 
	 * @param code
	 * @return
	 * @throws Exception 
	 */
	public Map<String,String> OAuthGetOpenid(String code) throws Exception {
		Map<String,String> mp = new HashMap<String,String>();
		WeixinAccount account = wechatService.findLoginWeixinAccount();
		if(null!=account&&!"".equals(account)){
			String requestUrl = WeixinUtil.oauth_getopenid.replace("APPID",
					account.getAccountappid()).replace("APPSECRET", account.getAccountappsecret()).replace("CODE", code);
			JSONObject jsonObject = WeixinUtil.httpRequest(requestUrl,
					"POST", null);
			String accessToken = wechatService.getAccessToken();
			if (null != jsonObject) {
				try {
					String openid = jsonObject.getString("openid");
					requestUrl = WeixinUtil.menu_userInfo_url.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openid);
					jsonObject = WeixinUtil.httpRequest(requestUrl, "GET", null);
					openid=jsonObject.getString("openid");//用户的标识，对当前公众号唯一标识
					String subscribe = jsonObject.getString("subscribe");
					if(null==subscribe||"".equals(subscribe)) {
						subscribe="0";
					}
					mp.put("openid", openid);//用户的唯一标识
					mp.put("nickname",jsonObject.getString("nickname"));//用户昵称
					mp.put("sex", jsonObject.getString("sex"));//用户的性别
					mp.put("headimgurl", jsonObject.getString("headimgurl"));//用户头像
					mp.put("subscribe", subscribe);//用户是否关注
				} catch (Exception e) {
					// 获取token失败
					e.printStackTrace();
					log.error("获取openid失败 errcode:{} errmsg:{}"
							+ jsonObject.getInt("errcode")
							+ jsonObject.getString("errmsg"));
				}
			}
		}
	    return mp;
	}
	
	
	
	public int createMenu(){
		Menu menu = new Menu();
		ViewButton button11 = new ViewButton();
		button11.setName("主页");
		button11.setType("view");
		button11.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx40c4b9828a515980&redirect_uri=http://y8hesp.natappfree.cc/weinxin/wxindexmain/getwxuserinfo.do?response_type=code&scope=snsapi_base&state=1#wechat_redirec");
		
		
		ViewButton button21 = new ViewButton();
		button21.setName("学习站点");
		button21.setType("view");
		button21.setUrl("https://www.baidu.com");//http://www.imooc.com
		
		ClickButton button31 = new ClickButton();
		button31.setName("扫码事件");
		button31.setType("scancode_push");
		button31.setKey("31");
		
		ClickButton button32 = new ClickButton();
		button32.setName("地理位置");
		button32.setType("location_select");
		button32.setKey("32");
		
		Button button = new Button();
		button.setName("功能菜单");
		button.setSub_button(new Button[]{button31,button32});
		
		menu.setButton(new Button[]{button11,button21,button});
		int result = 0;
		String accessToken = null;
		try {
			WechatService wechatService2 = new WechatService();
			accessToken = wechatService2.getAccessToken();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(accessToken);
		String url = WeixinUtil.menu_create_url.replace("ACCESS_TOKEN", accessToken);
		String menuData = JSONObject.fromObject(menu).toString();
		JSONObject jsonObject = null;
		try {
			jsonObject = WeixinUtil.doPostStr(url, menuData);
		} catch (ParseException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(jsonObject != null){
			result = jsonObject.getInt("errcode");
		}
		System.out.println(menuData);
		System.out.println(jsonObject);
		return result;
	}
	
	
	
	
	public static int deleteMenu(String token) throws ParseException, IOException{
		String url = WeixinUtil.DELETE_MENU_URL.replace("ACCESS_TOKEN", token);
		JSONObject jsonObject = WeixinUtil.doGetStr(url);
		System.out.println(jsonObject);
		int result = 0;
		if(jsonObject != null){
			result = jsonObject.getInt("errcode");
		}
		return result;
	}
	
	public static void main(String[] args) {
		WxIndexMainController wxIndex = new WxIndexMainController();
		wxIndex.createMenu();
//		WechatService wechatService2 = new WechatService();
//		String accessToken =null;
//		try {
//			accessToken = wechatService2.getAccessToken();
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		try {
//			wxIndex.deleteMenu(accessToken);
//		} catch (ParseException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
