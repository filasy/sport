package sport

class Round {
    Rank rank
    Integer roundNumber

    static constraints = {
        rank nullable: false
        roundNumber nullable: false, blank: false
    }

    String toString(){
        roundNumber
    }
}
