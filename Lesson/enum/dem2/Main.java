public class Main {
public static void main(String[] args) {
    Day[] days = Day.values();
    for(var d : days){
        // d.abbreviation = d.abbreviation.toUpperCase();   //Cuz "abbreviation" is public!
        System.out.println("day: " + d.getAbbreviation());
    }
}
}

enum Day {
    SUNDAY("Sun"), MONDAY("Mon"), TUESDAY("Tue"), WEDNESDAY("Wed"),
    THURSDAY("Thu"), FRIDAY("Fri"), SATURDAY("Sat");

    //don't use public.(Avoid modifying.)
    private String abbreviation;

    //Constructor(Only private or package)
    private Day(String abbreviation) {
        this.abbreviation = abbreviation;
    }
    public String getAbbreviation() {
        return this.abbreviation;
    }
}
