package com.example.springPostgres.resolver;


import com.example.springPostgres.service.IndrizzoService;
import com.example.springPostgres.model.Indirizzo;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class IndirizziResolver {
    @Autowired
    IndrizzoService idrizzoService;

    @GraphQLQuery
    public Optional<Indirizzo> indirizzoById(Long id){
        return idrizzoService.indirizzoById(id);
    }

    @GraphQLQuery
    public Iterable<Indirizzo> indirizzoAll(){
        return idrizzoService.indirizzoAll();
    }


    @GraphQLMutation
    public Indirizzo newIndirizzo(Long id, Long idana, String descrizione){
        return  idrizzoService.newIndirizzo(id, idana, descrizione);
    }

    @GraphQLMutation
    public Optional<Indirizzo> updateIndirizzo(Long id, String descrizione){
        return idrizzoService.updateIndirizzo(id, descrizione);
    }

    @GraphQLMutation
    public boolean deleteIndirizzo(Long id){
        return idrizzoService.deleteIndirizzo(id);
    }
}
