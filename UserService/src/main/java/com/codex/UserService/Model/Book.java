package com.codex.UserService.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private String id;

    private String bookName;

    private String authorName;

    private Double price;

    private int ratings;

    private StatusEnum catagory;

    private Boolean isPublish;

    public enum StatusEnum {
        TECHNOLOGY,DRAMA,THRILLER,POETRY,NONFICTION,COMICS
    }
}
