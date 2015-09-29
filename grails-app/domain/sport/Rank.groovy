package sport

class Rank {
    String name;

    static constraints = {
        name blank: false, unique: true
    }

    @Override
    String toString(){
        name
    }
}
