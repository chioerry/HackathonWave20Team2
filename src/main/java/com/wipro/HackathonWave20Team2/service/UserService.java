package com.wipro.HackathonWave20Team2.service;

import java.util.List;

import com.wipro.HackathonWave20Team2.domain.UserBean;
import com.wipro.HackathonWave20Team2.exception.UserAlreadyExistException;


public interface UserService {
	public List<UserBean> getAllUsers();
	public UserBean getUserById(String id);
	public UserBean addUser(UserBean userBean) throws UserAlreadyExistException;
	public UserBean updateUser(UserBean userBean);
	public UserBean deleteUser(UserBean userBean);
}
