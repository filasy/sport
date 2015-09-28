package sport

class Score {
    Integer firstTeam
    Integer secondTeam

    static constraints = {
        firstTeam  blank: false, nullable: false
        secondTeam  blank: false, nullable: false
    }

    String toString(){
        firstTeam + ":" + secondTeam
    }
}
