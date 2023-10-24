package com.example.mygestion.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "societe")
public class Societe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_societe;

    @Column(name = "societe", nullable = false, columnDefinition = "varchar(30) default 'No label.'")
    private String societename;

    public Long getId_societe() {
        return id_societe;
    }

    public void setId_societe(Long id_societe) {
        this.id_societe = id_societe;
    }

    public String getSocieteName() {
        return societename;
    }

    public void setSocieteName(String username) {
        this.societename = username;
    }

}
