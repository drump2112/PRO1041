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
public class LichDatSanBong {

    private String maDatSan;
    private String idSb;
    private String idNv;
    private String idKh;
    private Double tienCoc;
    private int caDa;
    private Date ngayDat;

    public LichDatSanBong() {
    }

    public LichDatSanBong(Date ngayDat) {
        this.ngayDat = ngayDat;
    }

    public LichDatSanBong(String maDatSan, String idSb, String idNv, String idKh, Double tienCoc, int caDa, Date ngayDat) {
        this.maDatSan = maDatSan;
        this.idSb = idSb;
        this.idNv = idNv;
        this.idKh = idKh;
        this.tienCoc = tienCoc;
        this.caDa = caDa;
        this.ngayDat = ngayDat;
    }

    public int getCaDa() {
        return caDa;
    }

    public void setCaDa(int caDa) {
        this.caDa = caDa;
    }

    public Double getTienCoc() {
        return tienCoc;
    }

    public void setTienCoc(Double tienCoc) {
        this.tienCoc = tienCoc;
    }

    public String getMaDatSan() {
        return maDatSan;
    }

    public void setMaDatSan(String maDatSan) {
        this.maDatSan = maDatSan;
    }

    public String getIdSb() {
        return idSb;
    }

    public void setIdSb(String idSb) {
        this.idSb = idSb;
    }

    public String getIdNv() {
        return idNv;
    }

    public void setIdNv(String idNv) {
        this.idNv = idNv;
    }

    public String getIdKh() {
        return idKh;
    }

    public void setIdKh(String idKh) {
        this.idKh = idKh;
    }

    public Date getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(Date ngayDat) {
        this.ngayDat = ngayDat;
    }

}