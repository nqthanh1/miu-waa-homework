package edu.miu.waa.homework.controller;

import edu.miu.waa.homework.entity.dto.PostDto;
import edu.miu.waa.homework.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping // GET - localhost:8080/api/posts
    public List<PostDto> getAll() {
        return postService.getAllPosts();
    }

    // GET /api/post/111
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getById(@PathVariable("id") long id) {
        var post = postService.getPostById(id);
        return ResponseEntity.ok(post);
    }

    // POST /api/posts
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void addPost(@RequestBody PostDto post) {
        postService.savePost(post);
    }

    @PutMapping("/{id}")
    public void updatePost(@PathVariable("id") long id, @RequestBody PostDto post) {
        postService.updatePost(id, post);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable("id") long id) {
        postService.deletePost(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/search")
    public List<PostDto> search(@RequestParam("keyword") String keyword) {
        return postService.searchPost(keyword);
    }
}
