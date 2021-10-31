/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrumxp;

import oru.inf.InfDB;

/**
 *
 * @author jespersundin
 */
public class MailSend {

    private static String userID;
    private static InfDB idb;

    public static void MailSend(InfDB idb, String userID) throws Exception {

        MailSend.idb = idb;
        MailSend.userID = userID;
        String fraga = "Select email from Users where förnamn = '" + SkickaFörfråganMöte.email + "';";
        String svar = idb.fetchSingle(fraga);
        Mail.SendMail(svar);

    }
}
