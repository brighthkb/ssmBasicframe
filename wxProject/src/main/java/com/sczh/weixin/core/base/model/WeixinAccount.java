package com.sczh.weixin.core.base.model;
import java.io.Serializable;
import java.util.Date;
/**
 * 公众号信息
 * @author tjun
 *
 */
public class WeixinAccount implements Serializable {
	/**主键*/ 
	private String id;
	/**公众帐号名称*/
    private String accountname;
    /**配置服务器时设置的微信服务器TOKEN*/
    private String accounttoken;
    /**公众微信号*/
    private String accountnumber;
    /**公众号类型*/
    private String accounttype;
    /**电子邮箱*/
    private String accountemail;
    /**公众帐号描述*/
    private String accountdesc;
    /**ACCESS_TOKEN*/
    private String accountaccesstoken;
    /**公众帐号APPID*/
    private String accountappid;
    /**公众帐号APPSECRET*/
    private String accountappsecret;
    /**TOKEN获取时间*/
    private Date addtoekntime;
    /**所属系统用户**/
    private String username;
    /**微信公众号所属原始id*/
    private String weixinAccountid;
    /**公众帐号jsapi_ticket**/
    private String accountjsticket;
    /**TICKET获取时间*/
    private Date addtickettime;

    private static final long serialVersionUID = 1L;

    public WeixinAccount(String id, String accountname, String accounttoken, String accountnumber, String accounttype, String accountemail, String accountdesc, String accountaccesstoken, String accountappid, String accountappsecret, Date addtoekntime, String username, String weixinAccountid, String accountjsticket, Date addtickettime) {
        this.id = id;
        this.accountname = accountname;
        this.accounttoken = accounttoken;
        this.accountnumber = accountnumber;
        this.accounttype = accounttype;
        this.accountemail = accountemail;
        this.accountdesc = accountdesc;
        this.accountaccesstoken = accountaccesstoken;
        this.accountappid = accountappid;
        this.accountappsecret = accountappsecret;
        this.addtoekntime = addtoekntime;
        this.username = username;
        this.weixinAccountid = weixinAccountid;
        this.accountjsticket = accountjsticket;
        this.addtickettime = addtickettime;
    }

    public WeixinAccount() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAccountname() {
        return accountname;
    }

    public void setAccountname(String accountname) {
        this.accountname = accountname == null ? null : accountname.trim();
    }

    public String getAccounttoken() {
        return accounttoken;
    }

    public void setAccounttoken(String accounttoken) {
        this.accounttoken = accounttoken == null ? null : accounttoken.trim();
    }

    public String getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber == null ? null : accountnumber.trim();
    }

    public String getAccounttype() {
        return accounttype;
    }

    public void setAccounttype(String accounttype) {
        this.accounttype = accounttype == null ? null : accounttype.trim();
    }

    public String getAccountemail() {
        return accountemail;
    }

    public void setAccountemail(String accountemail) {
        this.accountemail = accountemail == null ? null : accountemail.trim();
    }

    public String getAccountdesc() {
        return accountdesc;
    }

    public void setAccountdesc(String accountdesc) {
        this.accountdesc = accountdesc == null ? null : accountdesc.trim();
    }

    public String getAccountaccesstoken() {
        return accountaccesstoken;
    }

    public void setAccountaccesstoken(String accountaccesstoken) {
        this.accountaccesstoken = accountaccesstoken == null ? null : accountaccesstoken.trim();
    }

    public String getAccountappid() {
        return accountappid;
    }

    public void setAccountappid(String accountappid) {
        this.accountappid = accountappid == null ? null : accountappid.trim();
    }

    public String getAccountappsecret() {
        return accountappsecret;
    }

    public void setAccountappsecret(String accountappsecret) {
        this.accountappsecret = accountappsecret == null ? null : accountappsecret.trim();
    }

    public Date getAddtoekntime() {
        return addtoekntime;
    }

    public void setAddtoekntime(Date addtoekntime) {
        this.addtoekntime = addtoekntime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getWeixinAccountid() {
        return weixinAccountid;
    }

    public void setWeixinAccountid(String weixinAccountid) {
        this.weixinAccountid = weixinAccountid == null ? null : weixinAccountid.trim();
    }

    public String getAccountjsticket() {
        return accountjsticket;
    }

    public void setAccountjsticket(String accountjsticket) {
        this.accountjsticket = accountjsticket == null ? null : accountjsticket.trim();
    }

    public Date getAddtickettime() {
        return addtickettime;
    }

    public void setAddtickettime(Date addtickettime) {
        this.addtickettime = addtickettime;
    }
}