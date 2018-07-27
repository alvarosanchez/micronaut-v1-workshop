package fixtures.view

import groovy.transform.CompileStatic

@CompileStatic
class FixtureView {

//tag::fields[]
    String homeClubName
    String awayClubName

    String stadium

    Short homeScore
    Short awayScore

    Date date
//end::fields[]

}
