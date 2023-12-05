package com.example.ProjectQuanLyHocSinh.Entity.HocSinh;

import com.example.ProjectQuanLyHocSinh.Entity.BangDiem.BangDiem;
import com.example.ProjectQuanLyHocSinh.Entity.Lop.Lop;
import com.example.ProjectQuanLyHocSinh.Entity.PhuHuynh.PhuHuynh;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "hoc_sinh")
public class HocSinh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ten", length = 50)
    private String ten;

    @Column(name = "ho_va_dem", length = 50)
    private String hoVaDem;

    @Column(name = "email", length = 50)
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hoc_sinh_detail_id")
    private HocSinhDetail hocSinhDetail;

    @ManyToMany(fetch = FetchType.LAZY,cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH
    })
    @JoinTable(name = "hoc_sinh_lop",
            joinColumns = @JoinColumn(name = "hoc_sinh_id"),
            inverseJoinColumns = @JoinColumn(name = "lop_id"))
    private List<Lop> lops;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinTable(name = "hoc_sinh_bang_diem",
            joinColumns = @JoinColumn(name = "hoc_sinh_id"),
            inverseJoinColumns = @JoinColumn(name = "bang_diem_id")
    )
    private List<BangDiem> bangDiems;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "phu_huynh_id")
    private PhuHuynh phuHuynh;

    public HocSinh() {
    }

    public HocSinh(String ten, String hoVaDem, String email, HocSinhDetail hocSinhDetail, List<Lop> lops, List<BangDiem> bangDiems, PhuHuynh phuHuynh) {
        this.ten = ten;
        this.hoVaDem = hoVaDem;
        this.email = email;
        this.hocSinhDetail = hocSinhDetail;
        this.lops = lops;
        this.bangDiems = bangDiems;
        this.phuHuynh = phuHuynh;
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

    public String getHoVaDem() {
        return hoVaDem;
    }

    public void setHoVaDem(String hoVaDem) {
        this.hoVaDem = hoVaDem;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Lop> getLops() {
        return lops;
    }

    public void setLops(List<Lop> lops) {
        this.lops = lops;
    }

    public HocSinhDetail getHocSinhDetail() {
        return hocSinhDetail;
    }

    public void setHocSinhDetail(HocSinhDetail hocSinhDetail) {
        this.hocSinhDetail = hocSinhDetail;
    }

    public List<BangDiem> getBangDiems() {
        return bangDiems;
    }

    public void setBangDiems(List<BangDiem> bangDiems) {
        this.bangDiems = bangDiems;
    }

    public PhuHuynh getPhuHuynh() {
        return phuHuynh;
    }

    public void setPhuHuynh(PhuHuynh phuHuynh) {
        this.phuHuynh = phuHuynh;
    }

    @Override
    public String toString() {
        return "HocSinh{" +
                "id=" + id +
                ", ten='" + ten + '\'' +
                ", hoVaDem='" + hoVaDem + '\'' +
                ", email='" + email + '\'' +
                ", hocSinhDetail=" + hocSinhDetail +
                ", lops=" + lops +
                ", bangDiems=" + bangDiems +
                ", phuHuynh=" + phuHuynh +
                '}';
    }
}
