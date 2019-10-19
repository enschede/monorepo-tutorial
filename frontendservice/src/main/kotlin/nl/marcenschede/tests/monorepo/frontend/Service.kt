package nl.marcenschede.tests.monorepo.frontend

import nl.marcenschede.tests.monorepo.backend.Person
import nl.marcenschede.tests.monorepo.backend.PersonSearchCriteria
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import org.springframework.web.reactive.function.BodyExtractors
import org.springframework.web.reactive.function.BodyInserter
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono
import java.time.Duration

@RestController
class Service {

    @GetMapping("/welcome/{name}")
    fun welcome (@PathVariable name: String): Mono<String>? {

        val webClient = WebClient.create("http://localhost:8081/").method(HttpMethod.POST)
                .uri("/findPerson")
                .body(BodyInserters.fromObject(PersonSearchCriteria(name)))
                .retrieve()
                .bodyToMono(Person::class.java)
                .map { t -> "Welcome ${t.name}" }
                .timeout(Duration.ofMillis(1000))
                .onErrorReturn("Timeout")

        return webClient
    }
}