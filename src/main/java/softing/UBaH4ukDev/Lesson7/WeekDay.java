package softing.UBaH4ukDev.Lesson7;

public enum WeekDay {
    MONDAY(1, "Понедельник"),
    TUESDAY(2, "Вторник"),
    THURSDAY(4, "Четверг"),
    WEDNESDAY(3, "Среда"),
    FRIDAY(5, "Пятница"),
    SATURDAY(6, "Суббота"),
    SUNDAY(7, "Воскресенье");

    private int dayNumber;
    private String russianName;

    WeekDay(int dayNumber, String russianName) {
        this.dayNumber = dayNumber;
        this.russianName = russianName;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public String getRussianName() {
        return russianName;
    }
}