/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swing.controls;

import javax.swing.JComboBox;

/**
 *
 * @author sethk
 */
public class Combobox<E> extends JComboBox<E> {

    public Combobox() {
        setUI(new ComboSuggestionUI());
    }

}
