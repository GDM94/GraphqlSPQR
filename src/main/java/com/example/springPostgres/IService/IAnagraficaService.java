package com.example.springPostgres.IService;


import com.example.springPostgres.model.Anagrafica;
import com.example.springPostgres.model.Indirizzo;

import java.util.Optional;

public interface IAnagraficaService {

    public Anagrafica newAnagrafica(int id, String nome, String cognome);
    public boolean deleteAnagrafica(Long id);
    public Optional<Anagrafica> updateAnagrafica(Long id, String nome, String cognome);
    public Optional<Anagrafica> anagraficaById(Long id);
    public Iterable<Anagrafica> anagraficaAll();

}

