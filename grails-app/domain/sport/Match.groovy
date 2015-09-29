package sport

import org.grails.databinding.BindingFormat

class Match {
    @BindingFormat('dd:MM:yyyy HH:mm')
    Date startDate
    Round round
    Team firstTeam
    Team secondTeam
    Score score

    static constraints = {
        startDate nullable: false
        round nullable: false
        firstTeam nullable: false
        secondTeam nullable: false
        score nullable: true
    }

    static mapping = {
        sort "startDate":"asc"
    }

    @Override
    String toString() {
        firstTeam.toString() + " - " + secondTeam.toString() + "(" + round.toString() + ")"
    }
}
