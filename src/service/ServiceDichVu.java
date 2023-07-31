/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import repository.RPDichVu;

/**
 *
 * @author sethk
 */
public class ServiceDichVu {

    RPDichVu repo = new RPDichVu();

    public List<Double> getListGiaDv() {
        return repo.getListGiaDv();
    }
    
    
}
