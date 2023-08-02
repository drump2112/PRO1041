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
}
