package com.codex.RatingService.Repository;

import com.codex.RatingService.Model.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends MongoRepository<Rating,String> {


    List<Rating> getRatingByUserId(String userId);
    List<Rating> getRatingByBookId(String bookId);
}
