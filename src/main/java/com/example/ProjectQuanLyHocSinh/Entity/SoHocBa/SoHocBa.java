package com.example.ProjectQuanLyHocSinh.Entity.SoHocBa;

import com.example.ProjectQuanLyHocSinh.Entity.BangDiem.BangDiem;
import jakarta.persistence.*;

@Entity
@Table(name = "so_hoc_ba")
public class SoHocBa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "hanh_kiem")
    private String hanhKiem;

    @Column(name = "nhan_xet_giao_vien")
    private String nhanXetGiaoVien;

    @Column(name = "nhan_xet_phu_huynh")
    private String nhanXetPhuHuynh;

    @Column(name = "diem_So")
    private Double diemSo;

    public SoHocBa() {
    }

    public SoHocBa(String hanhKiem, String nhanXetGiaoVien, String nhanXetPhuHuynh, Double diemSo) {
        this.hanhKiem = hanhKiem;
        this.nhanXetGiaoVien = nhanXetGiaoVien;
        this.nhanXetPhuHuynh = nhanXetPhuHuynh;
        this.diemSo = diemSo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHanhKiem() {
        return hanhKiem;
    }

    public void setHanhKiem(String hanhKiem) {
        this.hanhKiem = hanhKiem;
    }

    public String getNhanXetGiaoVien() {
        return nhanXetGiaoVien;
    }

    public void setNhanXetGiaoVien(String nhanXetGiaoVien) {
        this.nhanXetGiaoVien = nhanXetGiaoVien;
    }

    public String getNhanXetPhuHuynh() {
        return nhanXetPhuHuynh;
    }

    public void setNhanXetPhuHuynh(String nhanXetPhuHuynh) {
        this.nhanXetPhuHuynh = nhanXetPhuHuynh;
    }

    public Double getDiemSo() {
        return diemSo;
    }

    public void setDiemSo(Double diemSo) {
        this.diemSo = diemSo;
    }

    @Override
    public String toString() {
        return "SoHocBa{" +
                "id=" + id +
                ", hanhKiem='" + hanhKiem + '\'' +
                ", nhanXetGiaoVien='" + nhanXetGiaoVien + '\'' +
                ", nhanXetPhuHuynh='" + nhanXetPhuHuynh + '\'' +
                ", diemSo=" + diemSo +
                '}';
    }
}
