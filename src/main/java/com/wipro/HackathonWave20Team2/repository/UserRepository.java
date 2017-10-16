package com.wipro.HackathonWave20Team2.repository;

import org.springframework.data.repository.CrudRepository;

import com.wipro.HackathonWave20Team2.domain.UserBean;

public interface UserRepository extends CrudRepository<UserBean, String>{

}
