package edu.miu.waa.homework.repo;

import edu.miu.waa.homework.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Long> {
    List<Comment> findByPostId(long postId);
}
