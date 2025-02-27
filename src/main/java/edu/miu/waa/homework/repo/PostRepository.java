package edu.miu.waa.homework.repo;

import edu.miu.waa.homework.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByAuthor(String author);
}
