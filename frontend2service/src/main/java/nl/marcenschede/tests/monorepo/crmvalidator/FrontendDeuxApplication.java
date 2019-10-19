package nl.marcenschede.tests.monorepo.crmvalidator;

import nl.marcenschede.tests.monorepo.backend.Person;
import nl.marcenschede.tests.monorepo.backend.PersonSearchCriteria;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;

@SpringBootApplication
@RestController
public class FrontendDeuxApplication {

    public static void main(String[] args) {
        SpringApplication.run(FrontendDeuxApplication.class, args);
    }

    @GetMapping("/welcome/{name}")
    public Mono<String> welcome(@PathVariable String name) {

        return WebClient.create("http://localhost:8081/findPerson").method(HttpMethod.POST)
                .body(BodyInserters.fromValue(new PersonSearchCriteria(name)))
                .retrieve()
                .bodyToMono(Person.class)
                .map(s -> "Welcome " + s.getName())
                .timeout(Duration.ofSeconds(1))
                .onErrorReturn("Timeout");
    }
}
