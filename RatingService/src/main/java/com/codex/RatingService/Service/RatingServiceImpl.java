package com.codex.RatingService.Service;

import com.codex.RatingService.Model.Rating;
import com.codex.RatingService.Repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating saveRating(Rating rating) {
        return ratingRepository.save(rating);

    }

    @Override
    public Rating getRating(String ratingId) {
        return ratingRepository.findById(ratingId)
                .orElseThrow(() -> new RuntimeException(ratingId +" doesn't exist!"));
    }

    @Override
    public List<Rating> getAllRating() {
        return ratingRepository.findAll();
    }

    @Override
    public void deleteRating(String ratingId) {
        ratingRepository.delete(getRating(ratingId));
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return ratingRepository.getRatingByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByBookId(String bookId) {
        return ratingRepository.getRatingByBookId(bookId);
    }
}
