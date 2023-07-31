/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domainModel.SanBong;
import java.util.ArrayList;
import repository.RPSanBong;
import viewModel.QLSanBong;

/**
 *
 * @author Quan Lew
 */
public class ServiceSanBong {

    RPSanBong repo = new RPSanBong();

    public ArrayList<QLSanBong> getList() {
        ArrayList<QLSanBong> lstSB = new ArrayList<>();
        for (SanBong qLSanBong : repo.getListSB()) {
            QLSanBong qlsb = new QLSanBong(qLSanBong.getId(), qLSanBong.getMa(), qLSanBong.getTenSan(), qLSanBong.getGia(), qLSanBong.getGia2(), qLSanBong.getLoaiSan());
            lstSB.add(qlsb);
        }
        return lstSB;

    }

    public String addSB(QLSanBong qlsb) {
        SanBong sb = new SanBong(qlsb.getMa(), qlsb.getTenSan(), qlsb.getGia(), qlsb.getGia2(), qlsb.getLoaiSan());
        if (repo.addSB(sb)) {
            return "Thêm sân bóng thành công";
        } else {
            return "Thêm sân bóng thất bại";
        }

    }

    public String updateSB(QLSanBong qlsb, String id) {
        SanBong sb = new SanBong(qlsb.getMa(), qlsb.getTenSan(), qlsb.getGia(), qlsb.getGia2(), qlsb.getLoaiSan());
        if (repo.updateSB(sb, id)) {
            return "Sửa sân bóng thành công";
        } else {
            return "Sửa sân bóng thất bại thất bại";
        }
    }

    public String deleteSB(String id) {
        if (repo.deleteSB(id)) {
            return "Xóa sân bóng thành công";
        }
        return "Xóa sân bóng thất bại";
    }
}
