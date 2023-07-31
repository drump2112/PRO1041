/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import dbConnection.DbConnection;
import domainModel.KhachHang;
import domainModel.LichDatSanCT;
import domainModel.LichDatSanBong;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

/**
 *
 * @author sethk
 */
public class RPLichDatSan {

    RPKhachHang repoKH = new RPKhachHang();
    RPTaiKhoan repoTK = new RPTaiKhoan();
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    public List<LichDatSanCT> getList() {
        ArrayList<LichDatSanCT> lst = new ArrayList<>();
//        String sql = "SELECT b.Ma, c.ten as tenSan, c.LoaiSan , a.ten as tenKH, "
//                + " a.SDT , b.ID_CaDa, CONVERT(varchar,ngayDat,103) as ngayDat,d.Ten as tenNV, b.TienDatCoc,b.TrangThai "
//                + " FROM dbo.KhachHang a right JOIN dbo.LichDat_SanBong b ON b.ID_KH = a.ID "
//                + " LEFT JOIN dbo.SanBong c ON c.ID = b.ID_SB left JOIN dbo.NhanVien d ON  d.ID = b.ID_NV";
        String sql = "SELECT b.Ma, c.ten as tenSan, c.LoaiSan , a.ten as tenKH, "
                + " a.SDT , b.ID_CaDa, CONVERT(varchar,ngayDat,103) as ngayDat,d.Ten as tenNV, b.TienDatCoc,b.TrangThai "
                + " FROM dbo.KhachHang a right JOIN dbo.LichDat_SanBong b ON b.ID_KH = a.ID "
                + " LEFT JOIN dbo.SanBong c ON c.ID = b.ID_SB left JOIN dbo.NhanVien d ON  d.ID = b.ID_NV"
                + " where b.NgayDat =convert(nvarchar(50),GETDATE()) or  b.NgayDat > convert(nvarchar(50),GETDATE()) ";
        try (Connection con = DbConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                LichDatSanCT lsd = new LichDatSanCT();

                lsd.setMaDS(rs.getString("Ma"));
                lsd.setTenSan(rs.getString("tenSan"));
                lsd.setLoai(rs.getInt("LoaiSan"));
                lsd.setTenKh(rs.getString("tenKH"));
                lsd.setSdt(rs.getString("sdt"));
                lsd.setCa(rs.getInt("ID_CaDa"));

                java.util.Date date = format.parse(rs.getString("ngayDat"));
                lsd.setNgay(new java.util.Date(date.getTime()));

                lsd.setTenNv(rs.getString("tenNV"));
                lsd.setTienDatCoc(rs.getDouble("TienDatCoc"));
                lsd.setTrangThai(rs.getInt("trangThai"));

                lst.add(lsd);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return lst;
    }

    public List<LichDatSanCT> loadTableDV() {
        ArrayList<LichDatSanCT> lst = new ArrayList<>();
        String sql = "SELECT b.Ma, c.ten as tenSan, a.ten as tenKH, b.TrangThai "
                + " FROM dbo.KhachHang a right JOIN dbo.LichDat_SanBong b ON b.ID_KH = a.ID "
                + " LEFT JOIN dbo.SanBong c ON c.ID = b.ID_SB left JOIN dbo.NhanVien d ON  d.ID = b.ID_NV Where trangThai = 1 OR trangThai = 2";

        try (Connection con = DbConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                LichDatSanCT lsd = new LichDatSanCT();

                lsd.setMaDS(rs.getString("Ma"));
                lsd.setTenSan(rs.getString("tenSan"));
                lsd.setTenKh(rs.getString("tenKH"));
                lsd.setTrangThai(rs.getInt("trangThai"));

                lst.add(lsd);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return lst;
    }

    public List<LichDatSanCT> getByMDS(String msd) {
        List<LichDatSanCT> lst = new ArrayList<>();

        String sql = "	SELECT b.Ma, c.ten as tenSan, c.LoaiSan , a.ten as tenKH, a.SDT , b.id_caDa,"
                + " CONVERT(varchar,ngayDat,103) as ngayDat,d.Ten as tenNV, b.TienDatCoc,b.TrangThai  FROM dbo.KhachHang "
                + " a RIGHT JOIN dbo.LichDat_SanBong b ON b.ID_KH = a.ID LEFT JOIN dbo.SanBong c ON c.ID = b.ID_SB "
                + " left JOIN dbo.NhanVien d ON  d.ID = b.ID_NV where b.ma = ? ";
        try (Connection con = DbConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setObject(1, msd);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LichDatSanCT lsd = new LichDatSanCT();
                lsd.setMaDS(rs.getString("Ma"));
                lsd.setTenSan(rs.getString("tenSan"));
                lsd.setLoai(rs.getInt("LoaiSan"));
                lsd.setTenKh(rs.getString("tenKH"));
                lsd.setSdt(rs.getString("sdt"));
                lsd.setCa(rs.getInt("id_caDa"));
                java.util.Date date2 = format.parse(rs.getString("ngayDat"));
                lsd.setNgay(new java.util.Date(date2.getTime()));
                lsd.setTenNv(rs.getString("tenNV"));
                lsd.setTienDatCoc(Double.parseDouble(String.valueOf(rs.getObject("TienDatCoc"))));
                lsd.setTrangThai(rs.getInt("trangThai"));

                lst.add(lsd);
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<LichDatSanCT> getListSan(String user, Date date) {
        ArrayList<LichDatSanCT> lst = new ArrayList<>();
        String sql = "	SELECT b.Ma, c.ten as tenSan, c.LoaiSan , a.ten as tenKH, a.SDT , b.id_caDa,"
                + " CONVERT(varchar,ngayDat,103) as ngayDat,d.Ten as tenNV, b.TienDatCoc,b.TrangThai  FROM dbo.KhachHang "
                + " a RIGHT JOIN dbo.LichDat_SanBong b ON b.ID_KH = a.ID LEFT JOIN dbo.SanBong c ON c.ID = b.ID_SB "
                + " left JOIN dbo.NhanVien d ON  d.ID = b.ID_NV where c.ten = ? and b.ngayDat = ? ";

        try (Connection con = DbConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            format = new SimpleDateFormat("yyyy-MM-dd");
            ps.setObject(1, user);
            String date1 = format.format(date);
            ps.setObject(2, date1);
            format = new SimpleDateFormat("dd/MM/yyyy");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LichDatSanCT lsd = new LichDatSanCT();

                lsd.setMaDS(rs.getString("Ma"));
                lsd.setTenSan(rs.getString("tenSan"));
                lsd.setLoai(rs.getInt("LoaiSan"));
                lsd.setTenKh(rs.getString("tenKH"));
                lsd.setSdt(rs.getString("sdt"));
                lsd.setCa(rs.getInt("id_caDa"));
                java.util.Date date2 = format.parse(rs.getString("ngayDat"));
                lsd.setNgay(new java.util.Date(date2.getTime()));
                lsd.setTenNv(rs.getString("tenNV"));
                lsd.setTienDatCoc(Double.parseDouble(String.valueOf(rs.getObject("TienDatCoc"))));
                lsd.setTrangThai(rs.getInt("trangThai"));

                lst.add(lsd);

            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return lst;
    }

    public String selectIDKH(String sdt) {
        String sql = "SELECT ID FROM dbo.KhachHang WHERE sdt = ?";
        String id = "";
        try (Connection con = DbConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, sdt);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getString("ID");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public List<String> loadCB() {
        List<String> lst = new ArrayList<>();
        String sql = "Select TenCa FROM caDa";
        try (Connection con = DbConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lst.add(rs.getString("tenCa"));
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String selectIDSB(String ten) {

        String sql = "SELECT id FROM sanbong WHERE ten = ? ";
        String str = "";
        try (Connection con = DbConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ten);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                str = rs.getString("id");
                return str;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public boolean addLichDatSan(LichDatSanBong lds, KhachHang kh) {
        repoKH.addKhachHang(kh);

        String sql = "INSERT INTO LichDat_SanBong(Ma,ID_SB,ID_NV,ID_KH, "
                + " ID_CaDa ,TienDatCoc,TrangThai,NgayDat) VALUES(?,?,?,?,?,?,?,?)";
        try (Connection con = DbConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, lds.getMaDatSan());
            ps.setObject(2, lds.getIdSb());
            ps.setObject(3, lds.getIdNv());
            ps.setObject(4, selectIDKH(kh.getSDT()));
            ps.setObject(5, lds.getCaDa());
            ps.setObject(6, lds.getTienCoc());
            ps.setObject(7, 1);

//            String date1 = format.format(lds.getNgayDat());
            ps.setObject(8, new java.sql.Date(lds.getNgayDat().getTime()));

            int result = ps.executeUpdate();

            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean nhanSan(String id, LichDatSanBong lsd) {
        String sql = "UPDATE LichDat_SanBong SET TrangThai = 2 WHERE CONVERT(DATE, ?) = CONVERT(DATE, GETDATE()) AND Ma = ? ";
        try (Connection con = DbConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, new java.sql.Date(lsd.getNgayDat().getTime()));
            ps.setObject(2, id);
            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean huySan(String id) {
        String sql = "DELETE FROM dbo.LichDat_SanBong WHERE Ma = ? ";
        try (Connection con = DbConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, id);
            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
