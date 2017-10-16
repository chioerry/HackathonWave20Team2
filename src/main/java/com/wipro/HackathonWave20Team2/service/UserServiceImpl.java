package com.wipro.HackathonWave20Team2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.HackathonWave20Team2.domain.UserBean;
import com.wipro.HackathonWave20Team2.exception.UserAlreadyExistException;
import com.wipro.HackathonWave20Team2.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	UserBean userBean;

	@Override
	public List<UserBean> getAllUsers() {
		
		return (List<UserBean>) userRepository.findAll();
	}

	@Override
	public UserBean getUserById(String id) {
		
		return userRepository.findOne(id);
	}

	@Override
	public UserBean addUser(UserBean userBean) throws UserAlreadyExistException{
		
		if(userRepository.findOne(userBean.getId())!=null)
		{
			throw new UserAlreadyExistException("User already exists");
			
		}else {
			
			return userRepository.save(userBean);
		}	
		
	}

	@Override
	public UserBean updateUser(UserBean userBean) {
		
		return userRepository.save(userBean);
	}

	@Override
	public String deleteUser(String id) {
		userRepository.delete(id);
		return "";
	}
	// Setter Method for mockito to access Repository
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
		
	}

}
