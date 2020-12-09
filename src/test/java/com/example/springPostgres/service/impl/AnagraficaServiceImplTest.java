package com.example.springPostgres.service.impl;

import com.example.springPostgres.model.Anagrafica;
import com.example.springPostgres.repositories.AnagraficaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;


@RunWith(MockitoJUnitRunner.class)
public class AnagraficaServiceImplTest {

    @Mock
    AnagraficaRepository anagraficaRepository;

    @InjectMocks
    AnagraficaServiceImpl anagraficaService;

    @Test
    public void newAnagrafica() {
        Anagrafica anagrafica = anagraficaService.newAnagrafica((long) 1, "test", "test");
        assertEquals(anagrafica.getNome(), "test");
    }

    @Test
    public void updateAnagrafica() {
    }

    @Test
    public void deleteAnagrafica() {
    }

    @Test
    public void anagraficaById() {
    }

    @Test
    public void anagraficaAll() {
    }
}