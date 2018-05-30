package fixtures

import fixtures.domain.Fixture
import fixtures.service.FixtureService
import fixtures.view.FixtureView
import io.micronaut.context.ApplicationContext
import io.micronaut.runtime.server.EmbeddedServer
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

class FixtureServiceSpec extends Specification {

    @Shared @AutoCleanup EmbeddedServer embeddedServer = ApplicationContext.run(EmbeddedServer)
    @Shared FixtureService fixtureService = embeddedServer.applicationContext.getBean(FixtureService)

    void "it can get full details of a fixture"() {
        given:
        Date now = new Date()
        Fixture fixture = new Fixture(homeClubId: 1, homeScore: 5, awayClubId: 2, awayScore: 0, date: now)
        fixture = fixtureService.save(fixture)

        when:
        FixtureView view = fixtureService.toView(fixture).blockingGet()

        then:
        view.date == now
        view.homeClubName == "Real Madrid CF"
        view.homeScore == 5
        view.awayClubName == "FC Barcelona"
        view.awayScore == 0
        view.stadium == "Santiago Bernabeu"

        cleanup:
        fixture.delete(flush: true)
    }

}
