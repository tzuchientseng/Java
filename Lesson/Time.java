import java.time.*;
import java.time.format.DateTimeFormatter;

public class Time{
    public static void main(String[] args){
        Instant instant = Instant.now();
        System.out.println("Current Instant: " + instant);
        
        Instant afterFiveHours = instant.plus(Duration.ofHours(5));
        System.out.println("Instant after 5 hours: " + afterFiveHours);

        LocalDate localDate = LocalDate.now();
        System.out.println("Current LocalDate: " + localDate);

        LocalDate firstOfNextMonth = localDate.plusMonths(1).withDayOfMonth(1);
        System.out.println("First day of next month: " + firstOfNextMonth);

        System.out.println("->isLeapYear(" + localDate.isLeapYear() + ")");


        LocalTime localTime = LocalTime.now();
        System.out.println("Current LocalTime: " + localTime);
        
        LocalTime timeAfterHalfHour = localTime.plusMinutes(30);
        System.out.println("Time after 30 minutes: " + timeAfterHalfHour);

        OffsetDateTime offsetDateTime = OffsetDateTime.now();
        System.out.println("Current OffsetDateTime: " + offsetDateTime);

        OffsetDateTime offsetPlusThree = offsetDateTime.withOffsetSameInstant(ZoneOffset.ofHours(3));
        System.out.println("OffsetDateTeme with +3 hours offest: " + offsetPlusThree);

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("Current ZonedDateTime: " + zonedDateTime);
        
        ZonedDateTime newYorkTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println("ZonedDateTime in New York: " + newYorkTime);

        ZoneId defaultZone = ZoneId.systemDefault();
        System.out.println("Default ZoneId: " + defaultZone);

        ZoneId tokyoZone = ZoneId.of("Asia/Tokyo");
        System.out.println("Tokyo ZoneId: " + tokyoZone);

        ZoneOffset currentOffset = OffsetDateTime.now().getOffset();
        System.out.println("Current ZoneOffset: " + currentOffset);

        ZoneOffset offsetOfTwo = ZoneOffset.of("+02:00");
        System.out.print("ZoneOffset of +02:00: " + offsetOfTwo);

// 
        LocalDate date1 = LocalDate.now();
        LocalDate date2 = LocalDate.of(2014,6,20);
        LocalDate date3 = LocalDate.parse("2014-06-20", DateTimeFormatter.ISO_DATE);

        System.out.println(date1);
        System.out.println(date2);
        System.out.println(date3);

    }
}