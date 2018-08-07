package com.sczh.weixin.mapper;
import org.apache.ibatis.annotations.Param;

import com.sczh.weixin.model.WxUser;
public interface WxUserMapper {
    int deleteByPrimaryKey(String id);
    
    int deleteByphone(@Param("phone")String phone);

    int insert(WxUser record);

    int insertSelective(WxUser record);

    WxUser selectByPrimaryKey(String id);
    
    WxUser selectByInfo(WxUser record);

    int updateByPrimaryKeySelective(WxUser record);

    int updateByPrimaryKey(WxUser record);
}
