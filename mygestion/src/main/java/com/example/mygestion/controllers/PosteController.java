package com.example.mygestion.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.example.mygestion.models.Poste;
import com.example.mygestion.services.PosteService;

import static com.example.mygestion.utils.ControllerUtil.returnError; 
import org.springframework.beans.factory.annotation.Autowired;
import static com.example.mygestion.utils.ControllerUtil.returnSuccess;

@RestController
@CrossOrigin
public class PosteController {

    @Autowired
    private PosteService posteService;

    @GetMapping("/soc/dept.get/poste")
    public ResponseEntity<?> getAllPoste() {
        try {
            List<Poste> postes = posteService.getAllPoste();
            return returnSuccess(postes, "Success.", HttpStatus.OK);
        } catch (Exception e) {
            return returnError(e, HttpStatus.OK);
        }
    }

    @PostMapping("/soc/dept/poste.add")
    public ResponseEntity<?> createPoste(@ModelAttribute("Poste") Poste poste) {
        try {
            posteService.createPoste(poste);
            return returnSuccess(poste, "Success for creating", HttpStatus.CREATED);
        } catch (Exception e) {
            return returnError(e, HttpStatus.OK);
        }
    }

    
    @GetMapping("/soc/dept/poste.{id}")
    public ResponseEntity<?> getPosteById(@PathVariable("id") Long id) {
        try {
            Poste reponse = posteService.getPosteById(id);
            return returnSuccess(reponse, "Result", HttpStatus.FOUND);
        } catch (Exception e) {
            return returnError(e, HttpStatus.BAD_GATEWAY);
        }
    }

    
    @PutMapping("/soc/dept/poste.{id}")
    public ResponseEntity<?> updatePoste(@PathVariable("id") Long id, @ModelAttribute("Poste") Poste poste) {
        try {
            Poste updatedPoste = posteService.updatePoste(id, poste);
            return returnSuccess(updatedPoste, "Object updated.", HttpStatus.OK);
        } catch (Exception e) {
            return returnError(e, HttpStatus.OK);
        }
    }

    
    @DeleteMapping("/soc/dept/poste.{id}")
    public ResponseEntity<?> deletePoste(@PathVariable("id") Long id) {
        try {
            posteService.deletePoste(id);
            return returnSuccess("user deleted", "Object deleted", HttpStatus.OK);
        } catch (Exception e) {
            return returnError(e, HttpStatus.OK);
        }
    }
  
}
