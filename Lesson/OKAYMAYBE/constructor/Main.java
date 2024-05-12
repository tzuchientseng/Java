package constructor;

public class Main {
public static void main(String[] args) {
    House house = new House();
}
}

class House {
    private Room room;
    
// Parameterless constructor
    public House() {
    this.room = new Room();
}
}

class Room {}