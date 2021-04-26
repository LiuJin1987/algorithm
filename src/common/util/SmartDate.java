package common.util;

import edu.princeton.cs.algs4.Date;

import java.util.Arrays;
import java.util.List;

/**
 * @author liujinlc
 * @date 2021/4/23 9:03
 **/
public class SmartDate implements Comparable<SmartDate>{

    private final Date date;
    private static final List<Integer> MONTH_OF_30_DAYS = Arrays.asList(4, 6, 9, 11);

    public SmartDate(int year, int month, int day) {
        this.date = new Date(month, day, year);
    }

    public SmartDate(String dateString) {
        String[] dateStrings = dateString.split("/");
        int year = Integer.parseInt(dateStrings[2]);
        int month = Integer.parseInt(dateStrings[0]);
        validMonth(month);
        int day = Integer.parseInt(dateStrings[1]);
        validDay(day, month, year);
        this.date = new Date(month, day, year);
    }

    private static void validMonth(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Invalid month");
        }
    }

    private static void validDay(int day, int month, int year) {
        if (day < 1 || day > 31) {
            throw new IllegalArgumentException("Invalid day");
        }
        if (MONTH_OF_30_DAYS.contains(month) && day == 31) {
            throw new IllegalArgumentException("Invalid day");
        }
        if (isLeapYear(year) && month == 2 && day == 30) {
            throw new IllegalArgumentException("Invalid day");
        }
        if (!isLeapYear(year) && month == 2 && day == 29) {
            throw new IllegalArgumentException("Invalid day");
        }
    }

    private static boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 100 != 0 && year % 4 == 0);
    }

    @Override
    public String toString() {
        return this.date.toString();
    }

    public String dayOfTheWeek() {
        // Zeller formula
        int month = this.date.month();
        int year = this.date.year();
        if (month <= 2) {
            month += 12;
            year--;
        }
        int weekdayValue =
                (this.date.day() + 2 * month + 3 * (month + 1) / 5
                        + year + year / 4 - year / 100 + year / 400) % 7;
        return DayOfTheWeek.getName(weekdayValue);
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure <tt>sgn(x.compareTo(y)) ==
     * -sgn(y.compareTo(x))</tt> for all <tt>x</tt> and <tt>y</tt>.  (This
     * implies that <tt>x.compareTo(y)</tt> must throw an exception iff
     * <tt>y.compareTo(x)</tt> throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * <tt>(x.compareTo(y)&gt;0 &amp;&amp; y.compareTo(z)&gt;0)</tt> implies
     * <tt>x.compareTo(z)&gt;0</tt>.
     *
     * <p>Finally, the implementor must ensure that <tt>x.compareTo(y)==0</tt>
     * implies that <tt>sgn(x.compareTo(z)) == sgn(y.compareTo(z))</tt>, for
     * all <tt>z</tt>.
     *
     * <p>It is strongly recommended, but <i>not</i> strictly required that
     * <tt>(x.compareTo(y)==0) == (x.equals(y))</tt>.  Generally speaking, any
     * class that implements the <tt>Comparable</tt> interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     *
     * <p>In the foregoing description, the notation
     * <tt>sgn(</tt><i>expression</i><tt>)</tt> designates the mathematical
     * <i>signum</i> function, which is defined to return one of <tt>-1</tt>,
     * <tt>0</tt>, or <tt>1</tt> according to whether the value of
     * <i>expression</i> is negative, zero or positive.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(SmartDate o) {
        return this.date.compareTo(o.date);
    }
}

enum DayOfTheWeek {
    /**
     * day of week enum
     */
    MONDAY(0) {
        @Override
        public String toString() {
            return "Monday";
        }
    },
    TUESDAY(1) {
        @Override
        public String toString() {
            return "Tuesday";
        }
    },
    WEDNESDAY(2) {
        @Override
        public String toString() {
            return "Wednesday";
        }
    },
    THURSDAY(3) {
        @Override
        public String toString() {
            return "Thursday";
        }
    },
    FRIDAY(4) {
        @Override
        public String toString() {
            return "Friday";
        }
    },
    SATURDAY(5) {
        @Override
        public String toString() {
            return "Saturday";
        }
    },
    SUNDAY(6) {
        @Override
        public String toString() {
            return "Sunday";
        }
    };

    private final int value;

    DayOfTheWeek(int value) {
        this.value = value;
    }

    private int getValue() {
        return value;
    }

    public static String getName(int value) {
        for (DayOfTheWeek dayOfTheWeeks : DayOfTheWeek.values()) {
            if (value == dayOfTheWeeks.getValue()) {
                return dayOfTheWeeks.toString();
            }
        }
        return "";
    }
}
