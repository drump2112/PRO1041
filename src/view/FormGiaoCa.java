/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import domainModel.DichVu;
import domainModel.GiaoCa;
import domainModel.GiaoCaCT;
import domainModel.TaiKhoan;
import java.awt.Color;
import global.Global;
import global.Uhelper;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import service.ServiceGiaoCa;
import service.ServiceTaiKhoan;
import view.FormNhanVien;

/**
 *
 * @author sethk
 */
public class FormGiaoCa extends javax.swing.JPanel {

//    private Global gl = new Global();
    private ServiceGiaoCa service = new ServiceGiaoCa();
    LocalDateTime date2 = LocalDateTime.now();
    ServiceTaiKhoan qltk = new ServiceTaiKhoan();
    LocalTime startTime = LocalTime.of(16, 10);
    LocalTime endTime = LocalTime.of(22, 30);

    LocalDateTime currentDateTime = LocalDateTime.now();
    LocalTime currentTime = currentDateTime.toLocalTime();

    /**
     * Creates new form FormGiaoCA
     */
    public FormGiaoCa() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        txtNguoiGiao.setText(Global.getUser());
        txtTienCoc.setEnabled(false);
        txtTongTien.setEnabled(false);
        txtTongDoanhThu.setEnabled(false);
        txtTongTienCacCa.setEnabled(false);

        txtTongTienCacCa.setText(Global.getTienBanGiaoCa() + "");
        if (qltk.DangNhap(Global.getUser(), Global.getPass()).equals("QL")) {
            btnBanGiaoCa.setEnabled(false);
        }

        if (currentTime.isAfter(startTime) && currentTime.isBefore(endTime)) {
            txtNguoiNhan.setEnabled(false);
        }
    }

    public void showChotCa() {
        try {
            GiaoCaCT tongTien = service.getTT(Global.getGioVao(), date2);
            GiaoCaCT tiecCoc = service.getTC(Global.getGioVao(), date2);
            txtTongTien.setText(tongTien.getTongTien() + "");
            txtTienCoc.setText(tiecCoc.getTienCoc() + "");
            txtTongDoanhThu.setText(tongTien.getTongTien() + tiecCoc.getTienCoc() + "");
            GiaoCa gc = service.getlistGC();
            txtTongTienCacCa.setText(gc.getTienTrongCa() + "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean kiemTraDieuKien() {

        if (Uhelper.checkEmpty(txtNguoiGiao, "Không được để trống người giao")) {
            return false;
        }

        if (!(currentTime.isAfter(startTime) && currentTime.isBefore(endTime))) {
            if (Uhelper.checkEmpty(txtNguoiNhan, "Không được để trống người nhận")) {
                return false;
            }
        }

        if (Uhelper.checkEmpty(txtThucTeGiao, "Không được để trống thực tế giao")) {
            return false;
        }
        if (Uhelper.checkEmpty(txtTienCoc, "Không được để trống tiền cọc")) {
            return false;
        }
//        if (Uhelper.checkEmpty(txtTienCuoiCa, "Không được để trống tiền cuối ca")) {
//            return false;
//        }
        if (Uhelper.checkEmpty(txtTongDoanhThu, "Không được để trống tổng doanh thu")) {
            return false;
        }
        if (Uhelper.checkEmpty(txtTongTien, "Không được để trống tổng tiền")) {
            return false;
        }

//        try {
//            Double.parseDouble(txtTienCuoiCa.getText().trim());
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Tiền cuối ca vui lòng nhập số vào");
//            return false;
//        }
        try {
            Double.parseDouble(txtThucTeGiao.getText().trim());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Tiền thực tế bàn giao vui lòng nhập số vào");
            return false;
        }

//        if (Double.parseDouble(txtTongTienCacCa.getText()) != Double.parseDouble(txtThucTeGiao.getText())) {
//            JOptionPane.showMessageDialog(null, "Tiền bàn giao không đủ");
//            return false;
//        }
        //////////////////////////////

        if (service.getListTenTK(txtNguoiNhan.getText()) == null) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập tên đăng nhập đúng của bạn phần người nhận");
            return false;
        }

        if (service.getListTenTK(txtNguoiGiao.getText()) == null) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập tên đăng nhập đúng của bạn phần người giao");
            return false;
        }

        if (txtNguoiGiao.getText().equalsIgnoreCase(txtNguoiNhan.getText())) {
            JOptionPane.showMessageDialog(null, "Tên người nhận và giao không được giống nhau");
            return false;
        }

        if (!(Global.getUser().equalsIgnoreCase(txtNguoiGiao.getText()))) {
            JOptionPane.showMessageDialog(null, "Tên tài khoản người người giao không khớp với tài khoản hiện tại");
            return false;
        }

        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSeth1 = new swing.component.PanelSeth();
        jLabel3 = new javax.swing.JLabel();
        txtTongTien = new swing.controls.TextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTienCoc = new swing.controls.TextField();
        jLabel7 = new javax.swing.JLabel();
        btnChotCa = new swing.controls.Button();
        txtTongDoanhThu = new swing.controls.TextField();
        panelSeth2 = new swing.component.PanelSeth();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtThucTeGiao = new swing.controls.TextField();
        jLabel14 = new javax.swing.JLabel();
        txtNguoiGiao = new swing.controls.TextField();
        jLabel15 = new javax.swing.JLabel();
        txtNguoiNhan = new swing.controls.TextField();
        btnBanGiaoCa = new swing.controls.Button();
        jLabel16 = new javax.swing.JLabel();
        txtTongTienCacCa = new swing.controls.TextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.GridLayout(1, 0));

        panelSeth1.setColor1(new java.awt.Color(142, 142, 250));
        panelSeth1.setColor2(new java.awt.Color(123, 123, 245));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/5.png"))); // NOI18N
        jLabel3.setText("Giao Dịch Trong Ca");

        txtTongTien.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txtTongTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongTienActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Doanh Thu");

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tiền cọc");

        txtTienCoc.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Tổng tiền");

        btnChotCa.setForeground(new java.awt.Color(102, 102, 102));
        btnChotCa.setText("Xem");
        btnChotCa.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnChotCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChotCaActionPerformed(evt);
            }
        });

        txtTongDoanhThu.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txtTongDoanhThu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongDoanhThuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSeth1Layout = new javax.swing.GroupLayout(panelSeth1);
        panelSeth1.setLayout(panelSeth1Layout);
        panelSeth1Layout.setHorizontalGroup(
            panelSeth1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSeth1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(panelSeth1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelSeth1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addGroup(panelSeth1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnChotCa, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelSeth1Layout.createSequentialGroup()
                                .addGroup(panelSeth1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel4))
                                .addGap(84, 84, 84)
                                .addGroup(panelSeth1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTienCoc, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTongDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(panelSeth1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(90, 90, 90)))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        panelSeth1Layout.setVerticalGroup(
            panelSeth1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSeth1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addGroup(panelSeth1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(panelSeth1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTienCoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(panelSeth1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTongDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(btnChotCa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(172, Short.MAX_VALUE))
        );

        add(panelSeth1);

        panelSeth2.setColor1(new java.awt.Color(186, 123, 247));
        panelSeth2.setColor2(new java.awt.Color(123, 123, 245));

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/5.png"))); // NOI18N
        jLabel8.setText("Bàn Giao Ca");

        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Thực Tế Giao");

        txtThucTeGiao.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        jLabel14.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Người Giao");

        txtNguoiGiao.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        jLabel15.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Người Nhận");

        txtNguoiNhan.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txtNguoiNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNguoiNhanActionPerformed(evt);
            }
        });

        btnBanGiaoCa.setForeground(new java.awt.Color(102, 102, 102));
        btnBanGiaoCa.setText("Bàn giao ca");
        btnBanGiaoCa.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnBanGiaoCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBanGiaoCaActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Tổng tiền các ca");

        txtTongTienCacCa.setBackground(new java.awt.Color(255, 153, 153));
        txtTongTienCacCa.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        javax.swing.GroupLayout panelSeth2Layout = new javax.swing.GroupLayout(panelSeth2);
        panelSeth2.setLayout(panelSeth2Layout);
        panelSeth2Layout.setHorizontalGroup(
            panelSeth2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSeth2Layout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSeth2Layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addGroup(panelSeth2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSeth2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtNguoiGiao, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNguoiNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtThucTeGiao, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSeth2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel13)
                        .addComponent(jLabel14)
                        .addComponent(jLabel15)
                        .addGroup(panelSeth2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelSeth2Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(52, 52, 52)
                                .addComponent(txtTongTienCacCa, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnBanGiaoCa, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(67, 67, 67))
        );
        panelSeth2Layout.setVerticalGroup(
            panelSeth2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSeth2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(panelSeth2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTongTienCacCa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(panelSeth2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtThucTeGiao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(panelSeth2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSeth2Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSeth2Layout.createSequentialGroup()
                        .addComponent(txtNguoiGiao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(txtNguoiNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addComponent(btnBanGiaoCa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(171, Short.MAX_VALUE))
        );

        add(panelSeth2);
    }// </editor-fold>//GEN-END:initComponents

    private void btnChotCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChotCaActionPerformed
        if (qltk.DangNhap(Global.getUser(), Global.getPass()).equals("QL")) {
            GiaoCa gc = service.getlistGC();
            txtTongTienCacCa.setText(gc.getTienTrongCa() + "");
            return;
        }
        try {
            int Select = JOptionPane.showConfirmDialog(null, "Bạn có chắc là muốn chốt ca không", "Chốt ca", JOptionPane.YES_NO_CANCEL_OPTION);
            if (JOptionPane.YES_OPTION == Select) {
                showChotCa();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnChotCaActionPerformed

    private void btnBanGiaoCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBanGiaoCaActionPerformed
        LocalDateTime localDate = LocalDateTime.now();

        try {
            if (kiemTraDieuKien()) {
//                GiaoCa gc = new GiaoCa();
//                gc.setNguoiNhan(txtNguoiNhan.getText());
//                gc.setNguoiGiao(txtNguoiGiao.getText());
//                gc.setTienTrongCa(Double.parseDouble(txtTongDoanhThu.getText()));
//                gc.setGioRa(localDate);
//                gc.setGioiVao(Global.getGioVao());
//                boolean bl = service.insertGiaoCa(gc, date2, localDate);
//                if (bl) {
//                    JOptionPane.showMessageDialog(null, "Giao ca thành công");
//                } else {
//                    JOptionPane.showMessageDialog(null, "Giao ca không thành công");
//                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnBanGiaoCaActionPerformed

    private void txtTongDoanhThuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongDoanhThuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongDoanhThuActionPerformed

    private void txtNguoiNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNguoiNhanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNguoiNhanActionPerformed

    private void txtTongTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongTienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongTienActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.controls.Button btnBanGiaoCa;
    private swing.controls.Button btnChotCa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private swing.component.PanelSeth panelSeth1;
    private swing.component.PanelSeth panelSeth2;
    private swing.controls.TextField txtNguoiGiao;
    private swing.controls.TextField txtNguoiNhan;
    private swing.controls.TextField txtThucTeGiao;
    private swing.controls.TextField txtTienCoc;
    private swing.controls.TextField txtTongDoanhThu;
    private swing.controls.TextField txtTongTien;
    private swing.controls.TextField txtTongTienCacCa;
    // End of variables declaration//GEN-END:variables
}
