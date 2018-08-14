package com.example.patel.simple_app_with_graph.Model;

public class User {
    private String Password;
    private String Email;

    public User() {
    }

    public User(String Password, String Email) {
        this.Password = Password;
        this.Email = Email;
    }


    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
}
