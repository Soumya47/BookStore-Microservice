package com.codex.UserService.Service;

import com.codex.UserService.Model.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "BOOK-SERVICE")
public interface BookService {
    @GetMapping("/api/v1/book/{bookId}")
    Book getBook(@PathVariable String bookId);
}
