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

public class MakeMonthGraph {

    List<BookDTO> bookList;
    List<BookDTO> bookList2;
    List<ReservationDTO> reservationList;
    String stringYearAndMonth;
    List<String> dataList;
    List<String> labelList = new ArrayList<>();

    public MakeMonthGraph(List<BookDTO> bookList, List<ReservationDTO> reservationList,
        String stringYearAndMonth, List<BookDTO> bookList2) {
        this.bookList = new ArrayList<>(bookList);
        this.reservationList = new ArrayList<>(reservationList);
        this.bookList2 = new ArrayList<>(bookList2);
        this.stringYearAndMonth = "" + stringYearAndMonth;
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

    public GraphDTO MakeBookGraph() throws ParseException {
        setLists();
        Map<String, Integer> dayBookCount2 = new HashMap<>();

        for (BookDTO book : bookList2) {
            String day = DateToDay(book.getBook_writedate());
            int count = 1;
            if (dayBookCount2.containsKey(day)) {
                count += dayBookCount2.get(day);
                System.out.println("날:"+day+" count:"+count);
            }
            dayBookCount2.put(day, count);
        }
        for (int i = 1; i <= Utility.LastDayOfMonth(stringYearAndMonth + "-01"); i++) {
            int count =0;
            if(dayBookCount2.containsKey(""+i)){
                count = dayBookCount2.get(""+i);
            }
            dataList.add(""+count);
        }

        return new GraphDTO(labelList, stringYearAndMonth, dataList);
    }

    public GraphDTO MakeRevenueGraph() throws ParseException {
        setLists();

        for (int i = 1; i <= Utility.LastDayOfMonth(stringYearAndMonth + "-01"); i++) {
            labelList.add("" + i);
        }
        
        Map<Integer, Double> CodePriceMap = new HashMap<>();
        Map<String, Double> dayRevenueMap2 = new HashMap<>();

        for (BookDTO book : bookList) {
            double bookPrice = book.getBook_price();
            double days = Utility.StringDateDifference(book.getBook_checkout(),
                book.getBook_checkin());
            System.out.println(book.getBook_code());
            CodePriceMap.put(book.getBook_code(), bookPrice / days);
        }
        for (ReservationDTO reservation : reservationList) {
            String day = DateToDay(reservation.getReservation_date());
            int bookCode = reservation.getBook_code();
            System.out.println(bookCode);
            double price = CodePriceMap.get(bookCode);
            if(day.equals("7")){
                System.out.println(price);
            }
            if (dayRevenueMap2.containsKey(day)) {
                price += dayRevenueMap2.get(day);
            }

            dayRevenueMap2.put(day, price);
        }
        for (int i = 1; i <= Utility.LastDayOfMonth(stringYearAndMonth + "-01"); i++) {
            double count = 0.0;
            if(dayRevenueMap2.containsKey(""+i)){
                count = dayRevenueMap2.get(""+i);
            }
            dataList.add("" + Math.round(count));
        }
        return new GraphDTO(labelList, stringYearAndMonth, dataList);
    }

    public GraphDTO MakeVisitorGraph() throws ParseException {
        setLists();
        Map<Integer, Integer> CodeMemberMap = new HashMap<>();
        Map<String, Integer> dayVisitorMap2 = new HashMap<>();
        for (BookDTO book : bookList) {
            int bookMember = book.getBook_member();
            CodeMemberMap.put(book.getBook_code(), bookMember);
        }
        for (ReservationDTO reservation : reservationList) {
            String day = DateToDay(reservation.getReservation_date());
            int bookCode = reservation.getBook_code();
            int member = CodeMemberMap.get(bookCode);
            if (dayVisitorMap2.containsKey(day)) {
                member += dayVisitorMap2.get(day);
            }
            dayVisitorMap2.put(day, member);
        }
        for (int i = 1; i <= Utility.LastDayOfMonth(stringYearAndMonth + "-01"); i++) {
            int count = 0;
            if(dayVisitorMap2.containsKey(""+i)){
                count = dayVisitorMap2.get(""+i);
            }
            dataList.add("" + count);
        }
        return new GraphDTO(labelList, stringYearAndMonth, dataList);
    }

}
