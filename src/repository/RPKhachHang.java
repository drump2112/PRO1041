/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import dbConnection.DbConnection;
import domainModel.KhachHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author sethk
 */
public class RPKhachHang {

    DbConnection dbConnection;

    public boolean addKhachHang(KhachHang kh) {
        String sql = "INSERT INTO dbo.KhachHang(Ma,Ten,SDT)VALUES(?,?,?)";

        try (Connection con = DbConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, kh.getMa());
            ps.setObject(2, kh.getTen());
            ps.setObject(3, kh.getSDT());
            int result = ps.executeUpdate();

            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<KhachHang> getListKH() {
        String sql = "select * from KhachHang";
        ArrayList<KhachHang> lstKH = new ArrayList<>();
        try {
            Connection con = dbConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang(); 
                kh.setId(rs.getString("Id"));
                kh.setMa(rs.getString("Ma"));
                kh.setTen(rs.getString("Ten"));
                kh.setSDT(rs.getString("SDT"));
                lstKH.add(kh);
            }
            return lstKH;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean insertKH(KhachHang kh) {
        String sql = "insert into KhachHang(Ma,Ten,SDT,Email) values(?,?,?,?)";
        try {
            Connection con = dbConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, kh.getMa());
            ps.setObject(2, kh.getTen());
            ps.setObject(3, kh.getSDT());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateKH(String id, KhachHang kh) {
        String sql = "update KhachHang setTen=?,SDT=?,Email=? where Ma = ?";
        try {
            Connection con = dbConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, kh.getTen());
            ps.setObject(2, kh.getSDT());
            ps.setObject(4, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteKH(String id) {
        String sql = "DELETE FROM KhachHang WHERE ma = ?";
        try {
            Connection con = dbConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
