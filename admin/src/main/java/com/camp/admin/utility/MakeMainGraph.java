package com.camp.admin.utility;

import com.camp.admin.DTO.BookDTO;
import com.camp.admin.DTO.GraphDTO;
import com.camp.admin.DTO.ReservationDTO;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MakeMainGraph {

    List<BookDTO> bookList;
    List<BookDTO> bookList2;
    List<ReservationDTO> reservationList;
    String stringYearAndMonth;
    List<String> dataList;
    List<String> labelList = new ArrayList<>();
    Map<Integer, Integer> CodeMemberMap = new HashMap<>();
    Map<Integer, Double> CodePriceMap = new HashMap<>();
    Map<Integer,Integer> BookCodeSiteCode = new HashMap<>();

    public MakeMainGraph(List<BookDTO> bookList, List<ReservationDTO> reservationList,
        String stringYearAndMonth, List<BookDTO> bookList2) {
        this.bookList = new ArrayList<>(bookList);
        this.reservationList = new ArrayList<>(reservationList);
        this.bookList2 = new ArrayList<>(bookList2);
        this.stringYearAndMonth = "" + stringYearAndMonth;
        setBookCodeSiteCode();
    }

    private void setLists() {
        dataList = new ArrayList<>();
    }
    private String StringDateToDay(String stringDate) {
        return "" + Integer.parseInt(stringDate.split("-")[2]);
    }

    private String DateToDay(Date date) {
        return StringDateToDay(Utility.DateToString(date));
    }
    public Map<String, Integer> BookCountMap(){
        setLists();
        Map<String, Integer> dayBookCount = new HashMap<>();

        for (BookDTO book : bookList2) {
            String day = DateToDay(book.getBook_writedate());
            int count = 1;
            if (dayBookCount.containsKey(day)) {
                count += dayBookCount.get(day);
            }
            dayBookCount.put(day, count);
        }
        return dayBookCount;
    }
    public GraphDTO MakeBookGraph() throws ParseException {
        setLists();
        Map<String, Integer> dayBookCount = BookCountMap();
        for (int i = 1; i <= Utility.LastDayOfMonth(stringYearAndMonth + "-01"); i++) {
            int count = 0;
            if (dayBookCount.containsKey("" + i)) {
                count = dayBookCount.get("" + i);
            }
            dataList.add("" + count);
        }

        return new GraphDTO(labelList, stringYearAndMonth, dataList);
    }
    public Map<String, Double> dayRevenueMap() throws ParseException {
        setLists();

        for (int i = 1; i <= Utility.LastDayOfMonth(stringYearAndMonth + "-01"); i++) {
            labelList.add("" + i);
        }

        CodePriceMap = new HashMap<>();
        Map<String, Double> dayRevenueMap = new HashMap<>();

        for (BookDTO book : bookList) {
            double bookPrice = book.getBook_price();
            double days = Utility.StringDateDifference(book.getBook_checkout(),
                book.getBook_checkin());

            CodePriceMap.put(book.getBook_code(), bookPrice / days);
        }
        for (ReservationDTO reservation : reservationList) {
            String day = DateToDay(reservation.getReservation_date());
            int bookCode = reservation.getBook_code();
            double price = CodePriceMap.get(bookCode);
            if (dayRevenueMap.containsKey(day)) {
                price += dayRevenueMap.get(day);
            }

            dayRevenueMap.put(day, price);
        }
        return dayRevenueMap;
    }

    public GraphDTO MakeRevenueGraph() throws ParseException {
        Map<String, Double> dayRevenueMap = dayRevenueMap();
        for (int i = 1; i <= Utility.LastDayOfMonth(stringYearAndMonth + "-01"); i++) {
            double count = 0.0;
            if (dayRevenueMap.containsKey("" + i)) {
                count = dayRevenueMap.get("" + i);
            }
            dataList.add("" + Math.round(count));
        }
        return new GraphDTO(labelList, stringYearAndMonth, dataList);
    }
    public Map<String, Integer> DayVisitorMap(){
        setLists();
        CodeMemberMap = new HashMap<>();
        Map<String, Integer> dayVisitorMap = new HashMap<>();
        for (BookDTO book : bookList) {
            int bookMember = book.getBook_member();
            CodeMemberMap.put(book.getBook_code(), bookMember);
        }
        for (ReservationDTO reservation : reservationList) {
            String day = DateToDay(reservation.getReservation_date());
            int bookCode = reservation.getBook_code();
            int member = CodeMemberMap.get(bookCode);
            if (dayVisitorMap.containsKey(day)) {
                member += dayVisitorMap.get(day);
            }
            dayVisitorMap.put(day, member);
        }
        return dayVisitorMap;
    }

    public GraphDTO MakeVisitorGraph() throws ParseException {
        Map<String, Integer> dayVisitorMap = DayVisitorMap();
        for (int i = 1; i <= Utility.LastDayOfMonth(stringYearAndMonth + "-01"); i++) {
            int count = 0;
            if (dayVisitorMap.containsKey("" + i)) {
                count = dayVisitorMap.get("" + i);
            }
            dataList.add("" + count);
        }
        return new GraphDTO(labelList, stringYearAndMonth, dataList);
    }

    public void setBookCodeSiteCode(){
        for(BookDTO book : bookList){
            BookCodeSiteCode.put(book.getBook_code(),book.getSite_code());
        }
    }
    public Map<String, Double> ZoneRevenueMap(Map<String, String> ScZn){
        Map<String, Double> zoneRevenue = new TreeMap<>();
        for (ReservationDTO reservation : reservationList) {
            int bookCode = reservation.getBook_code();
            double price = CodePriceMap.get(bookCode);
            String zoneName = ScZn.get(""+BookCodeSiteCode.get(bookCode));
            if(zoneRevenue.containsKey(zoneName)){
                price += zoneRevenue.get(zoneName);
            }
            zoneRevenue.put(zoneName,price);
        }
        return zoneRevenue;
    }
    public GraphDTO MakeZoneRevenueGraph(Map<String, String> ScZn){
        Map<String, Double> zoneRevenue = ZoneRevenueMap(ScZn);
        labelList = new ArrayList<>(zoneRevenue.keySet());
        dataList = new ArrayList<>();
        for(double revenue : zoneRevenue.values()){
            dataList.add(""+Math.round(revenue));
        }
        return new GraphDTO(labelList,stringYearAndMonth,dataList);
    }

    public Map<String, Integer> ZoneVisitorMap(Map<String, String> ScZn){
        Map<String, Integer> zoneVisitor = new TreeMap<>();
        for (ReservationDTO reservation : reservationList) {
            int bookCode = reservation.getBook_code();
            int member = CodeMemberMap.get(bookCode);
            String zoneName = ScZn.get(""+BookCodeSiteCode.get(bookCode));
            if(zoneVisitor.containsKey(zoneName)){
                member += zoneVisitor.get(zoneName);
            }
            zoneVisitor.put(zoneName,member);
        }
        return zoneVisitor;
    }
    public GraphDTO MakeZoneVisitorGraph(Map<String, String> ScZn){

        Map<String, Integer> zoneVisitor = ZoneVisitorMap(ScZn);

        labelList = new ArrayList<>(zoneVisitor.keySet());
        dataList = new ArrayList<>();
        for(int member : zoneVisitor.values()){
            dataList.add(""+member);
        }
        return new GraphDTO(labelList,stringYearAndMonth,dataList);
    }

}
