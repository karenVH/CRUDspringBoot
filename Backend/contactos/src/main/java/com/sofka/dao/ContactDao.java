package com.sofka.dao;

import java.util.List;
import java.util.Optional;

import com.sofka.domain.Contact;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ContactDao {
    
    @Modifying
    @Query("UPDATE contacts SET name = :name WHERE idContact = :id")
    void updateName(
        @Param(value = "id") Long id,
        @Param(value = "name") String name
    );

    @Modifying
    @Query("UPDATE contacts SET lastName = :lastName WHERE idContact = :id")
    void updateLastName(
        @Param(value = "id") Long id,
        @Param(value = "lastName") String lastName
    );


    @Modifying
    @Query("UPDATE contacts SET cellPhone = :cellPhone WHERE idContact = :id")
    void updateCellPhone(
        @Param(value = "id") Long id,
        @Param(value = "cellPhone") String cellPhone
    );

    @Modifying
    @Query("UPDATE contacts SET email = :email WHERE idContact = : id")
    void updateEmail(
        @Param(value = "id") Long id,
        @Param(value = "email") String email
    );

    @Modifying
    @Query("UPDATE contacts SET dateBirth = :dateBirth WHERE idContact = :id")
    void updateDateBirth(
        @Param(value = "id") Long id,
        @Param(value = "dateBirth") String dateBirth
    );

    Contact save(Contact contact);

    List<Contact> findAll();

    Optional<Contact> findById(Long id);

	void delete(Contact contact);
}
