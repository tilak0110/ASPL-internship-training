import java.util.Calendar;
import java.util.GregorianCalendar;

public class GregorianCalendarWithTime {
    public static void main(String[] args) {
        // Creating a GregorianCalendar instance with current date and time
        GregorianCalendar gCalendar = new GregorianCalendar();

        // Printing the full date and time
        System.out.println("Full Date & Time: " + gCalendar.getTime());

        // Extracting specific time components
        int hour = gCalendar.get(Calendar.HOUR_OF_DAY); // 24-hour format
        int minute = gCalendar.get(Calendar.MINUTE);
        int second = gCalendar.get(Calendar.SECOND);
        int millisecond = gCalendar.get(Calendar.MILLISECOND);

        System.out.println("Hour: " + hour);
        System.out.println("Minute: " + minute);
        System.out.println("Second: " + second);
        System.out.println("Millisecond: " + millisecond);

        // Setting a specific time (10:30:45 AM)
        gCalendar.set(Calendar.HOUR_OF_DAY, 10);
        gCalendar.set(Calendar.MINUTE, 30);
        gCalendar.set(Calendar.SECOND, 45);

        System.out.println("Updated Date & Time: " + gCalendar.getTime());
    }
}
