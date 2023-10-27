package dev.pro.shelter.service.impl;

import dev.pro.shelter.model.Contact;
import dev.pro.shelter.repository.ContactRepository;
import dev.pro.shelter.service.ContactService;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {
    private ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }
    @Override
    public Contact createContact(Contact contact) {
        return contactRepository.save(contact);
    }
}
