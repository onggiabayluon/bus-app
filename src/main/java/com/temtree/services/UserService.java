/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.temtree.services;

import com.temtree.pojo.User;
import java.util.List;
import java.util.Map;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author admin
 */
public interface UserService extends UserDetailsService {
    //UserDetails
    User getUserById(int id);
    boolean addUser(User user);
    List<User> getUsers(String username);
    
    List<User> getUsers();
    
//    boolean addUser(User user);

    boolean deleteUser(int id);
    
    User findById(int id);
}
