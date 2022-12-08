package com.codex.UserService.Service;

import com.codex.UserService.Model.UserModel;

import java.util.List;

public interface UserService {
    UserModel createUser(UserModel userModel);
    UserModel getUser(String userId);
    List<UserModel> getAllUser();
    void deleteUser(String userId);


}
