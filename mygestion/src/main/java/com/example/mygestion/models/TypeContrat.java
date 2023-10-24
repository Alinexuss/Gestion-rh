package com.example.mygestion.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "type_contrat")
public class TypeContrat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_type_contrat;

    @Column(name = "type_contrat", nullable = false, columnDefinition = "varchar(20) default 'No label.'")
    private String typeContrat;

    public Long getId_type_contrat() {
        return id_type_contrat;
    }

    public void setId_type_contrat(Long id_type_contrat) {
        this.id_type_contrat = id_type_contrat;
    }

    public String getTypeContrat() {
        return typeContrat;
    }

    public void setTypeContrat(String typeContrat) {
        this.typeContrat = typeContrat;
    }
}
