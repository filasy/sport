package sport

class Match {
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
        sort "startDate":"desc"
    }

    @Override
    String toString() {
        firstTeam.toString() + " - " + secondTeam.toString() + "(" + round.toString() + ")"
    }
}
