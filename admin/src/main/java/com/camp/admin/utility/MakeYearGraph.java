package com.camp.admin.utility;

import com.camp.admin.DTO.GraphDTO;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MakeYearGraph {


    List<MakeMainGraph> graphList;
    String stringYear;
    Map<String, String> ScZn;
    List<String> labelList;

    public MakeYearGraph(String stringYear, Map<String, String> ScZn,
        List<MakeMainGraph> graphList) {
        this.stringYear = stringYear;
        this.ScZn = ScZn;
        this.graphList = graphList;
        labelList = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            labelList.add("" + i);
        }
    }

    public GraphDTO MakeYearRevenueGraph() throws ParseException {
        List<String> year = new ArrayList<>();
        for (MakeMainGraph graph : graphList) {
            Map<String, Double> month = graph.dayRevenueMap();
            int sum = month.values().stream().mapToInt(Double::intValue).sum();
            year.add("" + sum);
        }
        return new GraphDTO(labelList, stringYear, year);
    }

    public GraphDTO MakeYearBookGraph() {
        List<String> year = new ArrayList<>();
        for (MakeMainGraph graph : graphList) {
            Map<String, Integer> month = graph.BookCountMap();
            int sum = month.values().stream().mapToInt(Integer::intValue).sum();
            year.add("" + sum);
        }
        return new GraphDTO(labelList, stringYear, year);
    }

    public GraphDTO MakeYearVisitorGraph() {
        List<String> year = new ArrayList<>();
        for (MakeMainGraph graph : graphList) {
            Map<String, Integer> month = graph.DayVisitorMap();
            int sum = month.values().stream().mapToInt(Integer::intValue).sum();
            year.add("" + sum);
        }
        return new GraphDTO(labelList, stringYear, year);
    }

    public GraphDTO MakeYearZoneRevenueGraph() {
        Map<String, Double> year = new TreeMap<>();
        List<String> yearRevenue = new ArrayList<>();
        for (MakeMainGraph graph : graphList) {
            Map<String, Double> month = graph.ZoneRevenueMap(ScZn);
            month.forEach((key, value) -> year.merge(key, value, Double::sum));
        }
        labelList = new ArrayList<>(year.keySet());
        for (double revenue : year.values()) {
            yearRevenue.add("" + Math.round(revenue));
        }
        return new GraphDTO(labelList, stringYear, yearRevenue);
    }

    public GraphDTO MakeYearZoneVisitorGraph() {
        Map<String, Integer> year = new TreeMap<>();
        List<String> yearRevenue = new ArrayList<>();
        for (MakeMainGraph graph : graphList) {
            Map<String, Integer> month = graph.ZoneVisitorMap(ScZn);
            month.forEach((key, value) -> year.merge(key, value, Integer::sum));
        }
        labelList = new ArrayList<>(year.keySet());
        for (double revenue : year.values()) {
            yearRevenue.add("" + Math.round(revenue));
        }
        return new GraphDTO(labelList, stringYear, yearRevenue);
    }
}
