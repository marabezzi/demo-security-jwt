package com.guilherme.vitrine.services;

import com.guilherme.vitrine.models.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class SendEmailService {

  private JavaMailSender javaMailSender;
  @Autowired
  public SendEmailService(JavaMailSender javaMailSender) {
    this.javaMailSender = javaMailSender;

  }

  public void sendNotification(Contact contact) throws MailException{

    StringBuilder sb = new StringBuilder();
    sb.append("Name: " + contact.getContactName()).append(System.lineSeparator());
    sb.append("Email: " + contact.getContactEmail()).append(System.lineSeparator());
    sb.append("Phone: " + contact.getContactPhone()).append(System.lineSeparator());
    sb.append("Cell: " + contact.getContactCell()).append(System.lineSeparator());
    sb.append("Subject: " + contact.getContactMotive()).append(System.lineSeparator());
    sb.append("\n Message: " + contact.getContactMessage());

    SimpleMailMessage mail = new SimpleMailMessage();

    mail.setTo("adm@zezinhotecidos.com.br");
    mail.setFrom("zezinhotecidos@zezinhotecidos.com.br");
    mail.setSubject(contact.getContactMotive());
    mail.setText(sb.toString());

    javaMailSender.send(mail);
  }

}
