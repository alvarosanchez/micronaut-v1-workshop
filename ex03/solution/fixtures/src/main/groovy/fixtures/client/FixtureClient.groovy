package fixtures.client

import fixtures.view.FixtureView
import groovy.transform.CompileStatic
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.Client

@CompileStatic
@Client("/")
interface FixtureClient {
    @Get("/")
    List<FixtureView> findAll()

}
