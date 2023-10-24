package com.example.mygestion.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.example.mygestion.models.Cnaps;
import com.example.mygestion.repositories.CnapsRepository;

@Service
public class CnapsService {
    
    @Autowired
    private CnapsRepository cnapsRepository;

    public List<Cnaps> getAllCnaps() {
        return cnapsRepository.findAll();
    }

    public Cnaps createCnaps(Cnaps cnaps) {
        return cnapsRepository.save(cnaps);
    }

    public Cnaps getCnapsById(Long id) {
        return cnapsRepository.findById(id).orElse(null);
    }

    public Cnaps updateCnaps(Long id, Cnaps cnaps) {
        cnaps.setId_cnaps(id);
        return cnapsRepository.save(cnaps);
    }

    public void deleteCnaps(Long id) {
        cnapsRepository.deleteById(id);
    }

    public void checkCnapsById(Long id) throws Exception {
        if(getCnapsById(id)==null) throw new Exception("Id Cnaps inexistant");
    }
}
