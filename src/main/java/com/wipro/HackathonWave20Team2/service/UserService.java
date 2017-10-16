package com.wipro.HackathonWave20Team2.service;

import java.util.List;

import com.wipro.HackathonWave20Team2.domain.UserBean;


public interface UserService {
	public List<UserBean> getAllUsers();
	public UserBean getUserById(String id);
	public UserBean addUser(UserBean userBean);
	public UserBean updateUser(UserBean userBean);
	public String deleteUser(String id);
}
