package com.sofka.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import java.io.Serializable;

//import org.springframework.data.annotation.Id;
@Data 
@Entity
@Table(name = "contact")
public class Contact implements Serializable{

    private static final long serialVersionUID = 1L;
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idContact")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "cellPhone")
    private String cellPhone;

    @Column(name = "dateBirth")
    private String dateBirth;

    public String getEmail() {
        return null;
    }
}
