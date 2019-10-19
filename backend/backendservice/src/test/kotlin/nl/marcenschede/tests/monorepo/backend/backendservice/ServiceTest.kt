package nl.marcenschede.tests.monorepo.backend.backendservice

import nl.marcenschede.tests.monorepo.backend.PersonSearchCriteria
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ServiceTest {

    val service = Service()

    @Test
    fun findMarc() {
        val person = service.findPerson(PersonSearchCriteria("marc"))

        assertThat(person.name).isEqualTo("Marc Enschede")
    }

    @Test
    fun findKitty() {
        val person = service.findPerson(PersonSearchCriteria("kitty"))

        assertThat(person.name).isEqualTo("Kitty Enschede")
    }

    @Test
    fun findYvette() {
        val person = service.findPerson(PersonSearchCriteria("yvette"))

        assertThat(person.name).isEqualTo("Yvette Enschede")
    }
}