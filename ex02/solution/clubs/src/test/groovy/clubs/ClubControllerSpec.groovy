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
    @Shared Long id

    @Transactional // <1>
    void setupSpec() {
        id = service.save("Real Madrid CF", "Santiago Bernabeu").id
        service.save("FC Barcelona", "Camp Nou")
    }

    @Transactional // <1>
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
        Club club = client.show(id)

        then:
        club.name == 'Real Madrid CF'
        club.stadium == 'Santiago Bernabeu'
    }
}
//end::spec[]
