package sport

class Round {
    Rank rank
    Integer roundNumber
    boolean locked = false

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
}
