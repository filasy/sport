package sport

class Rank {
    String name;

    static constraints = {
        name blank: false, unique: true
    }

    String toString(){
        name
    }
}
