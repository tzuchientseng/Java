public class Main2{
    private static final int SUNDAY = 0, MONDAY = 1, TUESDAY = 2, WEDNESDAY = 3, THURSDAY = 4, FRIDAY = 5, SATURDAY = 6;
    public static void main(String[] args) {
        var day = Day.SUNDAY;
        System.out.println("day: " + day);
        var s = "SUNDAY";
        var day2 = Day.valueOf(s);
        System.out.println("day2: " + day2);
        System.out.println("day==day2: "+ (day==day2));
        System.out.println("day.eqals(day2): "+ (day.equals(day2)));
        today(SUNDAY);
        today(day);
        Day.valueOf("sunday");
    }
        private static void today(int day){
        System.out.println(day);
    }
        private static void today(Day day){
        System.out.println(day);
    }
}

enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}
