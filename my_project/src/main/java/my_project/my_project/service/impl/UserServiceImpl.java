/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my_project.my_project.service.impl;

import my_project.my_project.domain.User;
import my_project.my_project.exception.UserException;
import my_project.my_project.repository.UserRepository;
import my_project.my_project.service.UserService;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class UserServiceImpl implements UserService{
    
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }
    

    @Override
    public User login(String username, String password) throws UserException {
        User user= userRepository.login(username, password);
        if(user == null){
            throw new UserException("Invalid user data");
        }
        return user;
    }
    
}
