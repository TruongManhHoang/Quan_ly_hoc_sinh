package com.example.ProjectQuanLyHocSinh.Entity.Truong;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "truong")
public class Truong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ten_truong" ,length = 50)
    private String tenTruong;

    @Column(name = "dia_chi", length = 50)
    private String diaChi;

    @Column(name = "so_dien_thoai", length = 25)
    private String sdt;

    @Column(name = "ngay_thanh_lap")
    private Date ngayThanhLap;

    public Truong() {
    }

    public Truong(String tenTruong, String diaChi, String sdt, Date ngayThanhLap) {
        this.tenTruong = tenTruong;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.ngayThanhLap = ngayThanhLap;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenTruong() {
        return tenTruong;
    }

    public void setTenTruong(String tenTruong) {
        this.tenTruong = tenTruong;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Date getNgayThanhLap() {
        return ngayThanhLap;
    }

    public void setNgayThanhLap(Date ngayThanhLap) {
        this.ngayThanhLap = ngayThanhLap;
    }

    @Override
    public String toString() {
        return "Truong{" +
                "id=" + id +
                ", tenTruong='" + tenTruong + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", sdt='" + sdt + '\'' +
                ", ngayThanhLap=" + ngayThanhLap +
                '}';
    }
}
