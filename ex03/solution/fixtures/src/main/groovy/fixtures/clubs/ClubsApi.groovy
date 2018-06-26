package fixtures.clubs

import groovy.transform.CompileStatic
import io.micronaut.http.annotation.Get
import io.reactivex.Maybe

@CompileStatic
//tag::class[]
interface ClubsApi {
    @Get("/{id}")
    Maybe<Club> findTeam(Long id)
}
//end::class[]
