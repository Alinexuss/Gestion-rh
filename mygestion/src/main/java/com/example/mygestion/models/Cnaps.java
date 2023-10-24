package com.example.mygestion.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "cnaps")
public class Cnaps {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cnaps;

    @Column(name = "numero_cnaps", nullable = false, columnDefinition = "varchar(10) default 'No label.'")
    private String numeroCnaps;

    public Long getId_cnaps() {
        return id_cnaps;
    }

    public void setId_cnaps(Long id_cnaps) {
        this.id_cnaps = id_cnaps;
    }

    public String getNumeroCnaps() {
        return numeroCnaps;
    }

    public void setNumeroCnaps(String numeroCnaps) {
        this.numeroCnaps = numeroCnaps;
    }
}
