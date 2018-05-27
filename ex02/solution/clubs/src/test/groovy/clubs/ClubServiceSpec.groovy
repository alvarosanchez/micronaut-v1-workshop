package clubs

import clubs.domain.Club
import clubs.service.ClubService
import grails.gorm.transactions.Rollback
import io.micronaut.context.ApplicationContext
import io.micronaut.runtime.server.EmbeddedServer
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

class ClubServiceSpec extends Specification {

    @Shared @AutoCleanup EmbeddedServer embeddedServer = ApplicationContext.run(EmbeddedServer)
    @Shared ClubService service = embeddedServer.applicationContext.getBean(ClubService)

    @Rollback
    void "it can work with clubs"() {
        expect:
        service.count() == 0

        when:
        service.save("Real Madrid", "Bernabeu")

        then:
        service.count() == 1

        when:
        List<Club> clubs = service.findAll()

        then:
        clubs.size() == 1
    }
}
