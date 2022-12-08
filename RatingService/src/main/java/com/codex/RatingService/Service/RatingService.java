package com.codex.RatingService.Service;

import com.codex.RatingService.Model.Rating;

import java.util.List;

public interface RatingService {
    Rating saveRating(Rating rating);
    Rating getRating(String ratingId);
    List<Rating> getAllRating();
    void deleteRating(String ratingId);

    List<Rating> getRatingByUserId(String userId);

    List<Rating> getRatingByBookId(String bookId);


}
