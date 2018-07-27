package clubs.api

import clubs.domain.Club
import groovy.transform.CompileStatic
import io.micronaut.http.annotation.Get

@CompileStatic
interface ClubsApi {

    @Get("/")
    List<Club> listClubs()

    @Get("/{id}")
    Club show(Long id)

}