/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainModel;

/**
 *
 * @author sethk
 */
public class KhuyenMai {
    private String id;
    private String ma;
    private String tenKm;
    private Double giaKm;

    public KhuyenMai() {
    }

    public KhuyenMai(String id, String ma, String tenKm, Double giaKm) {
        this.id = id;
        this.ma = ma;
        this.tenKm = tenKm;
        this.giaKm = giaKm;
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

    public String getTenKm() {
        return tenKm;
    }

    public void setTenKm(String tenKm) {
        this.tenKm = tenKm;
    }

    public Double getGiaKm() {
        return giaKm;
    }

    public void setGiaKm(Double giaKm) {
        this.giaKm = giaKm;
    }
    
    
}
