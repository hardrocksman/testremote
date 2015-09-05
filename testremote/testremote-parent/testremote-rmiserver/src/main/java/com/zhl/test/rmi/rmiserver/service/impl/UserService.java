package com.zhl.test.rmi.rmiserver.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zhl.test.rmi.core.model.UserInfoCore;
import com.zhl.test.rmi.core.service.IUserService;
import com.zhl.test.rmi.rmiserver.dao.UserInfoMapperCustomize;
import com.zhl.test.rmi.rmiserver.model.UserInfo;

public class UserService implements IUserService {

	@Autowired
	private UserInfoMapperCustomize userInfoCustomizeDao;
	
	/**
	 * 取得用户信息
	 */
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public List<UserInfoCore> getUser(Map<String, Object> param) {
		List<UserInfo> u = null;
		try{
			u = userInfoCustomizeDao.selectAllUser(param);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		List<UserInfoCore> userInfoCores = new ArrayList<UserInfoCore>();
		if(u != null && u.size() > 0){
			for(UserInfo userInfo : u){
				UserInfoCore  userInfoCore = new UserInfoCore();
				
				BeanUtils.copyProperties(userInfo, userInfoCore);
				userInfoCores.add(userInfoCore);
			}
		}
		return userInfoCores;
	}
	
	/**
	 * 根据用户名密码取得用户信息
	 */
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public UserInfoCore getUserByName(String userName, String password) {
		UserInfo userInfo = userInfoCustomizeDao.getUserByName(userName, password);
		UserInfoCore  userInfoCore = new UserInfoCore();
		if(userInfo != null){
			BeanUtils.copyProperties(userInfo, userInfoCore);
		}
		return userInfoCore;
	}
	
	/**
	 * 修改用户密码
	 */
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void updatePwd(String password, int userId)  throws Exception{
		userInfoCustomizeDao.updatePwd(password, userId);
		
	}

}
