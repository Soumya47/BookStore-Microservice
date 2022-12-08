package com.codex.UserService.Model;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "Users")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    @Id
    private String userId;
    @NotNull
    private String fullName;
    @NotNull
    private String email;

    private String address;

    @Transient
    private List<Rating> ratings = new ArrayList<>();

}
