package edu.miu.waa.homework.service.impl;

import edu.miu.waa.homework.entity.Post;
import edu.miu.waa.homework.entity.User;
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
    public UserDto getUserById(long id) {
        return modelMapper.map(userRepo.findById(id), UserDto.class);
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
        User existingUser = userRepo.findById(id);
        if (existingUser != null) {
            existingUser.setName(user.getName());
            userRepo.save(existingUser);
        }

    }

    @Override
    public List<PostDto> getPostsByUserId(long id) {
        List<Post> posts = userRepo.findById(id).getPosts();
        return listMapper.mapList(posts, new PostDto());
    }

    @Override
    public List<UserDto> usersHaveManyPosts() {
        List<User> users = userRepo.findUsersWithPosts(2);
        return listMapper.mapList(users, new UserDto());
    }
}
