package fixtures

import fixtures.clubs.Club
import fixtures.clubs.ClubsApi
import io.micronaut.retry.annotation.Fallback
import io.reactivex.Maybe

//tag::class[]
@Fallback
class ClubsClientMock implements ClubsApi{

    @Override
    Maybe<Club> findTeam(Long id) {
        if (id == 1) {
            Maybe.just(new Club(name: "CD Leganes", stadium: "Butarque"))
        } else {
            Maybe.just(new Club(name: "Getafe CF", stadium: "Coliseum"))
        }
    }
}
//end::class[]
