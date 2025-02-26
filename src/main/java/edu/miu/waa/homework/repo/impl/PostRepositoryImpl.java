package edu.miu.waa.homework.repo.impl;

import edu.miu.waa.homework.entity.Post;
import edu.miu.waa.homework.repo.PostRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Repository
public class PostRepositoryImpl implements PostRepository {
    private static List<Post> posts = new ArrayList<>();
    private static int productId = 300;
    static {

        Post p1 = new Post(111,"Post1","Content1","Author1");
        Post p2 = new Post(222,"Post2","Content2","Author2");
        Post p3 = new Post(223,"Title 3","Content 3","Shake Spear");
        posts.add(p1);
        posts.add(p2);
        posts.add(p3);
    }


    @Override
    public List<Post> findAll() {
        return posts;
    }

    @Override
    public Post findById(long id) {
        return posts
                .stream()
                .filter(post -> post.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(Post post) {
        post.setId(productId++);
        posts.add(post);
    }

    @Override
    public void deleteById(long id) {
        posts.removeIf(post -> post.getId() == id);
    }

    @Override
    public void update(long id, Post post) {
        Post postToUpdate = this.findById(id);

        if (postToUpdate != null) {
            postToUpdate.setTitle(post.getTitle());
            postToUpdate.setContent(post.getContent());
            postToUpdate.setAuthor(post.getAuthor());
        }
    }

    @Override
    public List<Post> search(String keyword) {
        return posts
                .stream()
                .filter(post -> post.getTitle().toLowerCase(Locale.ROOT).contains(keyword)
                        || post.getContent().toLowerCase().contains(keyword)
                        || post.getAuthor().toLowerCase(Locale.ROOT).contains(keyword))
                .toList();
    }
}