package com.zhl.test.rmi.core.service;

import java.util.List;
import java.util.Map;

import com.zhl.test.rmi.core.model.UserInfoCore;

public interface IUserService {
	// 取得所有用户信息
	public List<UserInfoCore> getUser(Map<String, Object> param);
	// 根据用户名密码取得用户信息
	public UserInfoCore getUserByName(String userName, String password);
	// 修改用户密码
	public void updatePwd(String password, int userId) throws Exception;
}
