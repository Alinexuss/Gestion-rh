package com.example.mygestion.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "societe_departement")
public class SocieteDepartement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_soc_dept;

    @Column(name = "id_societe", columnDefinition = "int references societe(id_societe)")
    private Long id_societe;

    @Column(name = "id_departement", columnDefinition = "int references departement(id_departement)")
    private Long id_departement;
    
    public Long getId_soc_dept() {
        return id_soc_dept;
    }

    public void setId_soc_dept(Long id_soc_dept) {
        this.id_soc_dept = id_soc_dept;
    }

    public Long getId_societe() {
        return id_societe;
    }

    public void setId_societe(Long id_societe) {
        this.id_societe = id_societe;
    }

    public Long getId_departement() {
        return id_departement;
    }

    public void setId_departement(Long id_departement) {
        this.id_departement = id_departement;
    }
}
