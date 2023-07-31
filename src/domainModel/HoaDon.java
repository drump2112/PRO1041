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
    private String idLDS;
    private String idnv;
    private String idkh;
    private String idv;
    private String hinhThucThanhToan;
    private Integer trangThai;
    private Integer soGioDa;
    private Double chiPhiPhatSinh;
    private String khuyenMai;
    private Double tongTien;
    private Date ngayThanhToan;

    public HoaDon() {
    }

    public HoaDon(String id, String ma, String idLDS, String idnv, String idkh, String idv, String hinhThucThanhToan, Integer trangThai, Integer soGioDa, Double chiPhiPhatSinh, String khuyenMai, Double tongTien, Date ngayThanhToan) {
        this.id = id;
        this.ma = ma;
        this.idLDS = idLDS;
        this.idnv = idnv;
        this.idkh = idkh;
        this.idv = idv;
        this.hinhThucThanhToan = hinhThucThanhToan;
        this.trangThai = trangThai;
        this.soGioDa = soGioDa;
        this.chiPhiPhatSinh = chiPhiPhatSinh;
        this.khuyenMai = khuyenMai;
        this.tongTien = tongTien;
        this.ngayThanhToan = ngayThanhToan;
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

    public String getIdLDS() {
        return idLDS;
    }

    public void setIdLDS(String idLDS) {
        this.idLDS = idLDS;
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

    public String getIdv() {
        return idv;
    }

    public void setIdv(String idv) {
        this.idv = idv;
    }

    public String getHinhThucThanhToan() {
        return hinhThucThanhToan;
    }

    public void setHinhThucThanhToan(String hinhThucThanhToan) {
        this.hinhThucThanhToan = hinhThucThanhToan;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    public Integer getSoGioDa() {
        return soGioDa;
    }

    public void setSoGioDa(Integer soGioDa) {
        this.soGioDa = soGioDa;
    }

    public Double getChiPhiPhatSinh() {
        return chiPhiPhatSinh;
    }

    public void setChiPhiPhatSinh(Double chiPhiPhatSinh) {
        this.chiPhiPhatSinh = chiPhiPhatSinh;
    }

    public String getKhuyenMai() {
        return khuyenMai;
    }

    public void setKhuyenMai(String khuyenMai) {
        this.khuyenMai = khuyenMai;
    }

    public Double getTongTien() {
        return tongTien;
    }

    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }
    
    
            
}
