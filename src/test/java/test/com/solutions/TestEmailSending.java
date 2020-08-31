package test.com.solutions;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class TestEmailSending {

    public static void main (String[] a) throws MessagingException {
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", false);
        prop.put("mail.smtp.starttls.enable", "false");
        prop.put("mail.smtp.host", "localhost");
        prop.put("mail.smtp.port", "2525");

        Session session = Session.getInstance( prop );
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("evboxteam@billinghouse.nl"));
        message.setRecipients(
                Message.RecipientType.TO, InternetAddress.parse("shantonav.sen@billinghouse.nl"));
        message.setSubject("Mail test Subject");

        String msg = "This is my first email using JavaMailer";

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(msg, "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);

        message.setContent(multipart);

        Transport.send(message);
    }
}
