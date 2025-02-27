package edu.miu.waa.homework.repo;

import edu.miu.waa.homework.entity.Post;
import edu.miu.waa.homework.entity.User;
import edu.miu.waa.homework.entity.dto.PostDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String name);
    User findById(long id);
    List<User> findAll();

    @Query( "SELECT u FROM User u JOIN u.posts p GROUP BY u HAVING COUNT(p) >= :num" )
    public List<User> findUsersWithPosts(int num); // 10
}
