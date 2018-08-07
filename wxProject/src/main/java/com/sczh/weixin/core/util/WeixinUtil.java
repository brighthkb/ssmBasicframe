package com.sczh.weixin.core.util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.hp.hpl.sparta.ParseException;

import net.sf.json.JSONObject;
/**
 * 公众平台通用接口工具类
* 
 * @author tagjun
 * @date 2018-08-09
 */
public class WeixinUtil {
	// 获取access_token的接口地址（GET） 限200（次/天）
	public final static String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	
	public final static String access_ticket_url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";
	// 菜单创建（POST） 限100（次/天）
    public static String menu_create_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
    // 获取用户信息
    public static String menu_userInfo_url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
    //客服接口地址
    public static String send_message_url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";
    //创建二维码地址
    public static String create_ticket_path  = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=ACCESS_TOKEN";
    //通过ticket换取二维码  
    public static String showqrcode_path  = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=TICKET";
    //获取用户授权code
    public static String oauth_getcode  = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECTURL&response_type=code&scope=snsapi_base&state=1#wechat_redirec";
    //获取用户信息opendId
    public static String oauth_getopenid  = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=APPSECRET&code=CODE&grant_type=authorization_code";
    //删除菜单
    public static final String DELETE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
    private static final Log log = LogFactory.getLog(WeixinUtil.class);
    /**
     * 发起https请求并获取结果
     * 
     * @param requestUrl 请求地址
     * @param requestMethod 请求方式（GET、POST）
     * @param outputStr 提交的数据
     * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
     */
    public static JSONObject httpRequest(String requestUrl, String requestMethod, String outputStr) {
        JSONObject jsonObject = null;
        StringBuffer buffer = new StringBuffer();
        try {
                // 创建SSLContext对象，并使用我们指定的信任管理器初始化
                TrustManager[] tm = { new MyX509TrustManager() };
                SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
                sslContext.init(null, tm, new java.security.SecureRandom());
                // 从上述SSLContext对象中得到SSLSocketFactory对象
                SSLSocketFactory ssf = sslContext.getSocketFactory();

                URL url = new URL(requestUrl);
                HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
                httpUrlConn.setSSLSocketFactory(ssf);

                httpUrlConn.setDoOutput(true);
                httpUrlConn.setDoInput(true);
                httpUrlConn.setUseCaches(false);
                // 设置请求方式（GET/POST）
                httpUrlConn.setRequestMethod(requestMethod);

                if ("GET".equalsIgnoreCase(requestMethod))
                        httpUrlConn.connect();

                // 当有数据需要提交时
                if (null != outputStr) {
                        OutputStream outputStream = httpUrlConn.getOutputStream();
                        // 注意编码格式，防止中文乱码
                        outputStream.write(outputStr.getBytes("UTF-8"));
                        outputStream.close();
                }

                // 将返回的输入流转换成字符串
                InputStream inputStream = httpUrlConn.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String str = null;
                while ((str = bufferedReader.readLine()) != null) {
                        buffer.append(str);
                }
                bufferedReader.close();
                inputStreamReader.close();
                // 释放资源
                inputStream.close();
                inputStream = null;
                httpUrlConn.disconnect();
                jsonObject = JSONObject.fromObject(buffer.toString());
                //jsonObject = JSONObject.fromObject(buffer.toString());
        } catch (ConnectException ce) {
        	log.info("Weixin server connection timed out.");
        } catch (Exception e) {
        	log.info("https request error:{}"+e.getMessage());
        }
        return jsonObject;
    }
    
    /**
     * 功能说明:使用区域码、时间（精确到毫秒）、累计次数，通过同步机制保证生成的唯一主键.
     * @param code String 组织机构代码后面几位
     * @return String
     */
    private static int count=0;//保存总次数
    public static final synchronized String makePK(String code){
      count++;
      if(count>=10000) count=0;
      String formatted = Integer.toString(count);
      StringBuffer buf = new StringBuffer("0000");
      buf.replace( 4-formatted.length(), 4, formatted );
      return code + System.currentTimeMillis() + buf.toString();
    }
    
    
	
	/**
	 * POST请求
	 * @param url
	 * @param outStr
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	public static JSONObject doPostStr(String url,String outStr) throws ParseException, IOException{
		DefaultHttpClient client = new DefaultHttpClient();
		HttpPost httpost = new HttpPost(url);
		JSONObject jsonObject = null;
		httpost.setEntity(new StringEntity(outStr,"UTF-8"));
		HttpResponse response = client.execute(httpost);
		String result = EntityUtils.toString(response.getEntity(),"UTF-8");
		jsonObject = JSONObject.fromObject(result);
		return jsonObject;
	}
	
	
	/**
	 * get请求
	 * @param url
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	public static JSONObject doGetStr(String url) throws ParseException, IOException{
		DefaultHttpClient client = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(url);
		JSONObject jsonObject = null;
		HttpResponse httpResponse = client.execute(httpGet);
		HttpEntity entity = httpResponse.getEntity();
		if(entity != null){
			String result = EntityUtils.toString(entity,"UTF-8");
			jsonObject = JSONObject.fromObject(result);
		}
		return jsonObject;
	}
}