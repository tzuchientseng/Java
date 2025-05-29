public class AnimalSystem {
    public static void main(String[] args) {
        // �Ыؤ@�Ӱʪ�
        Animal animal = new Animal(4);
        animal.eat();
        animal.sleep();

        // �Ыؤ@����
        Cat cat = new Cat(4, "���");
        cat.eat();
        cat.sleep();

        // �Ыؤ@���Ѫ�
        Tiger tiger = new Tiger(4, "���");
        tiger.eat();
        tiger.sleep();
    }
}

// �w�q�ʪ����O
class Animal {
    int legs;

    public Animal(int legs) {
        this.legs = legs;
    }

    public void eat() {
        System.out.println("�ʪ����b�Y");
    }

    public void sleep() {
        System.out.println("�ʪ����b��ı");
    }
}

// �w�q�����O�A�~�Ӧ۰ʪ����O
class Cat extends Animal {
    String color;

    public Cat(int legs, String color) {
        super(legs);
        this.color = color;
    }

    @Override
    public void eat() {
        System.out.println("�ߥ��b�Y");
    }

    @Override
    public void sleep() {
        System.out.println("�ߥ��b��ı");
    }
}

// �w�q�Ѫ����O�A�~�Ӧۿ����O
class Tiger extends Cat {
    public Tiger(int legs, String color) {
        super(legs, color);
    }

    @Override
    public void eat() {
        System.out.println("�Ѫ꥿�b�Y");
    }

    @Override
    public void sleep() {
        System.out.println("�Ѫ꥿�b��ı");
    }
}


