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
        Matcher matcher = Pattern.compile(sdt).matcher(txt.getText());
        if (matcher.matches()) {
            return false;
        }
        JOptionPane.showMessageDialog(null, mess);
        txt.requestFocus();
        return true;
    }

    public static boolean checkSo(JTextField txt) {
        try {
            Integer.parseInt(txt.getText());
        } catch (Exception e) {
            return true;
        }
        return false;

    }
    

}
