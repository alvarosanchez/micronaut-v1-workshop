package fixtures.clubs

import io.micronaut.http.annotation.Get
import io.micronaut.http.client.Client
import io.reactivex.Maybe

//tag::class[]
@Client("clubs")
interface ClubsClient {

    @Get("/{id}")
    Maybe<Club> findTeam(Long id)

}
//end::class[]
