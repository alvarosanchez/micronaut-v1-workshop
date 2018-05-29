package fixtures

import fixtures.clubs.Club
import fixtures.clubs.ClubsClient;
import io.micronaut.context.ApplicationContext
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.http.client.RxHttpClient
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

class FixtureControllerSpec extends Specification {

    @Shared @AutoCleanup EmbeddedServer embeddedServer = ApplicationContext.run(EmbeddedServer)
    @Shared @AutoCleanup RxHttpClient client = embeddedServer.applicationContext.createBean(RxHttpClient, embeddedServer.getURL())
    @Shared ClubsClient clubsClient = embeddedServer.applicationContext.getBean(ClubsClient)

    void "test index"() {
        when:
        Club club = clubsClient.findTeam(1).blockingGet()

        then:
        club.name == 'Real Madrid CF'
    }

}
