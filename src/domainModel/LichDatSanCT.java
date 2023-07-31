/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainModel;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author sethk
 */
public class LichDatSanCT {

    private String maDS;
    private String tenSan;
    private Integer loai;
    private String tenKh;
    private String sdt;
    private String tenNv;
    private int ca;

    private Date ngay;
    private Integer trangThai;
    private Double tienDatCoc;

    public LichDatSanCT() {
    }

    public LichDatSanCT(String maDS, String tenSan, Integer loai, String tenKh, String sdt, String tenNv, int ca, Date ngay, Integer trangThai, Double tienDatCoc) {
        this.maDS = maDS;
        this.tenSan = tenSan;
        this.loai = loai;
        this.tenKh = tenKh;
        this.sdt = sdt;
        this.tenNv = tenNv;
        this.ca = ca;
        this.ngay = ngay;
        this.trangThai = trangThai;
        this.tienDatCoc = tienDatCoc;
    }

    public LichDatSanCT(String tenSan, String maDS, String tenKh, int trangThai) {
        this.tenSan = tenSan;
        this.tenKh = tenKh;
        this.maDS = maDS;
        this.trangThai = trangThai;
    }

    public String getMaDS() {
        return maDS;
    }

    public void setMaDS(String maDS) {
        this.maDS = maDS;
    }

    public String getTenSan() {
        return tenSan;
    }

    public void setTenSan(String tenSan) {
        this.tenSan = tenSan;
    }

    public Integer getLoai() {
        return loai;
    }

    public void setLoai(Integer loai) {
        this.loai = loai;
    }

    public String getTenKh() {
        return tenKh;
    }

    public int getCa() {
        return ca;
    }

    public void setCa(int ca) {
        this.ca = ca;
    }

    public void setTenKh(String tenKh) {
        this.tenKh = tenKh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getTenNv() {
        return tenNv;
    }

    public void setTenNv(String tenNv) {
        this.tenNv = tenNv;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    public Double getTienDatCoc() {
        return tienDatCoc;
    }

    public void setTienDatCoc(Double tienDatCoc) {
        this.tienDatCoc = tienDatCoc;
    }

}
