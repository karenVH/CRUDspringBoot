package com.sofka.service;

import org.springframework.transaction.annotation.Transactional;
import com.sofka.dao.ContactDao;
import com.sofka.domain.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService implements IcontactService{

    @Autowired
    private ContactDao contactDao;
    /**
     *
     */
    //private static final boolean BOOLEAN = true;

    @Override
    @Transactional(readOnly = true)
    public List<Contact> list() {
        List<Contact> contacts;
        try{
            contacts = (List<Contact>) contactDao.findAll();
        }catch(Exception exc){
            exc.getLocalizedMessage();
            throw exc;
        }
        return contacts;
    }

    @Override
    @Transactional
    public Contact save(Contact contact) {
        //Retorna el metodo guardar
        return contactDao.save(contact);
    }

    @Override
    @Transactional
    public Contact update(Long id, Contact contact) {
        // retornael metodo para 
        contact.setId(id);
        return contactDao.save(contact);
    }

    @Transactional
    public void updateName(Long id, Contact contact){
        contactDao.updateName(id, contact.getName());
    }

    @Transactional
    public void updateCellPhone(Long id, Contact contact){
        contactDao.updateCellPhone(id, contact.getCellPhone());
    }

    @Transactional
    public void updateEmail(Long id, Contact contact){
        contactDao.updateEmail(id, contact.getEmail());
    }

    @Transactional
    public void updateDateBirth(Long id, Contact contact){
        contactDao.updateDateBirth(id, contact.getDateBirth());
    }

    @Override
    @Transactional
    public void delete(Contact contact){
        contactDao.delete(contact);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Contact> findContact(Contact contact) {
        return contactDao.findById(contact.getId());
    }

    public void updateLastName(Long id, Contact contact) {
        contactDao.updateLastName(id, contact.getLastName());
    }
    
}
