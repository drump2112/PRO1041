/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainModel;

/**
 *
 * @author sethk
 */
public class HoaDonCho {

    private String ma;
    private String mds;
    private String tenKH;
    private Double tongTien;

    public HoaDonCho() {
    }

    public HoaDonCho(String ma, String mds, String tenKH, Double tongTien) {
        this.ma = ma;
        this.mds = mds;
        this.tenKH = tenKH;
        this.tongTien = tongTien;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getMds() {
        return mds;
    }

    public void setMds(String mds) {
        this.mds = mds;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public Double getTongTien() {
        return tongTien;
    }

    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
    }

}
