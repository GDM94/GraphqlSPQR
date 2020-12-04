package com.example.springPostgres.repositories;

import com.example.springPostgres.model.Anagrafica;
import com.example.springPostgres.model.Indirizzo;
import com.example.springPostgres.model.RecapitiTelefonici;
import org.junit.ClassRule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

//import javafx.beans.binding.BooleanExpression;


@SpringBootTest
public class RepositoriesTest {

    @Autowired
    private AnagraficaRepository anagraficaRepository;

    @Autowired
    private RecapitiRepository recapitiRepository;

    @Autowired
    private IndirizzoRepository indirizzoRepository;

    @ClassRule
    public static PostgreSQLContainer postgreSQLContainer = BaeldungPostgresqlContainer.getInstance();


    private void insertDB() {
        newAnagrafica((long) 1, "Giovanni", "Di Martino");
        newAnagrafica((long) 2, "Luca", "Gabellini");
        newAnagrafica((long) 3, "Marco", "Pisu");
        newAnagrafica((long) 4, "Ivo", "Guerra");
        newAnagrafica((long) 5, "Michele", "Allevi");
        anagraficaRepository.flush();
        newRecapiti((long) 1, (long) 1, "mobile", "3314576361");
        newRecapiti((long) 2, (long) 2, "mobile", "3314576362");
        newRecapiti((long) 3, (long) 3, "mobile", "3314576363");
        newRecapiti((long) 4, (long) 4, "mobile", "3314576364");
        newRecapiti((long) 5, (long) 5, "mobile", "3314576365");
        recapitiRepository.flush();
        newIndirizzi((long) 1, (long) 1, "corso re umberto 74");
        newIndirizzi((long) 2, (long) 2, "corso re umberto 75");
        newIndirizzi((long) 3, (long) 3, "corso re umberto 76");
        newIndirizzi((long) 4, (long) 4, "corso re umberto 77");
        newIndirizzi((long) 5, (long) 5, "corso re umberto 78");
        indirizzoRepository.flush();
    }

    public void newAnagrafica(Long id, String nome, String cognome) {
        Anagrafica anagrafica = new Anagrafica();
        anagrafica.setIdana(id);
        anagrafica.setNome(nome);
        anagrafica.setCognome(cognome);
        Date date = new Date();
        anagrafica.setDate_create(date);
        anagrafica.setDate_agg(date);
        anagraficaRepository.save(anagrafica);
    }

    public void newRecapiti(Long idreca, Long idana, String tipo_recapito, String numero_recapito){
        RecapitiTelefonici recapitiTelefonici = new RecapitiTelefonici();
        recapitiTelefonici.setIdreca(idreca);
        recapitiTelefonici.setIdana(idana);
        recapitiTelefonici.setTipo_recapito(tipo_recapito);
        recapitiTelefonici.setNumero_recapito(numero_recapito);
        Anagrafica anagrafica = new Anagrafica();
        anagrafica.setIdana(idana);
        recapitiTelefonici.setAnagrafica(anagrafica);
        recapitiRepository.save(recapitiTelefonici);
    }

    public void newIndirizzi(Long idInd, Long idana, String descrizione){
        Indirizzo indirizzo = new Indirizzo();
        indirizzo.setIdaddress(idInd);
        indirizzo.setIdana(idana);
        indirizzo.setDescrizione(descrizione);
        Date date = new Date();
        indirizzo.setDate_create(date);
        indirizzo.setDate_agg(date);
        Anagrafica anagrafica = new Anagrafica();
        anagrafica.setIdana(idana);
        indirizzo.setAnagrafica(anagrafica);
        indirizzoRepository.save(indirizzo);
    }





    @Test
    public void test1(){
        insertDB();
        List<Anagrafica> analist =  anagraficaRepository.findAll();
        System.out.println(analist);
        assertEquals(5, analist.size());
    }

    @Test
    public void test2(){
        List<String> anaNameNumero = anagraficaRepository.getName_Numero(1);
        System.out.println(anaNameNumero);
        assertEquals(1, anaNameNumero.size());
    }




}