/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainModel;

/**
 *
 * @author toi84
 */
public class GiaoCaCT {

    private Double tongTien, tienCoc;

    public GiaoCaCT() {
    }

    public GiaoCaCT(Double tongTien, Double tienCoc) {
        this.tongTien = tongTien;
        this.tienCoc = tienCoc;
    }

    public Double getTongTien() {
        return tongTien;
    }

    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
    }

    public Double getTienCoc() {
        return tienCoc;
    }

    public void setTienCoc(Double tienCoc) {
        this.tienCoc = tienCoc;
    }

}
