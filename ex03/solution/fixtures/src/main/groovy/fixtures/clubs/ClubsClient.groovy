package fixtures.clubs

import io.micronaut.http.client.Client

//tag::class[]
@Client("clubs")    // <1>
interface ClubsClient extends ClubsApi {}
//end::class[]
