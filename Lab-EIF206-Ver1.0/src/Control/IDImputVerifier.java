/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 *
 * @author edva5
 */
public class IDImputVerifier extends InputVerifier{

    @Override
    public boolean verify(JComponent input) {
        String text = ((JTextField) input).getText();
        try {           
            return (text.length() <= 9); 
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
}
