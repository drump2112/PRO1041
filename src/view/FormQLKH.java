/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import service.ServiceKhachHang;
import swing.swing.ScrollBar;
import viewModel.QLKhachHang;

/**
 *
 * @author sethk
 */
public class FormQLKH extends javax.swing.JPanel {

    int index = -1;
    ServiceKhachHang sv = new ServiceKhachHang();
    DefaultTableModel model;

    /**
     * Creates new form FormQLKH
     */
    public FormQLKH() {
        initComponents();
        panelMain.setBackground(new Color(0, 0, 0, 0));
        spTable.setVerticalScrollBar(new ScrollBar());
        spTable.getVerticalScrollBar().setBackground(Color.WHITE);
        spTable.getViewport().setBackground(Color.WHITE);
        this.setBackground(new Color(0, 0, 0, 0));
        panelButton.setBackground(new Color(0, 0, 0, 0));

        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        loadData(sv.getAllKH());
    }

    public void loadData(ArrayList<QLKhachHang> lstQLKH) {
        model = (DefaultTableModel) tbKhachHang.getModel();
        model.setRowCount(0);
        for (QLKhachHang qlKH : lstQLKH) {
            model.addRow(new Object[]{
                qlKH.getTen(),
                qlKH.getSDT(),
                qlKH.getMa()});
        }
    }

    public void clear() {
        txtSdt.setText("");
        txtmakh.setText("");
        txtmakh.setText("");
    }

    public void showIndex() {
        QLKhachHang kh = sv.getAllKH().get(index);
        txtSdt.setText(kh.getSDT());
        txtmakh.setText(kh.getTen());
        txtmakh.setText(kh.getMa());
        tbKhachHang.setRowSelectionInterval(index, index);
    }

    public boolean check() {
        if (txtSdt.getText().trim().isEmpty() || txtmakh.getText().trim().isEmpty() || txtmakh.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống thông tin");
            return false;
        }
        if (txtmakh.getText().length() > 50) {
            JOptionPane.showMessageDialog(this, "Mã phải không quá 50 ký tự");
            return false;
        }
        if (txtSdt.getText().length() != 10) {
            JOptionPane.showMessageDialog(this, "SĐT phải đủ 10 số");
            return false;
        }
        ArrayList<QLKhachHang> lst = sv.getAllKH();
        for (QLKhachHang qLKhachHang : lst) {
            if (txtmakh.getText().equalsIgnoreCase(qLKhachHang.getMa())) {
                JOptionPane.showMessageDialog(this, "Trùng Mã KH");
                return false;
            }
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

        panelSeth4 = new swing.component.PanelSeth();
        jLabel2 = new javax.swing.JLabel();
        spTable = new javax.swing.JScrollPane();
        tbKhachHang = new swing.swing.Table();
        panelButton = new swing.swing.PanelBorder();
        btnThem = new swing.controls.Button();
        btnSua = new swing.controls.Button();
        btnXoa = new swing.controls.Button();
        panelMain = new swing.swing.PanelBorder();
        txtSdt = new swing.controls.TextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtmakh = new swing.controls.TextField();
        jLabel4 = new javax.swing.JLabel();
        txtTenKh = new swing.controls.TextField();

        setPreferredSize(new java.awt.Dimension(1079, 586));

        panelSeth4.setColor1(new java.awt.Color(28, 181, 224));
        panelSeth4.setColor2(new java.awt.Color(0, 0, 70));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/customerpng.png"))); // NOI18N
        jLabel2.setText(" Quản Lý Khách Hàng");

        tbKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Họ Tên", "SĐT", "Loại KH"
            }
        ));
        spTable.setViewportView(tbKhachHang);

        btnThem.setForeground(new java.awt.Color(102, 102, 102));
        btnThem.setText("Thêm");
        btnThem.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setForeground(new java.awt.Color(102, 102, 102));
        btnSua.setText("Sửa");
        btnSua.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setForeground(new java.awt.Color(102, 102, 102));
        btnXoa.setText("Xóa");
        btnXoa.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelButtonLayout = new javax.swing.GroupLayout(panelButton);
        panelButton.setLayout(panelButtonLayout);
        panelButtonLayout.setHorizontalGroup(
            panelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        panelButtonLayout.setVerticalGroup(
            panelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        panelMain.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        txtSdt.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("SĐT");

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Họ & Tên");

        txtmakh.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Mã KH");

        txtTenKh.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMainLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
            .addGroup(panelMainLayout.createSequentialGroup()
                .addGap(195, 195, 195)
                .addComponent(jLabel4)
                .addGap(41, 41, 41)
                .addComponent(txtmakh, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(387, Short.MAX_VALUE))
            .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelMainLayout.createSequentialGroup()
                    .addGap(153, 153, 153)
                    .addComponent(txtTenKh, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(515, Short.MAX_VALUE)))
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmakh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(66, Short.MAX_VALUE))
            .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelMainLayout.createSequentialGroup()
                    .addGap(52, 52, 52)
                    .addComponent(txtTenKh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(138, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout panelSeth4Layout = new javax.swing.GroupLayout(panelSeth4);
        panelSeth4.setLayout(panelSeth4Layout);
        panelSeth4Layout.setHorizontalGroup(
            panelSeth4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSeth4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(400, 400, 400))
            .addGroup(panelSeth4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panelSeth4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSeth4Layout.createSequentialGroup()
                        .addComponent(panelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99))
                    .addGroup(panelSeth4Layout.createSequentialGroup()
                        .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 1119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 41, Short.MAX_VALUE))))
        );
        panelSeth4Layout.setVerticalGroup(
            panelSeth4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSeth4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSeth4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSeth4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSeth4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        try {
            if (check()) {
                String ma = txtmakh.getText();
                String ten = txtTenKh.getText();
                String sdt = txtSdt.getText();
                QLKhachHang kh = new QLKhachHang(ma, ten, sdt);
                JOptionPane.showMessageDialog(this, sv.addNew(kh));
                clear();
                loadData(sv.getAllKH());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        try {
            if (check()) {
                String id = sv.getAllKH().get(index).getId();
                String ma = txtmakh.getText();
                String ten = txtTenKh.getText();
                String sdt = txtSdt.getText();
                QLKhachHang kh = new QLKhachHang(ma, ten, sdt);
                JOptionPane.showMessageDialog(this, sv.updateKH(id, kh));
                clear();
                loadData(sv.getAllKH());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Chọn Khách Hàng Muốn Sửa");
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        try {
            String id = sv.getAllKH().get(index).getId();
            JOptionPane.showMessageDialog(this, sv.deleteKH(id));
            clear();
            loadData(sv.getAllKH());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Chọn Khách Hàng Cần Xóa");
        }
    }//GEN-LAST:event_btnXoaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.controls.Button btnSua;
    private swing.controls.Button btnThem;
    private swing.controls.Button btnXoa;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private swing.swing.PanelBorder panelButton;
    private swing.swing.PanelBorder panelMain;
    private swing.component.PanelSeth panelSeth4;
    private javax.swing.JScrollPane spTable;
    private swing.swing.Table tbKhachHang;
    private swing.controls.TextField txtSdt;
    private swing.controls.TextField txtTenKh;
    private swing.controls.TextField txtmakh;
    // End of variables declaration//GEN-END:variables
}
