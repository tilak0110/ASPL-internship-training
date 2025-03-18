import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateHandlingExample {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getState());
        // java.util.Date (Legacy Date)
        java.util.Date utilDate = new java.util.Date();
        System.out.println("java.util.Date: " + utilDate);

        // Formatting java.util.Date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Formatted java.util.Date: " + sdf.format(utilDate));

        //  java.sql.Date (For Database)
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        System.out.println("java.sql.Date: " + sqlDate);

        //  java.sql.Timestamp (For Timestamps)
        java.sql.Timestamp timestamp = new java.sql.Timestamp(utilDate.getTime());
        System.out.println("java.sql.Timestamp: " + timestamp);

        // java.sql.Time (For storing only Time)
        java.sql.Time sqlTime = new java.sql.Time(utilDate.getTime());
        System.out.println("java.sql.Time: " + sqlTime);

        //  java.time.LocalDate (ISO-8601 format)
        LocalDate localDate = LocalDate.now();
        System.out.println("LocalDate: " + localDate);

        //  java.time.LocalTime
        LocalTime localTime = LocalTime.now();
        System.out.println("LocalTime: " + localTime);

        //java.time.LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("LocalDateTime: " + localDateTime);

        // Formatting LocalDateTime
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("Formatted LocalDateTime: " + localDateTime.format(formatter));

        // java.time.ZonedDateTime (Time zones)
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println("ZonedDateTime (New York): " + zonedDateTime);

        // java.time.Instant (UTC Timestamp)
        Instant instant = Instant.now();
        System.out.println("Instant (UTC Timestamp): " + instant);

        // Converting Between Different Types
        LocalDate sqlToLocalDate = sqlDate.toLocalDate();
        LocalDateTime timestampToLocalDateTime = timestamp.toLocalDateTime();
        System.out.println("SQL Date to LocalDate: " + sqlToLocalDate);
        System.out.println("Timestamp to LocalDateTime: " + timestampToLocalDateTime);

        //Manipulating LocalDate
        LocalDate nextWeek = localDate.plusWeeks(1);
        LocalDate lastMonth = localDate.minusMonths(1);
        System.out.println("Next Week's Date: " + nextWeek);
        System.out.println("Last Month's Date: " + lastMonth);

        // Parsing String to LocalDate
        LocalDate parsedDate = LocalDate.parse("2025-03-11");
        System.out.println("Parsed LocalDate: " + parsedDate);

        //  Using Calendar API (Legacy)
        Calendar calendar = Calendar.getInstance();
        calendar.set(2025, Calendar.MARCH, 11);
        java.util.Date calendarDate = calendar.getTime();
        System.out.println("Calendar Date: " + calendarDate);

        // Using GregorianCalendar (A subclass of Calendar)
        GregorianCalendar gCalendar = new GregorianCalendar(2025, Calendar.MARCH, 11);
        System.out.println("Gregorian Calendar Date: " + gCalendar.getTime());
    }
}
