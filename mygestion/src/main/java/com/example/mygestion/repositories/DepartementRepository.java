package com.example.mygestion.repositories;

import com.example.mygestion.models.Departement;


import org.springframework.data.jpa.repository.JpaRepository;


public interface DepartementRepository extends JpaRepository<Departement, Long> {

}
