/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import dbConnection.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sethk
 */
public class RPThanhToan {

    //SELECT  SUM(a.SoLuong * b.Gia_Tien) AS thanhtien FROM dbo.giohang a LEFT JOIN dbo.DichVu b ON  b.madv = a.MaDV WHERE a.mads = 'D27S11CS8' 
    public Double TongTien(String maDs) {
        Connection c = DbConnection.getConnection();

        String sql = "SELECT  SUM(a.SoLuong * b.Gia_Tien) AS thanhtien FROM dbo.giohang a LEFT JOIN dbo.DichVu b ON  b.madv = a.MaDV WHERE a.mads = ? ";
        try {

            PreparedStatement pts = c.prepareStatement(sql);
            pts.setObject(1, maDs);
            ResultSet rs = pts.executeQuery();
            if (rs.next()) {
                return rs.getDouble("thanhTien");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Double giaTien(String mds, int caDa) {
        Connection c = DbConnection.getConnection();
        if (caDa > 5) {
            String sql = "SELECT b.gia2 FROM dbo.LichDat_SanBong a LEFT JOIN dbo.SanBong b ON b.ID = a.ID_SB WHERE a.Ma = ? ";
            try {

                PreparedStatement pts = c.prepareStatement(sql);
                pts.setObject(1, mds);
                ResultSet rs = pts.executeQuery();
                if (rs.next()) {
                    return rs.getDouble("gia2");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        } else {
            String sql = "SELECT b.gia FROM dbo.LichDat_SanBong a LEFT JOIN dbo.SanBong b ON b.ID = a.ID_SB WHERE a.Ma = ? ";
            try {

                PreparedStatement pts = c.prepareStatement(sql);
                pts.setObject(1, mds);
                ResultSet rs = pts.executeQuery();
                if (rs.next()) {
                    return rs.getDouble("gia");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public Double getTienCoc(String mds) {
        Connection c = DbConnection.getConnection();

        String sql = "SELECT  TienDatCoc FROM dbo.LichDat_SanBong WHERE ma  = ? ";
        try {

            PreparedStatement pts = c.prepareStatement(sql);
            pts.setObject(1, mds);
            ResultSet rs = pts.executeQuery();
            if (rs.next()) {
                return rs.getDouble("TienDatCoc");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
