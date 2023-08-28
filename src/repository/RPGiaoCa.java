/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.*;
import java.util.*;
import dbConnection.DbConnection;
import domainModel.DichVu;
import domainModel.GiaoCa;
import domainModel.GiaoCaCT;
import domainModel.TaiKhoan;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 *
 * @author toi84
 */
public class RPGiaoCa {

    private Connection con = DbConnection.getConnection();
    private PreparedStatement pre;
    private String sql;

    public GiaoCaCT getGiaoCaTT(LocalDateTime gv, LocalDateTime gr) {

        sql = " select sum(TongTien) TT from HoaDon hd \n"
                + "join LichDat_SanBong lds on hd.Ma_LichDatSan = lds.Ma \n"
                + "join SanBong sb on lds.ID_SB = sb.ID\n"
                + "where hd.TrangThai = 1 and hd.NgayThanhToan between ? and ?";
        try {
            pre = con.prepareStatement(sql);

            String gioVao = gv.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            String gioRa = gr.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            pre.setObject(1, "2023-08-08 00:00:00");
            pre.setObject(2, "2023-09-09 00:00:00");
            ResultSet re = pre.executeQuery();
            GiaoCaCT giaoCaCT = new GiaoCaCT();
            while (re.next()) {
                giaoCaCT.setTongTien(re.getDouble("TT"));
                return giaoCaCT;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public GiaoCaCT getGiaoCaTC(LocalDateTime gv, LocalDateTime gr) {
        sql = " select sum(TienDatCoc) TC from LichDat_SanBong lds \n"
                + "where  lds.NgayDat between ? and ? and TrangThai = 1";
        try {
            pre = con.prepareStatement(sql);
            String gioVao = gv.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            String gioRa = gr.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            pre.setObject(1, "2023-08-08 00:00:00");
            pre.setObject(2, "2023-09-09 00:00:00");
            ResultSet re = pre.executeQuery();
            GiaoCaCT giaoCaCT = new GiaoCaCT();
            while (re.next()) {
                giaoCaCT.setTienCoc(re.getDouble("TC"));
                return giaoCaCT;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<TaiKhoan> listNameTk(String tenDangNhap) {
        ArrayList<TaiKhoan> list = new ArrayList<>();
        try {
            sql = "SELECT TenDangNhap from TaiKhoan WHERE TenDangNhap = ? ";
            pre = con.prepareStatement(sql);
            pre.setObject(1, tenDangNhap);
            ResultSet re = pre.executeQuery();
            while (re.next()) {
                TaiKhoan tk = new TaiKhoan();
                tk.setTenDangNhap(re.getString("TenDangNhap"));
                list.add(tk);
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean insertGiaoCa(GiaoCa gc, LocalDateTime gv, LocalDateTime gr) {
        try {
            sql = "INSERT INTO GiaoCa(tenNVV,tenNVR,GioVao,GioRa,NghiemThu,NgayTruc)\n"
                    + "VALUES(?,?,?,?,?,GETDATE())";
            pre = con.prepareStatement(sql);
            pre.setObject(1, gc.getNguoiNhan());
            pre.setObject(2, gc.getNguoiGiao());
            String gioVao = gv.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            String gioRa = gr.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            pre.setObject(3, gioVao);
            pre.setObject(4, gioRa);
            pre.setObject(5, gc.getTienTrongCa());
            int i = pre.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public GiaoCa getListGC() {
        ArrayList<GiaoCa> list = new ArrayList<>();
        sql = "SELECT Sum(NghiemThu) NT FROM GiaoCa where NgayTruc = GETDATE()";
        try {
            pre = con.prepareStatement(sql);
            ResultSet re = pre.executeQuery();
            while (re.next()) {
                GiaoCa gc = new GiaoCa();
                gc.setTienTrongCa(re.getDouble("NT"));
                return gc;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
