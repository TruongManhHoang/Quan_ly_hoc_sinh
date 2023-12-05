package com.example.ProjectQuanLyHocSinh.Entity.MonHoc;

import com.example.ProjectQuanLyHocSinh.Entity.GiaoVien.GiaoVien;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "mon_hoc")
public class MonHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ten_mon_hoc", length = 50)
    private String tenMonHoc;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinTable(name = "mon_hoc_giao_vien",
            joinColumns = @JoinColumn(name = "mon_hoc_id"),
            inverseJoinColumns = @JoinColumn(name = "giao_vien_id")
    )
    private List<GiaoVien> giaoViens;

    public MonHoc() {
    }

    public MonHoc(String tenMonHoc, List<GiaoVien> giaoViens) {
        this.tenMonHoc = tenMonHoc;
        this.giaoViens = giaoViens;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

    public List<GiaoVien> getGiaoViens() {
        return giaoViens;
    }

    public void setGiaoViens(List<GiaoVien> giaoViens) {
        this.giaoViens = giaoViens;
    }

    @Override
    public String toString() {
        return "MonHoc{" +
                "id=" + id +
                ", tenMonHoc='" + tenMonHoc + '\'' +
                ", giaoViens=" + giaoViens +
                '}';
    }
}
