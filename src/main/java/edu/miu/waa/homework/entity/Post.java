package edu.miu.waa.homework.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Post {
    long id;
    String title;
    String content;
    String author;

    public Post() {
    }
}

