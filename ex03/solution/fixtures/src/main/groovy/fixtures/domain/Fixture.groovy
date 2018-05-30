package fixtures.domain

import grails.gorm.annotation.Entity
import org.bson.types.ObjectId

@Entity
class Fixture {

//tag::fields[]
    ObjectId id
    Long homeClubId
    Long awayClubId

    Short homeScore
    Short awayScore

    Date date
//end::fields[]

}
