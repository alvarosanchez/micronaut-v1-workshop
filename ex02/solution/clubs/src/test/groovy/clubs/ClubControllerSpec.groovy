package clubs

import clubs.client.ClubsClient
import clubs.domain.Club
import grails.gorm.transactions.Rollback;
import io.micronaut.context.ApplicationContext
import io.micronaut.runtime.server.EmbeddedServer
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

@Rollback
class ClubControllerSpec extends Specification {

    @Shared @AutoCleanup EmbeddedServer embeddedServer = ApplicationContext.run(EmbeddedServer)
    @Shared ClubsClient client = embeddedServer.applicationContext.getBean(ClubsClient)

    void "test index"() {
        given:
        List<Club> response = client.listClubs()

        expect:
        response.size() == 2
    }
}
