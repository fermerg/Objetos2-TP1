package tp1.ejercicio1;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

public class EmailSender {
    private String host = "sandbox.smtp.mailtrap.io";
    private String port = "25";
    private String username = "f6d825a61368e0";
    private String password = "31556cf71f1808";
    private String from = "fernandamerg@gmail.com";
    private String to = "fernandamerg@gmail.com";

    public void enviarEmail() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", this.host);
        props.put("mail.smtp.port", this.port);
        Session session = Session.getInstance(props, new jakarta.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
                        }
                    });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(this.from));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(this.to));
            message.setSubject("Registro exitoso!");
            message.setText("Hola, te has registrado exitosamente en nuestro concurso");
            Transport.send(message);
            System.out.println("Mensaje enviado satisfactoriamente");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}