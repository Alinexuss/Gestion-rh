package com.example.mygestion.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.example.mygestion.models.Departement;
import com.example.mygestion.models.SocieteDepartement;
import com.example.mygestion.repositories.DepartementRepository;
import com.example.mygestion.repositories.SocieteDepartementRepository;

@Service
public class DepartementService {
    
    @Autowired
    private DepartementRepository departementRepository;

    @Autowired
    private SocieteDepartementRepository societeDepartementRepository;

    public List<Departement> getAllDepartement() {
        return departementRepository.findAll();
    }

    public Departement createDepartement(Departement departement) {
        return departementRepository.save(departement);
    }

    public Departement getDepartementById(Long id) {
        return departementRepository.findById(id).orElse(null);
    }

    public List<SocieteDepartement> getDepartementByIdSociete(Long id_societe) {
        return societeDepartementRepository.findAllDepartementByIdSociete(id_societe);
    }

    public Departement updateDepartement(Long id, Departement departement) {
        departement.setId_departement(id);
        return departementRepository.save(departement);
    }

    public void deleteDepartement(Long id) {
        departementRepository.deleteById(id);
    }

    public void checkDepartementById(Long id) throws Exception {
        if(getDepartementById(id)==null) throw new Exception("Id Departement inexistant");
    }
}
