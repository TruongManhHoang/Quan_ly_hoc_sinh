package com.example.ProjectQuanLyHocSinh.Entity.PhieuDiem;

import com.example.ProjectQuanLyHocSinh.Entity.HocSinh.HocSinh;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "phieu_diem")
public class PhieuDiem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ngay_kiem_tra")
    private Date ngayKiemTra;

    @Column(name = "diem_so")
    private Double diemSo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hoc_sinh_id")
    private HocSinh hocSinh;

    public PhieuDiem() {
    }

    public PhieuDiem(Date ngayKiemTra, Double diemSo, HocSinh hocSinh) {
        this.ngayKiemTra = ngayKiemTra;
        this.diemSo = diemSo;
        this.hocSinh = hocSinh;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getNgayKiemTra() {
        return ngayKiemTra;
    }

    public void setNgayKiemTra(Date ngayKiemTra) {
        this.ngayKiemTra = ngayKiemTra;
    }

    public Double getDiemSo() {
        return diemSo;
    }

    public void setDiemSo(Double diemSo) {
        this.diemSo = diemSo;
    }

    public HocSinh getHocSinh() {
        return hocSinh;
    }

    public void setHocSinh(HocSinh hocSinh) {
        this.hocSinh = hocSinh;
    }

    @Override
    public String toString() {
        return "PhieuDiem{" +
                "id=" + id +
                ", ngayKiemTra=" + ngayKiemTra +
                ", diemSo=" + diemSo +
                ", hocSinh=" + hocSinh +
                '}';
    }
}
