package com.example.mygestion.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.example.mygestion.models.Societe;
import com.example.mygestion.services.SocieteService;

import static com.example.mygestion.utils.ControllerUtil.returnError; 
import org.springframework.beans.factory.annotation.Autowired;
import static com.example.mygestion.utils.ControllerUtil.returnSuccess;

@RestController
@CrossOrigin
public class SocieteController {

    @Autowired
    private SocieteService societeService;

    @GetMapping("/soc")
    public ResponseEntity<?> getAllSociete() {
        try {
            List<Societe> societes = societeService.getAllSociete();
            return returnSuccess(societes, "Success.", HttpStatus.OK);
        } catch (Exception e) {
            return returnError(e, HttpStatus.OK);
        }
    }

    @PostMapping("/soc")
    public ResponseEntity<?> createSociete(@ModelAttribute("Societe") Societe societe) {
        try {
            societeService.createSociete(societe);
            return returnSuccess(societe, "Success for creating", HttpStatus.CREATED);
        } catch (Exception e) {
            return returnError(e, HttpStatus.OK);
        }
    }

    
    @GetMapping("/soc/{id}")
    public ResponseEntity<?> getSocieteById(@PathVariable("id") Long id) {
        try {
            Societe reponse = societeService.getSocieteById(id);
            return returnSuccess(reponse, "Result", HttpStatus.FOUND);
        } catch (Exception e) {
            return returnError(e, HttpStatus.BAD_GATEWAY);
        }
    }

    
    @PutMapping("/soc/{id}")
    public ResponseEntity<?> updateSociete(@PathVariable("id") Long id, @ModelAttribute("Societe") Societe societe) {
        try {
            Societe updatedSociete = societeService.updateSociete(id, societe);
            return returnSuccess(updatedSociete, "Object updated.", HttpStatus.OK);
        } catch (Exception e) {
            return returnError(e, HttpStatus.OK);
        }
    }

    
    @DeleteMapping("/soc/{id}")
    public ResponseEntity<?> deleteSociete(@PathVariable("id") Long id) {
        try {
            societeService.deleteSociete(id);
            return returnSuccess("user deleted", "Object deleted", HttpStatus.OK);
        } catch (Exception e) {
            return returnError(e, HttpStatus.OK);
        }
    }
  
}
