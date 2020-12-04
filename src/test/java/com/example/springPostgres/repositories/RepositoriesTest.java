package com.example.springPostgres.repositories;

import com.example.springPostgres.model.Anagrafica;
import com.example.springPostgres.model.Indirizzo;
import com.example.springPostgres.model.RecapitiTelefonici;
import javafx.beans.binding.BooleanExpression;
import org.junit.Before;
import org.junit.ClassRule;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@ActiveProfiles("test")
@Testcontainers
public class RepositoriesTest {

    @Autowired
    private AnagraficaRepository anagraficaRepository;

    @Autowired
    private RecapitiRepository recapitiRepository;

    @Autowired
    private IndirizzoRepository indirizzoRepository;


    @Test
    public void test1(){
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

    @Test
    public void test3(){
        int i = anagraficaRepository.updateNomeCognome(1, "gio1");
        assertEquals(1, i);
    }




}