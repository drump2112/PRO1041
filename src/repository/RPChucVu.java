/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import dbConnection.DbConnection;
import domainModel.ChucVu;
import java.util.ArrayList;

/**
 *
 * @author sethk
 */
public class RPChucVu {

    private Connection con = DbConnection.getConnection();

    public ArrayList<ChucVu> getListCV() {
        String sql = "select * from ChucVu";
        ArrayList<ChucVu> list = new ArrayList<>();
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet re = pre.executeQuery();
            while (re.next()) {
                ChucVu cv = new ChucVu();
                cv.setMa(re.getString("Ma"));
                cv.setTenChucVu(re.getString("TenChucVu"));
                list.add(cv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
