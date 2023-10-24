package com.example.mygestion.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.example.mygestion.models.Poste;
import com.example.mygestion.repositories.PosteRepository;

@Service
public class PosteService {
    
    @Autowired
    private PosteRepository posteRepository;

    public List<Poste> getAllPoste() {
        return posteRepository.findAll();
    }

    public Poste createPoste(Poste poste) {
        return posteRepository.save(poste);
    }

    public Poste getPosteById(Long id) {
        return posteRepository.findById(id).orElse(null);
    }

    public Poste updatePoste(Long id, Poste poste) {
        poste.setId_poste(id);
        return posteRepository.save(poste);
    }

    public void deletePoste(Long id) {
        posteRepository.deleteById(id);
    }

    public void checkPosteById(Long id) throws Exception {
        if(getPosteById(id)==null) throw new Exception("Id Poste inexistant");
    }
}
