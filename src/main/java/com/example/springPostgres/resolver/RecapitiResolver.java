package com.example.springPostgres.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.springPostgres.model.Anagrafica;
import com.example.springPostgres.model.RecapitiTelefonici;
import com.example.springPostgres.repositories.AnagraficaRepository;
import org.springframework.stereotype.Component;

@Component
public class RecapitiResolver implements GraphQLResolver<RecapitiTelefonici> {
     private AnagraficaRepository anagraficaRepository;

     public  RecapitiResolver(AnagraficaRepository anagraficaRepository){
         this.anagraficaRepository = anagraficaRepository;
     }

     public Anagrafica getAnagrafica(RecapitiTelefonici recapitiTelefonici){
          return anagraficaRepository.findById(recapitiTelefonici.getAnagrafica().getIdana()).orElse(null);
     }
}
