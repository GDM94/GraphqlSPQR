package com.example.springPostgres.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.springPostgres.IService.IAnagraficaService;
import com.example.springPostgres.model.RecapitiTelefonici;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RecapitiResolver implements GraphQLResolver<RecapitiTelefonici> {

     @Autowired
     IAnagraficaService nagraficaService;


}
