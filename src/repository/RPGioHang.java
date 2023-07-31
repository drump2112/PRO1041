/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import dbConnection.DbConnection;
import domainModel.GioHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sethk
 */
public class RPGioHang {

    public boolean addGioHang(GioHang gh) {
        String sql = "INSERT INTO dbo.giohang(ID,mads,MaDV,SoLuong)VALUES(DEFAULT,?,?,?)";
        try (Connection con = DbConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setObject(1, gh.getMaDs());
            ps.setObject(2, gh.getMaDv());
            ps.setObject(3, gh.getSoLuong());
            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<GioHang> getListOrder(String Mads) {

        List<GioHang> list = new ArrayList<>();
        String sql = "SELECT b.Ten_Dv, SUM(a.SoLuong) AS soLuong, b.Gia_Tien FROM "
                + " dbo.giohang a LEFT JOIN dbo.DichVu b ON  b.madv = a.MaDV WHERE a.mads = ?"
                + " GROUP BY b.Ten_Dv, b.Gia_Tien";
        try (Connection con = DbConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, Mads);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                GioHang gh = new GioHang();

                gh.setTenDv(rs.getString("Ten_DV"));
                gh.setSoLuong(rs.getInt("soLuong"));
                gh.setGiaTien(rs.getDouble("Gia_Tien"));

                list.add(gh); 
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
