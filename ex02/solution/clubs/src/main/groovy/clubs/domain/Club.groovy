package clubs.domain

import grails.gorm.annotation.Entity
import org.grails.datastore.gorm.GormEntity

@Entity
class Club implements GormEntity<Club> {

    String name
    String stadium

    static constraints = {
        stadium nullable: true
    }

}