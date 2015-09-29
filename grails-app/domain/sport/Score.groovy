package sport

class Score implements Comparable <Score> {
    Integer firstTeam
    Integer secondTeam

    static constraints = {
        firstTeam  blank: false, nullable: false
        secondTeam  blank: false, nullable: false
    }

    @Override
    String toString(){
        firstTeam + ":" + secondTeam
    }

    @Override
    int compareTo(Score obj) {
        int result = firstTeam.compareTo(obj.firstTeam)
        if (result != 0) {
            return result
        } else {
            return secondTeam.compareTo(obj.secondTeam)
        }
    }
}
