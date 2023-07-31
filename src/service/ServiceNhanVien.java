/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domainModel.NhanVien;
import java.util.ArrayList;
import repository.RPNhanVien;
import viewModel.QLNhanVien;

/**
 *
 * @author sethk
 */
public class ServiceNhanVien {

    RPNhanVien repo = new RPNhanVien();

    public ArrayList<QLNhanVien> getAllNV() {
        ArrayList<QLNhanVien> lstQLNV = new ArrayList<>();
        ArrayList<NhanVien> lstNV = repo.getListNV();
        for (NhanVien nv : lstNV) {
            QLNhanVien qlnv = new QLNhanVien(
                    nv.getId(),
                    nv.getMa(),
                    nv.getHoTen(), nv.getEmail(),
                    nv.getSdt(), nv.getIdCV(),
                    nv.getDiaChi(), nv.getCmt(),
                    nv.getNgaySinh(), nv.getGioiTinh());
            lstQLNV.add(qlnv);
        }
        return lstQLNV;
    }

    public String addNew(QLNhanVien QLNV) {
        NhanVien nv = new NhanVien(QLNV.getMa(),
                QLNV.getHoTen(),
                QLNV.getEmail(),
                QLNV.getSdt(),
                QLNV.getMaCv(),
                QLNV.getDiaChi(),
                QLNV.getNgaySinh(),
                QLNV.getCmt());
        if (repo.insertNV(nv)) {
            return "Success";
        } else {
            return "failed";
        }
    }

    public String updateNV(String id, QLNhanVien QLNV) {
        NhanVien nv = new NhanVien(
                QLNV.getHoTen(),
                QLNV.getEmail(),
                QLNV.getSdt(),
                QLNV.getMaCv(),
                QLNV.getDiaChi(),
                QLNV.getCmt(),
                QLNV.getNgaySinh(),
                QLNV.getGioiTinh());
        if (repo.updateNV(id, nv)) {
            return "Success";
        } else {
            return "failed";
        }
    }


    public String deleteNV(String id) {
        if (repo.deleteNV(id)) {
            return "Success";
        } else {
            return "failed";
        }
    }
}
