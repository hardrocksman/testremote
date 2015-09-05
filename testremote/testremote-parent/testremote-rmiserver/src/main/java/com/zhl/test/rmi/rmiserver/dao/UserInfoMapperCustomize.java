package com.zhl.test.rmi.rmiserver.dao;

import java.util.List;
import java.util.Map;

import com.zhl.test.rmi.rmiserver.model.UserInfo;


public interface UserInfoMapperCustomize {
	// 取得�?��用户信息
	public List<UserInfo> selectAllUser(Map<String, Object> param);
	// 根据用户名密码取得用户信�?
	public UserInfo getUserByName(String userName, String password);
	// 修改用户密码
	public void updatePwd(String password, int userId);
}
