package scrumxp;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jacob
 */
public class Validering {

    public static boolean textNotEmpty(JTextField tf) {
        // Metod för att kontrollera att text är ifyllt
        if (tf.getText().isEmpty()) {
            tf.requestFocus();
            return false;
        }
        return true;
    }

    public static boolean textAreaNotEmpty(JTextArea area) {
        // Metod för att kontrollera att ett textfällt är ifyllt
        if (area.getText().isEmpty()) {
            area.requestFocus();
            return false;
        }
        return true;
    }

    public static boolean valideraPassword(String password) {
        // Metod för att kontrollera att lösenordet inte är för långt, eller tomt. 
        if (password.length() > 10) {
            JOptionPane.showMessageDialog(null, "Lösenordet är för långt, max 10 tecken");
            return false;
        }
        if (password.isBlank()) {
            JOptionPane.showMessageDialog(null, "Vänligen ange ett lösenord.");
            return false;
        }
        return true;
    }

    public static boolean checkPassword(JPasswordField tf) {
        // Metod för att kontrollera a
        boolean svar = true;

        if (tf.getPassword().length == 0) {
            JOptionPane.showMessageDialog(null, "Vänligen ange ett lösenord.");
            tf.requestFocusInWindow();
            svar = false;
        }
        return svar;
    }

    public boolean containsIllegals(String toExamine) {
        // Metod för att kontrollera att endast tillåtna tecken används. 
        Pattern pattern = Pattern.compile("QWERTYUIOPÅSASDFGHJKLÖÖASDFGHJKLÖÄZXCVBNMqwertyuiopåasdfghjklöäzxcvbnm,.-");
        Matcher matcher = pattern.matcher(toExamine);
        // returns false if a illegal character is find in the string 
        return !matcher.find();
    }

    public static boolean isUnique(String toCheck, ArrayList<String> list) {
        for (String item : list) {
            if (item.equals(toCheck)) {
                return false;
            }
        }
        return true;

    }

    public static boolean valideraDatum(String password) {
        // Metod som kontrollerar att datum är angett i rätt format. 
        if (password.length() > 5) {
            JOptionPane.showMessageDialog(null, "Ange tid i formatet XX:XX.");
            return false;
        }
        if (password.isBlank()) {
            JOptionPane.showMessageDialog(null, "Vänligen ange en start- eller sluttid.");
            return false;
        }
        return true;
    }

    public static boolean jdatePickempty(datechooser.beans.DateChooserCombo datepicker) {
        // Metod som kontrollerarr att jDatepick är ifyllt. 
        String datum = datepicker.getText();
        return !datum.isEmpty();
    }

    public static boolean checkLogout() {
        // Metod som dubbelkollar ifall användaren vill logga ut. 
        boolean answer = false;
        String[] opt = {"Ja", "Nej"};       //används för att kunna skriva egna alternativ på svenska.
        int n = JOptionPane.showOptionDialog(null,
                "Är du säker på att du vill logga ut?",
                "Logga ut",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, opt, opt[0]);
        if (n == JOptionPane.YES_OPTION) {
            answer = true;
        } else if (n == JOptionPane.NO_OPTION) {
            answer = false;
        }
        return answer;
    }
}
