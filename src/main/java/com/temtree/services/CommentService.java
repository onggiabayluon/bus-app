/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.temtree.services;

import com.temtree.pojo.Comment;
import java.util.List;
import java.util.Map;

/**
 *
 * @author admin
 */
public interface CommentService {
    Comment addComment(String content, int bustripId, int userId);

    boolean deleteComment(int id);
}
