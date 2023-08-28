/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package global;

import domainModel.Bill;
import domainModel.HoaDon;
import java.time.LocalDateTime;

/**
 *
 * @author sethk
 */
public class Global {

    public static String user = "";

    public static String pass;

    public static String idnv = "";

    public static Bill bill;

    public static LocalDateTime gioVao;

    public static double tienBanGiaoCa;

    public static double tongSoTienHD_GetDate;

    public static double tongSoTienCoc_GetDate;

    public static boolean keyChucNang = true;

    public Global() {
    }

    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        Global.user = user;
    }

    public static Bill getBill() {
        return bill;
    }

    public static void setBill(Bill bill) {
        Global.bill = bill;
    }

    public static String getIdnv() {
        return idnv;
    }

    public static void setIdnv(String idnv) {
        Global.idnv = idnv;
    }

    public static String getPass() {
        return pass;
    }

    public static void setPass(String pass) {
        Global.pass = pass;
    }

    public static LocalDateTime getGioVao() {
        return gioVao;
    }

    public static void setGioVao(LocalDateTime gioVao) {
        Global.gioVao = gioVao;
    }

    public static double getTienBanGiaoCa() {
        return tienBanGiaoCa;
    }

    public static void setTienBanGiaoCa(double tienBanGiaoCa) {
        Global.tienBanGiaoCa = tienBanGiaoCa;
    }

    public static double getTongSoTienHD_GetDate() {
        return tongSoTienHD_GetDate;
    }

    public static void setTongSoTienHD_GetDate(double tongSoTienHD_GetDate) {
        Global.tongSoTienHD_GetDate = tongSoTienHD_GetDate;
    }

    public static double getTongSoTienCoc_GetDate() {
        return tongSoTienCoc_GetDate;
    }

    public static void setTongSoTienCoc_GetDate(double tongSoTienCoc_GetDate) {
        Global.tongSoTienCoc_GetDate = tongSoTienCoc_GetDate;
    }

    public static boolean isKeyChucNang() {
        return keyChucNang;
    }

    public static void setKeyChucNang(boolean keyChucNang) {
        Global.keyChucNang = keyChucNang;
    }

}
