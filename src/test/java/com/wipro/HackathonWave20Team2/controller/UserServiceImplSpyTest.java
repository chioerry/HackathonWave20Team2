package com.wipro.HackathonWave20Team2.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import com.wipro.HackathonWave20Team2.domain.UserBean;
import com.wipro.HackathonWave20Team2.repository.UserRepository;
import com.wipro.HackathonWave20Team2.service.UserServiceImpl;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.when;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplSpyTest {
    @Spy
    private UserServiceImpl userServiceSpy;
    @Mock
    private UserRepository userRepository;
    @Mock
    private UserBean userBean;

 @Test(expected=NullPointerException.class)
    public void shouldThrowNullPointerException_whenGetUserByIdIsCalledWithoutContext() throws Exception {
        //Act
        UserBean retrievedUser = userServiceSpy.getUserById("5");
        //Assert
        assertThat(retrievedUser, is(equalTo(userBean)));
    }

 public void shouldThrowNullPointerException_whenSaveUserIsCalledWithoutContext() throws Exception {
        //Arrange
        Mockito.doReturn(userBean).when(userRepository).save(userBean);
        //Act
        UserBean savedUser = userServiceSpy.addUser(userBean);
        //Assert
        assertThat(savedUser, is(equalTo(userBean)));
    }

 @Test
    public void shouldVerifyThatGetProductByIdIsCalled() throws Exception {
        //Arrange
        Mockito.doReturn(userBean).when(userServiceSpy).getUserById("5");
        //Act
        UserBean retrievedUser = userServiceSpy.getUserById("5");
        //Assert
        Mockito.verify(userServiceSpy).getUserById("5");
    }
    @Test
    public void shouldVerifyThatSaveProductIsNotCalled() throws Exception {
        //Arrange
        Mockito.doReturn(userBean).when(userServiceSpy).getUserById("5");
        //Act
        UserBean retrievedProduct = userServiceSpy.getUserById("5");
        //Assert
        Mockito.verify(userServiceSpy,never()).addUser(userBean);
    }
}
