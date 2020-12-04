package com.example.springPostgres.controller;

import com.example.springPostgres.model.Indirizzo;
import com.example.springPostgres.repositories.IndirizzoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/indirizzo")

public class IndirizzoController {
    @Autowired
    public IndirizzoRepository indirizzoRepository;

    @GetMapping   // GET Method for reading operation
    public List<Indirizzo> getAllindirizzo() {
        return indirizzoRepository.findAll();
    }

    @GetMapping("/{id}")    // GET Method for Read operation
    public ResponseEntity<Indirizzo> getIndirizzoById(@PathVariable(value = "id") Long indId)
            throws Exception {

        Indirizzo indirizzo = indirizzoRepository.findById(indId)
                .orElseThrow(() -> new Exception("Phone " + indId + " not found"));
        return ResponseEntity.ok().body(indirizzo);
    }

    @PostMapping    // POST Method for Create operation
    public Indirizzo createIndirizzo(@RequestBody Indirizzo ind) {
        return indirizzoRepository.save(ind);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Indirizzo> updateIndirizzo(
            @PathVariable(value = "id") long indId,  @RequestBody Indirizzo indirizzoDetail)
            throws Exception {

        Indirizzo indirizzo = indirizzoRepository.findById(indId)
                .orElseThrow(() -> new Exception("Indirizzo" + indId + " not found"));

        indirizzo.setIdana(indirizzoDetail.getIdana());
        indirizzo.setDescrizione(indirizzoDetail.getDescrizione());
        indirizzo.setDate_create(indirizzoDetail.getDate_create());
        indirizzo.setDate_agg(indirizzoDetail.getDate_agg());

        final Indirizzo updatedPhone = indirizzoRepository.save(indirizzo);
        return ResponseEntity.ok(updatedPhone);
    }

    @DeleteMapping("/{id}")    // DELETE Method for Delete operation
    public Map<String, Boolean> deleteIndirizzo(@PathVariable(value = "id") Long indId) throws Exception {
        Indirizzo indirizzo = indirizzoRepository.findById(indId)
                .orElseThrow(() -> new Exception("Phone " + indId + " not found"));

        indirizzoRepository.delete(indirizzo);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
