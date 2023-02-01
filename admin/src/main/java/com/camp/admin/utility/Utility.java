package com.camp.admin.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    static public int StringDateDifference(String stringDate1, String stringDate2) throws ParseException {
        long differenceDays;
        Date date1 = StringToDate(stringDate1);
        Date date2 = StringToDate(stringDate2);
        differenceDays = (date1.getTime() - date2.getTime()) / (1000 * 24 * 60 * 60);
        return (int) differenceDays;
    }
}
