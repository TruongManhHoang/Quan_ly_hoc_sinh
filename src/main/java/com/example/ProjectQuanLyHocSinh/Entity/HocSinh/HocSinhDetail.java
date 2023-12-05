package com.example.ProjectQuanLyHocSinh.Entity.HocSinh;

import jakarta.persistence.*;

import java.sql.Blob;
import java.sql.Date;
@Entity
@Table(name = "hoc_sinh_detail")
public class HocSinhDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "sdt", length = 50)
    private String sdt;

    @Column(name = "gioi_Tinh")
    private Boolean gioiTinh;

    @Column(name = "ngay_sinh")
    private Date ngaySinh;

    @Column(name = "dia_chi", length = 50)
    private String diaChi;

    @Column(name = "so_thich", length = 50)
    private String soThich;

    @Column(name = "facebook", length = 50)
    private String facebook;

    @Lob
    @Column(name = "avatar", length = 256)
    private Blob avatar;

    @OneToOne(mappedBy = "hocSinhDetail")
    private HocSinh hocSinh;

    public HocSinhDetail() {
    }

    public HocSinhDetail(String sdt, Boolean gioiTinh, Date ngaySinh, String diaChi, String soThich, String facebook, Blob avatar, HocSinh hocSinh) {
        this.sdt = sdt;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.soThich = soThich;
        this.facebook = facebook;
        this.avatar = avatar;
        this.hocSinh = hocSinh;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Boolean gioiTinh) {
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

    public String getSoThich() {
        return soThich;
    }

    public void setSoThich(String soThich) {
        this.soThich = soThich;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public Blob getAvatar() {
        return avatar;
    }

    public void setAvatar(Blob avatar) {
        this.avatar = avatar;
    }

    public HocSinh getHocSinh() {
        return hocSinh;
    }

    public void setHocSinh(HocSinh hocSinh) {
        this.hocSinh = hocSinh;
    }

    @Override
    public String toString() {
        return "HocSinhDetail{" +
                "id=" + id +
                ", sdt='" + sdt + '\'' +
                ", gioiTinh=" + gioiTinh +
                ", ngaySinh=" + ngaySinh +
                ", diaChi='" + diaChi + '\'' +
                ", soThich='" + soThich + '\'' +
                ", facebook='" + facebook + '\'' +
                ", avatar=" + avatar +
                ", hocSinh=" + hocSinh +
                '}';
    }
}
