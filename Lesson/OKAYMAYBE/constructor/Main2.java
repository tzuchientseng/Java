package constructor;

public class Main2 {
public static void main(String[] args) {
    House house = new House();
}
}

class House {
    private Room room;

// Parameterless constructor
    // public House() {
    //     this.room = new Room();
    // }

//  Parameterless constructor
    public House(){
        this(new Room());
    }

// Constructor with parameters
    public House(Room room) {
        super();
        this.room = room;
    }

}

class Room extends Object{
    public Room(){
        super();
    }
}