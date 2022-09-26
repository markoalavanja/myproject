/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my_project.my_project.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import my_project.my_project.domain.User;
import my_project.my_project.service.UserService;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

/**
 *
 * @author User
 */
@WebMvcTest(UserController.class)
public class UserControllerTests {
    
    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private ObjectMapper objectMapper;
    
    @MockBean
    private UserService userService;
    
    public void loginTest() throws Exception{
        User user = new User("b", "b", "Admin", "Admin");
        when(userService.login(user.getUsername(), user.getPassword())).thenReturn(user);
        mockMvc.perform(post("/user/login").contentType(MediaType.APPLICATION_JSON_VALUE)
            .content(objectMapper.writeValueAsString(user)))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.username", equalTo(user.getUsername())))
            .andExpect(jsonPath("$.password", equalTo(user.getPassword())));
    }
    
}
