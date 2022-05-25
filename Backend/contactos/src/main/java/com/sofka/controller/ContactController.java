package com.sofka.controller;

import java.util.regex.Pattern;

import com.sofka.domain.Contact;
import com.sofka.service.ContactService;

import com.sofka.utility.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import ch.qos.logback.core.Context;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Slf4j
@RestController
public class ContactController {

    @Autowired
    private ContactService contactService;

    private Response response = new Response();

    /**
     * Controlador para listar los contactos y manejar el error si no da
     * @return
     */
    @GetMapping(path = "/contacts")
    public Response listContact(){
        try{
            response.data = contactService.list();
        }catch (Exception exc){
            response.error = true;
            response.message = exc.getMessage();
            response.status =   "Error";
        }
        return response;
    }

    @PostMapping(path ="/contact")
    public ResponseEntity<Response> createContact(Context contact){
        response.data = contact;
        try{
            log.info("Crear Contacto: {}", contact);
            contactService.save((Contact) contact);
            return new ResponseEntity<Response>(response, HttpStatus.CREATED);
        }catch (Exception exc){
            response.status = exc.getCause().toString();
            response.error = true;
        }
        return null;
    }

    /**
     * Controlador para eliminar contacto y lanazar error si no lo hace
     * @param contact
     * @return
     */
    @DeleteMapping(path = "/user/{id}")
    public ResponseEntity<Contact> deleteContact(Contact contact){
        log.info("Contacto que desea borrar: {}", contact);
        contactService.delete(contact);
        return new ResponseEntity<Contact>(contact, HttpStatus.OK);
    }

    /**
     * Controlador Para actualizar el contacto y devolver error si no lo hace
     * @param contact
     * @param id
     * @return
     */
    @PutMapping(path = "/contact/{id}")
    public ResponseEntity<Contact> updateContact(Contact contact, @PathVariable("id") Long id ){
        log.info("Contactos que desea editar: {}", contact);
        contactService.update(id, contact);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

    /**
     * Controlador para editar el nombre del contacto
     * @param contact
     * @param id
     * @return
     */
    @PutMapping(path = "/contact/name/{id}")
    public ResponseEntity<Contact> updateName(Contact contact, @PathVariable("id") Long id ){
        log.info("Nombre del contacto que desea editar: {}", contact);
        contactService.updateName(id, contact);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

    /**
     * Controlador para editar el apellido del contacto
     * @param contact
     * @param id
     * @return
     */
    @PutMapping(path = "/contact/lastName/{id}")
    public ResponseEntity<Contact> updatelastName(Contact contact, @PathVariable("id") Long id ){
        log.info("Apellido que desea editar: {}", contact);
        contactService.updateLastName(id, contact);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

    /**
     * Controlador para editar el correo del contacto
     * @param contact
     * @param id
     * @return
     */
    @PutMapping(path = "/contact/email/{id}")
    public ResponseEntity<Contact> updateemail(Contact contact, @PathVariable("id") Long id ){
        log.info("Correo que deseas editar: {}", contact);
        contactService.updateEmail(id, contact);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

    /**
     * Controlador para editar el telefono del contacto
     * @param contact
     * @param id
     * @return
     */
    @PutMapping(path = "/contact/cellPhone{id}")
    public ResponseEntity<Contact> updatecelPhone(Contact contact, @PathVariable("id") Long id ){
        log.info("Telefono que deseas editar: {}", contact);
        contactService.updateCellPhone(id, contact);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }
 
    @PutMapping(path = "/contact/dateBirth{id}")
    public ResponseEntity<Contact> updatedateBirth(Contact contact, @PathVariable("id") Long id ){
        log.info("Telefono que deseas editar: {}", contact);
        contactService.updateDateBirth(id, contact);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

    
}
