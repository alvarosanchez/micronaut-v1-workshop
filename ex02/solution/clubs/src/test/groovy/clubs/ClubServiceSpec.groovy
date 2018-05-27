package clubs

import clubs.domain.Club
import clubs.service.ClubService
import grails.gorm.transactions.Rollback
import io.micronaut.context.ApplicationContext
import io.micronaut.runtime.server.EmbeddedServer
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

@Rollback
class ClubServiceSpec extends Specification {

    @Shared @AutoCleanup EmbeddedServer embeddedServer = ApplicationContext.run(EmbeddedServer)
    @Shared ClubService service = embeddedServer.applicationContext.getBean(ClubService)

    void "it can list all clubs"() {
        when:
        List<Club> clubs = service.findAll()

        then:
        clubs.size() == 2
    }
}
