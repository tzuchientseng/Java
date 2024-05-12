package DesignPattern.Strategy;

// 策略模式範例
public class StrategyDemo {
    public static void main(String[] args) {
        Context context;
        
        // 使用策略A
        context = new Context(new ConcreteStrategyA());
        context.contextInterface();
        
        // 使用策略B
        context = new Context(new ConcreteStrategyB());
        context.contextInterface();
    }
}

// 策略抽象類別
abstract class Strategy {
    public abstract void algorithmInterface();
}

// 具體策略A
class ConcreteStrategyA extends Strategy {
    public void algorithmInterface() {
        System.out.println("執行策略A的算法");
    }
}

// 具體策略B
class ConcreteStrategyB extends Strategy {
    public void algorithmInterface() {
        System.out.println("執行策略B的算法");
    }
}

// 上下文類別
class Context {
    private Strategy strategy;
    
    public Context(Strategy strategy) {
        this.strategy = strategy;
    }
    
    public void contextInterface() {
        strategy.algorithmInterface();
    }
}

