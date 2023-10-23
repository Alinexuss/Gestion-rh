package com.example.mygestion.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.example.mygestion.models.Societe;
import com.example.mygestion.repositories.SocieteRepository;

@Service
public class SocieteService {
    
    @Autowired
    private SocieteRepository societeRepository;

    public List<Societe> getAllSociete() {
        return societeRepository.findAll();
    }

    public Societe createSociete(Societe societe) {
        return societeRepository.save(societe);
    }

    public Societe getSocieteById(Long id) {
        return societeRepository.findById(id).orElse(null);
    }

    public Societe updateSociete(Long id, Societe societe) {
        societe.setId_societe(id);
        return societeRepository.save(societe);
    }

    public void deleteSociete(Long id) {
        societeRepository.deleteById(id);
    }

    public void checkSocieteById(Long id) throws Exception {
        if(getSocieteById(id)==null) throw new Exception("Id Societe inexistant");
    }
}
