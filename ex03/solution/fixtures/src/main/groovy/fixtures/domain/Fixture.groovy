package fixtures.domain

import grails.gorm.annotation.Entity

import java.time.ZonedDateTime

@Entity
class Fixture {

//tag::fields[]
//    ObjectId id
    Long homeClubId
    Long awayClubId

    Short homeScore
    Short awayScore

    ZonedDateTime date
//end::fields[]

}
