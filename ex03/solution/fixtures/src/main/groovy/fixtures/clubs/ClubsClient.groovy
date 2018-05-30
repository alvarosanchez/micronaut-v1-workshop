package fixtures.clubs

import io.micronaut.http.client.Client
import io.micronaut.retry.annotation.Recoverable

//tag::class[]
@Client("clubs")    // <1>
@Recoverable        // <2>
interface ClubsClient extends ClubsApi {}
//end::class[]
