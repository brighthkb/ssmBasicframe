package com.sczh.weixin.service;
import com.sczh.weixin.model.WxUser;
public interface IWxUserService{
	int deleteByPrimaryKey(String id);
	
	int deleteByUserid(String userid);

    String insert(WxUser record);

    int insertSelective(WxUser record);

    WxUser selectByPrimaryKey(String id);
    
    WxUser selectByInfo(WxUser record);

    int updateByPrimaryKeySelective(WxUser record);

    int updateByPrimaryKey(WxUser record);
}
