package streamAPI;

import java.util.List;

public class HWDemo {
    public static void main(String[] args) {
        // var d = new Disc(1,"aa",10,List.of(1,2,4));
        // System.out.println(d);

        var list = List.of(
            new Disc(1, "aa", 100, List.of(1, 2, 3)),
            new Disc(2, "bb", 300, List.of(2, 2, 3)),
            new Disc(3, "cc", 500, List.of(3, 5, 4)),
            new Disc(4, "dd", 600, List.of(4, 4, 4)),
            new Disc(5, "ee", 900, List.of(1, 2, 3))
        );
        System.out.println(list);

        var sum = list.stream()
            .filter(d -> d.getPrice() >= 500) // Filter discs with price >= 500
            .filter(d -> d.getID() > 3) // Further filter discs with id > 3
            .map(Disc::getPrice) // Map remaining discs to their prices
            .reduce(0, Integer::sum); // Sum up the prices

        System.out.println("Sum: " + sum);
    }
}

class Disc {
    private int id;
    private String name;
    private int price;
    private List<Integer> rep;

    public Disc(int id, String name, int price, List<Integer> rep) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rep = rep;
    }

    public int getID() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }

    public List<Integer> getRep() {
        return this.rep;
    }

    @Override
    public String toString() {
        var s = "id=%s, name=%s, price=%s, rep=%s";
        return String.format(s, this.id, this.name, this.price, this.rep);
    }
}


/*
class Product:
    def __init__(self, id, name, price, rep):
        self.id = id
        self.name = name
        self.price = price
        self.rep = rep

    def __str__(self):
        s = "id=%s, name=%s, price=%s, rep=%s"
        return s % (self.id, self.name, self.price, self.rep)
    def __str__(self):
        s = "id={}, name={}, price={}, rep={}"
        return s.format(self.id, self.name, self.price, self.rep)
# 示例
product = Product(1, "Product A", 10.99, "High")
print(product)
*/
