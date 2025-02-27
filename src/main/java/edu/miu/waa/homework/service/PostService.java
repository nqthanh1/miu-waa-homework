package edu.miu.waa.homework.service;

import edu.miu.waa.homework.entity.dto.PostDto;

import java.util.List;

public interface PostService {
    public List<PostDto> getAllPosts();
    public PostDto getPostById(long id);
    public void savePost(PostDto post);
    public void deletePost(long id);
    public void updatePost(long id, PostDto post);
    public List<PostDto> searchPost(String keyword);
}
