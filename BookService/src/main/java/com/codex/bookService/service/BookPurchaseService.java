package com.codex.bookService.service;

import com.codex.bookService.model.Book;
import com.codex.bookService.model.BookPurchase;
import com.codex.bookService.exceptions.BookNotFoundException;
import com.codex.bookService.repository.BookPurchaseRepo;
import com.codex.bookService.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class BookPurchaseService {

    @Autowired
    private BookPurchaseRepo bookPurchaseRepo;

    @Autowired
    private BookRepo bookRepo;

    public BookPurchase addBookDetails(BookPurchase bookPurchase) {
        return bookPurchaseRepo.save(bookPurchase);
    }


    public BookPurchase buyBook(String bookName) {
        Optional<BookPurchase> book = bookPurchaseRepo.findById(bookName);
        BookPurchase bookPurchase = new BookPurchase();
        Optional<Book> optionalBook = bookRepo.findBookByBookName(bookName);
        Integer count = 1;
        try {
            if (book.isPresent()) {
                book.get().setSoldBooks(book.get().getSoldBooks() + count);
                book.get().setTotalPrice(book.get().getTotalPrice() * book.get().getSoldBooks());
                return bookPurchaseRepo.save(book.get());
            } else {
                if(optionalBook.isPresent() && optionalBook.get().getIsPublish()) {
                    bookPurchase.setBookName(bookName);
                    bookPurchase.setSoldBooks(count);
                    bookPurchase.setTotalPrice(optionalBook.get().getPrice());
                } else {
                    throw new BookNotFoundException("Book Not Found");
                }
                return bookPurchaseRepo.save(bookPurchase);
            }
        } catch (Exception e) {
            throw new BookNotFoundException(String.format("Book not found with %s",bookName));
        }
    }
}
