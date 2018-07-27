package clubs.domain

import grails.gorm.annotation.Entity
import groovy.transform.CompileStatic
import org.grails.datastore.gorm.GormEntity

@CompileStatic
@Entity
class Club implements GormEntity<Club> {

    String name
    String stadium

    static constraints = {
        stadium nullable: true
    }

}