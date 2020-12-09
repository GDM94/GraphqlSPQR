package com.example.springPostgres.service.impl;

import com.example.springPostgres.service.RecapitiService;
import com.example.springPostgres.model.Anagrafica;
import com.example.springPostgres.model.RecapitiTelefonici;
import com.example.springPostgres.repositories.AnagraficaRepository;
import com.example.springPostgres.repositories.RecapitiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecapitiServiceImpl implements RecapitiService {
    @Autowired
    private RecapitiRepository recapitiRepository;

    @Autowired
    private AnagraficaRepository anagraficaRepository;

    @Override
    public Optional<RecapitiTelefonici> recapitoById(Long id){
        return recapitiRepository.findById(id);
    }

    @Override
    public Iterable<RecapitiTelefonici> recapitoAll(){
        return recapitiRepository.findAll();
    }

    @Override
    public RecapitiTelefonici newRecapiti(Long id, Long idana, String tipo_recapito, String numero_recapito){
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

    @Override
    public Boolean deleteRecapiti(long idreca){
        recapitiRepository.deleteById(idreca);
        return true;
    }

    @Override
    public Optional<RecapitiTelefonici> updateRecapiti(Long id, String tipo_recapito, String numero_recapito){
        Optional<RecapitiTelefonici> recapitiTelefonici = recapitiRepository.findById(id);
        recapitiTelefonici.ifPresent(a -> {
            a.setTipo_recapito(tipo_recapito);
            a.setNumero_recapito(numero_recapito);
        });

        return recapitiTelefonici;

    }
}
