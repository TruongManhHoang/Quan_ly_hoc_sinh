package com.example.ProjectQuanLyHocSinh.Entity.Lop;

import com.example.ProjectQuanLyHocSinh.Entity.GiaoVien.GiaoVien;
import com.example.ProjectQuanLyHocSinh.Entity.HocSinh.HocSinh;
import jakarta.persistence.*;

import java.time.Year;
import java.util.List;

@Entity
@Table(name = "lop")
public class Lop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ten_lop", length = 25)
    private String tenLop;

    @Column(name = "khoi_hoc", length = 25)
    private String khoiHoc;

    @Column(name = "nien_khoa", length = 25)
    private String nienKhoa;

    @Column(name = "giao_vien_chu_nhiem", length = 25)
    private String giaoVienChuNhiem;

    @ManyToMany(fetch = FetchType.LAZY,cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH
    })
    @JoinTable(name = "giao_vien_lop",
            joinColumns = @JoinColumn(name = "lop_id"),
            inverseJoinColumns = @JoinColumn(name = "giao_vien_id"))
    private List<GiaoVien> giaoViens;

    @ManyToMany(fetch = FetchType.LAZY,cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH
    })
    @JoinTable(name = "hoc_sinh_lop",
            joinColumns = @JoinColumn(name = "lop_id"),
            inverseJoinColumns = @JoinColumn(name = "hoc_sinh_id"))
    private List<HocSinh> hocSinhs;

    public Lop() {
    }

    public Lop(String tenLop, String khoiHoc, String nienKhoa, String giaoVienChuNhiem) {
        this.tenLop = tenLop;
        this.khoiHoc = khoiHoc;
        this.nienKhoa = nienKhoa;
        this.giaoVienChuNhiem = giaoVienChuNhiem;
    }

    public Lop(Integer id, String tenLop, String khoiHoc, String nienKhoa, String giaoVienChuNhiem, List<GiaoVien> giaoViens, List<HocSinh> hocSinhs) {
        this.id = id;
        this.tenLop = tenLop;
        this.khoiHoc = khoiHoc;
        this.nienKhoa = nienKhoa;
        this.giaoVienChuNhiem = giaoVienChuNhiem;
        this.giaoViens = giaoViens;
        this.hocSinhs = hocSinhs;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public String getKhoiHoc() {
        return khoiHoc;
    }

    public void setKhoiHoc(String khoiHoc) {
        this.khoiHoc = khoiHoc;
    }

    public String getNienKhoa() {
        return nienKhoa;
    }

    public void setNienKhoa(String nienKhoa) {
        this.nienKhoa = nienKhoa;
    }

    public String getGiaoVienChuNhiem() {
        return giaoVienChuNhiem;
    }

    public void setGiaoVienChuNhiem(String giaoVienChuNhiem) {
        this.giaoVienChuNhiem = giaoVienChuNhiem;
    }

    public List<GiaoVien> getGiaoViens() {
        return giaoViens;
    }

    public void setGiaoViens(List<GiaoVien> giaoViens) {
        this.giaoViens = giaoViens;
    }

    public List<HocSinh> getHocSinhs() {
        return hocSinhs;
    }

    public void setHocSinhs(List<HocSinh> hocSinhs) {
        this.hocSinhs = hocSinhs;
    }

    @Override
    public String toString() {
        return "Lop{" +
                "id=" + id +
                ", tenLop='" + tenLop + '\'' +
                ", khoiHoc='" + khoiHoc + '\'' +
                ", nienKhoa='" + nienKhoa + '\'' +
                ", giaoVienChuNhiem='" + giaoVienChuNhiem + '\'' +
                ", giaoViens=" + giaoViens +
                ", hocSinhs=" + hocSinhs +
                '}';
    }
}
