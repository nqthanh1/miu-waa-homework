package edu.miu.waa.homework.repo;

import edu.miu.waa.homework.entity.Comment;
import edu.miu.waa.homework.entity.Post;
import edu.miu.waa.homework.entity.User;
import edu.miu.waa.homework.entity.dto.PostDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String name);
    List<User> findAll();

    @Query( "SELECT u FROM User u JOIN u.posts p GROUP BY u HAVING COUNT(p) >= :num" )
    public List<User> findUsersWithPosts(int num); // 10

    @Query("SELECT u FROM User u JOIN u.posts p WHERE p.title LIKE :title")
    List<User> findUsersByPostTitle(@Param("title") String title);

    @Query("SELECT c FROM User u JOIN u.posts p JOIN p.comments c WHERE c.id = :commentId AND p.id = :postId AND u.id = :userId")
    Comment findCommentsByIdAndPostIdAndCommentId(long userId, long postId, long commentId);
}
