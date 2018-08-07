package com.sczh.weixin.core.base.mapper;
import java.util.List;

import com.sczh.weixin.core.base.model.WeixinAccount;

public interface WeixinAccountMapper {
    int deleteByPrimaryKey(String id);

    int insert(WeixinAccount record);

    int insertSelective(WeixinAccount record);

    WeixinAccount selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(WeixinAccount record);

    int updateByPrimaryKey(WeixinAccount record);
    
    public List<WeixinAccount> findAllwaccounts(WeixinAccount record)throws Exception;
}