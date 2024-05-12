import java.util.Arrays;

public class Security {
    public static void main(String[] args) {
        int[] data = {1, 2, 3};
        SafeObject obj = new SafeObject(100, "Hello", data);

        data[0] = 999;
        System.out.println(obj.getAttribute1());
        System.out.println(obj.getAttribute2());
        System.out.println(Arrays.toString(obj.getAttribute3()));
    }
}

final class SafeObject {
    private final int attribute1;
    private final String attribute2;
    private final int[] attribute3;

    public SafeObject(int attribute1, String attribute2, int[] attribute3) {
        this.attribute1 = attribute1;
        this.attribute2 = attribute2;
        this.attribute3 = Arrays.copyOf(attribute3, attribute3.length);
    }

    public int getAttribute1() {
        return attribute1;
    }

    public String getAttribute2() {
        return attribute2;
    }

    public int[] getAttribute3() {
        return Arrays.copyOf(attribute3, attribute3.length);
    }
}
