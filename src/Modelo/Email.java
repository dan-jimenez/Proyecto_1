/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 *
 * @author kevin
 */
public class Email {
    private String remitente;
    private String password;
    private String mensaje;
    private String asunto;
    private String destinatario;
    
    public Email() {
        
    }

    public Email(String remitente, String password, String mensaje, String asunto, String destinatario) {
        this.remitente = remitente;
        this.password = password;
        this.mensaje = mensaje;
        this.asunto = asunto;
        this.destinatario = destinatario;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }
    
    
    public void enviarCorreo(){
      //Es necesario un correo electronico para poder enviar los mensajes
        String correoEnvia = remitente; //el cual se incluye el nombre
        String passW = password;           //y la contraseña
        String destino=destinatario;
        Properties propiedad = new Properties();
        propiedad.put("mail.smtp.host", "smtp.gmail.com");
        propiedad.put("mail.smtp.starttls.enable", "true");
        propiedad.put("mail.smtp.port", "587");
        propiedad.put("mail.smtp.auth", "true");
        propiedad.put("mail.smtp.user", correoEnvia);
        propiedad.put("mail.smtp.clave", passW);
        propiedad.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        
        Session sesion = Session.getDefaultInstance(propiedad);
        
        //aqui se hace algo tipo inicio de sesion
        MimeMessage mail = new MimeMessage(sesion);
        
        try {
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress(destino));
            mail.setSubject(asunto);
            mail.setText(mensaje);
            
            Transport transporte= sesion.getTransport("smtp");
            transporte.connect("smtp.gmail.com", correoEnvia, passW);
            transporte.sendMessage(mail, mail.getAllRecipients());
            transporte.close();
            System.out.println("correo enviado");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
