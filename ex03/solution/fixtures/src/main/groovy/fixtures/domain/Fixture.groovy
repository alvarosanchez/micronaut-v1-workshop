package fixtures.domain

import grails.gorm.annotation.Entity
import groovy.transform.CompileStatic
import org.bson.types.ObjectId
import org.grails.datastore.gorm.GormEntity

@CompileStatic
@Entity
class Fixture implements GormEntity<Fixture> {

//tag::fields[]
    ObjectId id
    Long homeClubId
    Long awayClubId

    Short homeScore
    Short awayScore

    Date date
//end::fields[]

}
