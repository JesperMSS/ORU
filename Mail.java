
package scrumxp;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail {
    
    public static void SendMail(String recepient) throws MessagingException{
       Properties  properties = new Properties();

       // Instansierar e-postinställningar
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
       
       // Inställningar för e-postkonto
        String myAccountEmail = "skoloru123@gmail.com";
        String password = "Jordans123";

       // Kontrollerar lösenord och användarnamn 
      Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(myAccountEmail, password);
            }

        });
      Message message = prepareMessage(session, myAccountEmail, recepient);

      Transport.send(message);
    }
      private static Message prepareMessage(Session session, String myAccountEmail, String recepient){
        // Anger mailämne och mailtext
          try {
              Message message = new MimeMessage(session);
              message.setFrom(new InternetAddress(myAccountEmail));
              message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
              message.setSubject("Mötesförfrågning");
              message.setText("Hej! Du är inbjuden till ett möte. Info om mötet : " + SkickaFörfråganMöte.info);
              return message;
        } catch (Exception ex){

          }
          return null;

    }
      }
