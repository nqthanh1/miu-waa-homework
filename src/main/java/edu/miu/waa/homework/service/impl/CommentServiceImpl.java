package edu.miu.waa.homework.service.impl;

import edu.miu.waa.homework.entity.Comment;
import edu.miu.waa.homework.repo.CommentRepository;
import edu.miu.waa.homework.repo.PostRepository;
import edu.miu.waa.homework.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @Override
    public void saveComment(long postId, Comment comment) {
        comment.setPost(postRepository.findById(postId).get());
        commentRepository.save(comment);
    }

    @Override
    public void deleteComment(long commentId) {

    }

    @Override
    public void updateComment(long commentId, String comment) {

    }

    @Override
    public Comment getComment(long commentId) {
        return commentRepository.findById(commentId).get();
    }

    @Override
    public List<Comment> getAllComments(long postId) {
        return postRepository.findById(postId).get().getComments();
    }
}
