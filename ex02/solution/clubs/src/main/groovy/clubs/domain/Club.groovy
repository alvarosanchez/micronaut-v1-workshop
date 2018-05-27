package clubs.domain

import grails.gorm.annotation.Entity

@Entity
class Club {

    String name
    String stadium

    static constraints = {
        stadium nullable: true
    }

}