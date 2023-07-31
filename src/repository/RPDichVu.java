/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import dbConnection.DbConnection;
import domainModel.DichVu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sethk
 */
public class RPDichVu {

    private Connection con = DbConnection.getConnection();

    public List<Double> getListGiaDv() {
        String sql = "select Gia_tien from DichVu";
        List<Double> lst = new ArrayList<>();

        try {
            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet re = pre.executeQuery();
            while (re.next()) {
                lst.add(re.getDouble("Gia_tien"));
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
