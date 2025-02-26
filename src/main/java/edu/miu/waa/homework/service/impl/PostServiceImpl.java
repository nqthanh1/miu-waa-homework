package edu.miu.waa.homework.service.impl;

import edu.miu.waa.homework.entity.Post;
import edu.miu.waa.homework.entity.dto.PostDto;
import edu.miu.waa.homework.helper.ListMapper;
import edu.miu.waa.homework.repo.PostRepository;
import edu.miu.waa.homework.service.PostService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepo;

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
         postRepo.save(modelMapper.map(post,Post.class));
    }

    @Override
    public void deletePost(long id) {
        postRepo.deleteById(id);
    }

    @Override
    public void updatePost(long id, PostDto post) {
        postRepo.update(id,modelMapper.map(post,Post.class));
    }

    @Override
    public List<PostDto> searchPost(String keyword) {
        List<Post> posts = postRepo.search(keyword.toLowerCase(Locale.ROOT));
        return listMapper.mapList(posts,new PostDto());
    }


}
