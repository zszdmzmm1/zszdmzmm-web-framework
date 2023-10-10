package com.aue.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Data
public class User {
    private int id;
    @NotEmpty
    private String email;

    @Length(min = 4, max = 16)
    //@JsonIgnore
    private String password;
    private String role;

    @JsonIgnore
    private List<Post> postList;
}
