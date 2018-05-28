package clubs.controller

import clubs.api.ClubsApi
import clubs.domain.Club
import clubs.service.ClubService
import groovy.transform.CompileStatic
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get


@Controller("/")
@CompileStatic
class ClubController implements ClubsApi {

    final ClubService clubService

    ClubController(ClubService clubService) {
        this.clubService = clubService
    }

    @Get("/")
    List<Club> listClubs() {
        return clubService.findAll()
    }

    @Override
    @Get("/{id}")
    Club show(Long id) {
        return clubService.find(id)
    }
}