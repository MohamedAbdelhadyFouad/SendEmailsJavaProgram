package emailapp;

import javax.mail.PasswordAuthentication;
import java.util.Properties;
import javax.mail.AuthenticationFailedException;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSend {

    public static void sendEmail(String recepint) throws MessagingException {

        Properties prop = new Properties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        String myAccount = "Your Email";        // your Email
        String password = " Your Email password";      // your email password
        //String recepient=recepint;

        Session se = Session.getInstance(prop, new Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                
                 return new PasswordAuthentication(myAccount, password);
               

            }
        });

        Message message = prepareMessage(se, myAccount, recepint);
        Transport.send(message);
        System.out.println("Message sent successfully");
    }

    private static Message prepareMessage(Session se, String myAccount, String recepient) {
        Message msg = new MimeMessage(se);
        
        try {
            msg.setFrom(new InternetAddress(myAccount));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            msg.setSubject("Subject title "); // Here you can write the title, of your email
            msg.setText("Your message");   // here  you can write  your message 
            return msg;
        } catch (MessagingException ex) {
            System.out.println("there is smth wrong");
        }
        return null;
    }
}
