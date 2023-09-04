/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainModel;

import java.util.Date;

/**
 *
 * @author sethk
 */
public class HoaDon {

    private String id;
    private String ma;
    private String malds;
    private String idnv;
    private String idkh;
    private int trangThai;
    private String tenSan;
    private String tenKM;
    private String idGH;
    private Double tongTien;
    private Date ngayThanhToan;
    private float giaKM;
    public HoaDon() {
    }

    public HoaDon(String mslds, String idnv, String idkh, int trangThai, String tenKM, String idGH, Double tongTien) {
        
        this.malds = mslds;
        this.idnv = idnv;
        this.idkh = idkh;
        this.trangThai = trangThai;
        this.tenKM = tenKM;
        this.idGH = idGH;
        this.tongTien = tongTien;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getMslds() {
        return malds;
    }

    public void setMslds(String mslds) {
        this.malds = mslds;
    }

    public String getIdnv() {
        return idnv;
    }

    public void setIdnv(String idnv) {
        this.idnv = idnv;
    }

    public String getIdkh() {
        return idkh;
    }

    public void setIdkh(String idkh) {
        this.idkh = idkh;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getTenKM() {
        return tenKM;
    }

    public void setTenKM(String tenKM) {
        this.tenKM = tenKM;
    }

    public String getIdGH() {
        return idGH;
    }

    public void setIdGH(String idGH) {
        this.idGH = idGH;
    }

    public Double getTongTien() {
        return tongTien;
    }

    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
    }

    public String getMalds() {
        return malds;
    }

    public void setMalds(String malds) {
        this.malds = malds;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public String getTenSan() {
        return tenSan;
    }

    public void setTenSan(String tenSan) {
        this.tenSan = tenSan;
    }

    public float getGiaKM() {
        return giaKM;
    }

    public void setGiaKM(float giaKM) {
        this.giaKM = giaKM;
    }
    
    

}
