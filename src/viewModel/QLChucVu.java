/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewModel;

/**
 *
 * @author sethk
 */
public class QLChucVu {

    private String ma;
    private String tenQLChucVu;

    public QLChucVu() {
    }

    public QLChucVu(String ma, String tenQLChucVu) {
        this.ma = ma;
        this.tenQLChucVu = tenQLChucVu;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTenQLChucVu() {
        return tenQLChucVu;
    }

    public void setTenQLChucVu(String tenQLChucVu) {
        this.tenQLChucVu = tenQLChucVu;
    }
}
