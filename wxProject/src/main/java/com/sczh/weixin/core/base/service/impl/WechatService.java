package com.sczh.weixin.core.base.service.impl;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sczh.core.config.ConfigUtils;
import com.sczh.weixin.core.base.mapper.WeixinAccountMapper;
import com.sczh.weixin.core.base.model.WeixinAccount;
import com.sczh.weixin.core.entity.message.resp.TextMessageResp;
import com.sczh.weixin.core.util.MessageUtil;
import com.sczh.weixin.core.util.WeixinUtil;

import net.sf.json.JSONObject;
@Service("wechatService")
@SuppressWarnings("unused")
public class WechatService {
	private static final Log log = LogFactory.getLog(WechatService.class);
	@Autowired
	private WeixinAccountMapper weixinAccountMapper;

	public String coreService(HttpServletRequest request) {
		String respMessage = null;
		try {
			// 默认返回的文本消息内容
			String respContent = "请求处理异常，请稍候尝试！";
			// xml请求解析
			Map<String, String> requestMap = MessageUtil.parseXml(request);
			// 发送方帐号（open_id）
			String fromUserName = requestMap.get("FromUserName");
			// 公众帐号
			String toUserName = requestMap.get("ToUserName");
			// 消息类型
			String msgType = requestMap.get("MsgType");
			String msgId = requestMap.get("MsgId");
			// 消息内容
			String content = requestMap.get("Content");
			log.info("------------微信客户端发送请求---------------------   |   fromUserName:" + fromUserName
					+ "   |   ToUserName:" + toUserName + "   |   msgType:" + msgType + "   |   msgId:" + msgId
					+ "   |   content:" + content);
			// 根据微信ID,获取配置的全局的数据权限ID
			log.info("-toUserName--------" + toUserName);
			String sys_accountId = "";
			log.info("-sys_accountId--------" + sys_accountId);
			// 默认回复此文本消息
			respMessage = "success";// 默认不自动回复
			// 【微信触发类型】文本消息
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
				log.info("------------微信客户端发送请求------------------【微信触发类型】文本消息---");
				respContent = "您发送的是 文本消息！";
			}
			// 【微信触发类型】图片消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
				respContent = "您发送的是图片消息！";
			}
			// 【微信触发类型】地理位置消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
				respContent = "您发送的是地理位置消息！";
			}
			// 【微信触发类型】链接消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
				respContent = "您发送的是链接消息！";
			}
			// 【微信触发类型】音频消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
				respContent = "您发送的是音频消息！";
			}
			// 【微信触发类型】事件推送
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
				log.info("------------微信客户端发送请求------------------【微信触发类型】事件推送---");
				// 事件类型
				String eventType = requestMap.get("Event");
				// 订阅
				if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
					TextMessageResp textMessage = new TextMessageResp();
					textMessage.setToUserName(fromUserName);
					textMessage.setFromUserName(toUserName);
					textMessage.setCreateTime(new Date().getTime());
					textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
					textMessage.setContent(getMainMenu());
					// 将文本消息对象转换成xml字符串
					respMessage = MessageUtil.textMessageToXml(textMessage);
					parseUserInfo(fromUserName);
				}
				// 取消订阅取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
				else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {}
				// 自定义菜单点击事件
				else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return respMessage;
	}

	/**
	 * 解析返回用户信息数据
	 * 
	 * @param userInfoJSON
	 * @return
	 * @throws Exception 
	 */
	private void parseUserInfo(String openId) throws Exception {
		JSONObject jsonObject = new JSONObject();
		String accessToken = getAccessToken();
		String requestUrl = WeixinUtil.menu_userInfo_url.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openId);
		;
		// 获取用户信息
		String nickname = "";
		String openid = "";
		String sex = "";
		String headimgurl = "";
		jsonObject = WeixinUtil.httpRequest(requestUrl, "GET", null);
		if (null != jsonObject) {
			try {
				nickname = jsonObject.getString("nickname");// 用户昵称
				openid = jsonObject.getString("openid");// 用户的标识，对当前公众号唯一标识
				sex = jsonObject.getString("sex");// 用户的性别
				headimgurl = jsonObject.getString("headimgurl");// 用户的头像地址
			} catch (Exception e) {
				int errorCode = jsonObject.getInt("errcode");
				String errorMsg = jsonObject.getString("errmsg");
				log.error("获取用户信息失败 errcode:{" + errorCode + "} errmsg:{" + errorMsg + "}");
			}
		}
	}
	
	
	
	/** 
	 * 创建永久二维码(字符串) 
	 *  
	 * @param accessToken 
	 * @param sceneStr 场景str 
	 * @return 
	 * @throws Exception 
	 */  
	public void createForeverStrTicket(String sceneStr) throws Exception{        
		JSONObject jsonObject= new JSONObject();
    	String accessToken = getAccessToken();
    	String requestUrl = WeixinUtil.create_ticket_path.replace("ACCESS_TOKEN", accessToken);
    	//发送给微信服务器的数据
        String jsonStr = "{\"action_name\": \"QR_LIMIT_SCENE\", \"action_info\"：{\"scene\": {\"scene_str\": "+sceneStr+"}}}";
        // 获取用户信息
        jsonObject = WeixinUtil.httpRequest(requestUrl, "POST", jsonStr);
        if (null != jsonObject) {
            try {
            	String ticket= jsonObject.getString("ticket");//获取二维码ticket
            	String expire_seconds=jsonObject.getString("expire_seconds");//二维码有效时间
            	String url=jsonObject.getString("url");//二维码解析后的地址
            	String ui = "";
            } catch (Exception e) {
                    int errorCode = jsonObject.getInt("errcode");
                    String errorMsg = jsonObject.getString("errmsg");
                    log.error("创建永久二维码(字符串)失败 errcode:{"+errorCode+"} errmsg:{"+errorMsg+"}");
            }
        }
	}
	
	/**
	 * 下载二维码
	 * @param urlString
	 * @param filePath
	 * @return
	 */
	public static Boolean downloadFile(String urlString, String filePath){
        // 构造URL
        URL url;
         try {
             url = new URL(urlString);
              // 打开连接
             URLConnection con;
             try {
                  con = url.openConnection();
                  // 输入流
                 InputStream is = con.getInputStream();
                 // 1K的数据缓冲
                 byte[] bs = new byte[1024];
                 // 读取到的数据长度
                 int len;
                 // 输出的文件流
                 OutputStream os = new FileOutputStream(filePath);
                 // 开始读取
                 while ((len = is.read(bs)) != -1) {
                  os.write(bs, 0, len);
                 }
                 // 完毕，关闭所有链接
                 os.close();
                 is.close();
                 return true;
             } catch (IOException e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
                  return false;
             }
            
         } catch (MalformedURLException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
             return false;
         }
      
    }  
	/**
	 * 获取ticket
	 * @return
	 * @throws Exception 
	 */
	public String jsapi_ticket() throws Exception {
		String ticket = "";
		WeixinAccount account = findLoginWeixinAccount();
		ticket = account.getAccountjsticket();
		String  access_token=getAccessToken();
		if (ticket != null && !"".equals(ticket)) {
			// 判断有效时间 是否超过2小时
			java.util.Date end = new java.util.Date();
			java.util.Date start = new java.util.Date(account.getAddtickettime()
					.getTime());
			if ((end.getTime() - start.getTime()) / 1000 / 3600 >= 2) {
				// 失效 重新获取
				String requestUrl = WeixinUtil.access_ticket_url.replace(
						"ACCESS_TOKEN",access_token);
				JSONObject jsonObject = WeixinUtil.httpRequest(requestUrl,
						"GET", null);
				if (null != jsonObject) {
					try {
						ticket = jsonObject.getString("ticket");
						// 重置token
						account.setAccountjsticket(ticket);
						// 重置事件
						account.setAddtickettime(new Date());
						weixinAccountMapper.updateByPrimaryKey(account);
					} catch (Exception e) {
						ticket = null;
						// 获取token失败
						String wrongMessage = "获取ticket失败 errcode:{} errmsg:{}"
								+ jsonObject.getInt("errcode")
								+ jsonObject.getString("errmsg");
						log.info("------------"+wrongMessage);
						log.error("------------"+wrongMessage);
					}
				}
			} else {
				return account.getAccountjsticket();
			}
		} else {
			String requestUrl = WeixinUtil.access_ticket_url.replace(
					"ACCESS_TOKEN", access_token);
			JSONObject jsonObject = WeixinUtil.httpRequest(requestUrl, "GET",
					null);
			if (null != jsonObject) {
				try {
					ticket = jsonObject.getString("ticket");
					// 重置token
					account.setAccountjsticket(ticket);
					// 重置事件
					account.setAddtickettime(new Date());
					weixinAccountMapper.updateByPrimaryKey(account);
				} catch (Exception e) {
					ticket = null;
					// 获取token失败
					String wrongMessage = "获取ticket失败 errcode:{} errmsg:{}"
							+ jsonObject.getInt("errcode")
							+ jsonObject.getString("errmsg");
					log.info("------------"+wrongMessage);
					log.error("------------"+wrongMessage);
				}
			}
		}
		return ticket;
	}
    public String getAccessToken() throws Exception {
		String token = "";
		WeixinAccount account = findLoginWeixinAccount();
		token = account.getAccountaccesstoken();
		if (token != null && !"".equals(token)) {
			// 判断有效时间 是否超过2小时
			java.util.Date end = new java.util.Date();
			java.util.Date start = new java.util.Date(account.getAddtoekntime()
					.getTime());
			if ((end.getTime() - start.getTime()) / 1000 / 3600 >= 2) {
				// 失效 重新获取
				String requestUrl = WeixinUtil.access_token_url.replace(
						"APPID", account.getAccountappid()).replace(
						"APPSECRET", account.getAccountappsecret());
				JSONObject jsonObject = WeixinUtil.httpRequest(requestUrl,
						"GET", null);
				if (null != jsonObject) {
					try {
						token = jsonObject.getString("access_token");
						// 重置token
						account.setAccountaccesstoken(token);
						// 重置事件
						account.setAddtoekntime(new Date());
						weixinAccountMapper.updateByPrimaryKey(account);
					} catch (Exception e) {
						token = null;
						// 获取token失败
						String wrongMessage = "获取token失败 errcode:{} errmsg:{}"
								+ jsonObject.getInt("errcode")
								+ jsonObject.getString("errmsg");
						log.info("------------"+wrongMessage);
						log.error("------------"+wrongMessage);
					}
				}
			} else {
				return account.getAccountaccesstoken();
			}
		} else {
			String requestUrl = WeixinUtil.access_token_url.replace("APPID",
					account.getAccountappid()).replace("APPSECRET",
					account.getAccountappsecret());
			System.out.println(requestUrl);
			JSONObject jsonObject = WeixinUtil.httpRequest(requestUrl, "GET",
					null);
			if (null != jsonObject) {
				try {
					token = jsonObject.getString("access_token");
					// 重置token
					account.setAccountaccesstoken(token);
					// 重置事件
					account.setAddtoekntime(new Date());
//					weixinAccountMapper.updateByPrimaryKey(account);
				} catch (Exception e) {
					System.out.println(jsonObject);
					token = null;
//					// 获取token失败
//					String wrongMessage = "获取token失败 errcode:{} errmsg:{}"
//							+ jsonObject.getInt("errcode")
//							+ jsonObject.getString("errmsg");
//					log.info("------------"+wrongMessage);
//					log.error("------------"+wrongMessage);
				}
			}
		}
		return token;
	}
    
    
	public WeixinAccount findLoginWeixinAccount() throws Exception {
//		List<WeixinAccount> acclst = weixinAccountMapper.findAllwaccounts(null);
//		WeixinAccount weixinAccountEntity = acclst.size() != 0 ? acclst
//				.get(0) : null;
		WeixinAccount weixinAccountEntity = new WeixinAccount();
		weixinAccountEntity.setAccountappid(ConfigUtils.getConfig("WINXIN_APPID"));
		weixinAccountEntity.setAccountappsecret(ConfigUtils.getConfig("WINXIN_AppSecret"));
		weixinAccountEntity.setAddtoekntime(new Date());
		if (weixinAccountEntity != null) {
			return weixinAccountEntity;
		} else {
			weixinAccountEntity = new WeixinAccount();
			// 返回个临时对象，防止空指针
			weixinAccountEntity.setWeixinAccountid("-1");
			weixinAccountEntity.setId("-1");
			return weixinAccountEntity;
		}
	}
    
	/**
	 * 欢迎语
	 * 
	 * @return
	 */
	public static String getMainMenu() {
		// 复杂字符串文本读取，采用文件方式存储
		return "你好，欢迎关注扬帆项目管理平台！";
	}
}
