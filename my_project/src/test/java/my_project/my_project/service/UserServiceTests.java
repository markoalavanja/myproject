/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my_project.my_project.service;


import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import my_project.my_project.domain.User;
import my_project.my_project.exception.UserException;
import my_project.my_project.repository.UserRepository;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.junit.jupiter.api.Assertions.assertThrows;


/**
 *
 * @author User
 */
@SpringBootTest
public class UserServiceTests {
    
    @Autowired
    private UserService userService;
    
    @MockBean
    private UserRepository userRepository;
    
    @Test
    public void loginSuccesTest() throws UserException{
        User user= new User("a1", "a1", "Admin", "Admin");
        when(userRepository.login(user.getUsername(), user.getPassword())).thenReturn(user);
        User u= userService.login(user.getUsername(), user.getPassword());
        assertNotNull(u);
        assertEquals(user, u);
        
    }
    
    @Test
    public void loginFailureTest(){
        User user= new User("a2", "a2", "Admin", "Admin");
        when(userRepository.login(user.getUsername(), user.getPassword())).thenReturn(user);
        assertThrows(UserException.class, () -> {
            userService.login("abc", "abc");
        });
    }
    
}
