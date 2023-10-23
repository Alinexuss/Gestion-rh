package com.example.mygestion.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.example.mygestion.models.SocieteDepartement;
import com.example.mygestion.repositories.SocieteDepartementRepository;

@Service
public class SocieteDepartementService {
    
    @Autowired
    private SocieteDepartementRepository societeDepartementRepository;

    public List<SocieteDepartement> getAllSociete() {
        return societeDepartementRepository.findAll();
    }

    public SocieteDepartement createSociete(SocieteDepartement societeDepartement) {
        return societeDepartementRepository.save(societeDepartement);
    }

    public SocieteDepartement getSocieteById(Long id) {
        return societeDepartementRepository.findById(id).orElse(null);
    }

    public SocieteDepartement updateSociete(Long id, SocieteDepartement societeDepartement) {
        societeDepartement.setId_societe(id);
        return societeDepartementRepository.save(societeDepartement);
    }

    public void deleteSociete(Long id) {
        societeDepartementRepository.deleteById(id);
    }

    public void checkSocieteById(Long id) throws Exception {
        if(getSocieteById(id)==null) throw new Exception("Id SocieteDepartement inexistant");
    }
}
