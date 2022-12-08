package com.codex.UserService.Service;

import com.codex.UserService.Model.Book;
import com.codex.UserService.Model.Rating;
import com.codex.UserService.Model.UserModel;
import com.codex.UserService.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookService bookService;
    @Autowired
    private RatingService ratingService;


    @Override
    public UserModel createUser(UserModel userModel) {
        return userRepository.save(userModel);

    }

    @Override
    public UserModel getUser(String userId) {
        UserModel userModel = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException(userId + " doesn't exist!"));

        List<Rating> ratings = ratingService.getRating(userId);

        List<Rating> ratingList = ratings.stream().peek(rating -> {
            Book book = bookService.getBook(rating.getBookId());
            rating.setBook(book);
        }).collect(Collectors.toList());

        userModel.setRatings(ratingList);
        return userModel;
    }

    @Override
    public List<UserModel> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(String userId) {
        userRepository.delete(getUser(userId));
    }
}
