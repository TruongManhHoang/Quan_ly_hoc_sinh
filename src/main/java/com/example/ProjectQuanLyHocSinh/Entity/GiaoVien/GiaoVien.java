package com.example.ProjectQuanLyHocSinh.Entity.GiaoVien;

import com.example.ProjectQuanLyHocSinh.Entity.Lop.Lop;
import com.example.ProjectQuanLyHocSinh.Entity.MonHoc.MonHoc;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "giao_vien")
public class GiaoVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ten", length = 256)
    private String ten;

    @Column(name = "ho_va_ten_dem", length = 256)
    private String hoVaTenDem;

    @Column(name = "email", length = 256)
    private String email;
    @Column(name = "phu_trach_lop", length = 256)
    private String phuTrachLop;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Teacher_detail_id")
    private GiaoVienDetail giaoVienDetail;

    @ManyToMany(fetch = FetchType.LAZY,cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH
    })
    @JoinTable(name = "giao_vien_lop",
               joinColumns = @JoinColumn(name = "giao_vien_id"),
               inverseJoinColumns = @JoinColumn(name = "lop_id"))
    private List<Lop> lop;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinTable(name = "mon_hoc_giao_vien",
            joinColumns = @JoinColumn(name = "giao_vien_id"),
            inverseJoinColumns = @JoinColumn(name = "mon_hoc_id")
    )
    private List<MonHoc> monHocs;

    public GiaoVien() {
    }

    public GiaoVien(String ten, String hoVaTenDem, String email, String phuTrachLop, GiaoVienDetail giaoVienDetail, List<Lop> lop, List<MonHoc> monHocs) {
        this.ten = ten;
        this.hoVaTenDem = hoVaTenDem;
        this.email = email;
        this.phuTrachLop = phuTrachLop;
        this.giaoVienDetail = giaoVienDetail;
        this.lop = lop;
        this.monHocs = monHocs;
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

    public String getHoVaTenDem() {
        return hoVaTenDem;
    }

    public void setHoVaTenDem(String hoVaTenDem) {
        this.hoVaTenDem = hoVaTenDem;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public GiaoVienDetail getGiaoVienDetail() {
        return giaoVienDetail;
    }

    public void setGiaoVienDetail(GiaoVienDetail giaoVienDetail) {
        this.giaoVienDetail = giaoVienDetail;
    }

    public String getPhuTrachLop() {
        return phuTrachLop;
    }

    public void setPhuTrachLop(String phuTrachLop) {
        this.phuTrachLop = phuTrachLop;
    }

    public List<Lop> getLop() {
        return lop;
    }

    public void setLop(List<Lop> lop) {
        this.lop = lop;
    }

    public List<MonHoc> getMonHocs() {
        return monHocs;
    }

    public void setMonHocs(List<MonHoc> monHocs) {
        this.monHocs = monHocs;
    }

    @Override
    public String toString() {
        return "GiaoVien{" +
                "id=" + id +
                ", ten='" + ten + '\'' +
                ", hoVaTenDem='" + hoVaTenDem + '\'' +
                ", email='" + email + '\'' +
                ", phuTrachLop='" + phuTrachLop + '\'' +
                ", giaoVienDetail=" + giaoVienDetail +
                ", lop=" + lop +
                ", monHocs=" + monHocs +
                '}';
    }

}
