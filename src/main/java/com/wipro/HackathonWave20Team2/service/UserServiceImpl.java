package com.wipro.HackathonWave20Team2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.HackathonWave20Team2.domain.UserBean;
import com.wipro.HackathonWave20Team2.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public List<UserBean> getAllUsers() {
		
		return (List<UserBean>) userRepository.findAll();
	}

	@Override
	public UserBean getUserById(String id) {
		
		return userRepository.findOne(id);
	}

	@Override
	public UserBean addUser(UserBean userBean) {
		
		return userRepository.save(userBean);
	}

	@Override
	public UserBean updateUser(UserBean userBean) {
		
		return userRepository.save(userBean);
	}

	@Override
	public UserBean deleteUser(UserBean userBean) {
		userRepository.delete(userBean.getId());
		return userBean;
	}

}
