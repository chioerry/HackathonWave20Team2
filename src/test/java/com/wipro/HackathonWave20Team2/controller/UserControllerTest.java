package com.wipro.HackathonWave20Team2.controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import com.wipro.HackathonWave20Team2.MainClass;
import com.wipro.HackathonWave20Team2.domain.UserBean;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainClass.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    @LocalServerPort
    // The port is initialised with a random value
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();
    // The headers usually contain 
    HttpHeaders headers = new HttpHeaders();

    UserBean userBean;

    @Before
    public void setUp() throws Exception {
    	userBean = new UserBean("1","abc",21,"hyd","url1");
    }
    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testAddUser() throws Exception {

        HttpEntity<UserBean> entity = new HttpEntity<UserBean>(userBean, headers);        
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/users"),
                HttpMethod.POST, entity, String.class);
        assertNotNull(response);
        String actual = response.getBody();
        System.out.println(actual);
        assertEquals("User saved successfully",actual);
    }

    @Test
    public void testList() throws Exception {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/users"),
                HttpMethod.GET, entity, String.class);
        assertNotNull(response);

    }
    @Test
    public void testGetUser() throws Exception {
    	HttpEntity<UserBean> entity = new HttpEntity<UserBean>(userBean, headers);        
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/users/1"),
                HttpMethod.GET, entity, String.class);
        assertNotNull(response);
        String actual = response.getBody();
        System.out.println(actual);
        assertEquals("User Getting Successfully",actual);
    }
    @Test
    public void testUpdateUser() throws Exception {
    	HttpEntity<UserBean> entity = new HttpEntity<UserBean>(userBean, headers);        
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/users/2"),
                HttpMethod.PUT, entity, String.class);
        assertNotNull(response);
        String actual = response.getBody();
        System.out.println(actual);
        assertEquals("User Updated successfully",actual);
    }

    @Test
    public void testDeleteUser() throws Exception {
    	HttpEntity<UserBean> entity = new HttpEntity<UserBean>(userBean, headers);        
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/users/1"),
                HttpMethod.DELETE, entity, String.class);
        assertNotNull(response);
        String actual = response.getBody();
        System.out.println(actual);
        assertEquals("User Deleted successfully",actual);
    }

}

