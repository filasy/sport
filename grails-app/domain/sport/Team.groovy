package sport

class Team {
    String name

    static constraints = {
        name blank: false, unique: true, nullable: false
    }

    String toString(){
        name
    }
}
