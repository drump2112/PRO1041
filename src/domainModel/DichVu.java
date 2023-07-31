/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainModel;

/**
 *
 * @author sethk
 */
public class DichVu {

    private String maDV;
    private String tenDV;
    private Integer dvt;
    private Double giaTien;
    private Integer soLuong;

    public DichVu() {
    }

    public DichVu(String maDV, Double giaTien, Integer soLuong) {
        this.maDV = maDV;
        this.giaTien = giaTien;
        this.soLuong = soLuong;

    }

    public DichVu(String maDV, String tenDV, Integer dvt, Double giaTien, Integer soLuong) {
        this.maDV = maDV;
        this.tenDV = tenDV;
        this.dvt = dvt;
        this.giaTien = giaTien;
        this.soLuong = soLuong;
    }

    public String getMaDV() {
        return maDV;
    }

    public void setMaDV(String maDV) {
        this.maDV = maDV;
    }

    public String getTenDV() {
        return tenDV;
    }

    public void setTenDV(String tenDV) {
        this.tenDV = tenDV;
    }

    public Integer getDvt() {
        return dvt;
    }

    public void setDvt(Integer dvt) {
        this.dvt = dvt;
    }

    public Double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(Double giaTien) {
        this.giaTien = giaTien;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

}
