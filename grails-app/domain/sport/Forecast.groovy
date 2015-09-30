package sport

import sport.secure.User

class Forecast {
    User user
    Score score
    Date dateCreated
    Date lastUpdated


    static belongsTo = [match: Match]

    static constraints = {
        user nullable: false
        match nullable: false
        score nullable: false
        match unique: ('user')
    }

    @Override
    String toString() {
        return score.toString()
    }

    int getBall() {
        return score.getBall(match.score)
    }
}
