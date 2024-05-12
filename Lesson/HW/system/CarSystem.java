public class CarSystem {
    public static void main(String[] args) {
        Vehicle car = new Car("Toyota", "Camry");
        Vehicle motorcycle = new Motorcycle("Honda", "CBR500R");
        Vehicle truck = new Truck("Volvo", "VNL");

        car.accelerate(60);
        car.decelerate(20);
        car.honk();

        motorcycle.accelerate(80);
        motorcycle.decelerate(30);
        motorcycle.honk();

        truck.accelerate(50);
        truck.decelerate(10);
        truck.honk();
    }
}


interface Vehicle {
    String getBrand();
    String getModel();
    void accelerate(int speed);
    void decelerate(int speed);
    void honk();
}


class Car implements Vehicle {
    private String brand;
    private String model;

    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public void accelerate(int speed) {
        System.out.println("�T���[�t�A�t�׼W�[ " + speed + " ����/�p��");
    }

    @Override
    public void decelerate(int speed) {
        System.out.println("�T����t�A�t�״�� " + speed + " ����/�p��");
    }

    @Override
    public void honk() {
        System.out.println("�T�����");
    }
}


class Motorcycle implements Vehicle {
    private String brand;
    private String model;

    public Motorcycle(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public void accelerate(int speed) {
        System.out.println("�����[�t�A�t�׼W�[ " + speed + " ����/�p��");
    }

    @Override
    public void decelerate(int speed) {
        System.out.println("������t�A�t�״�� " + speed + " ����/�p��");
    }

    @Override
    public void honk() {
        System.out.println("�������");
    }
}


class Truck implements Vehicle {
    private String brand;
    private String model;

    public Truck(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public void accelerate(int speed) {
        System.out.println("�d���[�t�A�t�׼W�[ " + speed + " ����/�p��");
    }

    @Override
    public void decelerate(int speed) {
        System.out.println("�d����t�A�t�״�� " + speed + " ����/�p��");
    }

    @Override
    public void honk() {
        System.out.println("�d�����");
    }
}


