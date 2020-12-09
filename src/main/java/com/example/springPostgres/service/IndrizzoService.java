package com.example.springPostgres.service;

import com.example.springPostgres.model.Indirizzo;

import java.util.Optional;

public interface IndrizzoService {

    public Optional<Indirizzo> indirizzoById(Long id);
    public Iterable<Indirizzo> indirizzoAll();
    public Indirizzo newIndirizzo(Long id, Long idana, String descrizione);
    public Optional<Indirizzo> updateIndirizzo(Long id, String descrizione);
    public boolean deleteIndirizzo(Long id);


}
