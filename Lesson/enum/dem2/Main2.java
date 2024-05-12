public class Main2 {
public static void main(String[] args) {
    Day[] days = Day.values();
    for(var d : days){
        System.out.println("day action: " + d.action());
    }
}
}

enum Day {
    SUNDAY("Sun"){
        public String action(){
        return "sleep";
    }
    },

    MONDAY("Mon"), TUESDAY("Tue"), WEDNESDAY("Wed"), THURSDAY("Thu"), FRIDAY("Fri"), 
    
    SATURDAY("Sat"){
        public String action(){
        return "eat";
        }
    };

    private String abbreviation;

    //Constructor(Only private or package)
    private Day(String abbreviation) {
        this.abbreviation = abbreviation;
    }
    
    public String getAbbreviation() {
        return this.abbreviation;
    }
    
    public String action() {
        return "work";
    }
}