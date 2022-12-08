package com.codex.bookService.controller;

import com.codex.bookService.exceptions.BookNotFoundException;
import com.codex.bookService.model.Book;
import com.codex.bookService.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/addBook")
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.saveBook(book), HttpStatus.CREATED);
    }

    @GetMapping("/allBooks")
    public ResponseEntity<List<Book>> getAllBook() {
        List<Book> books = bookService.getAllBook();
        if(books.isEmpty()) {
            throw new BookNotFoundException("No book present");
        } else {
            return new ResponseEntity<>(bookService.getAllBook(),HttpStatus.OK);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable String id) {
        return new ResponseEntity<>( bookService.getBook(id),HttpStatus.OK);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Book>> getBooksByCategories(@PathVariable String category) {
        return new ResponseEntity<>(bookService.getBooksByCategory(category),HttpStatus.FOUND);
    }

    @PutMapping("/updateBook/{id}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book,@PathVariable String id) {
        return new ResponseEntity<>(bookService.updateBook(book,id),HttpStatus.FOUND);
    }

    @DeleteMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable String id) {
        bookService.deleteBook(id);
        return "Book deleted";
    }
    @GetMapping("/lowToHighRatings")
    public ResponseEntity<List<Book>> getSortedBooksAsc() {
        return new ResponseEntity<>(bookService.lowToHighRating(),HttpStatus.OK);
    }
    @GetMapping("/highToLowRatings")
    public ResponseEntity<List<Book>> getSortedBooksDsc() {
        return new ResponseEntity<>(bookService.highToLowRating(),HttpStatus.OK);
    }
}
