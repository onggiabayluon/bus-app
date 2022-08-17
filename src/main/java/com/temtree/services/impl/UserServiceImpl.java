/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.temtree.services.impl;

import com.temtree.pojo.User;
import com.temtree.repository.UserRepository;
import com.temtree.services.UserService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service("userDetailsService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
//    @Override
//    public boolean addUser(User user) {
//        return this.userRepository.addUser(user); 
//    }

    @Override
    public boolean deleteUser(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<User> getUsers() {
        return this.userRepository.getUsers();
    }

    @Override
    public User findById(int id) {
        return this.userRepository.findById(id);
    }

    @Override
    public User getUserById(int id) {
        return this.userRepository.getUserById(id);
    }

    @Override
    public boolean addUser(User user) {
        String pass = user.getPassword();
        user.setPassword(bCryptPasswordEncoder.encode(pass));
        user.setUserRole(User.USER);

        return this.userRepository.addUser(user);
    }

    @Override
    public List<User> getUsers(String username) {
        return this.userRepository.getUsers(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> users = userRepository.getUsers(username);
        
        if (users.isEmpty()) {
            throw new UsernameNotFoundException("Không tồn tại!");
        }
        
        User u = users.get(0);
        
        Set<GrantedAuthority> authorities = new HashSet<>();
        
        authorities.add(new SimpleGrantedAuthority(u.getUserRole()));
        
        System.out.println("com.temtree.services.impl.UserServiceImpl.loadUserByUsername()");
        System.err.println(u.getUserRole());
        
        return new org.springframework.security.core
                .userdetails.User(u.getUsername(), u.getPassword(), authorities);
    }

}
