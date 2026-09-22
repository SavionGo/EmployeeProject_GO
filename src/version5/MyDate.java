package version5;

import java.util.Objects;

public class MyDate implements Cloneable {
    private static final String[] MONTH_NAMES = {
        "Jan", "Feb", "Mar", "Apr", "May", "Jun",
        "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
    };

    public MyDate() {
        this.day = 1;
        this.month = 1;
        this.year = 2026;
    }

    public MyDate(int day, int month, int year) {
        setDay(day);
        setMonth(month);
        setYear(year);
    }

    private int day;
    private int month;
    private int year;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if (day >= 1 && day <= 31) {
            this.day = day;
        } else {
            this.day = 1;
        }
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (month >= 1 && month <= 12) {
            this.month = month;
        } else {
            this.month = 1;
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year > 0) {
            this.year = year;
        } else {
            this.year = 2026;
        }
    }

    public String getMonthName() {
        return MONTH_NAMES[month - 1];
    }

    public void displayDate() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return day + " " + getMonthName() + " " + year;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MyDate)) {
            return false;
        }
        MyDate other = (MyDate) obj;
        return day == other.day && month == other.month && year == other.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, month, year);
    }

    @Override
    public MyDate clone() {
        try {
            return (MyDate) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}
