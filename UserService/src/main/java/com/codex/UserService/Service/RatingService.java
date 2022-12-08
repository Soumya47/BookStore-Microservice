package com.codex.UserService.Service;

import com.codex.UserService.Model.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@FeignClient(name = "RATING-SERVICE")
public interface RatingService {
    @GetMapping("/api/v1/rating/getAllRating/user")
    List<Rating> getRating(@RequestParam(name = "userId") String userId);
}
