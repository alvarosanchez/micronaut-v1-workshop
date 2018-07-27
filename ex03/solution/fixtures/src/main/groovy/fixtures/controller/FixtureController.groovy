package fixtures.controller

import fixtures.service.FixtureService
import fixtures.view.FixtureView
import groovy.transform.CompileStatic
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@CompileStatic
@Controller("/")
class FixtureController {

//tag::service[]
    FixtureService fixtureService

    FixtureController(FixtureService fixtureService) {
        this.fixtureService = fixtureService
    }
//end::service[]

//tag::action[]
    @Get("/")
    List<FixtureView> findAll() {
        fixtureService.findAll().collect {
            fixtureService.toView(it).blockingGet()
        }
    }
//end::action[]
}