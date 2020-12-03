package com.example.springPostgres.resolver;


import com.example.springPostgres.IService.IAnagraficaService;
import com.example.springPostgres.model.Anagrafica;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AnagraficaResolver {

    @Autowired
    private IAnagraficaService anagraficaService;

    @GraphQLMutation
    public Anagrafica newAnagrafica(Long id, String nome, String cognome) {
        return anagraficaService.newAnagrafica(id, nome, cognome);
    }

    @GraphQLMutation
    public Optional<Anagrafica> updateAnagrafica(Long id, String nome, String cognome) {
        return anagraficaService.updateAnagrafica(id, nome, cognome);
    }

    @GraphQLMutation
    public boolean deleteAnagrafica(Long id) {
        return anagraficaService.deleteAnagrafica(id);
    }

    @GraphQLQuery
    public Optional<Anagrafica> anagraficaById(Long id) {
        return anagraficaService.anagraficaById(id);
    }

    @GraphQLQuery
    public Iterable<Anagrafica> anagraficaAll() {
        return anagraficaService.anagraficaAll();
    }

}