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

class ClubControllerSpec extends Specification {

    @Shared @AutoCleanup EmbeddedServer embeddedServer = ApplicationContext.run(EmbeddedServer)
    @Shared ClubsClient client = embeddedServer.applicationContext.getBean(ClubsClient)
    @Shared ClubService service = embeddedServer.applicationContext.getBean(ClubService)

    @Transactional
    void setup() {
        service.save("Real Madrid CF", "Santiago Bernabeu")
        service.save("FC Barcelona", "Camp Nou")
    }

    @Transactional
    void cleanupSpec() {
        Club.list()*.delete()
    }

    void "test index"() {
        when:
        List<Club> response = client.listClubs()

        then:
        response.size() == 2
    }

    void "test find one"() {
        when:
        Club club = client.show(1)

        then:
        club.name == 'Real Madrid CF'
        club.stadium == 'Santiago Bernabeu'
    }
}
