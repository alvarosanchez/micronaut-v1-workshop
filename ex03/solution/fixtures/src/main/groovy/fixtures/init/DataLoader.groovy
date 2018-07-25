package fixtures.init

import fixtures.domain.Fixture
import fixtures.service.FixtureService
import groovy.util.logging.Slf4j
import io.micronaut.context.annotation.Requires
import io.micronaut.context.env.Environment
import io.micronaut.context.event.ApplicationEventListener
import io.micronaut.runtime.server.event.ServerStartupEvent

import javax.inject.Singleton

//tag::class[]
@Slf4j
@Singleton
@Requires(notEnv = Environment.TEST)
class DataLoader implements ApplicationEventListener<ServerStartupEvent> {

    final FixtureService fixtureService

    DataLoader(FixtureService fixtureService) {
        this.fixtureService = fixtureService
    }

    @Override
    void onApplicationEvent(ServerStartupEvent event) { // <4>
        if (!fixtureService.count()) {
            log.debug "Loading sample data"
            Fixture fixture = new Fixture(homeClubId: 1, homeScore: 5, awayClubId: 2, awayScore: 0, date: new Date())
            fixtureService.save(fixture)
        }
    }
}
//end::class[]