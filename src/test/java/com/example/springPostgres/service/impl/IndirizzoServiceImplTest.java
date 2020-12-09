package com.example.springPostgres.service.impl;

import com.example.springPostgres.model.Indirizzo;
import com.example.springPostgres.repositories.IndirizzoRepository;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;



@RunWith(MockitoJUnitRunner.class)
public class IndirizzoServiceImplTest {

    @InjectMocks
    IndirizzoServiceImpl indirizzoService;

    private static Indirizzo ind;
    private static IndirizzoRepository indirizzoRepository;
    private static long id = (long) 1;
    private static Long idana= (long) 1;
    private static String descrizione = "test";
    private static List<Indirizzo> indList = new ArrayList<Indirizzo>();

    @BeforeClass
    public static void init(){
        indirizzoRepository = Mockito.mock(IndirizzoRepository.class);
        ind = new Indirizzo();
        ind.setIdaddress(id);
        ind.setIdana(idana);
        ind.setDescrizione(descrizione);
        indList.add(ind);
        Mockito.when(indirizzoRepository.findById(id)).thenReturn(Optional.ofNullable(ind));
        Mockito.when(indirizzoRepository.findAll()).thenReturn(indList);
    }

    @Test
    public void newindirizzo() {
        Indirizzo indirizzo = indirizzoService.newIndirizzo(id, idana, descrizione);
        assertEquals(indirizzo.getDescrizione(), descrizione);
    }

    @Test
    public void updateindirizzo() {
        Optional<Indirizzo> indirizzo = indirizzoService.updateIndirizzo(id, descrizione);
        indirizzo.ifPresent(a -> {
            assertEquals(a.getDescrizione(), descrizione);
        });
    }

    @Test
    public void deleteindirizzo() {
        assertEquals(indirizzoService.deleteIndirizzo(id), true);
    }

    @Test
    public void indirizzoById() {
        Optional<Indirizzo> indirizzo = indirizzoService.indirizzoById(id);
        indirizzo.ifPresent(a-> {
            assertEquals(a.getDescrizione(), descrizione);
            assertEquals(a.getIdana(), idana);
        });
    }

    @Test
    public void indirizzoAll() {
        List<Indirizzo> indirizzo = (List<Indirizzo>) indirizzoService.indirizzoAll();
        assertEquals(indirizzo.get(0).getDescrizione(), descrizione);

    }
}