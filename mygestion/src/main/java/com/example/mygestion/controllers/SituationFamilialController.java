package com.example.mygestion.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.example.mygestion.models.SituationFamilial;
import com.example.mygestion.services.SituationFamilialService;

import static com.example.mygestion.utils.ControllerUtil.returnError; 
import org.springframework.beans.factory.annotation.Autowired;
import static com.example.mygestion.utils.ControllerUtil.returnSuccess;

@RestController
@CrossOrigin
public class SituationFamilialController {

    @Autowired
    private SituationFamilialService situationFamilialService;

    @GetMapping("/soc/ficheperso")
    public ResponseEntity<?> getAllSituationFamilial() {
        try {
            List<SituationFamilial> situationFamilials = situationFamilialService.getAllSituationFamilial();
            return returnSuccess(situationFamilials, "Success.", HttpStatus.OK);
        } catch (Exception e) {
            return returnError(e, HttpStatus.OK);
        }
    }

    @PostMapping("/soc/ficheperso.add")
    public ResponseEntity<?> createSituationFamilial(@ModelAttribute("SituationFamilial") SituationFamilial situationFamilial) {
        try {
            situationFamilialService.createSituationFamilial(situationFamilial);
            return returnSuccess(situationFamilial, "Success for creating", HttpStatus.CREATED);
        } catch (Exception e) {
            return returnError(e, HttpStatus.OK);
        }
    }

    
    @GetMapping("/soc/ficheperso/{id}")
    public ResponseEntity<?> getSituationFamilialById(@PathVariable("id") Long id) {
        try {
            SituationFamilial reponse = situationFamilialService.getSituationFamilialById(id);
            return returnSuccess(reponse, "Result", HttpStatus.FOUND);
        } catch (Exception e) {
            return returnError(e, HttpStatus.BAD_GATEWAY);
        }
    }

    
    @PutMapping("/soc/ficheperso/{id}")
    public ResponseEntity<?> updateSituationFamilial(@PathVariable("id") Long id, @ModelAttribute("SituationFamilial") SituationFamilial situationFamilial) {
        try {
            SituationFamilial updatedSituationFamilial = situationFamilialService.updateSituationFamilial(id, situationFamilial);
            return returnSuccess(updatedSituationFamilial, "Object updated.", HttpStatus.OK);
        } catch (Exception e) {
            return returnError(e, HttpStatus.OK);
        }
    }

    
    @DeleteMapping("/soc/ficheperso/{id}")
    public ResponseEntity<?> deleteSituationFamilial(@PathVariable("id") Long id) {
        try {
            situationFamilialService.deleteSituationFamilial(id);
            return returnSuccess("user deleted", "Object deleted", HttpStatus.OK);
        } catch (Exception e) {
            return returnError(e, HttpStatus.OK);
        }
    }
  
}
