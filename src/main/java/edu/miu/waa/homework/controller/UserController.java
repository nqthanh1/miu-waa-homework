package edu.miu.waa.homework.controller;

import edu.miu.waa.homework.entity.Comment;
import edu.miu.waa.homework.security.entity.User;
import edu.miu.waa.homework.entity.dto.PostDto;
import edu.miu.waa.homework.entity.dto.UserDto;
import edu.miu.waa.homework.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/admin/users")
@PreAuthorize("hasRole('ADMIN')")
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
    public ResponseEntity<List<PostDto>> getPostsByUserId(@PathVariable("id") long id) {
        try {
            List<PostDto> posts = userService.getPostsByUserId(id);
            return new ResponseEntity<>(posts, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/user-many-posts")
    public List<UserDto> usersHaveManyPosts() {
        return userService.usersHaveNPosts(2);
    }

    @GetMapping("/user-n-posts/{n}")
    public List<UserDto> usersHaveNPosts(@PathVariable("n") int n) {
        return userService.usersHaveNPosts(n);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/posts/title") // GET - localhost:8080/api/users/posts/title?title=Post1
    public List<UserDto> findUsersByPostTitle(@RequestParam("title") String title) {
        return userService.findUsersByPostTitle(title);
    }


    @GetMapping("/{userId}/posts/{postId}/comments/{commentId}")
    public ResponseEntity<Comment> getCommentsByUserIdAndPostIdAndCommentId(@PathVariable("userId") long userId, @PathVariable("postId") long postId, @PathVariable("commentId") long commentId) {
        try {
            Comment comment = userService.getCommentsByUserIdAndPostIdAndCommentId(userId, postId, commentId);
            return new ResponseEntity<>(comment, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
