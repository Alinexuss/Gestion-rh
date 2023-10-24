package com.example.mygestion.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "poste")
public class Poste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_poste;

    @Column(name = "nom_poste", nullable = false, columnDefinition = "varchar(25) default 'No label.'")
    private String posteName;

    public Long getId_poste() {
        return id_poste;
    }

    public void setId_poste(Long id_poste) {
        this.id_poste = id_poste;
    }

    public String getPosteName() {
        return posteName;
    }

    public void setPosteName(String posteName) {
        this.posteName = posteName;
    }
}
