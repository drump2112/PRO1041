/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewModel;

import java.util.Date;

/**
 *
 * @author sethk
 */
public class QLNhanVien {

    private String id;
    private String ma;
    private String hoTen;
    private String Email;
    private String sdt;
    private String MaCv;
    private String diaChi;
    private String cmt;
    private Date ngaySinh;
    private String gioiTinh;

    public QLNhanVien() {
    }

    public QLNhanVien(String id, String ma, String hoTen, String Email, String sdt, String MaCv, String diaChi, String cmt, Date ngaySinh, String gioiTinh) {
        this.id = id;
        this.ma = ma;
        this.hoTen = hoTen;
        this.Email = Email;
        this.sdt = sdt;
        this.MaCv = MaCv;
        this.diaChi = diaChi;
        this.cmt = cmt;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
    }

    public QLNhanVien(String ma, String hoTen, String Email, String sdt, String MaCv, String diaChi, String cmt, Date ngaySinh, String gioiTinh) {
        this.ma = ma;
        this.hoTen = hoTen;
        this.Email = Email;
        this.sdt = sdt;
        this.MaCv = MaCv;
        this.diaChi = diaChi;
        this.cmt = cmt;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
    }

    public QLNhanVien(String hoTen, String Email, String sdt, String MaCv, String diaChi, String cmt, Date ngaySinh, String gioiTinh) {
        this.hoTen = hoTen;
        this.Email = Email;
        this.sdt = sdt;
        this.MaCv = MaCv;
        this.diaChi = diaChi;
        this.cmt = cmt;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
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

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getMaCv() {
        return MaCv;
    }

    public void setMaCv(String MaCv) {
        this.MaCv = MaCv;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getCmt() {
        return cmt;
    }

    public void setCmt(String cmt) {
        this.cmt = cmt;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
}
