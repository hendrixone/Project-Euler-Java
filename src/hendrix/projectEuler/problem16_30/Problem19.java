package hendrix.projectEuler.problem16_30;

import java.util.GregorianCalendar;

/**
 * Description:
 * Problem19, Counting Sundays
 * <p>
 * You are given the following information, but you may prefer to do some research for yourself.
 * <p>
 * 1 Jan 1900 was a Monday.
 * Thirty days has September,
 * April, June and November.
 * All the rest have thirty-one,
 * Saving February alone,
 * Which has twenty-eight, rain or shine.
 * And on leap years, twenty-nine.
 * A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
 * How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 */
public class Problem19 {
    static final GregorianCalendar gregorianCalendar = new GregorianCalendar();

    /*
    Solution description here
    */
    private static String solve() {
        //enumerate all days until 2000.12.31
        int month = 1;
        int year = 1900;
        int day = 0;
        int weekday = 0;
        int sum = 0;
        while (year != 2000 || month != 12 || day != 31) {
            day++;
            weekday++;
            if (weekday == 8)
                weekday = 1;
            if (day > getMonthDays(month, year)) {
                day = 1;
                month++;
            }
            if (month > 12) {
                year++;
                month = 1;
            }
            //add up all days that match the requirement
            if (day == 1 && weekday == 7 && year != 1900)
                sum++;
            //System.out.println(year+"."+month+"."+day+" "+weekday);
        }
        return Integer.toString(sum);
    }

    private static int getMonthDays(int month, int year) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if (gregorianCalendar.isLeapYear(year))
                    return 29;
                else
                    return 28;
            default:
                throw new IllegalArgumentException();

        }
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        String result = solve();
        long endTime = System.nanoTime();
        System.out.println("Answer: " + result + "\nProcess took " + (endTime - startTime) / (1000 * 1000) + "ms to execute");
    }
}
/*
Answer: 171
Process took 4ms to execute
*/