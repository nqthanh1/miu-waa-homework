package edu.miu.waa.homework.controller;

import edu.miu.waa.homework.entity.User;
import edu.miu.waa.homework.entity.dto.PostDto;
import edu.miu.waa.homework.entity.dto.UserDto;
import edu.miu.waa.homework.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserDto> getUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable("id") long id){
        return userService.getUserById(id);
    }

    @PostMapping // POST - localhost:8080/api/users
    public void addUser(@RequestBody User user){
        userService.saveUser(user);
    }

    @DeleteMapping("/{id}") // DELETE - localhost:8080/api/users/1
    public void deleteUser(@PathVariable("id") long id){
        userService.deleteUser(id);
    }

    //get posts by user id
    @GetMapping("/{id}/posts")
    public List<PostDto> getPostsByUserId(@PathVariable("id") long id){
        return userService.getPostsByUserId(id);
    }

    @GetMapping("/user-many-posts")
    public List<UserDto> usersHaveManyPosts() {
        return userService.usersHaveManyPosts();
    }

}
