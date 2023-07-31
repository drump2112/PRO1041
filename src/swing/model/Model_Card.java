/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swing.model;

import java.awt.Color;
import javax.swing.Icon;
import javax.swing.JPanel;

/**
 *
 * @author sethk
 */
public class Model_Card  {
    private Icon icon;
    private String title;
    private String value;
    private String desciption;

    public Model_Card() {
    }

    public Model_Card(Icon icon, String title, String value, String desciption) {
        this.icon = icon;
        this.title = title;
        this.value = value;
        this.desciption = desciption;
    }

    
    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }
        
    
}
