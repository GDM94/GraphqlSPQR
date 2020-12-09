
package com.example.springPostgres.controllerGraphQL;
/*
import com.example.springPostgres.repositories.AnagraficaRepository;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Moc;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
//@ActiveProfiles("test")
@AutoConfigureMockMvc
@Testcontainers
public class GraphqlTest {

    public JSONObject jo = new JSONObject();
    private JSONObject jo2 = new JSONObject();

    @Autowired
    private MockMvc mockMvc2;

    @Test
    public void Test2() throws Exception {

        JSONObject jo = new JSONObject();
        //jo.put("query", "{anagraficaById(id: 2) { nome } }");
        jo.put("mutation", "{newAnagrafica(id: 10, nome:“test“, cognome: “test“) { nome } }");
        System.out.println(jo.toString());
        jo.put("query", "{anagraficaById(id: 2) { nome } }");
        this.mockMvc2.perform(MockMvcRequestBuilders
                .post("/graphql")
                .content(jo.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

    }
    @Test
    public void Test3() throws Exception {
        this.mockMvc2.perform(MockMvcRequestBuilders
                .post("/graphql")
                .content("{\"query\":\" {anagraficaById(id:1) { idana nome cognome } } \"}")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    public void Test4() throws Exception {
        jo2.put("mutation", "{newAnagrafica(id: 15, nome: \"Carlo\", cognome: \"Luciani\") { idana nome cognome} }");
        //o2.put("mutation", "{deleteAnagrafica(id: 1)}");
        //System.out.println(jo2.toString());

        //jo.put("query", "{anagraficaById(id: 2) { nome } }");

        this.mockMvc2.perform(MockMvcRequestBuilders
                .post("/graphql")
                .content(jo2.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());



    }

}

@SpringBootTest
//@ActiveProfiles("test")
@AutoConfigureMockMvc
@Testcontainers
class GraphqlTest2 {

    @Autowired
    private MockMvc mockMvc3;

    @Mock
    AnagraficaRepository anagraficaRepository;

    @InjectMocks
    @Test
    public void Test5() throws Exception {
        //jo2.put("mutation", "{newAnagrafica(id: 15, nome: 'Carlo', cognome: 'Luciani') { idana nome cognome} }");
        JSONObject jo2 = new JSONObject();
        jo2.put("mutation", "{deleteAnagrafica(id: 1)}");
        System.out.println(jo2);

        //jo.put("query", "{anagraficaById(id: 2) { nome } }");


        this.mockMvc3.perform(MockMvcRequestBuilders
                .post("/graphql")
                .content(jo2.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

}

*/