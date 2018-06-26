package fixtures.clubs

import groovy.transform.CompileStatic
import io.micronaut.http.client.Client

//tag::class[]
@CompileStatic
@Client("clubs")    // <1>
interface ClubsClient extends ClubsApi {}
//end::class[]
