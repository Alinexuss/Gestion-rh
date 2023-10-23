package com.example.mygestion.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "departement")
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_departement;

    @Column(name = "nom_departement",  nullable = false, columnDefinition = "varchar(25) default 'No label.'")
    private Long nomdept;

    @Column(name = "volume_de_tache", nullable = false, precision = 7, scale = 0, columnDefinition = "numeric")
    private String volume_de_tache;

    @Column(name = "nombre_employe", nullable = false, columnDefinition = "numeric")
    private String nombre_employe;

    public Long getId_departement() {
        return id_departement;
    }

    public void setId_departement(Long id_departement) {
        this.id_departement = id_departement;
    }

    public Long getNomdept() {
        return nomdept;
    }

    public void setNomdept(Long nomdept) {
        this.nomdept = nomdept;
    }

    public String getVolume_de_tache() {
        return volume_de_tache;
    }

    public void setVolume_de_tache(String volume_de_tache) {
        this.volume_de_tache = volume_de_tache;
    }

    public String getNombre_employe() {
        return nombre_employe;
    }

    public void setNombre_employe(String nombre_employe) {
        this.nombre_employe = nombre_employe;
    }
}
