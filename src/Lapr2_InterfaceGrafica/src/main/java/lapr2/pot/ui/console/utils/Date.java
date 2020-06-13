package lapr2.pot.ui.console.utils;

import java.io.Serializable;
import java.util.Calendar;

public class Date implements Comparable<Date>, Serializable {

    private int year;

    private Month month;

    private int day;

    private static final int YEAR_BY_OMISSION = 1;

    private static final Month MONTH_BY_OMISSION = Month.JANUARY;

    private static final int DAY_BY_OMISSION = 1;

    private static enum DayOfWeek {

        SUNDAY {
            @Override
            public String toString() {
                return "Sunday";
            }
        },
        MONDAY {
            @Override
            public String toString() {
                return "Monday";
            }
        },
        TUESDAY {
            @Override
            public String toString() {
                return "Tuesday";
            }
        },
        WEDNESDAY {
            @Override
            public String toString() {
                return "Wednesday";
            }
        },
        THURSDAY {
            @Override
            public String toString() {
                return "Thursday";
            }
        },
        FRIDAY {
            @Override
            public String toString() {
                return "Friday";
            }
        },
        SATURDAY {
            @Override
            public String toString() {
                return "Saturday";
            }
        };

        public static String designationDayOfWeek(int orderDayDaSemana) {
            return DayOfWeek.values()[orderDayDaSemana].toString();
        }
    }

    private static enum Month {

        JANUARY(31) {
            @Override
            public String toString() {
                return "January";
            }
        },
        FEBRUARY(28) {
            @Override
            public String toString() {
                return "February";
            }
        },
        MARCH(31) {
            @Override
            public String toString() {
                return "March";
            }
        },
        APRIL(30) {
            @Override
            public String toString() {
                return "April";
            }
        },
        MAY(31) {
            @Override
            public String toString() {
                return "May";
            }
        },
        JUNE(30) {
            @Override
            public String toString() {
                return "June";
            }
        },
        JULY(31) {
            @Override
            public String toString() {
                return "July";
            }
        },
        AUGUST(31) {
            @Override
            public String toString() {
                return "august";
            }
        },
        SEPTEMBER(30) {
            @Override
            public String toString() {
                return "September";
            }
        },
        October(31) {
            @Override
            public String toString() {
                return "October";
            }
        },
        NOVEMBER(30) {
            @Override
            public String toString() {
                return "November";
            }
        },
        DECEMBER(31) {
            @Override
            public String toString() {
                return "December";
            }
        };

        private int numberOfDays;

        private Month(int numberOfDays) {
            this.numberOfDays = numberOfDays;
        }

        public int numberOfDays(int year) {
            if (ordinal() == 1 && Date.isLeapYear(year)) {
                return numberOfDays + 1;
            }
            return numberOfDays;
        }

        public static Month getMonth(int orderOfMonth) {
            return Month.values()[orderOfMonth - 1];
        }
    }

    public Date(int year, int month, int day) {
        setData(year, month, day);
    }

    public Date() {
        year = YEAR_BY_OMISSION;
        month = MONTH_BY_OMISSION;
        day = DAY_BY_OMISSION;
    }

    public Date(Date anotherData) {
        year = anotherData.year;
        month = anotherData.month;
        day = anotherData.day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month.ordinal() + 1;
    }

    public int getDay() {
        return day;
    }

    public final void setData(int year, int month, int day) {
        if (month < 1 || month > 12) {
            throw new InvalidMonthException("Month " + month + " is invalid!!");
        }
        if (day < 1 || day > Month.getMonth(month).numberOfDays(year)) {
            throw new InvalidDayException("Day " + year + "/" + month + "/" + day
                    + " is invalid!!");
        }
        this.year = year;
        this.month = Month.getMonth(month);
        this.day = day;
    }

    @Override
    public String toString() {
        return String.format("%s, %d de %s de %d", dayOfWeek(), day, month, year);
    }

    public String toYearMonthDayString() {
        return String.format("%02d/%02d/%02d", year, month.ordinal() + 1, day);
    }

    @Override
    public boolean equals(Object anotherObjeto) {
        if (this == anotherObjeto) {
            return true;
        }
        if (anotherObjeto == null || getClass() != anotherObjeto.getClass()) {
            return false;
        }
        Date anotherData = (Date) anotherObjeto;
        return year == anotherData.year && month.equals(anotherData.month)
                && day == anotherData.day;
    }

    @Override
    public int compareTo(Date anotherData) {
        return (anotherData.isMaior(this)) ? -1 : (isMaior(anotherData)) ? 1 : 0;
    }

    public String dayOfWeek() {
        int totalDays = counterDays();
        totalDays = totalDays % 7;

        return DayOfWeek.designationDayOfWeek(totalDays);
    }

    public boolean isMaior(Date anotherData) {
        int totalDays = counterDays();
        int totalDays1 = anotherData.counterDays();

        return totalDays > totalDays1;
    }

    public int diference(Date anotherData) {
        int totalDays = counterDays();
        int totalDays1 = anotherData.counterDays();

        return Math.abs(totalDays - totalDays1);
    }

    public int diference(int year, int month, int day) {
        int totalDays = counterDays();
        Date anotherData = new Date(year, month, day);
        int totalDays1 = anotherData.counterDays();

        return Math.abs(totalDays - totalDays1);
    }

    public static boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    public static Date dataAtual() {
        Calendar today = Calendar.getInstance();
        int year = today.get(Calendar.YEAR);
        int month = today.get(Calendar.MONTH) + 1;    // janeiro é representado por 0.
        int dia = today.get(Calendar.DAY_OF_MONTH);
        return new Date(year, month, dia);
    }

    private int counterDays() {
        int totalDays = 0;

        for (int i = 1; i < year; i++) {
            totalDays += isLeapYear(i) ? 366 : 365;
        }
        for (int i = 1; i < month.ordinal() + 1; i++) {
            totalDays += Month.getMonth(i).numberOfDays(year);
        }
        totalDays += day;

        return totalDays;
    }

    public Date convertStringToDate(String stringDate) {
        String[] arrayDate = stringDate.split("/");
        int day, month, year;
        day = Integer.parseInt(arrayDate[0]);
        month = Integer.parseInt(arrayDate[1]);
        year = Integer.parseInt(arrayDate[2]);
        return new Date(year, month, day);
    }
}
