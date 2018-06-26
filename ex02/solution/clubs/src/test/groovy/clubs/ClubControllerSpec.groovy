package clubs

import clubs.client.ClubsClient
import clubs.domain.Club
import clubs.service.ClubService
import grails.gorm.transactions.Transactional
import io.micronaut.context.ApplicationContext
import io.micronaut.runtime.server.EmbeddedServer
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

//tag::spec[]
class ClubControllerSpec extends Specification {

    @Shared @AutoCleanup EmbeddedServer embeddedServer = ApplicationContext.run(EmbeddedServer)
    @Shared ClubsClient client = embeddedServer.applicationContext.getBean(ClubsClient)
    @Shared ClubService service = embeddedServer.applicationContext.getBean(ClubService)
    @Shared List<Club> clubs = []

    @Transactional // <1>
    void setupSpec() {
        clubs << service.save("Real Madrid CF", "Santiago Bernabeu")
        clubs << service.save("FC Barcelona", "Camp Nou")
    }

    @Transactional // <1>
    void cleanupSpec() {
        Club.list()*.delete()
    }

    void "test index"() {
        when:
        List<Club> response = client.listClubs()

        then:
        response.size() == clubs.size()
    }

    void "test find one"() {
        given:
        Long realMadridId = clubs.find { it.name == 'Real Madrid CF'}.id
        when:
        Club club = client.show(realMadridId)

        then:
        club.name == 'Real Madrid CF'
        club.stadium == 'Santiago Bernabeu'
    }
}
//end::spec[]
