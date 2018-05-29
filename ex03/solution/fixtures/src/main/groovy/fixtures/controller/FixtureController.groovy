package fixtures.controller

import fixtures.domain.Fixture
import fixtures.service.FixtureService
import fixtures.view.FixtureView
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.reactivex.Flowable


@Controller("/")
class FixtureController {

//tag::service[]
    FixtureService fixtureService

    FixtureController(FixtureService fixtureService) {
        this.fixtureService = fixtureService
    }
//end::service[]

    @Get("/")
    Flowable<FixtureView> listFixtures() {
        return Flowable.<FixtureView>fromIterable (
            fixtureService.findAll().collect {
                fixtureService.toView(it).blockingGet()
            }
        )
    }
}