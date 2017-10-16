package com.wipro.HackathonWave20Team2.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.wipro.HackathonWave20Team2.domain.UserBean;
import com.wipro.HackathonWave20Team2.repository.UserRepository;
import com.wipro.HackathonWave20Team2.service.UserServiceImpl;

import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;






public class UserServiceImplMockTest {

  private UserServiceImpl userServiceImpl;
    @Mock
    private UserRepository userRepository;
    @Mock
    private UserBean userBean;
    @Before
    public void setupMock() {
        MockitoAnnotations.initMocks(this);
       userServiceImpl=new UserServiceImpl();
        userServiceImpl.setUserRepository(userRepository);
    }
    @Test
    public void shouldReturnUser_whenGetUserByIdIsCalled() throws Exception {
        // Arrange
        when(userRepository.findOne("5")).thenReturn(userBean);
        // Act
        UserBean retrievedUser = userServiceImpl.getUserById("5");
        // Assert
        assertThat(retrievedUser, is(equalTo(userBean)));

  }
    @Test
    public void shouldReturnUser_whenSaveUserIsCalled() throws Exception {
        // Arrange
        when(userRepository.save(userBean)).thenReturn(userBean);
        // Act
        UserBean savedUser = userServiceImpl.addUser(userBean);
        // Assert
        assertThat(savedUser, is(equalTo(userBean)));
    }
    @Test
    public void shouldCallDeleteMethodOfUserRepository_whenDeleteUserIsCalled() throws Exception {
        // Arrange
        doNothing().when(userRepository).delete("5");
        UserRepository my = Mockito.mock(UserRepository.class);
        // Act
        userServiceImpl.deleteUser("5");
        // Assert
        verify(userRepository, times(1)).delete("5");
    }
}

