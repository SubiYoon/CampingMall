package com.camp.admin.utility;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MakeHeadGraph {

    MakeMainGraph thisMonth;
    MakeMainGraph lastMonth;

    public MakeHeadGraph(MakeMainGraph today, MakeMainGraph lastMonth) {
        this.thisMonth = today;
        this.lastMonth = lastMonth;
    }

    private int NowRevenueSum() throws ParseException {
        Map<String, Double> revenue1 = thisMonth.dayRevenueMap();
        return (int)
            Math.round(revenue1.values().stream().mapToDouble(Double::intValue).sum() * 0.1) * 10;
    }

    private String RevenueRate() throws ParseException {
        Map<String, Double> revenue1 = lastMonth.dayRevenueMap();
        double compare =
            Math.round(revenue1.values().stream().mapToDouble(Double::intValue).sum() * 0.1) * 10;
        return Utility.RateOfIncrease(NowRevenueSum(), compare);
    }

    private int NowBookSum() {
        Map<String, Integer> month = thisMonth.BookCountMap();
        return month.values().stream().mapToInt(Integer::intValue).sum();
    }

    private String BookRate() {
        Map<String, Integer> month = lastMonth.BookCountMap();
        double compare = month.values().stream().mapToInt(Integer::intValue).sum();
        return Utility.RateOfIncrease(NowBookSum(), compare);
    }

    private int NowVisitor() {
        Map<String, Integer> month = thisMonth.DayVisitorMap();
        return month.values().stream().mapToInt(Integer::intValue).sum();
    }

    private String VisitorRate() {
        Map<String, Integer> month = lastMonth.DayVisitorMap();
        double compare = month.values().stream().mapToInt(Integer::intValue).sum();
        return Utility.RateOfIncrease(NowVisitor(), compare);
    }

    public List<String> MakeHeadList() throws ParseException {
        List<String> headList = new ArrayList<>();
        headList.add("" + NowRevenueSum());
        headList.add(RevenueRate());
        headList.add("" + NowBookSum());
        headList.add(BookRate());
        headList.add(NowVisitor() + "");
        headList.add(VisitorRate());
        return headList;
    }
}
