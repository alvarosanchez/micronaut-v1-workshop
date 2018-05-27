package clubs.init

import clubs.service.ClubService
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import io.micronaut.context.annotation.Requires
import io.micronaut.context.env.Environment
import io.micronaut.context.event.ApplicationEventListener
import io.micronaut.runtime.server.event.ServerStartupEvent

import javax.inject.Singleton

@Slf4j
@CompileStatic
@Singleton
@Requires(notEnv = Environment.TEST)
class DataLoader implements ApplicationEventListener<ServerStartupEvent> {

    final ClubService clubService

    DataLoader(ClubService clubService) {
        this.clubService = clubService
    }

    @Override
    void onApplicationEvent(ServerStartupEvent event) {
        if (!clubService.count()) {
            log.debug "Loading sample data"
            clubService.save("Real Madrid CF", "Santiago Bernabeu")
            clubService.save("FC Barcelona", "Camp Nou")
        }
    }
}
