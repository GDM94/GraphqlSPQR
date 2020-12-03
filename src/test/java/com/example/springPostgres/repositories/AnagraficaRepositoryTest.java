package com.example.springPostgres.repositories;

import com.example.springPostgres.model.Anagrafica;
import javafx.beans.binding.BooleanExpression;
import org.junit.ClassRule;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class AnagraficaRepositoryTest {

    @Autowired
    private AnagraficaRepository anagraficaRepository;

    @ClassRule
    public static PostgreSQLContainer postgreSQLContainer = BaeldungPostgresqlContainer.getInstance();


    private void insertAnagrafica() {
        newAnagrafica((long) 1, "Giovanni", "Di Martino");
        newAnagrafica((long) 2, "Luca", "Gabellini");
        newAnagrafica((long) 3, "Marco", "Pisu");
        newAnagrafica((long) 4, "Ivo", "Guerra");
        newAnagrafica((long) 5, "Michele", "Allevi");
        anagraficaRepository.flush();
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

    @Test
    public void test1(){
        insertAnagrafica();
        List<Anagrafica> analist =  anagraficaRepository.findAll();
        System.out.println(analist);
        assertEquals(5, analist.size());
    }




}