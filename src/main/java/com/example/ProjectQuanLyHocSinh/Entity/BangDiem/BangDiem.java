package com.example.ProjectQuanLyHocSinh.Entity.BangDiem;

import com.example.ProjectQuanLyHocSinh.Entity.HocSinh.HocSinh;
import com.example.ProjectQuanLyHocSinh.Entity.MonHoc.MonHoc;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "bang_diem")
public class BangDiem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String kyHoc;

    private double diemSo;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinTable(name = "hoc_sinh_bang_diem",
                joinColumns = @JoinColumn(name = "bang_diem_id"),
                inverseJoinColumns = @JoinColumn(name = "hoc_sinh_id")
    )
    private List<HocSinh> hocSinhs;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinTable(name = "mon_hoc_bang_diem",
            joinColumns = @JoinColumn(name = "bang_diem_id"),
            inverseJoinColumns = @JoinColumn(name = "mon_hoc_id")
    )
    private List<MonHoc> monHocs;

    public BangDiem() {
    }

    public BangDiem(String kyHoc, double diemSo, List<HocSinh> hocSinhs, List<MonHoc> monHocs) {
        this.kyHoc = kyHoc;
        this.diemSo = diemSo;
        this.hocSinhs = hocSinhs;
        this.monHocs = monHocs;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKyHoc() {
        return kyHoc;
    }

    public void setKyHoc(String kyHoc) {
        this.kyHoc = kyHoc;
    }

    public double getDiemSo() {
        return diemSo;
    }

    public void setDiemSo(double diemSo) {
        this.diemSo = diemSo;
    }

    public List<HocSinh> getHocSinhs() {
        return hocSinhs;
    }

    public void setHocSinhs(List<HocSinh> hocSinhs) {
        this.hocSinhs = hocSinhs;
    }

    public List<MonHoc> getMonHocs() {
        return monHocs;
    }

    public void setMonHocs(List<MonHoc> monHocs) {
        this.monHocs = monHocs;
    }

    @Override
    public String toString() {
        return "BangDiem{" +
                "id=" + id +
                ", kyHoc='" + kyHoc + '\'' +
                ", diemSo=" + diemSo +
                ", hocSinhs=" + hocSinhs +
                ", monHocs=" + monHocs +
                '}';
    }
}
