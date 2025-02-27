package edu.miu.waa.homework.service.impl;

import edu.miu.waa.homework.entity.Post;
import edu.miu.waa.homework.entity.User;
import edu.miu.waa.homework.entity.dto.PostDto;
import edu.miu.waa.homework.helper.ListMapper;
import edu.miu.waa.homework.repo.PostRepository;
import edu.miu.waa.homework.repo.UserRepository;
import edu.miu.waa.homework.service.PostService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepo;
    private final UserRepository userRepo;

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    ListMapper listMapper;


    @Override
    public List<PostDto> getAllPosts() {
        return listMapper.mapList(postRepo.findAll(),new PostDto());
    }

    @Override
    public PostDto getPostById(long id) {
        return modelMapper.map(postRepo.findById(id),PostDto.class);
    }

    @Override
    public void savePost(PostDto post) {
        User postedBy = userRepo.findById(post.getPostedById()).orElse(null);
        if(postedBy == null) return;

        Post newPost = modelMapper.map(post,Post.class);
        newPost.setPostedBy(postedBy);
         postRepo.save(newPost);
    }

    @Override
    public void deletePost(long id) {
        postRepo.deleteById(id);
    }

    @Override
    public void updatePost(long id, PostDto post) {
        postRepo.save(modelMapper.map(post,Post.class));
    }

    @Override
    public List<PostDto> searchPost(String keyword) {
        List<Post> posts = postRepo.search(keyword);
        return listMapper.mapList(posts,new PostDto());
    }



}
