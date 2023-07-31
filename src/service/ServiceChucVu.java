/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domainModel.ChucVu;
import java.util.ArrayList;
import repository.RPChucVu;
import viewModel.QLChucVu;

/**
 *
 * @author sethk
 */
public class ServiceChucVu {

    private RPChucVu repo = new RPChucVu();

    public ArrayList<QLChucVu> getList() {
        ArrayList<QLChucVu> list = new ArrayList<>();
        for (ChucVu cv : repo.getListCV()) {
            QLChucVu qLChucVu = new QLChucVu(cv.getMa(), cv.getTenChucVu());
            list.add(qLChucVu);
        }
        return list;
    }
}
