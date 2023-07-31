/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domainModel.GioHang;
import java.util.List;
import repository.RPGioHang;

/**
 *
 * @author sethk
 */
public class ServiceGioHang {

    RPGioHang RP = new RPGioHang();

    public void addGioHang(List<GioHang> list) {
        for (GioHang gh : list) {
            RP.addGioHang(gh);
        }
    }

    public List<GioHang> getListOrder(String Mads) {
        return RP.getListOrder(Mads);
    }
}
