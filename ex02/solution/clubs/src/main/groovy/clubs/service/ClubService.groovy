package clubs.service

import clubs.domain.Club
import grails.gorm.services.Service

import javax.validation.constraints.NotBlank

@Service(Club)
interface ClubService {

    int count()

    Club save(@NotBlank String name, @NotBlank String stadium)

    List<Club> findAll()

}
