package sport

class Round {
    Rank rank
    Integer roundNumber
    boolean enabled = true

    static constraints = {
        rank nullable: false
        roundNumber nullable: false, blank: false
    }

    String toString(){
        "Тур " + roundNumber
    }
}
