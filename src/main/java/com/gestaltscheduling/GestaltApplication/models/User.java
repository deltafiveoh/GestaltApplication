package com.gestaltscheduling.GestaltApplication.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class User {

    @NotBlank (message = "Username required")
    @Size(min=3, max=50, message = "Username must be between 3 and 50 characters")
    private String username;

    @NotBlank (message = "Username required")
    private String email;

    @NotBlank (message = "Username required")
    @Size(min=8, max=20, message = "Username must be between 8 and 20 characters")
    private String password;

    @GeneratedValue
    @Id
    private int id;

    public User() {
    }

    public User(String username, String email, String password) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
    }

//    @OneToOne
//    private User user;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
