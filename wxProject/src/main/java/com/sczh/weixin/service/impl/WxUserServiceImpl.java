package com.sczh.weixin.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sczh.core.utils.IdentityUtils;
import com.sczh.weixin.mapper.WxUserMapper;
import com.sczh.weixin.model.WxUser;
import com.sczh.weixin.service.IWxUserService;
@Service
public class WxUserServiceImpl implements IWxUserService{
	
	@Autowired
    private WxUserMapper wxUserMapper;
	
	@Override
	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return wxUserMapper.deleteByPrimaryKey(id);
	}

	@Override
	public String insert(WxUser record) {
		// TODO Auto-generated method stub
		String uuid = IdentityUtils.uuid2();
		record.setId(uuid);
		wxUserMapper.insert(record);
		return uuid;
	}

	@Override
	public int insertSelective(WxUser record) {
		// TODO Auto-generated method stub
		record.setId(IdentityUtils.uuid2());
		return wxUserMapper.insertSelective(record);
	}

	@Override
	public WxUser selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return wxUserMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(WxUser record) {
		// TODO Auto-generated method stub
		return wxUserMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(WxUser record) {
		// TODO Auto-generated method stub
		return wxUserMapper.updateByPrimaryKey(record);
	}

	@Override
	public WxUser selectByInfo(WxUser record) {
		// TODO Auto-generated method stub
		return wxUserMapper.selectByInfo(record);
	}

	@Override
	public int deleteByUserid(String userid) {
		// TODO Auto-generated method stub
		return 0;
	}
 
}
