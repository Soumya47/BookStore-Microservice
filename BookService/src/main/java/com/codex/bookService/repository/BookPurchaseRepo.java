package com.codex.bookService.repository;

import com.codex.bookService.model.BookPurchase;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookPurchaseRepo extends MongoRepository<BookPurchase,String> {
}
