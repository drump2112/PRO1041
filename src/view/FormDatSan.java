/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import domainModel.KhachHang;
import domainModel.LichDatSanBong;
import domainModel.LichDatSanCT;
import global.Uhelper;
import swing.swing.ScrollBar;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import repository.RPLichDatSan;
import repository.RPTaiKhoan;
import service.ServiceLichDatSan;
import swing.model.StatusType;
import textfield.SearchOptinEvent;
import textfield.SearchOption;

/**
 *
 * @author sethk
 */
public class FormDatSan extends javax.swing.JPanel {

    DefaultTableModel model;
    DefaultComboBoxModel model1;
    int index = -1;
    RPLichDatSan repoLDS = new RPLichDatSan();
    RPTaiKhoan repoTK = new RPTaiKhoan();
    ServiceLichDatSan qlds = new ServiceLichDatSan();
    String check = null;

    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    /**
     * Creates new form FormDatSan
     */
    public FormDatSan() {
        initComponents();
        txtDate.setBackground(new Color(0, 0, 0, 0));
        spTable.setVerticalScrollBar(new ScrollBar());
        cboCaDa.setBackground(new Color(0, 0, 0, 0));
        spTable.getVerticalScrollBar().setBackground(Color.WHITE);
        spTable.getViewport().setBackground(Color.WHITE);
        this.setBackground(new Color(0, 0, 0, 0));
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        txtSearch.addEventOptionSelected(new SearchOptinEvent() {
            @Override
            public void optionSelected(SearchOption so, int i) {
                txtSearch.setHint("Tìm theo " + so.getName() + "...");
            }

        });

        txtSearch.addOption(new SearchOption("Mã ĐS", new ImageIcon(getClass().getResource("/icon/qr.png"))));
        txtSearch.addOption(new SearchOption("Trạng Thái", new ImageIcon(getClass().getResource("/icon/name.png"))));

        loadCB(qlds.loadCB());
        fillTable(qlds.getList());

    }

    void fillTable(List<LichDatSanCT> list) {
        model = (DefaultTableModel) tbDatSan.getModel();
        model.setRowCount(0);

        for (LichDatSanCT lsd : list) {
            model.addRow(new Object[]{
                lsd.getMaDS(),
                lsd.getTenSan(),
                lsd.getLoai(),
                lsd.getTenKh(),
                lsd.getSdt(),
                lsd.getCa(),
                format.format(lsd.getNgay()),
                lsd.getTenNv(),
                lsd.getTienDatCoc(),
                lsd.getTrangThai() == 0 ? StatusType.EMPTY : (lsd.getTrangThai() == 1 ? StatusType.RESERVED : StatusType.USING)
            });
        }
    }

    void loadCB(List<String> list) {
        model1 = (DefaultComboBoxModel) cboCaDa.getModel();
        for (String str : list) {
            model1.addElement(str);
        }
    }

    KhachHang readFormKh() {
        return new KhachHang(txtHotenKh.getText(), txtSdtKH.getText());
    }

    LichDatSanBong readForm() {
        String idsb = repoLDS.selectIDSB(check);
        return new LichDatSanBong(txtMaDs.getText(),
                idsb,
                repoTK.selectIDNV(global.Global.getUser()),
                repoLDS.selectIDKH(txtSdtKH.getText()),
                Double.parseDouble(txtTienCoc.getText()),
                cboCaDa.getSelectedIndex() + 1,
                txtDate.getDate());
    }

    boolean check() {
        if (Uhelper.checkEmpty(txtHotenKh, "Họ Tên Khách Hàng Trống!")) {
            return false;
        }
        if (Uhelper.checkEmpty(txtSdtKH, "SĐT Khách Hàng Trống!")) {
            return false;
        }
        if (Uhelper.checkEmpty(txtMaDs, "Mã Đặt Sân Trống!")) {
            return false;
        }
        if (Uhelper.checkSo(txtTienCoc) && txtTienCoc.getText().trim().length() != 0) {
            JOptionPane.showMessageDialog(this, "Tiền là Số");
            return false;
        }
        if (check == null || check.equals("")) {
            JOptionPane.showMessageDialog(this, "Chọn Sân Muốn Đặt");
            return false;
        }
        if (txtDate.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Chọn Ngày Muốn Đặt Sấn");
            return false;
        }
        return true;
    }

    boolean checkCaDa() {
        LocalTime date = LocalTime.now();
        DateTimeFormatter DTF = DateTimeFormatter.ofPattern("H:mm");
        String h = DTF.format(date);

        LocalTime startTime = LocalTime.parse("06:16");
        LocalTime endTime = LocalTime.of(8, 0);

        LocalTime startTime2 = LocalTime.parse("08:16");
        LocalTime endTime2 = LocalTime.of(10, 0);

        LocalTime startTime3 = LocalTime.parse("10:16");
        LocalTime endTime3 = LocalTime.of(12, 0);

        LocalTime startTime4 = LocalTime.parse("14:16");
        LocalTime endTime4 = LocalTime.of(16, 0);

        LocalTime startTime5 = LocalTime.parse("16:16");
        LocalTime endTime5 = LocalTime.of(18, 0);

        LocalTime startTime6 = LocalTime.parse("18:16");
        LocalTime endTime6 = LocalTime.of(20, 0);

        LocalTime startTime7 = LocalTime.parse("20:16");
        LocalTime endTime7 = LocalTime.of(22, 0);

        if (cboCaDa.getSelectedItem().equals("ca 1")) {
            if (date.isAfter(startTime)) {
                return false;
            }
        }

        if (cboCaDa.getSelectedItem().equals("ca 2")) {
            if (date.isAfter(startTime2)) {
                JOptionPane.showMessageDialog(null, "Đã quá giờ của ca 2");
                return false;
            }
        }

        if (cboCaDa.getSelectedItem().equals("ca 3")) {
            if (date.isAfter(startTime3)) {
                JOptionPane.showMessageDialog(null, "Đã quá giờ của ca 3");
                return false;
            }
        }

        if (cboCaDa.getSelectedItem().equals("ca 4")) {
            if (date.isAfter(startTime4)) {
                JOptionPane.showMessageDialog(null, "Đã quá giờ của ca 4");
                return false;
            }
        }
        if (cboCaDa.getSelectedItem().equals("ca 5")) {
            if (date.isAfter(startTime5)) {
                JOptionPane.showMessageDialog(null, "Đã quá giờ của ca 5");
                return false;
            }
        }

        if (cboCaDa.getSelectedItem().equals("ca 6")) {
            if (date.isAfter(startTime6)) {
                JOptionPane.showMessageDialog(null, "Đã quá giờ của ca 6");
                return false;
            }
        }

        if (cboCaDa.getSelectedItem().equals("ca 7")) {
            if (date.isAfter(startTime7)) {
                JOptionPane.showMessageDialog(null, "Đã quá giờ của ca 7");
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

        panelBorder1 = new swing.swing.PanelBorder();
        spTable = new javax.swing.JScrollPane();
        tbDatSan = new swing.swing.Table();
        jLabel1 = new javax.swing.JLabel();
        txtDate = new com.toedter.calendar.JDateChooser();
        button1 = new swing.controls.Button();
        panelSeth4 = new swing.component.PanelSeth();
        lbSan5A = new javax.swing.JLabel();
        lbSan5B = new javax.swing.JLabel();
        lbSan5C = new javax.swing.JLabel();
        lbSan7A = new javax.swing.JLabel();
        lbSan7B = new javax.swing.JLabel();
        lbSan7C = new javax.swing.JLabel();
        lbSan11A = new javax.swing.JLabel();
        lbSan11B = new javax.swing.JLabel();
        lbSan11C = new javax.swing.JLabel();
        panelSeth1 = new swing.component.PanelSeth();
        btnDatSan = new swing.controls.ButtonGradient();
        btnHuySan = new swing.controls.ButtonGradient();
        btnNhanSan = new swing.controls.ButtonGradient();
        btnNhanSan1 = new swing.controls.ButtonGradient();
        panelSeth3 = new swing.component.PanelSeth();
        jLabel2 = new javax.swing.JLabel();
        txtHotenKh = new swing.controls.TextField();
        txtSdtKH = new swing.controls.TextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMaDs = new swing.controls.TextField();
        jLabel7 = new javax.swing.JLabel();
        cboCaDa = new swing.controls.Combobox();
        jLabel8 = new javax.swing.JLabel();
        txtTienCoc = new swing.controls.TextField();
        txtSearch = new textfield.TextFieldSearchOption();

        setBackground(new java.awt.Color(255, 255, 255));

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        spTable.setBorder(null);

        tbDatSan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã ĐS", "Tên Sân", "Loại", "Khách Hàng", "SĐT", "Ca", "Ngày", "Nhân Viên", "Tiền Cọc", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbDatSan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDatSanMouseClicked(evt);
            }
        });
        spTable.setViewportView(tbDatSan);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("Danh Sách Đặt Sân");

        button1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/rl.png"))); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 1188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );

        panelSeth4.setColor1(new java.awt.Color(28, 181, 224));
        panelSeth4.setColor2(new java.awt.Color(241, 208, 62));

        lbSan5A.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lbSan5A.setForeground(new java.awt.Color(255, 255, 0));
        lbSan5A.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/sb1.png"))); // NOI18N
        lbSan5A.setText("Sân 5-A");
        lbSan5A.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbSan5AMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbSan5AMouseEntered(evt);
            }
        });

        lbSan5B.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lbSan5B.setForeground(new java.awt.Color(255, 255, 0));
        lbSan5B.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/sb1.png"))); // NOI18N
        lbSan5B.setText("Sân 5-B");
        lbSan5B.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbSan5BMouseClicked(evt);
            }
        });

        lbSan5C.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lbSan5C.setForeground(new java.awt.Color(255, 255, 0));
        lbSan5C.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/sb1.png"))); // NOI18N
        lbSan5C.setText("Sân 5-C");
        lbSan5C.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbSan5CMouseClicked(evt);
            }
        });

        lbSan7A.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lbSan7A.setForeground(new java.awt.Color(255, 255, 255));
        lbSan7A.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/sb1.png"))); // NOI18N
        lbSan7A.setText("Sân 7-A");
        lbSan7A.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbSan7AMouseClicked(evt);
            }
        });

        lbSan7B.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lbSan7B.setForeground(new java.awt.Color(255, 255, 255));
        lbSan7B.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/sb1.png"))); // NOI18N
        lbSan7B.setText("Sân 7-B");
        lbSan7B.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbSan7BMouseClicked(evt);
            }
        });

        lbSan7C.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lbSan7C.setForeground(new java.awt.Color(255, 255, 255));
        lbSan7C.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/sb1.png"))); // NOI18N
        lbSan7C.setText("Sân 7-C");
        lbSan7C.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbSan7CMouseClicked(evt);
            }
        });

        lbSan11A.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lbSan11A.setForeground(new java.awt.Color(28, 181, 224));
        lbSan11A.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/sb1.png"))); // NOI18N
        lbSan11A.setText("Sân 11-A");
        lbSan11A.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbSan11AMouseClicked(evt);
            }
        });

        lbSan11B.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lbSan11B.setForeground(new java.awt.Color(28, 181, 224));
        lbSan11B.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/sb1.png"))); // NOI18N
        lbSan11B.setText("Sân 11-B");
        lbSan11B.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbSan11BMouseClicked(evt);
            }
        });

        lbSan11C.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lbSan11C.setForeground(new java.awt.Color(28, 181, 224));
        lbSan11C.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/sb1.png"))); // NOI18N
        lbSan11C.setText("Sân 11-C");
        lbSan11C.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbSan11CMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelSeth4Layout = new javax.swing.GroupLayout(panelSeth4);
        panelSeth4.setLayout(panelSeth4Layout);
        panelSeth4Layout.setHorizontalGroup(
            panelSeth4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSeth4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelSeth4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbSan11A)
                    .addComponent(lbSan7A)
                    .addComponent(lbSan5A))
                .addGap(101, 101, 101)
                .addGroup(panelSeth4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbSan5B)
                    .addComponent(lbSan11B)
                    .addComponent(lbSan7B))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addGroup(panelSeth4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbSan7C)
                    .addComponent(lbSan5C)
                    .addComponent(lbSan11C))
                .addGap(17, 17, 17))
        );
        panelSeth4Layout.setVerticalGroup(
            panelSeth4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSeth4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelSeth4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSan5A)
                    .addComponent(lbSan5B)
                    .addComponent(lbSan5C))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(panelSeth4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSan7A)
                    .addComponent(lbSan7B)
                    .addComponent(lbSan7C))
                .addGap(31, 31, 31)
                .addGroup(panelSeth4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSan11A)
                    .addComponent(lbSan11B)
                    .addComponent(lbSan11C))
                .addGap(27, 27, 27))
        );

        panelSeth1.setColor1(new java.awt.Color(241, 208, 62));
        panelSeth1.setColor2(new java.awt.Color(211, 184, 61));

        btnDatSan.setText("Đặt Sân");
        btnDatSan.setColor1(new java.awt.Color(57, 106, 252));
        btnDatSan.setColor2(new java.awt.Color(36, 36, 62));
        btnDatSan.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnDatSan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatSanActionPerformed(evt);
            }
        });

        btnHuySan.setText("Hủy Sân");
        btnHuySan.setColor1(new java.awt.Color(57, 106, 252));
        btnHuySan.setColor2(new java.awt.Color(36, 36, 62));
        btnHuySan.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnHuySan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuySanActionPerformed(evt);
            }
        });

        btnNhanSan.setText("Nhận Sân");
        btnNhanSan.setColor1(new java.awt.Color(57, 106, 252));
        btnNhanSan.setColor2(new java.awt.Color(36, 36, 62));
        btnNhanSan.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnNhanSan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanSanActionPerformed(evt);
            }
        });

        btnNhanSan1.setText("Trả Sân");
        btnNhanSan1.setColor1(new java.awt.Color(57, 106, 252));
        btnNhanSan1.setColor2(new java.awt.Color(36, 36, 62));
        btnNhanSan1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnNhanSan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanSan1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSeth1Layout = new javax.swing.GroupLayout(panelSeth1);
        panelSeth1.setLayout(panelSeth1Layout);
        panelSeth1Layout.setHorizontalGroup(
            panelSeth1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSeth1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelSeth1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDatSan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelSeth1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnNhanSan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHuySan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNhanSan1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        panelSeth1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnDatSan, btnNhanSan});

        panelSeth1Layout.setVerticalGroup(
            panelSeth1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSeth1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnDatSan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNhanSan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNhanSan1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnHuySan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        panelSeth1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnDatSan, btnNhanSan});

        panelSeth3.setColor1(new java.awt.Color(142, 142, 250));
        panelSeth3.setColor2(new java.awt.Color(123, 123, 245));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/8.png"))); // NOI18N
        jLabel2.setText("Thông Tin Khách Hàng");

        txtHotenKh.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txtHotenKh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHotenKhActionPerformed(evt);
            }
        });

        txtSdtKH.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txtSdtKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSdtKHActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Họ Tên");

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("SĐT");

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Mã ĐS");

        txtMaDs.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txtMaDs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaDsActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Ca Đá");

        cboCaDa.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Cọc");

        txtTienCoc.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txtTienCoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienCocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSeth3Layout = new javax.swing.GroupLayout(panelSeth3);
        panelSeth3.setLayout(panelSeth3Layout);
        panelSeth3Layout.setHorizontalGroup(
            panelSeth3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSeth3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSeth3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSeth3Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cboCaDa, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelSeth3Layout.createSequentialGroup()
                        .addGroup(panelSeth3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelSeth3Layout.createSequentialGroup()
                                .addGroup(panelSeth3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelSeth3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelSeth3Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(39, 39, 39))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSeth3Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(panelSeth3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtSdtKH, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtMaDs, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtHotenKh, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(panelSeth3Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtTienCoc, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelSeth3Layout.setVerticalGroup(
            panelSeth3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSeth3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSeth3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHotenKh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(panelSeth3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSdtKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(panelSeth3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaDs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSeth3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTienCoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(panelSeth3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboCaDa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        txtSearch.setColorOverlay1(new java.awt.Color(69, 104, 220));
        txtSearch.setColorOverlay2(new java.awt.Color(176, 106, 179));
        txtSearch.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txtSearch.setHint("Tìm Kiếm...");
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelSeth4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panelSeth3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelSeth1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelSeth4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelSeth1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(panelSeth3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {panelSeth3, panelSeth4});

    }// </editor-fold>//GEN-END:initComponents

    private void txtHotenKhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHotenKhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHotenKhActionPerformed

    private void txtSdtKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSdtKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSdtKHActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtSearchActionPerformed

    private void btnDatSanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatSanActionPerformed
        if (check() && checkCaDa()) {
            JOptionPane.showMessageDialog(this, qlds.addLichDatSan(readForm(), readFormKh()));
            fillTable(qlds.getList());
        }
    }//GEN-LAST:event_btnDatSanActionPerformed

    private void btnHuySanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuySanActionPerformed
        // TODO add your handling code here:
        String id = tbDatSan.getValueAt(index, 0).toString();
        JOptionPane.showMessageDialog(this, qlds.huySan(id));
        fillTable(qlds.getList());

    }//GEN-LAST:event_btnHuySanActionPerformed

    private void btnNhanSanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanSanActionPerformed
        // TODO add your handling code here:
        try {
            String id = tbDatSan.getValueAt(index, 0).toString();
            String getND = tbDatSan.getValueAt(index, 6).toString();
            Date ND = format.parse(getND);
            LichDatSanBong lsd = new LichDatSanBong(ND);
            JOptionPane.showMessageDialog(this, qlds.nhanSan(id, lsd));
            fillTable(qlds.getList());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnNhanSanActionPerformed

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
        if (txtSearch.isSelected()) {
            int option = txtSearch.getSelectedIndex();

            if (option == 0) {
                fillTable(qlds.getByMDS(txtSearch.getText()));
            } else {
                fillTable(qlds.getList());
            }
        }
    }//GEN-LAST:event_txtSearchKeyPressed

    private void txtMaDsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaDsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaDsActionPerformed

    private void btnNhanSan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanSan1ActionPerformed
        // TODO add your handling code here

    }//GEN-LAST:event_btnNhanSan1ActionPerformed

    private void lbSan5AMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSan5AMouseClicked
        // TODO add your handling code here:
        if (txtDate.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Chọn Ngày Tháng");
        } else {
            check = lbSan5A.getText().trim();
            fillTable(qlds.getListSan(lbSan5A.getText().trim(), txtDate.getDate()));
        }
    }//GEN-LAST:event_lbSan5AMouseClicked

    private void lbSan5BMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSan5BMouseClicked
        // TODO add your handling code here:\
        if (txtDate.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Chọn Ngày Tháng");
        } else {
            check = lbSan5B.getText().trim();
            fillTable(qlds.getListSan(lbSan5B.getText().trim(), txtDate.getDate()));
        }
    }//GEN-LAST:event_lbSan5BMouseClicked

    private void lbSan5CMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSan5CMouseClicked
        // TODO add your handling code here:
        if (txtDate.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Chọn Ngày Tháng");
        } else {
            check = lbSan5C.getText().trim();
            fillTable(qlds.getListSan(lbSan5C.getText().trim(), txtDate.getDate()));
        }
    }//GEN-LAST:event_lbSan5CMouseClicked

    private void lbSan7AMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSan7AMouseClicked
        // TODO add your handling code here:
        if (txtDate.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Chọn Ngày Tháng");
        } else {
            check = lbSan7A.getText().trim();
            fillTable(qlds.getListSan(lbSan7A.getText().trim(), txtDate.getDate()));
        }

    }//GEN-LAST:event_lbSan7AMouseClicked

    private void lbSan7BMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSan7BMouseClicked
        // TODO add your handling code here:
        if (txtDate.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Chọn Ngày Tháng");
        } else {
            check = lbSan7B.getText().trim();
            fillTable(qlds.getListSan(lbSan7B.getText().trim(), txtDate.getDate()));
        }

    }//GEN-LAST:event_lbSan7BMouseClicked

    private void lbSan7CMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSan7CMouseClicked
        // TODO add your handling code here:
        if (txtDate.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Chọn Ngày Tháng");
        } else {
            check = lbSan7C.getText().trim();
            fillTable(qlds.getListSan(lbSan7C.getText().trim(), txtDate.getDate()));
        }
    }//GEN-LAST:event_lbSan7CMouseClicked

    private void lbSan11AMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSan11AMouseClicked
        // TODO add your handling code here:
        if (txtDate.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Chọn Ngày Tháng");
        } else {
            check = lbSan11A.getText().trim();
            fillTable(qlds.getListSan(lbSan11A.getText().trim(), txtDate.getDate()));
        }
    }//GEN-LAST:event_lbSan11AMouseClicked

    private void lbSan11BMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSan11BMouseClicked
        // TODO add your handling code here:
        if (txtDate.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Chọn Ngày Tháng");
        } else {
            check = lbSan11B.getText().trim();
            fillTable(qlds.getListSan(lbSan11B.getText().trim(), txtDate.getDate()));
        }
    }//GEN-LAST:event_lbSan11BMouseClicked

    private void lbSan11CMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSan11CMouseClicked
        // TODO add your handling code here:

        if (txtDate.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Chọn Ngày Tháng");
        } else {
            check = lbSan11C.getText().trim();
            fillTable(qlds.getListSan(lbSan11C.getText().trim(), txtDate.getDate()));
        }
    }//GEN-LAST:event_lbSan11CMouseClicked

    private void txtTienCocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienCocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTienCocActionPerformed

    private void tbDatSanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDatSanMouseClicked
        // TODO add your handling code here:
        index = tbDatSan.getSelectedRow();
    }//GEN-LAST:event_tbDatSanMouseClicked

    private void lbSan5AMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSan5AMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lbSan5AMouseEntered

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
        fillTable(qlds.getList());
    }//GEN-LAST:event_button1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.controls.ButtonGradient btnDatSan;
    private swing.controls.ButtonGradient btnHuySan;
    private swing.controls.ButtonGradient btnNhanSan;
    private swing.controls.ButtonGradient btnNhanSan1;
    private swing.controls.Button button1;
    private swing.controls.Combobox cboCaDa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lbSan11A;
    private javax.swing.JLabel lbSan11B;
    private javax.swing.JLabel lbSan11C;
    private javax.swing.JLabel lbSan5A;
    private javax.swing.JLabel lbSan5B;
    private javax.swing.JLabel lbSan5C;
    private javax.swing.JLabel lbSan7A;
    private javax.swing.JLabel lbSan7B;
    private javax.swing.JLabel lbSan7C;
    private swing.swing.PanelBorder panelBorder1;
    private swing.component.PanelSeth panelSeth1;
    private swing.component.PanelSeth panelSeth3;
    private swing.component.PanelSeth panelSeth4;
    private javax.swing.JScrollPane spTable;
    private swing.swing.Table tbDatSan;
    private com.toedter.calendar.JDateChooser txtDate;
    private swing.controls.TextField txtHotenKh;
    private swing.controls.TextField txtMaDs;
    private swing.controls.TextField txtSdtKH;
    private textfield.TextFieldSearchOption txtSearch;
    private swing.controls.TextField txtTienCoc;
    // End of variables declaration//GEN-END:variables
}
