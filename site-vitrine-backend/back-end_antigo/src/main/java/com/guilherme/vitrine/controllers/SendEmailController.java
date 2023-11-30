package com.guilherme.vitrine.controllers;

import com.guilherme.vitrine.models.Contact;
import com.guilherme.vitrine.services.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api"})
public class SendEmailController {
  @Autowired
  private SendEmailService sendEmailService;

  @RequestMapping({"/contact"})
  public boolean signupSuccess(@RequestBody Contact contact) {

     /*  Contact contact = new Contact();
       contact.setContactMotive(contactMotive);
       contact.setContactMessage(message);
       contact.setContactEmail(email);

       contact.setContactName(name);
       contact.setContactPhone(phone);
       contact.setContactCell(cell);*/
    try {
      sendEmailService.sendNotification(contact);

    }catch(MailException e) {}


    return true;
  }

}
