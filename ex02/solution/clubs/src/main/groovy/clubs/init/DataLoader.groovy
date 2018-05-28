package clubs.init

import clubs.service.ClubService
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import io.micronaut.context.annotation.Requires
import io.micronaut.context.env.Environment
import io.micronaut.context.event.ApplicationEventListener
import io.micronaut.runtime.server.event.ServerStartupEvent

import javax.inject.Singleton

//tag::class[]
@Slf4j
@CompileStatic
@Singleton // <1>
@Requires(notEnv = Environment.TEST) // <2>
class DataLoader implements ApplicationEventListener<ServerStartupEvent> { // <3>

    final ClubService clubService

    DataLoader(ClubService clubService) {
        this.clubService = clubService
    }

    @Override
    void onApplicationEvent(ServerStartupEvent event) { // <4>
        if (!clubService.count()) {
            log.debug "Loading sample data"
            clubService.save("Real Madrid CF", "Santiago Bernabeu")
            clubService.save("FC Barcelona", "Camp Nou")
            clubService.save("CD Leganes", "Butarque")
            clubService.save("Getafe CF", "Coliseum")
        }
    }
}
//end::class[]
