package simpleClasses;

enum DayOfWeek {
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY
}

public class Arguments {
    public static void main(String[] args) {
        for (DayOfWeek day : DayOfWeek.values()) {
            System.out.println(day);
        }
    }
}
