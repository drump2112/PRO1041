/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domainModel.KhachHang;
import domainModel.LichDatSanBong;
import domainModel.LichDatSanCT;
import java.util.Date;
import java.util.List;
import repository.RPLichDatSan;

/**
 *
 * @author sethk
 */
public class ServiceLichDatSan {

    RPLichDatSan repo = new RPLichDatSan();

    public List<LichDatSanCT> getList() {
        return repo.getList();
    }

    public List<LichDatSanCT> loadTableDV() {
        return repo.loadTableDV();
    }

    public List<String> loadCB() {
        return repo.loadCB();
    }

    public List<LichDatSanCT> getListSan(String user, Date date) {
        return repo.getListSan(user, date);
    }

    public String addLichDatSan(LichDatSanBong lds, KhachHang kh) {
        if (repo.addLichDatSan(lds, kh)) {
            return "Đặt Sân Thành Công";
        } else {
            return "Đặt Sân Thất Bại";
        }
    }

    public String huySan(String maDs) {
        if (repo.huySan(maDs)) {
            return "Đã Hủy Sân";
        } else {
            return "Hủy Sân Thất Bại";
        }
    }

    public String nhanSan(String id, LichDatSanBong lsd) {
        if (repo.nhanSan(id, lsd)) {
            return "Đã nhận sân";
        } else {
            return "nhân sân thất bại";
        }
    }

    public List<LichDatSanCT> getByMDS(String msd) {
        return repo.getByMDS(msd);
    }

}
