package sport

import sport.secure.User

class Forecast {
    User user
    Match match
    Score score
    Date dateCreated
    Date lastUpdated

    static constraints = {
        user nullable: false
        match nullable: false
        score nullable: true
    }
}
