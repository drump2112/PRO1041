/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domainModel.HoaDon;
import domainModel.HoaDonCho;
import java.util.List;
import repository.RPHoaDon;

/**
 *
 * @author sethk
 */
public class ServiceHoaDon {

    RPHoaDon RP = new RPHoaDon();

    public List<HoaDonCho> getListBillWait() {
        return RP.getListBillWait();
    }

    public String changeStatus(String id) {
        if (RP.changeStatus(id)) {
            return "Thanh Toán Thành Công";
        } else {
            return "Thanh Toán Không Thành Công";
        }
    }

    public String addHoaDon(HoaDon hd) {
        if (RP.addHoaDon(hd)) {
            return "Thanh Toán Thành Công";
        } else {
            return "Thanh Toán Không Thành Công";
        }
    }

    public String addHoaDonCho(HoaDon hd) {
        if (RP.addHoaDonCho(hd)) {
            return "Thêm Vào Hàng Chờ Thành Công";
        } else {
            return "Thêm Vào Hàng Không Thành Công";
        }
    }

    public List<HoaDonCho> findByMds(String mds) {
        return RP.findByMds(mds);
    }

    public List<HoaDonCho> findByName(String name) {
        return RP.findByName(name);
    }
}
