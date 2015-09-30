package sport

import org.grails.databinding.BindingFormat

class Match {
    @BindingFormat('dd:MM:yyyy HH:mm')
    Date startDate
    Round round
    Team firstTeam
    Team secondTeam
    Score score

    static hasMany = [forecasts: Forecast]

    static constraints = {
        startDate nullable: false
        round nullable: false
        firstTeam nullable: false, unique: ('secondTeam')
        secondTeam nullable: false, unique: ('firstTeam')
        score nullable: true
    }

    static mapping = {
        sort "startDate":"desc"
    }

    @Override
    String toString() {
        firstTeam.toString() + " - " + secondTeam.toString() + " (" + round.toString() + ")"
    }
}
