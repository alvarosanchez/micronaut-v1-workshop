package fixtures

import fixtures.client.FixtureClient
import fixtures.domain.Fixture
import fixtures.service.FixtureService
import fixtures.view.FixtureView;
import io.micronaut.context.ApplicationContext
import io.micronaut.runtime.server.EmbeddedServer
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

class FixtureControllerSpec extends Specification {

    @Shared @AutoCleanup EmbeddedServer embeddedServer = ApplicationContext.run(EmbeddedServer)
    @Shared FixtureClient client = embeddedServer.applicationContext.getBean(FixtureClient)
    @Shared FixtureService fixtureService = embeddedServer.applicationContext.getBean(FixtureService)

    void "test index"() {
        given:
        Fixture fixture = new Fixture(homeClubId: 1, homeScore: 5, awayClubId: 2, awayScore: 0, date: new Date())
        fixtureService.save(fixture)

        when:
        List<FixtureView> views = client.findAll()

        then:
        views.first().homeClubName == "Real Madrid CF"
        views.first().awayClubName == "FC Barcelona"

        cleanup:
        fixture.delete(flush: true)
    }
}
