package edu.miu.waa.homework.service;

import edu.miu.waa.homework.entity.Comment;

import java.util.List;

public interface CommentService {
    public void saveComment(long postId, Comment comment);
    public void deleteComment(long commentId);
    public void updateComment(long commentId, String comment);
    public Comment getComment(long commentId);
    public List<Comment> getAllComments(long postId);
}
