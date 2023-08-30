/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import dbConnection.DbConnection;
import domainModel.HoaDon;
import domainModel.HoaDonCho;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sethk
 */
public class RPHoaDon {

    public List<HoaDonCho> getListBillWait() {
        Connection c = DbConnection.getConnection();
        List<HoaDonCho> list = new ArrayList<>();
        String sql = "SELECT a.id ,a.Ma_LichDatSan AS mds,b.Ten, a.TongTien  FROM dbo.HoaDon a INNER JOIN  dbo.KhachHang b ON b.ID = a.ID_KH WHERE a.TrangThai = 0";
        try {

            PreparedStatement pts = c.prepareStatement(sql);

            ResultSet rs = pts.executeQuery();
            while (rs.next()) {
                HoaDonCho hdc = new HoaDonCho();

                hdc.setMa(rs.getString("id"));
                hdc.setMds(rs.getString("mds"));
                hdc.setTenKH(rs.getString("Ten"));
                hdc.setTongTien(rs.getDouble("TongTien"));
                list.add(hdc);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean changeStatus(String id) {
        Connection c = DbConnection.getConnection();

        String sql = "UPDATE dbo.HoaDon SET TrangThai = 1 WHERE ID = ? ";

        try {
            PreparedStatement pts = c.prepareStatement(sql);
            pts.setObject(1, id);

            int rs = pts.executeUpdate();
            return rs > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addHoaDon(HoaDon hd) {
        Connection c = DbConnection.getConnection();
        String sql = "	INSERT INTO dbo.HoaDon	(Ma_LichDatSan,ID_NV,ID_KH,TrangThai,KhuyenMai,TongTien,NgayThanhToan)VALUES(?,?,?,?,?,?,GETDATE())";
        try {
            PreparedStatement pts = c.prepareStatement(sql);
            pts.setObject(1, hd.getMslds());
            pts.setObject(2, hd.getIdnv());
            pts.setObject(3, hd.getIdkh());
            pts.setObject(4, hd.getTrangThai());
            pts.setObject(5, hd.getTenKM());
            pts.setObject(6, hd.getTongTien());
            return pts.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addHoaDonCho(HoaDon hd) {
        Connection c = DbConnection.getConnection();
        String sql = "	INSERT INTO dbo.HoaDon	(Ma_LichDatSan,ID_NV,ID_KH,TrangThai,KhuyenMai,TongTien,NgayThanhToan)VALUES(?,?,?,?,?,?,GETDATE())";
        try {
            PreparedStatement pts = c.prepareStatement(sql);
            pts.setObject(1, hd.getMslds());
            pts.setObject(2, hd.getIdnv());
            pts.setObject(3, hd.getIdkh());
            pts.setObject(4, hd.getTrangThai());
            pts.setObject(5, hd.getTenKM());
            pts.setObject(6, hd.getTongTien());
            return pts.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<HoaDonCho> findByMds(String mds) {
        Connection c = DbConnection.getConnection();
        List<HoaDonCho> list = new ArrayList<>();
        String sql = "SELECT a.id ,a.Ma_LichDatSan AS mds,b.Ten, a.TongTien  FROM dbo.HoaDon a INNER JOIN  dbo.KhachHang b ON b.ID = a.ID_KH WHERE a.TrangThai = 0 AND a.Ma_LichDatSan = ? ";
        try {

            PreparedStatement pts = c.prepareStatement(sql);
            pts.setObject(1, mds);
            ResultSet rs = pts.executeQuery();
            while (rs.next()) {
                HoaDonCho hdc = new HoaDonCho();

                hdc.setMa(rs.getString("id"));
                hdc.setMds(rs.getString("mds"));
                hdc.setTenKH(rs.getString("Ten"));
                hdc.setTongTien(rs.getDouble("TongTien"));
                list.add(hdc);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<HoaDonCho> findByName(String name) {
        Connection c = DbConnection.getConnection();
        List<HoaDonCho> list = new ArrayList<>();
        String sql = "SELECT a.id ,a.Ma_LichDatSan AS mds,b.Ten, a.TongTien  FROM dbo.HoaDon a INNER JOIN  dbo.KhachHang b ON b.ID = a.ID_KH WHERE a.TrangThai = 0 AND b.Ten like N'%" + name + "%'";
        try {

            PreparedStatement pts = c.prepareStatement(sql);
           
            ResultSet rs = pts.executeQuery();
            while (rs.next()) {
                HoaDonCho hdc = new HoaDonCho();

                hdc.setMa(rs.getString("id"));
                hdc.setMds(rs.getString("mds"));
                hdc.setTenKH(rs.getString("Ten"));
                hdc.setTongTien(rs.getDouble("TongTien"));
                list.add(hdc);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
