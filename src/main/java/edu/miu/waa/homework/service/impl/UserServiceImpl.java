package edu.miu.waa.homework.service.impl;

import edu.miu.waa.homework.aspect.annotation.ExecutionTime;
import edu.miu.waa.homework.entity.Comment;
import edu.miu.waa.homework.entity.Post;
import edu.miu.waa.homework.security.entity.User;
import edu.miu.waa.homework.entity.dto.PostDto;
import edu.miu.waa.homework.entity.dto.UserDto;
import edu.miu.waa.homework.helper.ListMapper;
import edu.miu.waa.homework.repo.UserRepository;
import edu.miu.waa.homework.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    private ListMapper listMapper;

    @Override
    public List<UserDto> getAllUsers() {
        return listMapper.mapList(userRepo.findAll(), new UserDto());
    }

    @Override
    @ExecutionTime
    public UserDto getUserById(long id) {
        return modelMapper.map(userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found")), UserDto.class);
    }

    @Override
    public void saveUser(User user) {
        userRepo.save(user);

    }

    @Override
    public void deleteUser(long id) {
        userRepo.deleteById(id);

    }

    @Override
    public void updateUser(long id, User user) {
        //update existing user
        User existingUser = userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        if (existingUser != null) {
            existingUser.setUsername(user.getUsername());
            userRepo.save(existingUser);
        }

    }

    @Override
    public List<PostDto> getPostsByUserId(long id) {
        User user = userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        List<Post> posts = user.getPosts();
        return listMapper.mapList(posts, new PostDto());
    }

    @Override
    public List<UserDto> usersHaveNPosts(int n) {
        List<User> users = userRepo.findUsersWithPosts(n);
        return listMapper.mapList(users, new UserDto());
    }

    @Override
    public List<UserDto> findUsersByPostTitle(String title) {
        return listMapper.mapList(userRepo.findUsersByPostTitle("%" + title + "%"), new UserDto());
    }

    @Override
    public Comment getCommentsByUserIdAndPostIdAndCommentId(long userId, long postId, long commentId) {
        return userRepo.findCommentsByIdAndPostIdAndCommentId(userId, postId, commentId);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepo.findByUsername(username);
    }
}
