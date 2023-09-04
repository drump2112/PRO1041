/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package global;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author sethk
 */
public class Uhelper {

    public static boolean checkEmpty(JTextField txt, String mss) {
        if (txt.getText().isEmpty() || txt.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, mss);
            txt.requestFocus();
            return true;
        }
        return false;
    }

    public static boolean CheckSDT(JTextField txt, String mess) {
        String sdt = "0\\d{9}";
        Matcher matcher = Pattern.compile(sdt).matcher(txt.getText().trim());
        if (matcher.matches()) {
            return false;
        }
        JOptionPane.showMessageDialog(null, mess);
        txt.requestFocus();
        return true;
    }

    public static boolean checkKiTuDacBietTruSo(JTextField txt, String mess) {
        if (txt.getText().trim().matches(".*[^0-9a-zA-Z].*")) {
            JOptionPane.showMessageDialog(null, mess);
            return true;
        }
        return false;
    }

    public static boolean checkKiTuDacBietTruDautru(JTextField txt, String mess) {
        if (txt.getText().trim().matches("[!@#$%^&*()_+=|\\\\[\\\\]{};:'\\\",.<>?/\\\\\\\\]+"
        )) {
            JOptionPane.showMessageDialog(null, mess);
            return true;
        }
        return false;
    }

    public static boolean checkKiTuDacBietTruSoVaChu(JTextField txt, String mess) {
        if (txt.getText().trim().matches(".*[^0-9a-zA-Z].*")) {
            JOptionPane.showMessageDialog(null, mess);
            return true;
        }
        return false;
    }

    public static boolean checkKiTuDacBiet(JTextField txt, String mess) {
        if (txt.getText().trim().matches("[a-zA-Z0-9]+")) {
            JOptionPane.showMessageDialog(null, mess);
            return true;
        }
        return false;
    }

    public static boolean checkKiTuDacBietTruDauCach(JTextField txt, String mess) {
        if (txt.getText().trim().matches(".*[^a-zA-Z0-9\\s].*")) {
            JOptionPane.showMessageDialog(null, mess);
            return true;
        }
        return false;
    }

    public static boolean checkEmail(JTextField txt, String mess) {
        String email = "^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$";
        Matcher match = Pattern.compile(email).matcher(txt.getText());
        if (!match.matches()) {
            JOptionPane.showMessageDialog(null, mess);
            return true;
        }
        return false;
    }

    public static boolean checkDoDaiChuoi50(JTextField txt, String mess) {
        if (txt.getText().trim().length() > 50) {
            JOptionPane.showMessageDialog(null, mess);
            return true;
        }
        return false;
    }

    public static boolean checkDoDaiChuoi20(JTextField txt, String mess) {
        if (txt.getText().trim().length() > 20) {
            JOptionPane.showMessageDialog(null, mess);
            return true;
        }
        return false;
    }

    public static boolean checkDoDaiChuoi10(JTextField txt, String mess) {
        if (txt.getText().trim().length() > 10) {
            JOptionPane.showMessageDialog(null, mess);
            return true;
        }
        return false;
    }

    public static boolean checkDoDaiTenKH(JTextField txt, String mess) {
        if (txt.getText().trim().length() < 7) {
            JOptionPane.showMessageDialog(null, mess);
            return true;
        }
        return false;
    }

    public static boolean checkPhaiCo1KhoangTrang(JTextField txt, String mess) {
        int spaceCount = txt.getText().trim().length() - txt.getText().trim().replace(" ", "").length();
        if (spaceCount == 0) {
            JOptionPane.showMessageDialog(null, mess);
            return true;
        }
        return false;
    }

    public static boolean checkCo4KhoangTrang(JTextField txt, String mess) {
        int spaceCount = txt.getText().trim().length() - txt.getText().trim().replace(" ", "").length();
        if (spaceCount > 4) {
            JOptionPane.showMessageDialog(null, mess);
            return true;
        }
        return false;
    }

    public static boolean checkDoDaiChuoiLonHon3(JTextField txt, String mess) {
        if (txt.getText().trim().length() < 4) {
            JOptionPane.showMessageDialog(null, mess);
            return true;
        }
        return false;
    }

    public static boolean checkSoLonHon0(JTextField txt, String mess) {
        if (Integer.parseInt(txt.getText().trim()) == 0) {
            JOptionPane.showMessageDialog(null, mess);
            return true;
        }
        return false;
    }

    public static boolean checkPhaiLaSo(JTextField txt, String mess) {
        try {
            Integer.parseInt(txt.getText().trim());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, mess);
            return true;
        }
        return false;
    }

    public static boolean checkKhongQua100tr(JTextField txt, String mess) {
        if (Integer.parseInt(txt.getText().trim()) > 100000000) {
            JOptionPane.showMessageDialog(null, mess);
            return true;
        }
        return false;
    }

    public static boolean checkKhongQua50chuc(JTextField txt, String mess) {
        if (Integer.parseInt(txt.getText().trim()) < 50000) {
            JOptionPane.showMessageDialog(null, mess);
            return true;
        }
        return false;
    }

    public static boolean checkChuoiKhongQua2DauCach(JTextField txt, String mess) {
        if (txt.getText().trim().matches(".*\\s{2,}.*")) {
            JOptionPane.showMessageDialog(null, mess);
            return true;
        }
        return false;
    }

    public static boolean checkTenNguoiDungKhongCoSo(JTextField txt, String mess) {
        if (!txt.getText().trim().matches("^[\\p{L}\\s'-]+$"
        )) {
            JOptionPane.showMessageDialog(null, mess);
            return true;
        }
        return false;
    }

}
