package com.example.springPostgres.resolver;


import com.example.springPostgres.model.Anagrafica;
import com.example.springPostgres.model.Indirizzo;
import com.example.springPostgres.repositories.AnagraficaRepository;
import org.springframework.stereotype.Component;

@Component
public class IndirizziResolver {
    private AnagraficaRepository anagraficaRepository;

    public  IndirizziResolver (AnagraficaRepository anagraficaRepository){
        this.anagraficaRepository = anagraficaRepository;
    }

    public Anagrafica getAnagrafica(Indirizzo indirizzo){
        return anagraficaRepository.findById(indirizzo.getAnagrafica().getIdana()).orElse(null);
    }
}
