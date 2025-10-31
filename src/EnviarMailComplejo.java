


import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;



public class EnviarMailComplejo
{
    /**
     * @param args se ignoran
     */
    void Envie(String to)
    {
        try
        {
          // se obtiene el objeto Session. La configuración es para
          // una cuenta de gmail.
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.ionos.es");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", "sat@copiadorascostaluz.com");
            

            Session session = Session.getDefaultInstance(props, null);
            // session.setDebug(true);

            // Se compone la parte del texto
            BodyPart texto = new MimeBodyPart();
            texto.setText("Factura Copiadoras Costaluz");

            // Se compone el adjunto con la imagen
            BodyPart adjunto = new MimeBodyPart();
            adjunto.setDataHandler(
                new DataHandler(new FileDataSource("C:\\Facturas\\FacturasConQr\\"+Inicio.NumeroFactura.getText().trim()+".pdf")));
            System.out.println("C:\\Facturas\\FacturasConQr\\"+Inicio.NumeroFactura.getText().trim()+".pdf");
            adjunto.setFileName(Inicio.NumeroFactura.getText().trim()+".pdf");

            // Una MultiParte para agrupar texto e imagen.
            MimeMultipart multiParte = new MimeMultipart();
            multiParte.addBodyPart(texto);
            multiParte.addBodyPart(adjunto);

            // Se compone el correo, dando to, from, subject y el
            // contenido.
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("admon@copiadorascostaluz.com"));
            message.addRecipient(
                Message.RecipientType.TO,
                new InternetAddress(to));
            message.setSubject("Factura numero "+Inicio.NumeroFactura.getText().trim());
            message.setContent(multiParte);

            try ( // Se envia el correo.
                    Transport t = session.getTransport("smtp")) {
                t.connect("sat@copiadorascostaluz.com", "Sat1971");
                t.sendMessage(message, message.getAllRecipients());
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}