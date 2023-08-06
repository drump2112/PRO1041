/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domainModel.NhanVien;
import domainModel.TaiKhoan;
import java.util.List;
import repository.RPTaiKhoan;

/**
 *
 * @author sethk
 */

public class ServiceTaiKhoan {

    RPTaiKhoan RP = new RPTaiKhoan();

    public List<TaiKhoan> getListTK() {
        return RP.getListTK();
    }

    public String DangNhap(String user, String pass) {
        return RP.dangNhap(user, pass);
    }

    public String getNameStaff(String user) {
        return RP.getNameStaff(user);
    }

    public String selectIDNV(String user) {
        return RP.selectIDNV(user);
    }

    public NhanVien infoStaff(String id) {
        return RP.infoStaff(id);
    }

    public String doiMatKhau(TaiKhoan tk) {
        if (RP.doiMatKhau(tk)) {
            return "Đổi Mật Khẩu Thành Công !";
        }

        return "Đổi Mật Khẩu Không Thành Công !";
    }
}
