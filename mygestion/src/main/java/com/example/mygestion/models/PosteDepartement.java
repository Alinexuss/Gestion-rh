package com.example.mygestion.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "poste_departement")
public class PosteDepartement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_poste_departement;

    @Column(name = "id_poste", columnDefinition = "int references poste(id_poste)")
    private Long id_poste;

    @Column(name = "id_departement", columnDefinition = "int references departement(id_departement)")
    private Long id_departement;
    
    public Long getId_poste_departement() {
        return id_poste_departement;
    }

    public void setId_poste_departement(Long id_poste_departement) {
        this.id_poste_departement = id_poste_departement;
    }

    public Long getId_poste() {
        return id_poste;
    }

    public void setId_poste(Long id_poste) {
        this.id_poste = id_poste;
    }

    public Long getId_departement() {
        return id_departement;
    }

    public void setId_departement(Long id_departement) {
        this.id_departement = id_departement;
    }
}
