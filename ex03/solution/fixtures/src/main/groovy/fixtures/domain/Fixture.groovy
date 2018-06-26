package fixtures.domain

import grails.gorm.annotation.Entity
import groovy.transform.CompileStatic
import org.bson.types.ObjectId

@CompileStatic
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
