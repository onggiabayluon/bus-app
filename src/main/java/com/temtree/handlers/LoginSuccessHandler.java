/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.temtree.handlers;

import com.temtree.pojo.User;
import com.temtree.services.UserService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 *
 * @author admin
 */
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    private UserService userDetailService;
    
    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication a)
            throws IOException, ServletException {
        
        // Add currentUser to session
//        String referer = request.getHeader("Referer");
//        System.err.println(referer);
        User u = this.userDetailService.getUsers(a.getName()).get(0);
        request.getSession().setAttribute("currentUser", u);
        
        response.sendRedirect("/busapp/");
    }
}
