/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.temtree.repository;

import com.temtree.pojo.Comment;
import java.util.List;
import java.util.Map;

/**
 *
 * @author admin
 */
public interface CommentRepository {

    Comment addComment(Comment comment);

    boolean deleteComment(int id);
}
