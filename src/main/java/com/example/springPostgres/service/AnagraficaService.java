package com.example.springPostgres.service;


import com.example.springPostgres.model.Anagrafica;

import java.util.Optional;

public interface AnagraficaService {

    public Anagrafica newAnagrafica(Long id, String nome, String cognome);
    public boolean deleteAnagrafica(Long id);
    public Optional<Anagrafica> updateAnagrafica(Long id, String nome, String cognome);
    public Optional<Anagrafica> anagraficaById(Long id);
    public Iterable<Anagrafica> anagraficaAll();

}

