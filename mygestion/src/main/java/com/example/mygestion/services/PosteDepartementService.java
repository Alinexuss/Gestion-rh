package com.example.mygestion.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.example.mygestion.models.PosteDepartement;
import com.example.mygestion.repositories.PosteDepartementRepository;

@Service
public class PosteDepartementService {
    
    @Autowired
    private PosteDepartementRepository posteDepartementRepository;

    public List<PosteDepartement> getAllPosteDepartement() {
        return posteDepartementRepository.findAll();
    }

    public PosteDepartement createPosteDepartement(PosteDepartement posteDepartement) {
        return posteDepartementRepository.save(posteDepartement);
    }

    public PosteDepartement getPosteDepartementById(Long id) {
        return posteDepartementRepository.findById(id).orElse(null);
    }

    public PosteDepartement updatePosteDepartement(Long id, PosteDepartement posteDepartement) {
        posteDepartement.setId_poste_departement(id);
        return posteDepartementRepository.save(posteDepartement);
    }

    public void deletePosteDepartement(Long id) {
        posteDepartementRepository.deleteById(id);
    }

    public void checkPosteDepartementById(Long id) throws Exception {
        if(getPosteDepartementById(id)==null) throw new Exception("Id PosteDepartement inexistant");
    }
}
