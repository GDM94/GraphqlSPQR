package com.example.springPostgres.service.impl;

import com.example.springPostgres.service.IndrizzoService;
import com.example.springPostgres.model.Anagrafica;
import com.example.springPostgres.model.Indirizzo;
import com.example.springPostgres.repositories.AnagraficaRepository;
import com.example.springPostgres.repositories.IndirizzoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class IndirizzoServiceImpl implements IndrizzoService {

    @Autowired
    private IndirizzoRepository indirizzoRepository;

    @Autowired
    private AnagraficaRepository anagraficaRepository;

    @Override
    public Optional<Indirizzo> indirizzoById(Long id){
        return indirizzoRepository.findById(id);
    }

    @Override
    public Iterable<Indirizzo> indirizzoAll(){
        return indirizzoRepository.findAll();
    }

    @Override
    public Indirizzo newIndirizzo(Long id, Long idana, String descrizione){
        Indirizzo indirizzo = new Indirizzo();
        indirizzo.setIdaddress(id);
        indirizzo.setIdana(idana);
        indirizzo.setDescrizione(descrizione);
        Date date = new Date();
        indirizzo.setDate_create(date);
        indirizzo.setDate_agg(date);
        Anagrafica anagrafica = new Anagrafica();
        anagrafica.setIdana(idana);
        indirizzo.setAnagrafica(anagrafica);
        indirizzoRepository.save(indirizzo);
        return indirizzo;
    }

    @Override
    public Optional<Indirizzo> updateIndirizzo(Long id, String descrizione){
        Optional<Indirizzo> indirizzo = indirizzoRepository.findById(id);
        Date date = new Date();

        indirizzo.ifPresent(a -> {
            a.setDescrizione(descrizione);
            a.setDate_agg(date);
            indirizzoRepository.save(a);
        });

        return indirizzo;
    }

    @Override
    public boolean deleteIndirizzo(Long id){
        indirizzoRepository.deleteById(id);
        return true;
    }


}
