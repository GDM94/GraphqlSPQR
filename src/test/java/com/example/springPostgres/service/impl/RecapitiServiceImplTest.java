package com.example.springPostgres.service.impl;

import com.example.springPostgres.model.Anagrafica;
import com.example.springPostgres.model.RecapitiTelefonici;
import com.example.springPostgres.repositories.AnagraficaRepository;
import com.example.springPostgres.repositories.RecapitiRepository;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class RecapitiServiceImplTest {

    @InjectMocks
    RecapitiServiceImpl recapitiService;

    private static RecapitiRepository recapitiRepository;
    private static RecapitiTelefonici recapitiTelefonici = new RecapitiTelefonici();
    private static Anagrafica anagrafica = new Anagrafica();
    private static Long idreca = (long) 1;
    private static Long idana = (long) 1;
    private static String tipo_reca = "mobile";
    private static String numero_reca = "test";
    private static String nome = "test";
    private static String cognome = "test";
    private static ArrayList<RecapitiTelefonici> recaList = new ArrayList<RecapitiTelefonici>();


    @BeforeClass
    public static void init(){
        recapitiRepository = Mockito.mock(RecapitiRepository.class);
        recapitiTelefonici.setIdreca(idreca);
        recapitiTelefonici.setIdana(idana);
        recapitiTelefonici.setTipo_recapito(tipo_reca);
        recapitiTelefonici.setNumero_recapito(numero_reca);
        anagrafica.setIdana(idana);
        anagrafica.setNome(nome);
        anagrafica.setCognome(cognome);
        recapitiTelefonici.setAnagrafica(anagrafica);
        recaList.add(recapitiTelefonici);

        Mockito.when(recapitiRepository.findById(idreca)).thenReturn(Optional.ofNullable(recapitiTelefonici));
        Mockito.when(recapitiRepository.findAll()).thenReturn(recaList);
    }

    @Test
    public void recapitoById() {
        Optional<RecapitiTelefonici> reca = recapitiService.recapitoById(idreca);
        reca.ifPresent(r -> {
            assertEquals(r.getIdreca(), idreca);
        });
    }

    @Test
    public void recapitoAll() {
        List<RecapitiTelefonici> r = recapitiService.recapitoAll();
        assertEquals(r.get(0).getIdreca(), idreca);
    }

    @Test
    public void newRecapiti() {
        RecapitiTelefonici r = recapitiService.newRecapiti(idreca, idana, tipo_reca, numero_reca);
        assertEquals(r.getIdreca(), idreca);
    }

    @Test
    public void deleteRecapiti() {
        boolean condition = recapitiService.deleteRecapiti(idreca);
        assertEquals(condition, true);
    }

    @Test
    public void updateRecapiti() {
        Optional<RecapitiTelefonici> reca = recapitiService.updateRecapiti(idreca, tipo_reca, numero_reca);
        reca.ifPresent(r-> {
            assertEquals(r.getIdreca(), idreca);
        });
    }
}