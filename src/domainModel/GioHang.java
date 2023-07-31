/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainModel;

/**
 *
 * @author sethk
 */
public class GioHang {

    private String id;
    private String maDs;
    private String maDv;
    private String tenDv;
    private int soLuong;
    private Double giaTien;

    public GioHang() {
    }

    public GioHang(String id, String maDs, String maDv, int soLuong) {
        this.id = id;
        this.maDs = maDs;
        this.maDv = maDv;
        this.soLuong = soLuong;
    }

    public GioHang(String id, String maDs, String maDv, String tenDv, int soLuong) {
        this.id = id;
        this.maDs = maDs;
        this.maDv = maDv;
        this.tenDv = tenDv;
        this.soLuong = soLuong;
    }

    public GioHang(String id, String maDs, String maDv, String tenDv, int soLuong, Double giaTien) {
        this.id = id;
        this.maDs = maDs;
        this.maDv = maDv;
        this.tenDv = tenDv;
        this.soLuong = soLuong;
        this.giaTien = giaTien;
    }

    public GioHang(String maDv, String maDs, int soLuong) {
        this.maDs = maDs;
        this.maDv = maDv;
        this.soLuong = soLuong;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaDs() {
        return maDs;
    }

    public void setMaDs(String maDs) {
        this.maDs = maDs;
    }

    public String getMaDv() {
        return maDv;
    }

    public void setMaDv(String maDv) {
        this.maDv = maDv;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getTenDv() {
        return tenDv;
    }

    public void setTenDv(String tenDv) {
        this.tenDv = tenDv;
    }

    public Double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(Double giaTien) {
        this.giaTien = giaTien;
    }

}
