package com.example.springPostgres.IService;

import com.example.springPostgres.model.RecapitiTelefonici;

import java.util.Optional;

public interface IRecapitiService {
    public Optional<RecapitiTelefonici> recapitoById(Long id);
    public Iterable<RecapitiTelefonici> recapitoAll();
    public RecapitiTelefonici newRecapiti(Long id, Long idana, String tipo_recapito, String numero_recapito);
    public void deleteRecapiti(long idreca);
    public RecapitiTelefonici updateRecapiti(Long id, String tipo_recapito, String numero_recapito);


}
