package clubs.api

import clubs.domain.Club
import io.micronaut.http.HttpResponse
import io.micronaut.http.client.Client
import io.micronaut.http.annotation.Get

interface ClubsApi {

    @Get("/")
    List<Club> listClubs()

}