package com.example.springPostgres.controller;

import com.example.springPostgres.resolver.AnagraficaResolver;
import com.example.springPostgres.resolver.IndirizziResolver;
import com.example.springPostgres.resolver.RecapitiResolver;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.GraphQLException;
import graphql.schema.GraphQLSchema;
import io.leangen.graphql.GraphQLSchemaGenerator;
import io.leangen.graphql.metadata.strategy.query.AnnotatedResolverBuilder;
import io.leangen.graphql.metadata.strategy.query.PublicResolverBuilder;
import io.leangen.graphql.metadata.strategy.value.jackson.JacksonValueMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class GraphqlController {
    private final GraphQL graphQL;

    @Autowired
    public GraphqlController(AnagraficaResolver anagraficaResolver,
                             IndirizziResolver indirizziResolver,
                             RecapitiResolver recapitiResolver) {
        GraphQLSchema schema = new GraphQLSchemaGenerator().withResolverBuilders(
                // Resolve by annotations
                new AnnotatedResolverBuilder(),
                // Resolve public methods inside root package
                new PublicResolverBuilder("com.graphql.userPoc"))
                .withOperationsFromSingleton(anagraficaResolver, AnagraficaResolver.class)
                .withOperationsFromSingleton(indirizziResolver, IndirizziResolver.class)
                .withOperationsFromSingleton(recapitiResolver, RecapitiResolver.class)
                .withValueMapperFactory(new JacksonValueMapperFactory()).generate();
        graphQL = GraphQL.newGraphQL(schema).build();
    }

    @PostMapping(value = "/graphql")
    public Map<String,Object> execute(@RequestBody Map<String, String> request, HttpServletRequest raw)
            throws GraphQLException {
        ExecutionResult result = graphQL.execute(request.get("query"));
        return result.getData();

    }

}
