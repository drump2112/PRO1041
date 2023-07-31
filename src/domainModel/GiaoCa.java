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
public class GiaoCa {

    private String id;
    private String ma;
    private String nguoiGiao;
    private String nguoiNhan;
    private Time gioiVao;
    private Time gioRa;
    private Double tienTrongCa;
    private Date NgayTruc;

    public GiaoCa() {
    }

    public GiaoCa(String id, String ma, String nguoiGiao, String nguoiNhan, Time gioiVao, Time gioRa, Double tienTrongCa, Date NgayTruc) {
        this.id = id;
        this.ma = ma;
        this.nguoiGiao = nguoiGiao;
        this.nguoiNhan = nguoiNhan;
        this.gioiVao = gioiVao;
        this.gioRa = gioRa;
        this.tienTrongCa = tienTrongCa;
        this.NgayTruc = NgayTruc;
    }

}
