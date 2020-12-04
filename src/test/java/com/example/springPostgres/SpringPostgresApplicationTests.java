package com.example.springPostgres;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class GraphqldemoApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Test
	void anagraficaAll() throws Exception {
		String expectedResponse = "{\n" +
				"    \"anagraficaAll\": [\n" +
				"        {\n" +
				"            \"nome\": \"Arianna\"\n" +
				"        },\n" +
				"        {\n" +
				"            \"nome\": \"Tommaso\"\n" +
				"        },\n" +
				"        {\n" +
				"            \"nome\": \"Andrea\"\n" +
				"        },\n" +
				"        {\n" +
				"            \"nome\": \"Giancarlo\"\n" +
				"        },\n" +
				"        {\n" +
				"            \"nome\": \"Giancarlo\"\n" +
				"        }\n" +
				"    ]\n" +
				"}";

		mockMvc.perform(MockMvcRequestBuilders.post("/graphql")
				.content("query {\n" +
						"    anagraficaAll{\n" +
						"        nome\n" +
						"        \n" +
						"\n" +
						"    }\n" +
						"}")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json(expectedResponse))
				.andReturn();
	}

}