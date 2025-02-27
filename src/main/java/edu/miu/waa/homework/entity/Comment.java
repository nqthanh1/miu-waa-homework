package edu.miu.waa.homework.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String description;

    @ManyToOne
    @JoinColumn(name = "post_id")
    @JsonBackReference
    Post post;

    public Comment() {
    }

}
