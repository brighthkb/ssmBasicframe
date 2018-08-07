package com.sczh.weixin.model;
import java.io.Serializable;
/**
 * 微信用户信息
 * @author tjun
 *
 */
public class WxUser implements Serializable {
    private String id;//主键id

    private String phone;//微信用户对应用户id

    private String openid;//绑定用户对应的公众号唯一id

    private String nickname;//昵称
    
    private String name;//用户名

    private String sex;//性别

    private String headimgurl;//头像

    private String subscribe;//是否关注

    private static final long serialVersionUID = 1L;

    public WxUser(String id, String phone, String openid, String nickname,String name,String sex, String headimgurl, String subscribe) {
        this.id = id;
        this.phone = phone;
        this.openid = openid;
        this.nickname = nickname;
        this.name=name;
        this.sex = sex;
        this.headimgurl = headimgurl;
        this.subscribe = subscribe;
    }

    public WxUser() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    } 
    public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }
    

    public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl == null ? null : headimgurl.trim();
    }
    
	public String getSubscribe() {
		return subscribe;
	}

	public void setSubscribe(String subscribe) {
		this.subscribe = subscribe;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}