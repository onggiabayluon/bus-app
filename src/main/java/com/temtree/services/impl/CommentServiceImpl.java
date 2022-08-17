/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.temtree.services.impl;

import com.temtree.pojo.Bustrip;
import com.temtree.pojo.Comment;
import com.temtree.pojo.User;
import com.temtree.repository.BustripRepository;
import com.temtree.repository.CommentRepository;
import com.temtree.repository.UserRepository;
import com.temtree.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BustripRepository bustripRepository;
    
    @Override
    public Comment addComment(String content, int bustripId, int userId) {
        Bustrip bustrip = this.bustripRepository.findById(bustripId);
        User user = this.userRepository.findById(userId);

        Comment c = new Comment();
        c.setBustripId(bustrip);
        c.setUserId(user);
        c.setContent(content);
        
        return this.commentRepository.addComment(c); 
    }

    @Override
    public boolean deleteComment(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
