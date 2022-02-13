package com.athira.fleetapp.services;

import com.athira.fleetapp.entities.Contact;
import com.athira.fleetapp.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

    public List<Contact> getContacts(){
        return contactRepository.findAll();
    }

    public void save(Contact contact) {
        contactRepository.save(contact);
    }

    public Optional<Contact> findById(int id) {
        return contactRepository.findById(id);
    }

    public void delete(Integer id) {
        contactRepository.deleteById(id);
    }
}
