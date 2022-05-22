package com.sofka.service;


import java.util.List;
import java.util.Optional;

import com.sofka.domain.Contact;

public interface IcontactService{
    /**
     * Metodo para listar los contactos
     * @return
     */
    public List<Contact> list();
    /**
     * Metodo para guardar contacto
     * @param contact
     * @return
     */
    public Contact save(Contact contact);
    /**
     * Metodo para actualizar
     * @param id
     * @param contact
     * @return
     */
    public Contact update(Long id, Contact contact);
    /**
     * Metodo para eliminar contactos
     * @param contact
     */
    public void delete(Contact contact);
    /**
     * 
     * @param contact
     * @return
     */
    public Optional<Contact> findContact(Contact contact);

}