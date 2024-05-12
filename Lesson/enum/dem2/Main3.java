public class Main3 {
    public static void main(String[] args) {
        Day[] days = Day.values();
            for(var d : days){
            System.out.println("day action: " + d.action());
          }
        }
    }

interface DayJob{
    public String action();
}
enum Day implements DayJob {
    //Method 1: lambda
    SUNDAY("Sun",()->"sleep"), 
    //Method 2: anonymous Inner Class 
    MONDAY("Mon",new DayJob(){
        public String action(){
            return "work";
        }
    }), 
    //Method 3: class Work implements DayJob
    TUESDAY("Tue",new Work()), 
    
    WEDNESDAY("Wed",()->"work"), THURSDAY("Thu",()->"work"), 
    FRIDAY("Fri",()->"work"), SATURDAY("Sat",()->"eat");

    private String abbreviation;
    private DayJob job;
    
    //Constructor(Only private or package)
    private Day(String abbreviation, DayJob job) {
        this.abbreviation = abbreviation;
        this.job = job;
        }

    public String getAbbreviation() {
        return this.abbreviation;
    }
    public String action() {
        return this.job.action();
    }
}
//Tuesday
class Work implements DayJob{
    public String action(){
        return "Work";
    }
}