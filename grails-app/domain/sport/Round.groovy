package sport

import sport.secure.User

class Round {
    Rank rank
    Integer roundNumber
    boolean locked = false

    static hasMany = [matches: Match]

    static constraints = {
        rank nullable: false
        roundNumber nullable: false, blank: false
    }

    static mapping = {
        sort "roundNumber":"desc"
    }

    @Override
    String toString(){
        "Тур " + roundNumber
    }

    int getBallForUser(User user){
        def result = 0
        matches.each {
            result += Forecast.findByUserAndMatch(user, it)?.getBall()?:0
        }
        return result
    }
}
