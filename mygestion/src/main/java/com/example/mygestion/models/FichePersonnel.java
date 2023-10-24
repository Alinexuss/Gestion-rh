package com.example.mygestion.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "fiche_personnel")
public class FichePersonnel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_fiche_personnel;

    @Column(name = "numero_matricule", nullable = false, columnDefinition = "varchar(10) default 'No label.'")
    private String numero_matricule;

    @Column(name = "nom", nullable = false, columnDefinition = "varchar(25) default 'No label.'")
    private String nom;

    @Column(name = "prenom", nullable = false, columnDefinition = "varchar(50) default 'No label.'")
    private String prenom;

    @Column(name = "date_de_naissance")
    private Date date_de_naissance;
}
