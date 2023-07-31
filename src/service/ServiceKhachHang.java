/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domainModel.KhachHang;
import java.util.ArrayList;
import repository.RPKhachHang;
import viewModel.QLKhachHang;

/**
 *
 * @author sethk
 */
public class ServiceKhachHang {

    RPKhachHang repo = new RPKhachHang();

    public String addKhachHang(KhachHang kh) {
        if (repo.addKhachHang(kh)) {
            return "Thêm Khách hàng Thành Công";
        }
        return "them khong thanh cong";
    }

    public ArrayList<QLKhachHang> getAllKH() {
        ArrayList<QLKhachHang> lstQLKH = new ArrayList<>();
        ArrayList<KhachHang> lstkh = repo.getListKH();
        for (KhachHang kh : lstkh) {
            QLKhachHang qlkh = new QLKhachHang(kh.getId(), kh.getMa(), kh.getTen(), kh.getSDT());
            lstQLKH.add(qlkh);
        }
        return lstQLKH;
    }

    public String addNew(QLKhachHang QLkH) {
        KhachHang kh = new KhachHang(QLkH.getMa(), QLkH.getTen(), QLkH.getSDT());
        if (repo.addKhachHang(kh)) {
            return "Success";
        } else {
            return "failed";
        }
    }

    public String updateKH(String id, QLKhachHang QLkH) {
        KhachHang kh = new KhachHang(QLkH.getMa(), QLkH.getTen(), QLkH.getSDT());
        if (repo.updateKH(id, kh)) {
            return "Success";
        } else {
            return "failed";
        }
    }

    public String deleteKH(String id) {
        if (repo.deleteKH(id)) {
            return "Success";
        } else {
            return "failed";
        }
    }
}
