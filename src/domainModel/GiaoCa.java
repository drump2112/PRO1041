/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainModel;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author sethk
 */
public class GiaoCa {

    private String id;
    private String nguoiGiao;
    private String nguoiNhan;
    private LocalDateTime gioiVao;
    private LocalDateTime gioRa;
    private Double tienTrongCa;
    private Date NgayTruc;

    public GiaoCa() {
    }

    public GiaoCa(String id, String nguoiGiao, String nguoiNhan, LocalDateTime gioiVao, LocalDateTime gioRa, Double tienTrongCa, Date NgayTruc) {
        this.id = id;
        this.nguoiGiao = nguoiGiao;
        this.nguoiNhan = nguoiNhan;
        this.gioiVao = gioiVao;
        this.gioRa = gioRa;
        this.tienTrongCa = tienTrongCa;
        this.NgayTruc = NgayTruc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNguoiGiao() {
        return nguoiGiao;
    }

    public void setNguoiGiao(String nguoiGiao) {
        this.nguoiGiao = nguoiGiao;
    }

    public String getNguoiNhan() {
        return nguoiNhan;
    }

    public void setNguoiNhan(String nguoiNhan) {
        this.nguoiNhan = nguoiNhan;
    }

    public LocalDateTime getGioiVao() {
        return gioiVao;
    }

    public void setGioiVao(LocalDateTime gioiVao) {
        this.gioiVao = gioiVao;
    }

    public LocalDateTime getGioRa() {
        return gioRa;
    }

    public void setGioRa(LocalDateTime gioRa) {
        this.gioRa = gioRa;
    }

    public Double getTienTrongCa() {
        return tienTrongCa;
    }

    public void setTienTrongCa(Double tienTrongCa) {
        this.tienTrongCa = tienTrongCa;
    }

    public Date getNgayTruc() {
        return NgayTruc;
    }

    public void setNgayTruc(Date NgayTruc) {
        this.NgayTruc = NgayTruc;
    }

}
