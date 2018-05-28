package hello.galaxy;

import io.micronaut.context.ApplicationContext
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.http.client.RxHttpClient
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

//tag::spec[]
class HelloControllerSpec extends Specification {

    @Shared @AutoCleanup EmbeddedServer embeddedServer = ApplicationContext.run(EmbeddedServer) // <1>
    @Shared @AutoCleanup RxHttpClient client = embeddedServer.applicationContext.createBean(RxHttpClient, embeddedServer.getURL()) // <2>

    void "test index"() {
        given:
        String response = client.toBlocking().retrieve("/hello") // <3>

        expect:
        response == "Hello Galaxy!"
    }
}
//end::spec[]
