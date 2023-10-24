package com.example.mygestion.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.example.mygestion.models.Cnaps;
import com.example.mygestion.services.CnapsService;

import static com.example.mygestion.utils.ControllerUtil.returnError; 
import org.springframework.beans.factory.annotation.Autowired;
import static com.example.mygestion.utils.ControllerUtil.returnSuccess;

@RestController
@CrossOrigin
public class CnapsController {

    @Autowired
    private CnapsService cnapsService;

    @GetMapping("/soc/cnaps")
    public ResponseEntity<?> getAllCnaps() {
        try {
            List<Cnaps> Cnapss = cnapsService.getAllCnaps();
            return returnSuccess(Cnapss, "Success.", HttpStatus.OK);
        } catch (Exception e) {
            return returnError(e, HttpStatus.OK);
        }
    }

    @PostMapping("/soc/cnaps.add")
    public ResponseEntity<?> createCnaps(@ModelAttribute("Cnaps") Cnaps cnaps) {
        try {
            cnapsService.createCnaps(cnaps);
            return returnSuccess(cnaps, "Success for creating", HttpStatus.CREATED);
        } catch (Exception e) {
            return returnError(e, HttpStatus.OK);
        }
    }

    
    @GetMapping("/soc/cnaps.{id}")
    public ResponseEntity<?> getCnapsById(@PathVariable("id") Long id) {
        try {
            Cnaps reponse = cnapsService.getCnapsById(id);
            return returnSuccess(reponse, "Result", HttpStatus.FOUND);
        } catch (Exception e) {
            return returnError(e, HttpStatus.BAD_GATEWAY);
        }
    }

    
    @PutMapping("/soc/cnaps.{id}")
    public ResponseEntity<?> updateCnaps(@PathVariable("id") Long id, @ModelAttribute("Cnaps") Cnaps cnaps) {
        try {
            Cnaps updatedCnaps = cnapsService.updateCnaps(id, cnaps);
            return returnSuccess(updatedCnaps, "Object updated.", HttpStatus.OK);
        } catch (Exception e) {
            return returnError(e, HttpStatus.OK);
        }
    }

    
    @DeleteMapping("/soc/cnaps.{id}")
    public ResponseEntity<?> deleteCnaps(@PathVariable("id") Long id) {
        try {
            cnapsService.deleteCnaps(id);
            return returnSuccess("user deleted", "Object deleted", HttpStatus.OK);
        } catch (Exception e) {
            return returnError(e, HttpStatus.OK);
        }
    }
  
}
