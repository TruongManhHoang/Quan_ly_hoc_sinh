package com.example.ProjectQuanLyHocSinh.Entity.TheHocSinh;

import com.example.ProjectQuanLyHocSinh.Entity.HocSinh.HocSinh;
import jakarta.persistence.*;

import java.sql.Blob;

@Entity
@Table(name = "the_hoc_sinh")
public class TheHocSinh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Lob
    @Column(name = "avatar")
    private Blob avatar;

    @Column(name = "dia_chi", length = 50)
    private String diaChi;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hoc_sinh_id")
    private HocSinh hocSinh;

    public TheHocSinh() {
    }

    public TheHocSinh(Blob avatar, String diaChi, HocSinh hocSinh) {
        this.avatar = avatar;
        this.diaChi = diaChi;
        this.hocSinh = hocSinh;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Blob getAvatar() {
        return avatar;
    }

    public void setAvatar(Blob avatar) {
        this.avatar = avatar;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public HocSinh getHocSinh() {
        return hocSinh;
    }

    public void setHocSinh(HocSinh hocSinh) {
        this.hocSinh = hocSinh;
    }

    @Override
    public String toString() {
        return "TheHocSinh{" +
                "id=" + id +
                ", avatar=" + avatar +
                ", diaChi='" + diaChi + '\'' +
                ", hocSinh=" + hocSinh +
                '}';
    }
}
