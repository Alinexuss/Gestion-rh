package com.example.mygestion.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.example.mygestion.models.SituationFamilial;
import com.example.mygestion.repositories.SituationFamilialRepository;

@Service
public class SituationFamilialService {
    
    @Autowired
    private SituationFamilialRepository situationFamilialRepository;

    public List<SituationFamilial> getAllSituationFamilial() {
        return situationFamilialRepository.findAll();
    }

    public SituationFamilial createSituationFamilial(SituationFamilial situationFamilial) {
        return situationFamilialRepository.save(situationFamilial);
    }

    public SituationFamilial getSituationFamilialById(Long id) {
        return situationFamilialRepository.findById(id).orElse(null);
    }

    public SituationFamilial updateSituationFamilial(Long id, SituationFamilial situationFamilial) {
        situationFamilial.setId_situation(id);
        return situationFamilialRepository.save(situationFamilial);
    }

    public void deleteSituationFamilial(Long id) {
        situationFamilialRepository.deleteById(id);
    }

    public void checkSituationFamilialById(Long id) throws Exception {
        if(getSituationFamilialById(id)==null) throw new Exception("Id SituationFamilial inexistant");
    }
}
