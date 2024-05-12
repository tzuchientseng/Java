package generic;

public class Main<T> {
    T t;
    public T getT() {
        return this.t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public <O> String say(O o) {
        return "Hi " + o.toString();
    }

    public static void main(String[] args) {
        Main<Integer> f = new Main<>();
        f.setT(1);
        System.out.println(f.getT());
        System.out.println(f.say("Sunny!"));
    }
}