package DesignPattern.SimpleFactory;

import java.lang.reflect.Constructor;

public class Reflection_SimpleFactory {
    public static void main(String[] args) {
        try {
            // 通過配置文件或其他方式獲取具體工廠類的名稱
            String factoryClassName = "DesignPattern.SimpleFactory.ConcreteFactoryA"; // 或 "DesignPattern.SimpleFactory.ConcreteFactoryB"
            // 利用反射創建具體工廠實例
            Class<?> factoryClass = Class.forName(factoryClassName);
            Constructor<?> constructor = factoryClass.getDeclaredConstructor();
            // AbstractFactory factory = (AbstractFactory) Class.forName(factoryClassName).newInstance(); //java9 以前寫法
            AbstractFactory factory = (AbstractFactory) constructor.newInstance();
            // 使用工廠創建產品
            Product product = factory.createProduct();
            // 使用產品
            product.use();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// 抽象工廠
interface AbstractFactory {
    Product createProduct();
}

// 具體工廠A
class ConcreteFactoryA implements AbstractFactory {
    @Override
    public Product createProduct() {
        return new ProductA();
    }
}

// 具體工廠B
class ConcreteFactoryB implements AbstractFactory {
    @Override
    public Product createProduct() {
        return new ProductB();
    }
}

// 抽象產品
interface Product {
    void use();
}

// 具體產品A
class ProductA implements Product {
    @Override
    public void use() {
        System.out.println("使用產品A");
    }
}

// 具體產品B
class ProductB implements Product {
    @Override
    public void use() {
        System.out.println("使用產品B");
    }
}
 