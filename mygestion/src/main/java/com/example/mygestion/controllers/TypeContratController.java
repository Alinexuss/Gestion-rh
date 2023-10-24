package com.example.mygestion.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.example.mygestion.models.TypeContrat;
import com.example.mygestion.services.TypeContratService;

import static com.example.mygestion.utils.ControllerUtil.returnError; 
import org.springframework.beans.factory.annotation.Autowired;
import static com.example.mygestion.utils.ControllerUtil.returnSuccess;

@RestController
@CrossOrigin
public class TypeContratController {

    @Autowired
    private TypeContratService typeContratService;

    @GetMapping("/soc/contraType")
    public ResponseEntity<?> getAllTypeContrat() {
        try {
            List<TypeContrat> typeContrats = typeContratService.getAllTypeContrat();
            return returnSuccess(typeContrats, "Success.", HttpStatus.OK);
        } catch (Exception e) {
            return returnError(e, HttpStatus.OK);
        }
    }

    @PostMapping("/soc/contraType.add")
    public ResponseEntity<?> createTypeContrat(@ModelAttribute("TypeContrat") TypeContrat typeContrat) {
        try {
            typeContratService.createTypeContrat(typeContrat);
            return returnSuccess(typeContrat, "Success for creating", HttpStatus.CREATED);
        } catch (Exception e) {
            return returnError(e, HttpStatus.OK);
        }
    }

    
    @GetMapping("/soc/contratype/{id}")
    public ResponseEntity<?> getTypeContratById(@PathVariable("id") Long id) {
        try {
            TypeContrat reponse = typeContratService.getTypeContratById(id);
            return returnSuccess(reponse, "Result", HttpStatus.FOUND);
        } catch (Exception e) {
            return returnError(e, HttpStatus.BAD_GATEWAY);
        }
    }

    
    @PutMapping("/soc/contraType/{id}")
    public ResponseEntity<?> updateTypeContrat(@PathVariable("id") Long id, @ModelAttribute("TypeContrat") TypeContrat typeContrat) {
        try {
            TypeContrat updatedTypeContrat = typeContratService.updateTypeContrat(id, typeContrat);
            return returnSuccess(updatedTypeContrat, "Object updated.", HttpStatus.OK);
        } catch (Exception e) {
            return returnError(e, HttpStatus.OK);
        }
    }

    
    @DeleteMapping("/soc/contraType/{id}")
    public ResponseEntity<?> deleteTypeContrat(@PathVariable("id") Long id) {
        try {
            typeContratService.deleteTypeContrat(id);
            return returnSuccess("user deleted", "Object deleted", HttpStatus.OK);
        } catch (Exception e) {
            return returnError(e, HttpStatus.OK);
        }
    }
  
}
