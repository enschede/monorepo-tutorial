package nl.marcenschede.tests.monorepo.backend.backendservice

import nl.marcenschede.tests.monorepo.backend.Person
import nl.marcenschede.tests.monorepo.backend.PersonSearchCriteria
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@Component
@RestController
class Service {

    @PostMapping("/findPerson")
    fun findPerson(@RequestBody personSearchCriteria: PersonSearchCriteria ): Person {
        return when {
            personSearchCriteria.name == "marc" -> Person(name = "Marc Enschede")
            personSearchCriteria.name == "kitty" -> Person(name = "Kitty Enschede")
            personSearchCriteria.name == "yvette" -> Person(name = "Yvette Enschede")

            else -> Person("Unknown")
        }
    }
}
