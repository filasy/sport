package sport

import sport.secure.User

class Forecast {
    User user
    Score score
    Date dateCreated
    Date lastUpdated
    boolean enabled = true


    static belongsTo = [match: Match]

    static constraints = {
        user nullable: false
        match nullable: false
        score nullable: false
    }

    @Override
    String toString() {
        return score.toString()
    }
}
