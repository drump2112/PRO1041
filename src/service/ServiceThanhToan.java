/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import repository.RPThanhToan;

/**
 *
 * @author sethk
 */
public class ServiceThanhToan {
    
    RPThanhToan RP = new RPThanhToan();
    
    public Double TongTien(String maDs) {
        return RP.TongTien(maDs);
    }
    
    public Double giaSan(String mds, int caDa) {
        
        return RP.giaTien(mds, caDa);
    }

    public Double tienDatCoc(String mds) {
        return RP.getTienCoc(mds);
    }
}
