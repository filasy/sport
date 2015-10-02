package sport

import sport.secure.User

class Forecast{
    User user
    Score score
    Date dateCreated
    Date lastUpdated
    boolean locked = false


    static belongsTo = [game: Game]

    static constraints = {
        user nullable: false
        game nullable: false, unique: ('user')
    }

    @Override
    String toString() {
        return score.toString()
    }

    def getBall() {
        return  score.getBall(game?.score)?: 0
    }
}
