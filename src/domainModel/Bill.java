/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainModel;

import java.util.Date;
import java.util.List;

/**
 *
 * @author sethk
 */
public class Bill {

    private String mds;
    private String tenNl;
    private Date ngayLap;
    private String tenKh;
    private String tenSan;
    private Double tienSan;
    private Double tienDv;
    private Double giamGia;
    private List<GioHang> listdv;

    public Bill() {
    }

    public Bill(String mds, String tenNl, Date ngayLap, String tenKh, String tenSan, Double tienSan, Double tienDv, Double giamGia, List<GioHang> listdv) {
        this.mds = mds;
        this.tenNl = tenNl;
        this.ngayLap = ngayLap;
        this.tenKh = tenKh;
        this.tenSan = tenSan;
        this.tienSan = tienSan;
        this.tienDv = tienDv;
        this.giamGia = giamGia;
        this.listdv = listdv;
    }

    public String getMds() {
        return mds;
    }

    public void setMds(String mds) {
        this.mds = mds;
    }

    public String getTenNl() {
        return tenNl;
    }

    public void setTenNl(String tenNl) {
        this.tenNl = tenNl;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }

    public String getTenKh() {
        return tenKh;
    }

    public void setTenKh(String tenKh) {
        this.tenKh = tenKh;
    }

    public String getTenSan() {
        return tenSan;
    }

    public void setTenSan(String tenSan) {
        this.tenSan = tenSan;
    }

    public Double getTienSan() {
        return tienSan;
    }

    public void setTienSan(Double tienSan) {
        this.tienSan = tienSan;
    }

    public Double getTienDv() {
        return tienDv;
    }

    public void setTienDv(Double tienDv) {
        this.tienDv = tienDv;
    }

    public Double getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(Double giamGia) {
        this.giamGia = giamGia;
    }

    public List<GioHang> getListdv() {
        return listdv;
    }

    public void setListdv(List<GioHang> listdv) {
        this.listdv = listdv;
    }

}
