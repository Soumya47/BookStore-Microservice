package com.codex.bookService.service;

import com.codex.bookService.exceptions.DuplicateBookException;
import com.codex.bookService.model.Book;
import com.codex.bookService.exceptions.BookNotFoundException;
import com.codex.bookService.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepo bookRepo;

    public Book saveBook(Book book) {
        Optional<Book> bookById = bookRepo.findBookByBookName(book.getBookName());
        if(bookById.isPresent()) {
            throw new DuplicateBookException(String.format("Book already exist with %s",book.getBookName()));
        }
        return bookRepo.save(book);
    }

    public List<Book> getAllBook() {
        return bookRepo.findAll();
    }

    public Book getBook(String id) {
        return bookRepo.findById(id)
                .orElseThrow(()->new BookNotFoundException(String.format("Book not found with %s",id)));
    }

    public List<Book> getBooksByCategory(String category) {
        List<Book> books  = bookRepo.findBooksByCategories(category);

        if(books.isEmpty()) {
            throw new BookNotFoundException(String.format("No book found with this category : %s",category));
        }
        return books;
    }

    public Book updateBook( Book book,String id) {
        Book book1 = bookRepo.findById(id)
                .orElseThrow(()->new BookNotFoundException(String.format("Book not found with %s",id)));
        book1.setBookName(book.getBookName());
        book1.setAuthorName(book.getAuthorName());
        book1.setPrice(book.getPrice());
        book1.setRatings(book.getRatings());
        book1.setCatagory(book.getCatagory());
        book1.setIsPublish(book.getIsPublish());
        return bookRepo.save(book1);
    }

    public void deleteBook(String id) {
        Book book = bookRepo.findById(id)
                .orElseThrow(()->new BookNotFoundException(String.format("Book not found with %s",id)));
        bookRepo.delete(book);
    }

    public List<Book> lowToHighRating() {
        List<Book> allBooks = bookRepo.findAll();
        allBooks.sort(Book.bookByRatingsAsc);
        return allBooks;
    }

    public List<Book> highToLowRating() {
        List<Book> allBooks = bookRepo.findAll();
        allBooks.sort(Book.bookByRatingsDsc );
        return allBooks;
    }





}
