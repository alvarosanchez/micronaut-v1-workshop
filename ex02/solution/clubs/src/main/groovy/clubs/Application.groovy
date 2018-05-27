package clubs

import clubs.service.ClubService
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import io.micronaut.context.event.ApplicationEventListener
import io.micronaut.runtime.Micronaut
import io.micronaut.runtime.server.event.ServerStartupEvent

import javax.inject.Singleton

@Slf4j
@CompileStatic
@Singleton
class Application implements ApplicationEventListener<ServerStartupEvent> {

    final ClubService clubService

    Application(ClubService clubService) {
        this.clubService = clubService
    }

    static void main(String... args) {
        Micronaut.run(Application, args)
    }

    @Override
    void onApplicationEvent(ServerStartupEvent event) {
        if (!clubService.count()) {
            clubService.save("Real Madrid CF", "Santiago Bernabeu")
            clubService.save("FC Barcelona", "Camp Nou")
        }
    }
}
