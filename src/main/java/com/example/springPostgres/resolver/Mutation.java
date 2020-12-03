package com.example.springPostgres.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.springPostgres.model.Anagrafica;
import com.example.springPostgres.model.Indirizzo;
import com.example.springPostgres.model.RecapitiTelefonici;
import com.example.springPostgres.repositories.AnagraficaRepository;
import com.example.springPostgres.repositories.IndirizzoRepository;
import com.example.springPostgres.repositories.RecapitiRepository;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;


@Component
public class Mutation implements GraphQLMutationResolver {

    private AnagraficaRepository anagraficaRepository;
    private IndirizzoRepository indirizzoRepository;
    private RecapitiRepository recapitiRepository;

    public Mutation(AnagraficaRepository anagraficaRepository,
                    IndirizzoRepository indirizzoRepository,
                    RecapitiRepository recapitiRepository){
        this.anagraficaRepository = anagraficaRepository;
        this.indirizzoRepository = indirizzoRepository;
        this.recapitiRepository = recapitiRepository;
    }

    public Anagrafica newAnagrafica(int id, String nome, String cognome ){
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

    public Optional<Anagrafica> updateAnagrafica(long id, String nome, String cognome) {
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

    public boolean deleteAnagrafica(Long id) {
        anagraficaRepository.deleteById(id);
        return true;
    }

    public Indirizzo newIndirizzo(int id, int idana, String descrizione){
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
/*
    public Optional<Indirizzo> updateIndirizzo(long id, String descrizione) {
        Optional<Indirizzo> indirizzo = indirizzoRepository.findById(id);
        Date date = new Date();

        indirizzo.ifPresent(a -> {
            a.setDescrizione(descrizione);
            a.setDate_agg(date);
            indirizzoRepository.save(a);
        });

        return indirizzo;
    }

    public boolean deleteIndirizzo(Long id) {
        indirizzoRepository.deleteById(id);
        return true;
    }


 */

    public RecapitiTelefonici newRecapito(int id, int idana, String tipo_recapito, String numero_recapito){
        RecapitiTelefonici recapitiTelefonici = new RecapitiTelefonici();
        recapitiTelefonici.setIdreca(id);
        recapitiTelefonici.setIdana(idana);
        recapitiTelefonici.setTipo_recapito(tipo_recapito);
        recapitiTelefonici.setNumero_recapito(numero_recapito);
        Anagrafica anagrafica = new Anagrafica();
        anagrafica.setIdana(idana);
        recapitiTelefonici.setAnagrafica(anagrafica);
        recapitiRepository.save(recapitiTelefonici);
        return recapitiTelefonici;
    }





}
