package com.example.springPostgres.ServiceMock;

import com.example.springPostgres.model.Anagrafica;
import com.example.springPostgres.repositories.AnagraficaRepository;
import com.example.springPostgres.service.impl.AnagraficaServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class AnagraficaServiceMock {

    @Mock
    AnagraficaRepository anagraficaRepository;

    @InjectMocks
    AnagraficaServiceImpl anagraficaService;

    @Test
    public void Test2(){
        Anagrafica anagrafica = anagraficaService.newAnagrafica((long) 1, "test", "test");
        assertEquals(anagrafica.getNome(), "test");
    }

    /*
    @Test
    public void Test1(){
        Anagrafica anagraficaTest = new Anagrafica();
        anagraficaTest.setIdana((long) 1);
        anagraficaTest.setNome("nomeTest");
        anagraficaTest.setCognome("cognomeTest");
        anagraficaTest.setDate_agg(new Date());
        anagraficaTest.setDate_create(new Date());
        Mockito.when(anagraficaService.newAnagrafica(anagraficaTest.getIdana(),
                anagraficaTest.getNome(),
                anagraficaTest.getCognome()))
                .thenReturn(anagraficaTest);

        assertEquals(anagraficaTest.getNome(), anagraficaService.newAnagrafica(anagraficaTest.getIdana(), anagraficaTest.getNome(), anagraficaTest.getCognome()).getNome());
    }
    */

}
