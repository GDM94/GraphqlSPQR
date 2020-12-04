package com.example.springPostgres.controllerGraphQL;




import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
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

    @Autowired
    private MockMvc mockMvc2;


























































    @Test
    public void Test2() throws Exception {
        JSONObject jo = new JSONObject();
        jo.put("query", "{anagraficaById(id: 2) { nome } }");

        this.mockMvc2.perform(MockMvcRequestBuilders
                .post("/graphql")
                .content(jo.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

    }
}
