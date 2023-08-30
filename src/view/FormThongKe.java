/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import dbConnection.DbConnection;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import swing.chart.ModelPieChart;
import swing.chart.PieChart;
import swing.swing.ScrollBar;

/**
 *
 * @author sethk
 */
public class FormThongKe extends javax.swing.JPanel {

    /**
     * Creates new form FormThongKe
     */
    public FormThongKe() {

        initComponents();

        spTable.setVerticalScrollBar(new ScrollBar());
        spTable.getVerticalScrollBar().setBackground(Color.WHITE);
        spTable.getViewport().setBackground(Color.WHITE);

        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);

        pieChart.setChartType(PieChart.PeiChartType.DONUT_CHART);

//        pieChart.addData(new ModelPieChart("Tigher", 150, new Color(23, 126, 238)));
//        pieChart.addData(new ModelPieChart("ABC", 100, new Color(221, 65, 65)));
//        pieChart.addData(new ModelPieChart("Coca", 1, new Color(47, 157, 64)));
//        pieChart.addData(new ModelPieChart("Vita", 60, new Color(196, 151, 58)));
    }

    private void showData(int month, int year) {
        String sql = "SELECT c.LoaiSan, SUM(a.TongTien)  AS tongtien FROM dbo.HoaDon a LEFT JOIN dbo.LichDat_SanBong b ON  b.Ma = a.Ma_LichDatSan LEFT JOIN  dbo.SanBong c ON c.ID = b.ID_SB   "
                + " WHERE MONTH(a.NgayThanhToan) = ? AND YEAR(a.NgayThanhToan) = ? GROUP BY c.LoaiSan";
        try (Connection con = DbConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            pieChart.clearData();
            int index = 0;
            ps.setObject(1, month);
            ps.setObject(2, year);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String loaiSan = String.valueOf(rs.getInt("LoaiSan"));
                double value = rs.getDouble("tongtien");
                pieChart.addData(new ModelPieChart(loaiSan, value, getColor(index++)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Color getColor(int index) {
        Color[] color = new Color[]{new Color(52, 148, 203), new Color(175, 67, 237), new Color(87, 218, 137)};

        return color[index];
    }

//    private String getTenSan(int index) {
//        String[] String = new String[]{"Sân 5", "Sân 7", "Sân 11"};
//
//        return String[index];
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSeth1 = new swing.component.PanelSeth();
        txtYear = new com.toedter.calendar.JYearChooser();
        txtMonth = new com.toedter.calendar.JMonthChooser();
        button1 = new swing.controls.Button();
        line = new javax.swing.JPanel();
        spTable = new javax.swing.JScrollPane();
        table1 = new swing.swing.Table();
        pieChart = new swing.chart.PieChart();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1125, 584));

        panelSeth1.setColor1(new java.awt.Color(87, 218, 137));
        panelSeth1.setColor2(new java.awt.Color(0, 0, 0));

        txtYear.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N

        txtMonth.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N

        button1.setText("Kết quả");
        button1.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        line.setBackground(new java.awt.Color(255, 255, 255));
        line.setPreferredSize(new java.awt.Dimension(0, 1));

        javax.swing.GroupLayout lineLayout = new javax.swing.GroupLayout(line);
        line.setLayout(lineLayout);
        lineLayout.setHorizontalGroup(
            lineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 308, Short.MAX_VALUE)
        );
        lineLayout.setVerticalGroup(
            lineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelSeth1Layout = new javax.swing.GroupLayout(panelSeth1);
        panelSeth1.setLayout(panelSeth1Layout);
        panelSeth1Layout.setHorizontalGroup(
            panelSeth1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSeth1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(txtMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
            .addGroup(panelSeth1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelSeth1Layout.createSequentialGroup()
                    .addGap(73, 73, 73)
                    .addComponent(line, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                    .addGap(73, 73, 73)))
        );
        panelSeth1Layout.setVerticalGroup(
            panelSeth1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSeth1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panelSeth1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelSeth1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtMonth, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                        .addComponent(txtYear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(panelSeth1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelSeth1Layout.createSequentialGroup()
                    .addGap(55, 55, 55)
                    .addComponent(line, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        spTable.setBorder(null);

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Loại Sân", "Tỷ Lệ", "Doanh Thu"
            }
        ));
        spTable.setViewportView(table1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(pieChart, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(spTable, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                    .addComponent(panelSeth1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(71, 71, 71))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pieChart, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelSeth1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130)
                        .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
        int month = txtMonth.getMonth() + 1;
        int year = txtYear.getYear();

        showData(month, year);
    }//GEN-LAST:event_button1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.controls.Button button1;
    private javax.swing.JPanel line;
    private swing.component.PanelSeth panelSeth1;
    private swing.chart.PieChart pieChart;
    private javax.swing.JScrollPane spTable;
    private swing.swing.Table table1;
    private com.toedter.calendar.JMonthChooser txtMonth;
    private com.toedter.calendar.JYearChooser txtYear;
    // End of variables declaration//GEN-END:variables
}
