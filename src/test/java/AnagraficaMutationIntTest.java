import com.example.springPostgres.IService.IAnagraficaService;
import com.example.springPostgres.model.Anagrafica;
import com.graphql.spring.boot.test.GraphQLResponse;
import com.graphql.spring.boot.test.GraphQLTestTemplate;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AnagraficaMutationIntTest {

    @Autowired
    private GraphQLTestTemplate graphQLTestTemplate;

    @MockBean
    //@ContextConfiguration
    private IAnagraficaService anagraficaServiceMock;
    static Anagrafica anagrafica = new Anagrafica();


    @BeforeAll
    static void setUp() {
        anagrafica.setNome("Piero");
        anagrafica.setCognome("Rossi");
    }

    @Test
    public void newAnagrafica() throws IOException {
        //doReturn(anagrafica).when(anagraficaServiceMock).newAnagrafica((long) 12, "Piero", "Rossi");
        GraphQLResponse response = graphQLTestTemplate.postForResource("graphql/create-ana.graphql");
        assertThat(response.isOk()).isTrue();
        assertThat(response.get("$.data.newAnagrafica.id")).isNotNull();
        assertThat(response.get("$.data.newAnagrafica.nome")).isEqualTo("Piero");

    }

    /*
    @Test
    @WithMockUser(username = TEST_USERNAME, roles = "ADMIN")
    public void deleteUser() throws IOException {
        doReturn(user).when(userServiceMock).deleteUser(TEST_USERNAME);
        GraphQLResponse response = graphQLTestTemplate.postForResource("graphql/delete-user.graphql");
        assertThat(response.isOk()).isTrue();
        assertThat(response.get("$.data.deleteUser.id")).isNotNull();
        assertThat(response.get("$.data.deleteUser.username")).isEqualTo(TEST_USERNAME);

    }

     */
}