package clubs.client

import clubs.api.ClubsApi
import groovy.transform.CompileStatic
import io.micronaut.http.client.Client

@CompileStatic
@Client("/")
interface ClubsClient extends ClubsApi {}