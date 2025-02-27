package edu.miu.waa.homework.controller;

import edu.miu.waa.homework.entity.Comment;
import edu.miu.waa.homework.entity.dto.PostDto;
import edu.miu.waa.homework.service.CommentService;
import edu.miu.waa.homework.service.PostService;
import lombok.AllArgsConstructor;
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
    private final CommentService commentService;

    @Autowired
    public PostController(PostService postService, CommentService commentService) {
        this.postService = postService;
        this.commentService = commentService;
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

    // GET /api/posts/1/comments
    @GetMapping("/{postId}/comments")
    public List<Comment> getAllComments(@PathVariable("postId") long postId) {
        return commentService.getAllComments(postId);
    }

    // POST /api/posts/1/comments
    @PostMapping("/{postId}/comments")
    public void addComment(@PathVariable("postId") long postId, @RequestBody Comment comment) {
        commentService.saveComment(postId, comment);
    }
}
