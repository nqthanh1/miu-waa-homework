package edu.miu.waa.homework.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class PostDto {
    private long id;
    private String title;
    private String content;
    private String author;

    public PostDto() {
    }
}
