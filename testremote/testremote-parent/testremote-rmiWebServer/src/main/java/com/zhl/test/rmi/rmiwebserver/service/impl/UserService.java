package com.zhl.test.rmi.rmiwebserver.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zhl.test.rmi.core.model.UserInfo;
import com.zhl.test.rmi.core.service.IUserService;
import com.zhl.test.rmi.rmiserver.dao.UserInfoMapperCustomize;

public class UserService implements IUserService {

	@Autowired
	private UserInfoMapperCustomize userInfoCustomizeDao;
	
	/**
	 * 取得用户信息
	 */
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public List<UserInfo> getUser(Map<String, Object> param) {
		List<UserInfo> u = null;
		try{
			u = userInfoCustomizeDao.selectAllUser(param);
		}catch(Exception e){
			e.printStackTrace();
		}
		return u;
	}
	
	/**
	 * 根据用户名密码取得用户信息
	 */
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public UserInfo getUserByName(String userName, String password) {
		return userInfoCustomizeDao.getUserByName(userName, password);
	}
	
	/**
	 * 修改用户密码
	 */
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void updatePwd(String password, int userId)  throws Exception{
		userInfoCustomizeDao.updatePwd(password, userId);
		
	}

}
