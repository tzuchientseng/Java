package builder;
public class SimpleBuilderExample {
    private int value;

    public SimpleBuilderExample setValue(int value) {
        this.value = value;
        return this;
    }

    public void printValue() {
        System.out.println("Value: " + value);
    }

    public static void main(String[] args) {
        SimpleBuilderExample builder = new SimpleBuilderExample();

        // 使用 return this 可以在同一行程式碼中連續呼叫多個方法
        builder.setValue(42).printValue(); // 這行程式碼等同於兩行： builder.setValue(42); builder.printValue();
    }
}