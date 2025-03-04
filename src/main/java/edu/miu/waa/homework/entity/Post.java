package edu.miu.waa.homework.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import edu.miu.waa.homework.security.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String title;
    String content;
    String author;

    @ManyToOne
    @JoinColumn(name = "posted_by_id")
    @JsonBackReference
    User postedBy;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    List<Comment> comments;

    public Post() {
    }
}

