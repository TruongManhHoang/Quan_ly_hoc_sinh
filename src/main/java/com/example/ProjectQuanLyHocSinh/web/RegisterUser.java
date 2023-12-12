package com.example.ProjectQuanLyHocSinh.web;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;

public class RegisterUser {
    @NotNull(message = "thông tin bắt buộc")
    @Size(min=1, message = "độ dài tối thiểu là 1")
    private String username;

    @NotNull(message = "thông tin bắt buộc")
    @Size(min=8, message = "độ dài tối thiểu là 8")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[@#$%^&+=!])(?=\\S+$).*$",
            message = "Mật khẩu phải chứa ít nhất 1 chữ số và 1 ký tự đặc biệt")
    private String password;
    private String firstName;
    private String lastName;
    @NotBlank(message = "thông tin bắt buộc")
    @Email(message = "Email không hợp lệ")
    private String email;

    public RegisterUser() {
    }

    public RegisterUser(String username, String password, String firstName, String lastName, String email) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
