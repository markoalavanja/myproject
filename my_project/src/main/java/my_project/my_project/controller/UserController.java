/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my_project.my_project.controller;

import my_project.my_project.domain.User;
import my_project.my_project.exception.UserException;
import my_project.my_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("user")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @PostMapping("login")
    public @ResponseBody ResponseEntity<User> login(@RequestBody User user){
        try{
        return ResponseEntity.status(HttpStatus.OK).body(userService.login(user.getUsername(), user.getPassword()));
        }catch(UserException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        
    }
    
}
