package com.example.ProjectQuanLyHocSinh.Entity.PhuHuynh;

import jakarta.persistence.*;

import java.sql.Blob;

@Entity
@Table(name = "phu_huynh")
public class PhuHuynh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ten", length = 50)
    private String ten;

    @Column(name = "ho_va_dem", length = 50)
    private String hoVaDem;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "dia_chi", length = 50)
    private String diaChi;

    @Column(name = "gioiTinh")
    private Boolean gioiTinh;

    @Lob
    @Column(name = "avatar")
    private Blob avatar;

    public PhuHuynh() {
    }

    public PhuHuynh(String ten, String hoVaDem, String email, String diaChi, Boolean gioiTinh, Blob avatar) {
        this.ten = ten;
        this.hoVaDem = hoVaDem;
        this.email = email;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.avatar = avatar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getHoVaDem() {
        return hoVaDem;
    }

    public void setHoVaDem(String hoVaDem) {
        this.hoVaDem = hoVaDem;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Blob getAvatar() {
        return avatar;
    }

    public void setAvatar(Blob avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "PhuHuynh{" +
                "id=" + id +
                ", ten='" + ten + '\'' +
                ", hoVaDem='" + hoVaDem + '\'' +
                ", email='" + email + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", gioiTinh=" + gioiTinh +
                ", avatar=" + avatar +
                '}';
    }
}
