package com.example.springPostgres.controllerREST;

import com.example.springPostgres.model.Anagrafica;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Date;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Testcontainers
public class HttpRequestTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void testGet() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/anagrafica")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[*].idana").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$[*].idana").isNotEmpty());

    }

    @Test
    public void testPost() throws Exception{
        Anagrafica anagrafica = new Anagrafica();
        anagrafica.setIdana((long) 1);
        anagrafica.setNome("NomeTest");
        anagrafica.setCognome("CognomeTest");
        Date date = new Date();
        anagrafica.setDate_create(date);
        anagrafica.setDate_agg(date);

        this.mockMvc.perform(MockMvcRequestBuilders
            .post("/anagrafica")
            .content(new ObjectMapper().writeValueAsString(anagrafica))
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void putTest() throws Exception{
        Anagrafica anagrafica = new Anagrafica();
        anagrafica.setIdana((long) 1);
        anagrafica.setNome("NomeTest2");
        anagrafica.setCognome("CognomeTest2");
        Date date = new Date();
        anagrafica.setDate_create(date);
        anagrafica.setDate_agg(date);
        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/anagrafica/1")
                .content(new ObjectMapper().writeValueAsString(anagrafica))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void deleteTest() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders
                .delete("/anagrafica/{id}", 1))
                .andExpect(status().isAccepted());
    }

}
