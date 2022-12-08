package com.codex.bookService.controller;

import com.codex.bookService.model.BookPurchase;
import com.codex.bookService.service.BookPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class BookPurchaseController {
    @Autowired
    BookPurchaseService bookPurchaseService;
    @PostMapping("/addBookDetails")
    public ResponseEntity<BookPurchase> saveBook(@Valid @RequestBody BookPurchase book) {
        return new ResponseEntity<>(bookPurchaseService.addBookDetails(book), HttpStatus.CREATED);
    }
    @PatchMapping("/buy/{id}")
    public ResponseEntity<BookPurchase> buyBook(@PathVariable String id) {
        return new ResponseEntity<>(bookPurchaseService.buyBook(id), HttpStatus.OK);
    }
}
