package sport

class Round {
    Rank rank
    Integer roundNumber
    boolean enabled = true

    static constraints = {
        rank nullable: false
        roundNumber nullable: false, blank: false
    }

    @Override
    String toString(){
        "Тур " + roundNumber
    }
}
