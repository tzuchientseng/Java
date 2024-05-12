public class Main2{
    public static void main(String[] args) {
        var u = new User("M12283XXXX", "Sunny Tseng");

        System.out.println(u.id);
        System.out.println(u.name);

        System.out.println(u);
    }

    record User(String id, String name) {}
}