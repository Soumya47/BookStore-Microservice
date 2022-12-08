package com.codex.bookService.repository;

import com.codex.bookService.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepo extends MongoRepository<Book,String> {
    @Query("{bookName:?0}")
    Optional<Book> findBookByBookName(String bookName);

    @Query("{catagory:?0}")
    List<Book> findBooksByCategories(String category);
}
