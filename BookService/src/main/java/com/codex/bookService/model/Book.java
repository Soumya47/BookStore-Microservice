package com.codex.bookService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Comparator;

@Document(collection = "Book")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    private String id;
    @NotNull
    private String bookName;
    @NotNull
    private String authorName;
    @Min(value = 0,message = "It should be positive")
    private Double price;
    @Min(value = 0,message = "It should be positive")
    private int ratings;
    private StatusEnum catagory;
    @NotNull
    private Boolean isPublish;

    public enum StatusEnum {
        TECHNOLOGY,DRAMA,THRILLER,POETRY,NONFICTION,COMICS
    }


    public static Comparator<Book> bookByRatingsAsc = (t1, t2) -> {
        int rating1 = t1.getRatings();
        int rating2 = t2.getRatings();
        return (rating1-rating2);
    };
    public static Comparator<Book> bookByRatingsDsc = (t1, t2) -> {
        int rating1 = t1.getRatings();
        int rating2 = t2.getRatings();
        return (rating2-rating1);
    };
}
