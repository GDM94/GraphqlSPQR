package com.example.springPostgres.controller;

import com.example.springPostgres.model.Anagrafica;
import com.example.springPostgres.repositories.AnagraficaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/anagrafica")
public class AnagraficaController {
    @Autowired
    public AnagraficaRepository anagraficaRepository;

    @GetMapping("/hello")
    public String getHello() { return "Hello World"; }

    @GetMapping   // GET Method for reading operation
    public List<Anagrafica> getAllanagrafica() {
        return anagraficaRepository.findAll();
    }

    @GetMapping("/{id}")    // GET Method for Read operation
    public ResponseEntity<Anagrafica> getAnagraficaById(@PathVariable(value = "id") Long anaId)
            throws Exception {

        Anagrafica anagrafica = anagraficaRepository.findById(anaId)
                .orElseThrow(() -> new Exception("Amagrafica " + anaId + " not found"));
        return ResponseEntity.ok().body(anagrafica);
    }


    @GetMapping("/query/{id}")
    public  List<String> getQueryID(@PathVariable(value = "id") long anaId) throws Exception {
        return anagraficaRepository.getName_Numero(anaId);
    }


    @PostMapping    // POST Method for Create operation
    public Anagrafica createAnagrafica(@RequestBody Anagrafica ana) {
        return anagraficaRepository.save(ana);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Anagrafica> updateAnagrafica(
            @PathVariable(value = "id") long anaId,  @RequestBody Anagrafica anaDetails)
            throws Exception {

        Anagrafica anagrafica = anagraficaRepository.findById(anaId)
                .orElseThrow(() -> new Exception("Anagrafica " + anaId + " not found"));

        anagrafica.setNome(anaDetails.getNome());
        anagrafica.setCognome(anaDetails.getCognome());
        anagrafica.setDate_create(anaDetails.getDate_create());
        anagrafica.setDate_agg(anaDetails.getDate_agg());

        final Anagrafica updatedAnagrafica = anagraficaRepository.save(anagrafica);
        return ResponseEntity.ok(updatedAnagrafica);
    }

    @DeleteMapping("/{id}")    // DELETE Method for Delete operation
    public Map<String, Boolean> deleteAnagrafica(@PathVariable(value = "id") Long anaID) throws Exception {
        Anagrafica anagrafica = anagraficaRepository.findById(anaID)
                .orElseThrow(() -> new Exception("Phone " + anaID + " not found"));

        anagraficaRepository.delete(anagrafica);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @PatchMapping("/patch/nome/{id}")
    public ResponseEntity<Anagrafica> partialUpdateName(
            @RequestBody Anagrafica partialUpdate,
            @PathVariable("id") long anaId) throws Exception {

        Anagrafica anagrafica = anagraficaRepository.findById(anaId)
                .orElseThrow(() -> new Exception("Anagrafica " + anaId + " not found"));
        anagrafica.setNome(partialUpdate.getNome());
        final Anagrafica updatedAnagrafica = anagraficaRepository.save(anagrafica);
        return ResponseEntity.ok(updatedAnagrafica);
    }


    @PatchMapping("/patch/query/{id}")
    public String queryUpdate(
            @RequestBody Anagrafica partialUpdate,
            @PathVariable("id") long anaId)  throws Exception {

        int i = anagraficaRepository.updateNomeCognome(anaId, partialUpdate.getNome());
        return "query update executed";
    }



}
