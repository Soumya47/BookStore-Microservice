package com.codex.RatingService.Controller;

import com.codex.RatingService.Model.Rating;
import com.codex.RatingService.Service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/rating")
public class RatingController {
    @Autowired
    private RatingService ratingService;

    @PostMapping("/saveRating")
    public ResponseEntity<?> saveRating(@RequestBody Rating rating) {
        return ResponseEntity.status(201).body(ratingService.saveRating(rating));
    }
    @GetMapping("/getRating")
    public ResponseEntity<?> getRating( @RequestParam String ratingId) {
        return ResponseEntity.status(200).body(ratingService.getRating(ratingId));
    }

    @GetMapping("/getAllRating")
    public ResponseEntity<?> getAllRating() {
        return ResponseEntity.status(200).body(ratingService.getAllRating());
    }

    @GetMapping("/deleteRating")
    public ResponseEntity<?> deleteRating(@RequestParam String ratingId) {
        ratingService.deleteRating(ratingId);
        return ResponseEntity.status(200).body(ratingId +" deleted");
    }

    @GetMapping("/getAllRating/user")
    public ResponseEntity<?> getAllRatingByUser(@RequestParam String userId) {
        return ResponseEntity.status(200).body(ratingService.getRatingByUserId(userId));
    }

    @GetMapping("/getAllRating/book")
    public ResponseEntity<?> getAllRatingByBook(@RequestParam String bookId) {
        return ResponseEntity.status(200).body(ratingService.getRatingByBookId(bookId));
    }

}
