package com.example.mygestion.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.example.mygestion.models.TypeContrat;
import com.example.mygestion.repositories.TypeContratRepository;

@Service
public class TypeContratService {
    
    @Autowired
    private TypeContratRepository typeContratRepository;

    public List<TypeContrat> getAllTypeContrat() {
        return typeContratRepository.findAll();
    }

    public TypeContrat createTypeContrat(TypeContrat typeContrat) {
        return typeContratRepository.save(typeContrat);
    }

    public TypeContrat getTypeContratById(Long id) {
        return typeContratRepository.findById(id).orElse(null);
    }

    /*Maka id anah type de contrat ampiasaina amin'ny mampiditra contrat vaovao */
    public TypeContrat getIdByTypeContrat(String typeContrat) {
        return typeContratRepository.findByTypeContrat(typeContrat);
    }

    public TypeContrat updateTypeContrat(Long id, TypeContrat typeContrat) {
        typeContrat.setId_type_contrat(id);
        return typeContratRepository.save(typeContrat);
    }

    public void deleteTypeContrat(Long id) {
        typeContratRepository.deleteById(id);
    }

    public void checkTypeContratById(Long id) throws Exception {
        if(getTypeContratById(id)==null) throw new Exception("Id TypeContrat inexistant");
    }
}
