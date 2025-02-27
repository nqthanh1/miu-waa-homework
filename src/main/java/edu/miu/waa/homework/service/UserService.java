package edu.miu.waa.homework.service;

import edu.miu.waa.homework.entity.Comment;
import edu.miu.waa.homework.entity.User;
import edu.miu.waa.homework.entity.dto.PostDto;
import edu.miu.waa.homework.entity.dto.UserDto;

import java.util.List;

public interface UserService {
    public List<UserDto> getAllUsers();
    public UserDto getUserById(long id);
    public void saveUser(User user);
    public void deleteUser(long id);
    public void updateUser(long id, User user);
    public List<PostDto> getPostsByUserId(long id);
    public List<UserDto> usersHaveNPosts(int n);
    List<UserDto> findUsersByPostTitle(String title);
    public Comment getCommentsByUserIdAndPostIdAndCommentId(long userId, long postId, long commentId);
}
