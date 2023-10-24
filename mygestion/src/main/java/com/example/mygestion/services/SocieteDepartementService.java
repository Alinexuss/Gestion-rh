package com.example.mygestion.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.example.mygestion.models.Societe;
import com.example.mygestion.models.Departement;
import com.example.mygestion.models.SocieteDepartement;
import com.example.mygestion.repositories.SocieteDepartementRepository;

@Service
public class SocieteDepartementService {
    
    @Autowired
    private SocieteDepartementRepository societeDepartementRepository;

    public List<SocieteDepartement> getAllSocieteDepartements() {
        return societeDepartementRepository.findAll();
    }

    public SocieteDepartement addSocieteDepartement(Societe societe, Departement departement) {
        SocieteDepartement societeDepartement = new SocieteDepartement();
        societeDepartement.setId_societe(societe.getId_societe());
        societeDepartement.setId_departement(departement.getId_departement());

        return societeDepartementRepository.save(societeDepartement);
    }

    public SocieteDepartement getSocieteById(Long id) {
        return societeDepartementRepository.findById(id).orElse(null);
    }

    public SocieteDepartement updateSocietedeDepartement(Long id, SocieteDepartement societeDepartement) {
        societeDepartement.setId_societe(id);
        return societeDepartementRepository.save(societeDepartement);
    }

    public void deleteSocieteDepartement(Long id) {
        societeDepartementRepository.deleteById(id);
    }

    public void checkSocieteDepartementById(Long id) throws Exception {
        if(getSocieteById(id)==null) throw new Exception("Id SocieteDepartement inexistant");
    }
}
