package clubs.service

import clubs.domain.Club
import grails.gorm.services.Service

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Service(Club)
interface ClubService {

//tag::operations[]
    int count()
    Club save(@NotBlank String name, @NotBlank String stadium)
    List<Club> findAll()
    Club find(@NotNull Long id)
//end::operations[]

}
