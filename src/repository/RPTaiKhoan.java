/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import dbConnection.DbConnection;
import domainModel.NhanVien;
import domainModel.TaiKhoan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sethk
 */
public class RPTaiKhoan {

    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    public List<TaiKhoan> getListTK() {
        Connection c = DbConnection.getConnection();
        List<TaiKhoan> lst = new ArrayList<>();
        String sql = "SELECT * FROM dbo.TaiKhoan";
        try {
            PreparedStatement pts = c.prepareStatement(sql);
            ResultSet rs = pts.executeQuery();
            while (rs.next()) {
                TaiKhoan tk = new TaiKhoan();
                tk.setEmail(rs.getString("Email"));
                tk.setMatKhau(rs.getString("MatKhau"));
                tk.setIdcv(rs.getString("macv"));
                tk.setId(rs.getString("ID_NV"));
                tk.setSdt(rs.getString("SDT"));
                tk.setTenDangNhap(rs.getString("TenDangNhap"));

                lst.add(tk);
            }
            return lst;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String dangNhap(String user, String pass) {
        Connection c = DbConnection.getConnection();
        String maCv;
        String sql = " SELECT MaCV FROM dbo.TaiKhoan WHERE tenDangNhap COLLATE SQL_Latin1_General_Cp850_CS_AS LIKE  ? COLLATE SQL_Latin1_General_Cp850_CS_AS AND matKhau COLLATE SQL_Latin1_General_Cp850_CS_AS LIKE ? COLLATE SQL_Latin1_General_Cp850_CS_AS";
        try {
            PreparedStatement pts = c.prepareStatement(sql);
            pts.setString(1, user);
            pts.setString(2, pass);
            ResultSet rs = pts.executeQuery();
            if (rs.next()) {
                maCv = rs.getString("MaCV");
                return maCv;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Fail";
    }

    public String selectIDNV(String user) {
        Connection c = DbConnection.getConnection();
        String idnv = "";
        String sql = "SELECT NhanVien.ID FROM dbo.TaiKhoan   JOIN dbo.NhanVien ON  NhanVien.ID = TaiKhoan.id_nv WHERE TenDangNhap = ? ";
        try {
            PreparedStatement pts = c.prepareStatement(sql);
            pts.setObject(1, user);
            ResultSet rs = pts.executeQuery();
            if (rs.next()) {
                idnv = rs.getString("ID");
                return idnv;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Fail";
    }

    public NhanVien infoStaff(String id) {
        Connection c = DbConnection.getConnection();
        String sql = "SELECT Ma, Ten, Email, SDT, Ma_CV , Diachi, CMT, CONVERT(varchar,NgaySinh,103) as NgaySinh, GioiTinh FROM nhanvien WHERE id = ?";
        try {
            PreparedStatement pts = c.prepareStatement(sql);
            pts.setObject(1, id);
            ResultSet rs = pts.executeQuery();

            if (rs.next()) {
                java.util.Date date = format.parse(rs.getString("NgaySinh"));

                return new NhanVien(rs.getString("Ma"),
                        rs.getString("Ten"),
                        rs.getString("Email"),
                        rs.getString("SDT"),
                        rs.getString("Ma_CV"),
                        rs.getString("Diachi"),
                        rs.getString("CMT"),
                        new java.util.Date(date.getTime()),
                        rs.getString("GioiTinh"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean doiMatKhau(TaiKhoan tk) {
        Connection c = DbConnection.getConnection();
        String sql = " UPDATE dbo.TaiKhoan SET MatKhau = ? WHERE TenDangNhap =?  ";

        try {
            PreparedStatement pts = c.prepareStatement(sql);
            pts.setString(1, tk.getMatKhau());
            pts.setString(2, tk.getTenDangNhap());

            int i = pts.executeUpdate();
            return i > 0;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public String getNameStaff(String user) {

        Connection c = DbConnection.getConnection();

        String sql = " SELECT NhanVien.ten as ten FROM dbo.TaiKhoan JOIN dbo.NhanVien ON  NhanVien.ID = TaiKhoan.id_nv WHERE TenDangNhap =  ? ";

        try {
            PreparedStatement pts = c.prepareStatement(sql);

            pts.setObject(1, user);

            ResultSet rs = pts.executeQuery();

            while (rs.next()) {
                return rs.getString("ten");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;

    }

    public static void main(String[] args) {
        RPTaiKhoan rp = new RPTaiKhoan();
        System.out.println(rp.getNameStaff("toitq2002"));
    }
}
