package com.example.ProjectQuanLyHocSinh.Entity.SoDauBai;

import com.example.ProjectQuanLyHocSinh.Entity.GiaoVien.GiaoVien;
import com.example.ProjectQuanLyHocSinh.Entity.Lop.Lop;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "so_dau_bai")
public class SoDauBai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ngay_giang_day")
    private Date ngayGiangDay;

    @Column(name = "noi_dung_bai_giang", length = 256)
    private String noiDungBaiGiang;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "giao_vien_id")
    private GiaoVien giaoVien;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lop_id")
    private Lop lop;

    public SoDauBai() {
    }

    public SoDauBai(Date ngayGiangDay, String noiDungBaiGiang, GiaoVien giaoVien, Lop lop) {
        this.ngayGiangDay = ngayGiangDay;
        this.noiDungBaiGiang = noiDungBaiGiang;
        this.giaoVien = giaoVien;
        this.lop = lop;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getNgayGiangDay() {
        return ngayGiangDay;
    }

    public void setNgayGiangDay(Date ngayGiangDay) {
        this.ngayGiangDay = ngayGiangDay;
    }

    public String getNoiDungBaiGiang() {
        return noiDungBaiGiang;
    }

    public void setNoiDungBaiGiang(String noiDungBaiGiang) {
        this.noiDungBaiGiang = noiDungBaiGiang;
    }

    public GiaoVien getGiaoVien() {
        return giaoVien;
    }

    public void setGiaoVien(GiaoVien giaoVien) {
        this.giaoVien = giaoVien;
    }

    public Lop getLop() {
        return lop;
    }

    public void setLop(Lop lop) {
        this.lop = lop;
    }

    @Override
    public String toString() {
        return "SoDauBai{" +
                "id=" + id +
                ", ngayGiangDay=" + ngayGiangDay +
                ", noiDungBaiGiang='" + noiDungBaiGiang + '\'' +
                ", giaoVien=" + giaoVien +
                ", lop=" + lop +
                '}';
    }
}
