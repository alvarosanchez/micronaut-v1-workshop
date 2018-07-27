package clubs

import clubs.domain.Club
import clubs.service.ClubService
import grails.gorm.transactions.Rollback
import io.micronaut.context.ApplicationContext
import io.micronaut.runtime.server.EmbeddedServer
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

//tag::spec[]
@Rollback // <1>
class ClubServiceSpec extends Specification {

    @Shared @AutoCleanup EmbeddedServer embeddedServer = ApplicationContext.run(EmbeddedServer)
    @Shared ClubService service = embeddedServer.applicationContext.getBean(ClubService) // <2>

    void "it can work with clubs"() {
        when:
        service.save("Real Madrid CF", "Bernabeu")

        then:
        service.count() == old(service.count()) + 1
        service.findAll().size() == old(service.findAll().size()) + 1
    }

    void "it can save and fetch a club"() {
        given:
        final String name = 'CD Leganes'
        final String stadium = 'Butarque'

        when:
        Club savedClub = service.save(name, stadium)

        then:
        savedClub.name == name
        savedClub.stadium == stadium

        when:
        Club club = service.find(savedClub.id)

        then:
        club.name == name
        club.stadium == stadium
    }
}
//end::spec[]
