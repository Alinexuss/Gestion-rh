package com.example.mygestion.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "situation_familial")
public class SituationFamilial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_situation;

    @Column(name = "situation", nullable = false, columnDefinition = "varchar(100) default 'No label.'")
    private String situation;

    public Long getId_situation() {
        return id_situation;
    }

    public void setId_situation(Long id_situation) {
        this.id_situation = id_situation;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }
}
