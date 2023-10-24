package com.example.mygestion.repositories;

import com.example.mygestion.models.TypeContrat;


import org.springframework.data.jpa.repository.JpaRepository;


public interface TypeContratRepository extends JpaRepository<TypeContrat, Long> {
    TypeContrat findByTypeContrat(String typeContrat);
}
