package com.codex.UserService.Controller;

import com.codex.UserService.Model.UserModel;
import com.codex.UserService.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/saveUser")
    public ResponseEntity<?> createUser(@RequestBody UserModel userModel) {
        return ResponseEntity.status(201).body(userService.createUser(userModel));
    }
    @GetMapping("/getUser")
    public ResponseEntity<?> getUser( @RequestParam String userId) {
        return ResponseEntity.status(200).body(userService.getUser(userId));
    }

    @GetMapping("/getAllUser")
    public ResponseEntity<?> getAllUser() {
        return ResponseEntity.status(200).body(userService.getAllUser());
    }
    @GetMapping("/deleteUser")
    public ResponseEntity<?> deleteUser(@RequestParam String userId) {
        userService.deleteUser(userId);
        return ResponseEntity.status(200).body(userId +" deleted");
    }

}
