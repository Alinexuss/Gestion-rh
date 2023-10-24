package com.example.mygestion.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.example.mygestion.models.Departement;
import com.example.mygestion.models.Societe;
import com.example.mygestion.models.SocieteDepartement;
import com.example.mygestion.services.DepartementService;
import com.example.mygestion.services.SocieteDepartementService;

import static com.example.mygestion.utils.ControllerUtil.returnError; 
import org.springframework.beans.factory.annotation.Autowired;
import static com.example.mygestion.utils.ControllerUtil.returnSuccess;

@RestController
@CrossOrigin
public class DepartementController {

    @Autowired
    private DepartementService departementService;

    @Autowired
    private SocieteDepartementService societeDepartementService;

    @GetMapping("/soc/dept.get")
    public ResponseEntity<?> getAllDepartement() {
        try {
            List<Departement> departements = departementService.getAllDepartement();
            return returnSuccess(departements, "Success.", HttpStatus.OK);
        } catch (Exception e) {
            return returnError(e, HttpStatus.OK);
        }
    }

    @PostMapping("/soc/dept.add")
    public ResponseEntity<?> createDepartement(@ModelAttribute("Departement") Departement departement) {
        try {
            departementService.createDepartement(departement);
            return returnSuccess(departement, "Success for creating", HttpStatus.CREATED);
        } catch (Exception e) {
            return returnError(e, HttpStatus.OK);
        }
    }

    /*Creer un nouvel departement par rapport a la societe qui la possede */
    @PostMapping("/soc/dept.soc/add")
    public ResponseEntity<?> createDepartementBySociete(@ModelAttribute("Societe") Societe societe ,@ModelAttribute("Departement") Departement departement) {
        try {
            departementService.createDepartement(departement);
            societeDepartementService.addSocieteDepartement(societe, departement);
            return returnSuccess(departement, "Success for creating", HttpStatus.CREATED);
        } catch (Exception e) {
            return returnError(e, HttpStatus.OK);
        }
    }

    @GetMapping("/soc/dept.{id}")
    public ResponseEntity<?> getDepartementById(@PathVariable("id") Long id) {
        try {
            Departement reponse = departementService.getDepartementById(id);
            return returnSuccess(reponse, "Result", HttpStatus.FOUND);
        } catch (Exception e) {
            return returnError(e, HttpStatus.BAD_GATEWAY);
        }
    }

    /*Afficher toutes les departements de la societes*/
    @GetMapping("/soc/dept.soc/{id}")
    public ResponseEntity<?> getDepartementByIdSociete(@PathVariable("id") Long id) {
        try {
            List<SocieteDepartement>  reponse = departementService.getDepartementByIdSociete(id);
            return returnSuccess(reponse, "Result", HttpStatus.FOUND);
        } catch (Exception e) {
            return returnError(e, HttpStatus.BAD_GATEWAY);
        }
    }

    @PutMapping("/soc/dept/{id}")
    public ResponseEntity<?> updateDepartement(@PathVariable("id") Long id, @ModelAttribute("Departement") Departement departement) {
        try {
            Departement updatedDepartement = departementService.updateDepartement(id, departement);
            return returnSuccess(updatedDepartement, "Object updated.", HttpStatus.OK);
        } catch (Exception e) {
            return returnError(e, HttpStatus.OK);
        }
    }

    
    @DeleteMapping("/soc/dept/{id}")
    public ResponseEntity<?> deleteDepartement(@PathVariable("id") Long id) {
        try {
            departementService.deleteDepartement(id);
            return returnSuccess("user deleted", "Object deleted", HttpStatus.OK);
        } catch (Exception e) {
            return returnError(e, HttpStatus.OK);
        }
    }
  
}
