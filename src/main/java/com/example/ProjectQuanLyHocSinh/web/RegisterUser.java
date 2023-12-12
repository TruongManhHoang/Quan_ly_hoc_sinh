package com.example.ProjectQuanLyHocSinh.web;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.*;

import java.sql.Blob;
import java.sql.Date;

public class RegisterUser {
    @NotBlank(message = "Thông tin bắt buộc")
    @Size(min = 1, message = "Độ dài tối thiểu là 1")
    private String username;

    @NotBlank(message = "Thông tin bắt buộc")
    @Size(min = 8, message = "Độ dài tối thiểu là 8")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[@#$%+!^&=])(?=\\S+$).*$ ",
    message = "Mật khẩu phải chứa ít nhất 1 kí tự đặc biệt và 1 chữ số")
    private String password;

    @NotBlank(message = "Thông tin bắt buộc")
    private String firstName;

    @NotBlank(message = "Thông tin bắt buộc")
    private String lastName;

    @Email(message = "Email không hợp lệ")
    @NotBlank(message = "Thông tin bắt buộc")
    private String email;

    private String enabled;

    @NotBlank(message = "Thông tin bắt buộc")
    private String gioiTinh;

    @NotBlank(message = "Thông tin bắt buộc")
    private Date ngaySinh;

    @NotBlank(message = "Thông tin bắt buộc")
    private String diaChi;

    private String chucVu;

    private Blob avatar;

    public RegisterUser() {
    }

    public RegisterUser(String username, String password, String firstName, String lastName, String email, String gioiTinh, Date ngaySinh, String diaChi, String chucVu, Blob avatar) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.chucVu = chucVu;
        this.avatar = avatar;
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

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public Blob getAvatar() {
        return avatar;
    }

    public void setAvatar(Blob avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "RegisterUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", enabled='" + enabled + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", ngaySinh=" + ngaySinh +
                ", diaChi='" + diaChi + '\'' +
                ", chucVu='" + chucVu + '\'' +
                ", avatar=" + avatar +
                '}';
    }
}
