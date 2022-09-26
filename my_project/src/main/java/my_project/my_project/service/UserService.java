/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my_project.my_project.service;

import my_project.my_project.domain.User;
import my_project.my_project.exception.UserException;

/**
 *
 * @author User
 */
public interface UserService {
    User login(String username, String password) throws UserException;
}
