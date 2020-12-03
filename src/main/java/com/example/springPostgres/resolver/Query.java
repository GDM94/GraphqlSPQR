package com.example.springPostgres.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.springPostgres.model.Anagrafica;
import com.example.springPostgres.model.Indirizzo;
import com.example.springPostgres.model.RecapitiTelefonici;
import com.example.springPostgres.repositories.AnagraficaRepository;
import com.example.springPostgres.repositories.IndirizzoRepository;
import com.example.springPostgres.repositories.RecapitiRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Query implements GraphQLQueryResolver {

    private final AnagraficaRepository anagraficaRepository;
    private final IndirizzoRepository indirizzoRepository;
    private final RecapitiRepository recapitiRepository;

    public Query(AnagraficaRepository anagraficaRepository,
                 IndirizzoRepository indirizzoRepository,
                 RecapitiRepository recapitiRepository){
        this.anagraficaRepository = anagraficaRepository;
        this.indirizzoRepository = indirizzoRepository;
        this.recapitiRepository = recapitiRepository;
    }

    public Optional<Anagrafica> anagraficaById(long id) {
        return anagraficaRepository.findById(id);
    }

    public Iterable<Anagrafica> anagraficaAll(){
        return anagraficaRepository.findAll();
    }

    public Optional<Indirizzo> indirizzoById(long id){
        return indirizzoRepository.findById(id);
    }

    public Iterable<Indirizzo> indirizzoAll(){
        return indirizzoRepository.findAll();
    }

    public Optional<RecapitiTelefonici> recapitoById(long id){
        return recapitiRepository.findById(id);
    }

    public Iterable<RecapitiTelefonici> recapitoAll(){
        return recapitiRepository.findAll();
    }

}
