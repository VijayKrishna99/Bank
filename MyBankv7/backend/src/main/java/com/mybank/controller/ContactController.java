package com.mybank.controller;


import com.mybank.model.Contact;
import com.mybank.repository.ContactRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Random;

@RestController
public class ContactController {

    private final ContactRepository contactRepository;

    public ContactController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @PostMapping("/contact")
        public Contact getContact(@RequestBody Contact contact) {
             contact.setContactId(getServiceRequestNumber());
             contact.setCreateDt(new Date(System.currentTimeMillis()));
             return contactRepository.save(contact);
        }

        public String getServiceRequestNumber(){
            Random random = new Random();
            int ranNum = random.nextInt(999999999 - 9999)+ 9999;
            return "SR"+ranNum;
        }
}
