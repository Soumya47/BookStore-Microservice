package com.codex.UserService.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Rating {
    private String ratingId;

    private String bookId;

    private String userId;

    private int rating;

    private String feedBack;

    private Book book;
}
