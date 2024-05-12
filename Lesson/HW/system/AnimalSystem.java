public class AnimalSystem {
    public static void main(String[] args) {
        // 創建一個動物
        Animal animal = new Animal(4);
        animal.eat();
        animal.sleep();

        // 創建一隻貓
        Cat cat = new Cat(4, "橘色");
        cat.eat();
        cat.sleep();

        // 創建一隻老虎
        Tiger tiger = new Tiger(4, "橘色");
        tiger.eat();
        tiger.sleep();
    }
}

// 定義動物類別
class Animal {
    int legs;

    public Animal(int legs) {
        this.legs = legs;
    }

    public void eat() {
        System.out.println("動物正在吃");
    }

    public void sleep() {
        System.out.println("動物正在睡覺");
    }
}

// 定義貓類別，繼承自動物類別
class Cat extends Animal {
    String color;

    public Cat(int legs, String color) {
        super(legs);
        this.color = color;
    }

    @Override
    public void eat() {
        System.out.println("貓正在吃");
    }

    @Override
    public void sleep() {
        System.out.println("貓正在睡覺");
    }
}

// 定義老虎類別，繼承自貓類別
class Tiger extends Cat {
    public Tiger(int legs, String color) {
        super(legs, color);
    }

    @Override
    public void eat() {
        System.out.println("老虎正在吃");
    }

    @Override
    public void sleep() {
        System.out.println("老虎正在睡覺");
    }
}


