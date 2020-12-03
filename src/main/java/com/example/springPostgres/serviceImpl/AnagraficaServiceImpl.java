package com.example.springPostgres.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.springPostgres.IService.IAnagraficaService;
import com.example.springPostgres.model.Anagrafica;
import com.example.springPostgres.repositories.AnagraficaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnagraficaServiceImpl implements IAnagraficaService {

    @Autowired
    private AnagraficaRepository anagraficaRepository;

    @Override
    public Anagrafica newAnagrafica(Long id, String nome, String cognome) {
        Anagrafica anagrafica = new Anagrafica();
        anagrafica.setIdana(id);
        anagrafica.setNome(nome);
        anagrafica.setCognome(cognome);
        Date date = new Date();
        anagrafica.setDate_create(date);
        anagrafica.setDate_agg(date);
        anagraficaRepository.save(anagrafica);
        return anagrafica;
    }

    @Override
    public Optional<Anagrafica> updateAnagrafica(Long id, String nome, String cognome) {
        Optional<Anagrafica> anagrafica = anagraficaRepository.findById(id);
        Date date = new Date();

        anagrafica.ifPresent(a -> {
            a.setNome(nome);
            a.setCognome(cognome);
            a.setDate_agg(date);
            anagraficaRepository.save(a);
        });

        return anagrafica;
    }

    @Override
    public boolean deleteAnagrafica(Long id) {
        anagraficaRepository.deleteById(id);
        return true;
    }

    @Override
    public Optional<Anagrafica> anagraficaById(Long id) {
        return anagraficaRepository.findById(id);
    }


    @Override
    public Iterable<Anagrafica> anagraficaAll(){
        return anagraficaRepository.findAll();
    }

}