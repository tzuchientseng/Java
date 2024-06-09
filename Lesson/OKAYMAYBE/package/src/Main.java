public class Main {
    public static void main(String[] args) {
        var o = EEE.valueOf(args[0]);
        run(o);
    }

    private static void run(EEE e) {
        e.Eapply();
    }
}

enum EEE {
    A(new AAA()),
    B(new BBB());

    private Contract o;

    private EEE(Contract o) {
        this.o = o;
    }

    public void Eapply() {
        this.o.apply();
    }
}

interface Contract {
    void apply();
}

class AAA implements Contract {
    public void apply() {
        System.out.println("AAA");
    }
}

class BBB implements Contract {
    public void apply() {
        System.out.println("BBB");
    }
}