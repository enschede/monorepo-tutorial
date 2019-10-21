package nl.marcenschede.tests.monorepo.it;

import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainIntegrationTest {

    @Test
    void greeting() {

        final String response = new RestTemplate().getForObject("http://localhost:8082/welcome/marc", String.class);

        assertEquals(response, "Welcome Marc Enschede");
    }
}
