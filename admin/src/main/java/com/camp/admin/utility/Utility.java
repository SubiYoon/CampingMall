package com.camp.admin.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utility {

    static public Date StringToDate(String stringDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return new Date(sdf.parse(stringDate).getTime());
    }

    static public String DateToString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    static public int DateDifference(Date date1, Date date2) {
        long differenceDays;
        differenceDays = (date1.getTime() - date2.getTime()) / (1000 * 24 * 60 * 60);
        return (int) differenceDays;
    }

    static public int StringDateDifference(String stringDate1, String stringDate2)
        throws ParseException {
        long differenceDays;
        Date date1 = StringToDate(stringDate1);
        Date date2 = StringToDate(stringDate2);
        differenceDays = (date1.getTime() - date2.getTime()) / (1000 * 24 * 60 * 60);
        return (int) differenceDays;
    }

    static public int LastDayOfMonth(String stringDate) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(Utility.StringToDate(stringDate));
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    public static String RateOfIncrease(double baseNumber, double compareNumber) {
        double rate;
        if (compareNumber > 0) {
            rate = (baseNumber - compareNumber) / compareNumber;
        } else if (baseNumber > 0) {
            rate = 999.99;
        } else {
            rate = 0;
        }
        if (rate > 999.99) {
            rate = 999.99;
        } else if (rate < -999.99) {
            rate = -999.99;
        }
        return Math.round(rate * 100) + "%";
    }
    public static String StringYearAndMonthFromStringDate(String stringDate){
        String[] array = stringDate.split("-");
        return array[0]+"-"+array[1];
    }
    public static String StringYearFromStringDate(String stringDate){
        String[] array = stringDate.split("-");
        return array[0];
    }
}
