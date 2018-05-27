package clubs.client

import clubs.api.ClubsApi
import io.micronaut.http.client.Client

@Client("/")
interface ClubsClient extends ClubsApi {}