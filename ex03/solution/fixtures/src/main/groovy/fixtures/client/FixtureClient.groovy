package fixtures.client

import fixtures.view.FixtureView
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.Client

@Client("/")
interface FixtureClient {
    @Get("/")
    List<FixtureView> findAll()

}
