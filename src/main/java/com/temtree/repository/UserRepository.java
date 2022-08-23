/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.temtree.repository;

import com.temtree.pojo.User;
import java.util.List;
import java.util.Map;

/**
 *
 * @author admin
 */
public interface UserRepository{
    User getUserById(int id);
    
    List<User> getUsers(String username);
    
    List<User> getUsers();
    
    List<User> getUsersByRole(String role);
    User findById(int id);
    

    boolean addUser(User user);

    boolean deleteUser(int id);
}
