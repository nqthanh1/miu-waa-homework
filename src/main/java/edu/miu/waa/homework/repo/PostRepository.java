package edu.miu.waa.homework.repo;

import edu.miu.waa.homework.entity.Post;

import java.util.List;

public interface PostRepository {
    List<Post> findAll();
    Post findById(long id);
    void save(Post post);
    void deleteById(long id);
    void update(long id, Post post);
    List<Post> search(String keyword);
}
