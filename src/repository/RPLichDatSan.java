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
import javax.swing.JOptionPane;

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
        String sql = "SELECT b.Ma, c.ten as tenSan, c.LoaiSan , a.ten as tenKH, \n"
                + "                                a.SDT , b.ID_CaDa, CONVERT(varchar,ngayDa,103) as ngayDa,d.Ten as tenNV, b.TienDatCoc,b.TrangThai \n"
                + "                                FROM dbo.KhachHang a \n"
                + "								right JOIN dbo.LichDat_SanBong b ON b.ID_KH = a.ID \n"
                + "                                LEFT JOIN dbo.SanBong c ON c.ID = b.ID_SB \n"
                + "								left JOIN dbo.NhanVien d ON  d.ID = b.ID_NV \n"
                + "								JOIN caDa on caDa.id = b.ID_CaDa\n"
                + "                                where (b.TrangThai =1 or b.TrangThai =2) \n"
                + "								and b.NgayDa = CONVERT(DATE, GETDATE()) \n"
                + "								and CONVERT(TIME, GETDATE()) < caDa.GioMuonTT or b.NgayDa > GETDATE() and b.TrangThai !=3";

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

                java.util.Date date = format.parse(rs.getString("ngayDa"));
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

    public boolean changeStatusDS(String id) {
        Connection c = DbConnection.getConnection();

        String sql = "UPDATE dbo.LichDat_SanBong SET TrangThai = 3 WHERE ma = ? ";

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
   

    public List<LichDatSanCT> loadTableDV() {
        ArrayList<LichDatSanCT> lst = new ArrayList<>();
        String sql = "SELECT b.Ma, c.ten as tenSan, b.ID_CaDa ,c.LoaiSan, a.ten as tenKH, b.TrangThai "
                + " FROM dbo.KhachHang a right JOIN dbo.LichDat_SanBong b ON b.ID_KH = a.ID "
                + " LEFT JOIN dbo.SanBong c ON c.ID = b.ID_SB left JOIN dbo.NhanVien d ON  d.ID = b.ID_NV Where trangThai = 2";

        try (Connection con = DbConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                LichDatSanCT lsd = new LichDatSanCT();

                lsd.setMaDS(rs.getString("Ma"));
                lsd.setTenSan(rs.getString("tenSan"));
                lsd.setTenKh(rs.getString("tenKH"));
                lsd.setTrangThai(rs.getInt("trangThai"));
                lsd.setCa(rs.getInt("ID_CaDa"));
                lsd.setLoai(rs.getInt("LoaiSan"));

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
                + " CONVERT(varchar,ngayDa,103) as ngayDa,d.Ten as tenNV, b.TienDatCoc,b.TrangThai  FROM dbo.KhachHang "
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
                java.util.Date date2 = format.parse(rs.getString("ngayDa"));
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
        String sql = "	SELECT b.Ma, c.ten as tenSan, c.LoaiSan , a.ten as tenKH, a.SDT , b.id_caDa,dbo.caDa.gioBD , gioKT,\n"
                + "                 CONVERT(varchar,ngayDa,103) as ngayDa,d.Ten as tenNV, b.TienDatCoc,b.TrangThai  FROM dbo.KhachHang \n"
                + "                a RIGHT JOIN dbo.LichDat_SanBong b ON b.ID_KH = a.ID LEFT JOIN dbo.SanBong c ON c.ID = b.ID_SB \n"
                + "               left JOIN dbo.NhanVien d ON  d.ID = b.ID_NV JOIN caDa on caDa.id = b.ID_CaDa where (b.TrangThai = 2 or b.TrangThai = 1) and (c.ten = ? and b.NgayDa = ? and GETDATE() < ?) \n"
                + "               or (c.ten = ? and b.NgayDa = ? and (CONVERT(DATE, GETDATE()) = ? and CONVERT(TIME, GETDATE()) < caDa.GioMuonTT))";

        try (Connection con = DbConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            format = new SimpleDateFormat("yyyy-MM-dd");
            ps.setObject(1, user);
            String date1 = format.format(date);
            ps.setObject(2, date1);
            ps.setObject(3, date1);
            ps.setObject(4, user);
            ps.setObject(5, date1);
            ps.setObject(6, date1);

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
                java.util.Date date2 = format.parse(rs.getString("ngayDa"));
                lsd.setNgay(new java.util.Date(date2.getTime()));
                lsd.setTenNv(rs.getString("tenNV"));
                lsd.setTienDatCoc(Double.parseDouble(String.valueOf(rs.getObject("TienDatCoc"))));
                lsd.setTrangThai(rs.getInt("trangThai"));
                lsd.setGioBD(rs.getTime("gioBD"));
                lsd.setGioKT(rs.getTime("gioKT"));
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
                + " ID_CaDa ,TienDatCoc,TrangThai,NgayDa) VALUES(?,?,?,?,?,?,?,?)";
        try (Connection con = DbConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, lds.getMaDatSan());
            ps.setObject(2, lds.getIdSb());
            ps.setObject(3, lds.getIdNv());
            ps.setObject(4, selectIDKH(kh.getSDT()));
            ps.setObject(5, lds.getCaDa());
            ps.setObject(6, lds.getTienCoc());
            ps.setObject(7, 1);

//            String date1 = format.format(lds.getNgayDa());
            ps.setObject(8, new java.sql.Date(lds.getNgayDa().getTime()));

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

    public boolean checkTrung(String maSan, Date ngayDa, String tenSan, int caDa) {
        java.sql.Connection con = DbConnection.getConnection();
        String sql = "select lds.Ma m, lds.ID_CaDa cd ,CONVERT(varchar,lds.ngayDa,103) nd, sb.Ten as T from LichDat_SanBong lds join SanBong sb on lds.ID_SB = sb.ID where  ( lds.ID_CaDa = ? and lds.NgayDa = ? and sb.Ten = ?) or lds.Ma = ?";
        try {
            java.sql.PreparedStatement pts = con.prepareStatement(sql);
            pts.setObject(1, caDa);
            pts.setObject(2, new java.sql.Date(ngayDa.getTime()));
            pts.setObject(3, tenSan);
            pts.setObject(4, maSan);
            java.sql.ResultSet rs = pts.executeQuery();
            if (rs.next()) {
                LichDatSanCT lich = new LichDatSanCT();
                lich.setMaDS(rs.getString("m"));
                Date date = format.parse(rs.getString("nd"));
                lich.setNgay(new java.util.Date(date.getTime()));
                lich.setTenSan(rs.getString("T"));
                lich.setCa(rs.getInt("cd"));
                if (lich.getMaDS().equals(maSan)) {
                    JOptionPane.showMessageDialog(null, "Mã đặt sân đã có rồi");
                    return true;
                }

                String date1 = format.format(lich.getNgay());
                String date2 = format.format(ngayDa);

                if (lich.getTenSan().equalsIgnoreCase(tenSan) && lich.getCa() == caDa && date1.equalsIgnoreCase(date2)) {
                    JOptionPane.showMessageDialog(null, "Lịch cửa sân này đã có rồi");
                    return true;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean kiemTraThoiGianNhanCa(LichDatSanBong lsd) {
        String sql = "SELECT * From caDa C WHERE id = ? and CONVERT(TIME, GETDATE()) BETWEEN C.gioBD AND C.GioMuonTT AND CONVERT(DATE,?) = CONVERT(DATE, GETDATE())";
        try {
            Connection con = DbConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, lsd.getCaDa());
            ps.setObject(2, new java.sql.Date(lsd.getNgayDa().getTime()));
            ResultSet re = ps.executeQuery();
            while (re.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void nhanSan(String id, LichDatSanBong lsd) {
        if (kiemTraThoiGianNhanCa(lsd)) {
            String sql = "UPDATE LichDat_SanBong SET TrangThai = 2 WHERE Ma = ? ";
            try (Connection con = DbConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setObject(1, id);
                int result = ps.executeUpdate();
                if (result > 0) {
                    JOptionPane.showMessageDialog(null, "Nhận sân thành công");
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        JOptionPane.showMessageDialog(null, "Bạn không thể nhận sân vào giờ này (Hay ngày đá không phải hôm nay)");
        return;
    }
}
