package com.example.springPostgres.service.impl;

import com.example.springPostgres.model.Anagrafica;
import com.example.springPostgres.repositories.AnagraficaRepository;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;



@RunWith(MockitoJUnitRunner.class)
public class AnagraficaServiceImplTest {

    @InjectMocks
    AnagraficaServiceImpl anagraficaService;

    private static Anagrafica ana;
    private static AnagraficaRepository anagraficaRepository;
    private static long id = (long) 1;
    private static String nome= "test";
    private static String cognome = "test";
    private static List<Anagrafica> anaList = new ArrayList<Anagrafica>();

    @BeforeClass
    public static void init(){
        anagraficaRepository = Mockito.mock(AnagraficaRepository.class);
        ana = new Anagrafica();
        ana.setIdana(id);
        ana.setNome(nome);
        ana.setCognome(cognome);
        anaList.add(ana);
        Mockito.when(anagraficaRepository.findById(id)).thenReturn(Optional.ofNullable(ana));
        Mockito.when(anagraficaRepository.findAll()).thenReturn(anaList);
    }

    @Test
    public void newAnagrafica() {
        Anagrafica anagrafica = anagraficaService.newAnagrafica(id, nome, cognome);
        assertEquals(anagrafica.getNome(), nome);
    }

    @Test
    public void updateAnagrafica() {
        Optional<Anagrafica> anagrafica = anagraficaService.updateAnagrafica(id, nome, cognome);
        anagrafica.ifPresent(a -> {
            assertEquals(a.getNome(), nome);
        });
    }

    @Test
    public void deleteAnagrafica() {
        assertEquals(anagraficaService.deleteAnagrafica(id), true);
    }

    @Test
    public void anagraficaById() {
        Optional<Anagrafica> anagrafica = anagraficaService.anagraficaById(id);
        anagrafica.ifPresent(a-> {
            assertEquals(a.getNome(), nome);
            assertEquals(a.getCognome(), cognome);
        });
    }

    @Test
    public void anagraficaAll() {
        List<Anagrafica> anagraficas = anagraficaService.anagraficaAll();
        assertEquals(anagraficas.get(0).getNome(), nome);


    }
}