/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrumxp;

/**
 *
 * @author jespersundin
 */

import oru.inf.InfDB;
import oru.inf.InfException; 
import java.util.logging.Level;
import java.util.logging.Logger;

public class ScrumXP {

    /**
     * @param args the command line arguments
     * 
     */
    
    private static InfDB idb; 
    
    public static void main(String[] args) throws InfException {
        // TODO code application logic here
        
        try{
            idb = new InfDB("mibdb", "3306", "mibdba", "mibkey");
        } catch (InfException ex){
            Logger.getLogger(ScrumXP.class.getName()).log(Level.SEVERE , null, ex);
        }
        
    new LoginForm().setVisible(true); 
        
    }
    
}
