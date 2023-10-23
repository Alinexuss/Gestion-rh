package com.example.mygestion.repositories;

import com.example.mygestion.models.SocieteDepartement;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface SocieteDepartementRepository extends JpaRepository<SocieteDepartement, Long> {
    List<SocieteDepartement> findAllDepartementByIdSociete(Long id_societe);
}
