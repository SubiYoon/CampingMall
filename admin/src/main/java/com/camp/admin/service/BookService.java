package com.camp.admin.service;


import com.camp.admin.DTO.BookDTO;
import com.camp.admin.DTO.GraphDTO;
import com.camp.admin.DTO.ReservationDTO;
import com.camp.admin.DTO.SiteDTO;
import com.camp.admin.DTO.ZoneDTO;
import com.camp.admin.frame.MyService;
import com.camp.admin.mapper.BookMapper;
import com.camp.admin.utility.MakeMainGraph;
import com.camp.admin.utility.Utility;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.TreeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService implements MyService<Integer, BookDTO> {

    @Autowired
    BookMapper mapper;
    @Autowired
    ReservationService reservationService;
    @Autowired
    SiteService siteService;

    @Autowired
    ZoneService zoneService;


    @Override
    public void insert(BookDTO v) throws Exception {
        mapper.insert(v);
    }

    @Override
    public void delete(Integer k) throws Exception {
        mapper.delete(k);
    }

    @Override
    public void update(BookDTO v) throws Exception {
        mapper.update(v);
    }

    @Override
    public BookDTO select(Integer k) throws Exception {
        return mapper.select(k);
    }

    @Override
    public List<BookDTO> selectAll() throws Exception {
        return mapper.selectAll();
    }

    public BookDTO selectMerchant(String merchant_uid) {
        return mapper.selectMerchant(merchant_uid);
    }

    public void insertBookAndReservation(BookDTO v) throws Exception {
        this.insert(v);

        BookDTO book = this.selectMerchant(v.getMerchant_uid());
        reservationService.insertReservationByBook(book);
    }

    public void deleteBookAndReservation(Integer k) throws Exception {
        reservationService.deleteByBook(k);
        BookDTO book = this.select(k);
        book.setBook_state(0);
        this.update(book);
    }

    public BookDTO SelectByReservationCode(int reservation_code) {
        return mapper.selectByReservationCode(reservation_code);
    }

    //예약 조회 기능
    public List<BookDTO> SelectByDateAndCompanyCode(String stringDate, int company_code)
        throws ParseException {
        List<BookDTO> books = new ArrayList<>();
        List<ReservationDTO> reservations = reservationService.SelectByDateAndCompanyCode(
            stringDate, company_code);
        for (ReservationDTO reservation : reservations) {
            books.add(SelectByReservationCode(reservation.getReservation_code()));
        }
        return books;
    }

    //일매출
    public double DailySales(String reservation_Date, int company_code) throws Exception {
        List<ReservationDTO> reservations = reservationService.SelectByDateAndCompanyCode(
            reservation_Date, company_code);
        double dailySales = 0;
        for (ReservationDTO reservation : reservations) {
            BookDTO book = select(reservation.getBook_code());
            double bookDays = Utility.StringDateDifference(book.getBook_checkout(),
                book.getBook_checkin());
            dailySales += (double) book.getBook_price() / bookDays;
        }
        return dailySales;
    }

    //stringYearAndMonth = "2023-02"
    public List<String> DailyList(String stringYearAndMonth, int company_code) throws Exception {
        List<String> sales = new ArrayList<>();
        String stringDate = stringYearAndMonth + "-01";
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(Utility.StringToDate(stringDate));
        for (int i = 0; i < Utility.LastDayOfMonth(stringDate); i++) {
            sales.add(
                "" + (int) DailySales(Utility.DateToString(calendar.getTime()), company_code));
            calendar.add(Calendar.DATE, +1);
        }
        return sales;
    }

    //해당 년월의 일별 매출을 GraphDTO 형식으로 담는다.
    public GraphDTO MonthSalesGraph(String stringYearAndMonth, int company_code) throws Exception {
        List<String> labelsList = new ArrayList<>();
        for (int i = 1; i <= Utility.LastDayOfMonth(stringYearAndMonth + "-01"); i++) {
            labelsList.add("" + i);
        }
        return new GraphDTO(labelsList, stringYearAndMonth,
            DailyList(stringYearAndMonth, company_code));
    }

    private List<String> DailyUserList(String stringYearAndMonth, int companyCode)
        throws Exception {
        List<String> sales = new ArrayList<>();
        String stringDate = stringYearAndMonth + "-01";
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(Utility.StringToDate(stringDate));
        for (int i = 0; i < Utility.LastDayOfMonth(stringDate); i++) {
            sales.add(
                "" + (int) DailyUser(Utility.DateToString(calendar.getTime()), companyCode));
            calendar.add(Calendar.DATE, +1);
        }
        return sales;
    }

    public GraphDTO MonthlyUserGraph(String stringYearAndMonth, int company_code)
        throws Exception {
        List<String> labelsList = new ArrayList<>();
        for (int i = 1; i <= Utility.LastDayOfMonth(stringYearAndMonth + "-01"); i++) {
            labelsList.add("" + i);
        }
        return new GraphDTO(labelsList, stringYearAndMonth,
            DailyUserList(stringYearAndMonth, company_code));
    }

    public GraphDTO MonthlyBookGraph(String stringYearAndMonth, int company_code)
        throws Exception {
        List<String> labelsList = new ArrayList<>();
        for (int i = 1; i <= Utility.LastDayOfMonth(stringYearAndMonth + "-01"); i++) {
            labelsList.add("" + i);
        }
        return new GraphDTO(labelsList, stringYearAndMonth,
            DailyBookList(stringYearAndMonth, company_code));
    }

    private List<String> DailyBookList(String stringYearAndMonth, int companyCode)
        throws Exception {
        List<String> sales = new ArrayList<>();
        String stringDate = stringYearAndMonth + "-01";
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(Utility.StringToDate(stringDate));
        for (int i = 0; i < Utility.LastDayOfMonth(stringDate); i++) {
            sales.add(
                "" + DailyBookCount(Utility.DateToString(calendar.getTime()), companyCode));
            calendar.add(Calendar.DATE, +1);
        }
        return sales;
    }

    public int DailyBookCount(String stringDate, int companyCode) {
        return mapper.selectByWriteDateAndCompanyCode(companyCode, stringDate).size();
    }

    //월매출(date는 year랑 month만 정상적으로 담겨있으면 됨)
    public double MonthlySales(String stringDate, int company_code) throws Exception {
        double monthlySales = 0;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(Utility.StringToDate(stringDate));
        calendar = new GregorianCalendar(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
            1);
        int daysOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int i = 0; i < daysOfMonth; i++) {
            monthlySales += DailySales(Utility.DateToString(calendar.getTime()), company_code);
            calendar.add(Calendar.DATE, 1);
        }
        return monthlySales;
    }

    public int MonthlyBookCount(String stringDate, int company_code) throws Exception {
        int monthlySales = 0;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(Utility.StringToDate(stringDate));
        calendar = new GregorianCalendar(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
            1);
        int daysOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int i = 0; i < daysOfMonth; i++) {
            monthlySales += DailyBookCount(Utility.DateToString(calendar.getTime()), company_code);
            calendar.add(Calendar.DATE, 1);
        }
        return monthlySales;
    }

    public int MonthlyUserCount(String stringDate, int company_code) throws Exception {
        int monthlySales = 0;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(Utility.StringToDate(stringDate));
        calendar = new GregorianCalendar(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
            1);
        int daysOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int i = 0; i < daysOfMonth; i++) {
            monthlySales += DailyUser(Utility.DateToString(calendar.getTime()), company_code);
            calendar.add(Calendar.DATE, 1);
        }
        return monthlySales;
    }

    public double YearlySales(String stringDate, int company_code) throws Exception {
        double yearlySales = 0;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(Utility.StringToDate(stringDate));
        calendar = new GregorianCalendar(calendar.get(Calendar.YEAR), Calendar.JANUARY, 1);
        for (int i = 0; i < 12; i++) {
            yearlySales += MonthlySales(Utility.DateToString(calendar.getTime()), company_code);
            calendar.add(Calendar.MONTH, 1);
        }

        return yearlySales;
    }

    //년간 월별 매출
    //stringYear = "2022"
    public List<String> MonthlyList(String stringYear, int company_code) throws Exception {
        List<String> sales = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            String stringDate;
            if (i / 10 == 0) {
                stringDate = "-0" + i + "-01";
            } else {
                stringDate = "-" + i + "-01";
            }
            stringDate = stringYear + stringDate;
            sales.add("" + (int) MonthlySales(stringDate, company_code));
        }
        return sales;
    }

    public List<String> MonthlyBookCountList(String stringYear, int company_code) throws Exception {
        List<String> sales = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            String stringDate;
            if (i / 10 == 0) {
                stringDate = "-0" + i + "-01";
            } else {
                stringDate = "-" + i + "-01";
            }
            stringDate = stringYear + stringDate;
            sales.add("" + (int) MonthlyBookCount(stringDate, company_code));
        }
        return sales;
    }

    public List<String> MonthlyUserCountList(String stringYear, int company_code) throws Exception {
        List<String> sales = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            String stringDate;
            if (i / 10 == 0) {
                stringDate = "-0" + i + "-01";
            } else {
                stringDate = "-" + i + "-01";
            }
            stringDate = stringYear + stringDate;
            sales.add("" + (int) MonthlyUserCount(stringDate, company_code));
        }
        return sales;
    }

    //해당 년도의 월간 매출을 GraphDTO 형식으로 담는다.
    public GraphDTO YearSalesGraph(String stringYear, int company_code) throws Exception {
        List<String> labelsList = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            String stringDate;
            if (i / 10 == 0) {
                stringDate = stringYear + "/0" + i;
            } else {
                stringDate = stringYear + "/" + i;
            }
            labelsList.add(stringDate);
        }
        return new GraphDTO(labelsList, stringYear, MonthlyList(stringYear, company_code));
    }

    public GraphDTO YearlyBookGraph(String stringYear, int company_code) throws Exception {
        List<String> labelsList = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            String stringDate;
            if (i / 10 == 0) {
                stringDate = stringYear + "/0" + i;
            } else {
                stringDate = stringYear + "/" + i;
            }
            labelsList.add(stringDate);
        }
        return new GraphDTO(labelsList, stringYear, MonthlyBookCountList(stringYear, company_code));
    }

    public GraphDTO YearlyUserGraph(String stringYear, int company_code) throws Exception {
        List<String> labelsList = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            String stringDate;
            if (i / 10 == 0) {
                stringDate = stringYear + "/0" + i;
            } else {
                stringDate = stringYear + "/" + i;
            }
            labelsList.add(stringDate);
        }
        return new GraphDTO(labelsList, stringYear, MonthlyUserCountList(stringYear, company_code));
    }


    public List<BookDTO> selectUserAll(int user_code) {
        return mapper.selectUserAll(user_code);
    }

    public Map<String, Integer> DailySiteUserMap(String stringDate, int company_code)
        throws Exception {
        Map<String, Integer> SiteUserMap = new HashMap<>();
        List<ReservationDTO> reservationList = reservationService.SelectByDateAndCompanyCode(
            stringDate, company_code);
        for (ReservationDTO reservation : reservationList) {
            BookDTO book = SelectByReservationCode(reservation.getReservation_code());
            String siteName = siteService.select(book.getSite_code()).getSite_name();
            int userNumber = book.getBook_member();
            if (SiteUserMap.containsKey(siteName)) {
                SiteUserMap.put(siteName, SiteUserMap.get(siteName) + userNumber);
            } else {
                SiteUserMap.put(siteName, userNumber);
            }
        }
        return SiteUserMap;
    }

    //stringYearAndMonth = "20023-02"형식
    //site_code , Book_member의 합산이 짝지어서 return
    public Map<String, Integer> MonthlySiteUserMap(String stringYearAndMonth, int company_code)
        throws Exception {
        Map<String, Integer> SiteUserMap = new HashMap<>();
        String stringDate = stringYearAndMonth + "-01";
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(Utility.StringToDate(stringDate));
        for (int i = 0; i < Utility.LastDayOfMonth(stringDate); i++) {
            Map<String, Integer> daily = DailySiteUserMap(Utility.DateToString(calendar.getTime()),
                company_code);
            for (Entry<String, Integer> entry : daily.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                SiteUserMap.merge(key, value, Integer::sum);
            }
            calendar.add(Calendar.DATE, 1);
        }
        return SiteUserMap;
    }

    public Map<String, Integer> YearlySiteUserMap(String stringYear, int company_code)
        throws Exception {
        Map<String, Integer> SiteUserMap = new HashMap<>();
        for (int i = 1; i <= 12; i++) {
            String stringYearAndMonth;
            if (i / 10 == 1) {
                stringYearAndMonth = stringYear + "-" + i;
            } else {
                stringYearAndMonth = stringYear + "-0" + i;
            }
            Map<String, Integer> monthly = MonthlySiteUserMap(stringYearAndMonth, company_code);
            for (Entry<String, Integer> entry : monthly.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                SiteUserMap.merge(key, value, Integer::sum);
            }
        }
        return SiteUserMap;
    }

    //stringYearAndMonth = "20023-02"형식
    public GraphDTO MonthlySiteUserGraph(String stringYearAndMonth, int company_code)
        throws Exception {

        Map<String, Integer> monthlySiteUserMap = MonthlySiteUserMap(stringYearAndMonth,
            company_code);
        List<String> labesList = new ArrayList<>();
        for (String label : monthlySiteUserMap.keySet()) {
            labesList.add("" + label);
        }
        List<String> dataList = new ArrayList<>();
        for (int data : monthlySiteUserMap.values()) {
            dataList.add("" + data);
        }
        return new GraphDTO(labesList, stringYearAndMonth, dataList);
    }

    //stringYear = "2023"형식
    //해당년도 사이트별 인원수 GraphDTO 형식으로 반환
    public GraphDTO YearlySiteUserGraph(String stringYear, int company_code) throws Exception {
        Map<String, Integer> yearlySiteUserMap = YearlySiteUserMap(stringYear, company_code);
        List<String> labesList = new ArrayList<>();
        for (String label : yearlySiteUserMap.keySet()) {
            labesList.add("" + label);
        }
        List<String> dataList = new ArrayList<>();
        for (int data : yearlySiteUserMap.values()) {
            dataList.add("" + data);
        }
        return new GraphDTO(labesList, stringYear, dataList);
    }

    public Map<String, Double> DailyZoneSalesMap(String stringDate, int company_code)
        throws Exception {
        Map<String, Double> zoneSalesMap = new TreeMap<>();
        List<ReservationDTO> reservationList = reservationService.SelectByDateAndCompanyCode(
            stringDate, company_code);
        for (ReservationDTO reservation : reservationList) {
            BookDTO book = SelectByReservationCode(reservation.getReservation_code());
            String zoneName = zoneService.select(
                siteService.select(book.getSite_code()).getZone_code()).getZone_name();
            int sales = book.getBook_price();
            double bookDays = Utility.StringDateDifference(book.getBook_checkout(),
                book.getBook_checkin());
            if (zoneSalesMap.containsKey(zoneName)) {
                zoneSalesMap.put(zoneName, zoneSalesMap.get(zoneName) + (sales / bookDays));
            } else {
                zoneSalesMap.put(zoneName, sales / bookDays);
            }
        }
        return zoneSalesMap;
    }

    public Map<String, Double> MonthlyZoneSalesMap(String stringYearAndMonth, int company_code)
        throws Exception {
        Map<String, Double> zoneSalesMap = new TreeMap<>();
        String stringDate = stringYearAndMonth + "-01";
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(Utility.StringToDate(stringDate));
        for (int i = 0; i < Utility.LastDayOfMonth(stringDate); i++) {
            Map<String, Double> daily = DailyZoneSalesMap(Utility.DateToString(calendar.getTime()),
                company_code);
            for (Entry<String, Double> entry : daily.entrySet()) {
                String key = entry.getKey();
                Double value = entry.getValue();
                zoneSalesMap.merge(key, value, Double::sum);
            }
            calendar.add(Calendar.DATE, 1);
        }
        return zoneSalesMap;
    }

    public Map<String, Double> YearlyZoneSalesMap(String stringYear, int company_code)
        throws Exception {
        Map<String, Double> ZoneSalesMap = new TreeMap<>();
        for (int i = 1; i <= 12; i++) {
            String stringYearAndMonth;
            if (i / 10 == 1) {
                stringYearAndMonth = stringYear + "-" + i;
            } else {
                stringYearAndMonth = stringYear + "-0" + i;
            }
            Map<String, Double> monthly = MonthlyZoneSalesMap(stringYearAndMonth, company_code);
            for (Entry<String, Double> entry : monthly.entrySet()) {
                String key = entry.getKey();
                Double value = entry.getValue();
                ZoneSalesMap.merge(key, value, Double::sum);
            }
        }
        return ZoneSalesMap;
    }

    public GraphDTO MonthlyZoneSalesGraph(String stringYearAndMonth, int company_code)
        throws Exception {
        Map<String, Double> monthlyZoneSalesMap = MonthlyZoneSalesMap(stringYearAndMonth,
            company_code);
        List<String> labesList = new ArrayList<>();
        for (String label : monthlyZoneSalesMap.keySet()) {
            labesList.add("" + label);
        }
        List<String> dataList = new ArrayList<>();
        for (Double data : monthlyZoneSalesMap.values()) {
            dataList.add("" + Math.round(data));
        }
        return new GraphDTO(labesList, stringYearAndMonth, dataList);
    }

    public GraphDTO YearlyZoneSalesGraph(String stringYear, int company_code) throws Exception {
        Map<String, Double> yearlyZoneSalesMap = YearlyZoneSalesMap(stringYear, company_code);
        List<String> labesList = new ArrayList<>();
        for (String label : yearlyZoneSalesMap.keySet()) {
            labesList.add("" + label);
        }
        List<String> dataList = new ArrayList<>();
        for (Double data : yearlyZoneSalesMap.values()) {
            dataList.add("" + Math.round(data));
        }
        return new GraphDTO(labesList, stringYear, dataList);
    }

    public Map<String, Integer> DailyZoneUserMap(String stringDate, int company_code)
        throws Exception {
        Map<String, Integer> zoneUserMap = new TreeMap<>();
        List<ReservationDTO> reservationList = reservationService.SelectByDateAndCompanyCode(
            stringDate, company_code);
        for (ReservationDTO reservation : reservationList) {
            BookDTO book = SelectByReservationCode(reservation.getReservation_code());
            String zoneName = zoneService.select(
                siteService.select(book.getSite_code()).getZone_code()).getZone_name();
            int userNumber = book.getBook_member();
            if (zoneUserMap.containsKey(zoneName)) {
                zoneUserMap.put(zoneName, zoneUserMap.get(zoneName) + userNumber);
            } else {
                zoneUserMap.put(zoneName, userNumber);
            }
        }
        return zoneUserMap;
    }

    public Map<String, Integer> MonthlyZoneUserMap(String stringYearAndMonth, int company_code)
        throws Exception {
        Map<String, Integer> zoneUserMap = new TreeMap<>();
        String stringDate = stringYearAndMonth + "-01";
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(Utility.StringToDate(stringDate));
        for (int i = 0; i < Utility.LastDayOfMonth(stringDate); i++) {
            Map<String, Integer> daily = DailyZoneUserMap(Utility.DateToString(calendar.getTime()),
                company_code);
            for (Entry<String, Integer> entry : daily.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                zoneUserMap.merge(key, value, Integer::sum);
            }
            calendar.add(Calendar.DATE, 1);
        }
        return zoneUserMap;
    }

    public Map<String, Integer> YearlyZoneUserMap(String stringYear, int company_code)
        throws Exception {
        Map<String, Integer> zoneUserMap = new TreeMap<>();
        for (int i = 1; i <= 12; i++) {
            String stringYearAndMonth;
            if (i / 10 == 1) {
                stringYearAndMonth = stringYear + "-" + i;
            } else {
                stringYearAndMonth = stringYear + "-0" + i;
            }
            Map<String, Integer> monthly = MonthlyZoneUserMap(stringYearAndMonth, company_code);
            for (Entry<String, Integer> entry : monthly.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                zoneUserMap.merge(key, value, Integer::sum);
            }
        }
        return zoneUserMap;
    }

    public GraphDTO MonthlyZoneUserGraph(String stringYearAndMonth, int company_code)
        throws Exception {
        Map<String, Integer> monthlyZoneUserMap = MonthlyZoneUserMap(stringYearAndMonth,
            company_code);
        List<String> labesList = new ArrayList<>();
        for (String label : monthlyZoneUserMap.keySet()) {
            labesList.add("" + label);
        }
        List<String> dataList = new ArrayList<>();
        for (int data : monthlyZoneUserMap.values()) {
            dataList.add("" + data);
        }
        return new GraphDTO(labesList, stringYearAndMonth, dataList);
    }

    public GraphDTO YearlyZoneUserGraph(String stringYear, int company_code) throws Exception {
        Map<String, Integer> yearlyZoneUserMap = YearlyZoneUserMap(stringYear, company_code);
        List<String> labesList = new ArrayList<>();
        for (String label : yearlyZoneUserMap.keySet()) {
            labesList.add("" + label);
        }
        List<String> dataList = new ArrayList<>();
        for (int data : yearlyZoneUserMap.values()) {
            dataList.add("" + data);
        }
        return new GraphDTO(labesList, stringYear, dataList);
    }


    public BookDTO selectViewForm(String book_checkin, String book_checkout, int book_sitecode) {

        BookDTO book = new BookDTO();
        try {
            SiteDTO site = siteService.select(book_sitecode);
            book.setSite_name(site.getSite_name());
            book.setBook_price(site.getSite_price());
        } catch (Exception e) {
            e.printStackTrace();
        }
        DateFormat dateFormat = new SimpleDateFormat("MMddHHmmss");
        Calendar cal = Calendar.getInstance();
        Random random = new Random();
        book.setMerchant_uid(dateFormat.format(cal.getTime()) + random.nextInt(100000));
        book.setBook_checkin(book_checkin);
        book.setBook_checkout(book_checkout);
        book.setSite_code(book_sitecode);

        return book;
    }

    public List<Map<String, Object>> selectAllState(int book_state) throws Exception {
        return mapper.selectAllState(book_state);
    }

    public int updateBookState(String merchant_uid, int state) {
        return mapper.updateBookState(merchant_uid, state);
    }


    public String DailySalesRate(String stringDate, int company_code) throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(Utility.StringToDate(stringDate));
        calendar.add(Calendar.DATE, -1);
        return Utility.RateOfIncrease(DailySales(stringDate, company_code),
            DailySales(Utility.DateToString(calendar.getTime()), company_code));
    }

    //stringYearAndMonth = "2023-08"
    public String MonthlySalesRate(String stringYearAndMonth, int company_code) throws Exception {
        String stringDate = stringYearAndMonth + "-01";
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(Utility.StringToDate(stringDate));
        calendar.add(Calendar.MONTH, -1);
        return Utility.RateOfIncrease(MonthlySales(stringDate, company_code),
            MonthlySales(Utility.DateToString(calendar.getTime()), company_code));
    }

    //stringYear = "2023"
    public String YearlySalesRate(String stringYear, int company_code) throws Exception {
        String stringDate = stringYear + "-01-01";
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(Utility.StringToDate(stringDate));
        calendar.add(Calendar.YEAR, -1);
        return Utility.RateOfIncrease(YearlySales(stringDate, company_code),
            YearlySales(Utility.DateToString(calendar.getTime()), company_code));
    }

    public List<BookDTO> selectUserBook(int company_code, String user_id) throws Exception {
        return mapper.selectUserBook(company_code, user_id);
    }

    public int DailyUser(String stringDate, int company_code) throws Exception {
        int userCount = 0;
        List<ReservationDTO> reservations = reservationService.SelectByDateAndCompanyCode(
            stringDate, company_code);
        for (ReservationDTO reservation : reservations) {
            BookDTO book = select(reservation.getBook_code());
            userCount += book.getBook_member();
        }
        return userCount;
    }

    //stringYearAndMonth = "2023-02"
    public int MonthlyUser(String stringYearAndMonth, int company_code) throws Exception {
        int userCount = 0;
        int lastday = Utility.LastDayOfMonth(stringYearAndMonth + "-01");
        for (int i = 1; i <= lastday; i++) {
            String day = "-";
            if (i / 10 < 1) {
                day += "0" + i;
            } else {
                day += "" + i;
            }
            String stringDate = stringYearAndMonth + day;
            userCount += DailyUser(stringDate, company_code);
        }
        return userCount;
    }

    //stringYear = "2023"
    public int YearlyUser(String stringYear, int company_code) throws Exception {
        int userCount = 0;
        for (int i = 0; i < 12; i++) {
            String stringDate = stringYear;
            if (i / 10 < 1) {
                stringDate += "-0" + i;
            } else {
                stringDate += "-" + i;
            }
            userCount += MonthlyUser(stringDate, company_code);
        }
        return userCount;
    }

    public String DailyUserRate(String stringDate, int company_code) throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(Utility.StringToDate(stringDate));
        calendar.add(Calendar.DATE, -1);
        return Utility.RateOfIncrease(DailyUser(stringDate, company_code),
            DailyUser(Utility.DateToString(calendar.getTime()), company_code));
    }

    public String MonthlyUserRate(String stringYearAndMonth, int company_code) throws Exception {
        String stringDate = stringYearAndMonth + "-01";
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(Utility.StringToDate(stringDate));
        calendar.add(Calendar.MONTH, -1);
        return Utility.RateOfIncrease(
            MonthlyUser(Utility.StringYearAndMonthFromStringDate(stringDate), company_code),
            MonthlyUser(
                Utility.StringYearAndMonthFromStringDate(Utility.DateToString(calendar.getTime())),
                company_code));
    }

    public String MonthlyBookRate(String stringYearAndMonth, int company_code) throws Exception {
        String stringDate = stringYearAndMonth + "-01";
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(Utility.StringToDate(stringDate));
        calendar.add(Calendar.MONTH, -1);
        return Utility.RateOfIncrease(
            MonthlyBookCount(stringDate, company_code),
            MonthlyBookCount(
                Utility.DateToString(calendar.getTime()),
                company_code));
    }

    public String YearlyUserRate(String stringYear, int company_code) throws Exception {
        String stringDate = stringYear + "-01-01";
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(Utility.StringToDate(stringDate));
        calendar.add(Calendar.YEAR, -1);
        return Utility.RateOfIncrease(
            YearlyUser(Utility.StringYearFromStringDate(stringDate), company_code),
            YearlyUser(Utility.StringYearFromStringDate(Utility.DateToString(calendar.getTime())),
                company_code));
    }

    public List<Map<String, Object>> selectAllmain(int companyCode) throws Exception {
        return mapper.selectAllmain(companyCode);
    }

    public List<BookDTO> selectByCompanyCodeAndYearMonth(int company_code, String stringYearMonth) {
        return mapper.selectByCompanyCodeAndYearMonth(company_code, stringYearMonth + "%");
    }

    public List<BookDTO> selectByCompanyCodeAndWriteDate(int company_code,
        String stringYearAndMonth)
        throws ParseException {

        return mapper.selectByCompanyCodeAndWriteDate(company_code, "%" + stringYearAndMonth + "%");

    }

    public MakeMainGraph getMonthGraph(int company_code, String stringYearAndMonth)
        throws ParseException {
        List<BookDTO> bookList = selectByCompanyCodeAndYearMonth(company_code,stringYearAndMonth);
        List<BookDTO> bookList2 = selectByCompanyCodeAndWriteDate(company_code,stringYearAndMonth);
        List<ReservationDTO> reservationList = reservationService.selectByCompanyCodeAndYearMonth(company_code,stringYearAndMonth);
        return new MakeMainGraph(bookList,reservationList,stringYearAndMonth,bookList2);
    }
    public Map<String, String> SiteCodeAndZoneNameMap(int company_code) throws Exception {
        Map<String, String> ScZn = new TreeMap<>();
        List<SiteDTO> siteList = siteService.selectSet(company_code);
        List<ZoneDTO> zoneList = zoneService.selectZone(company_code);
        for(SiteDTO site : siteList){
            String zoneName="";
            for(ZoneDTO zone : zoneList){
                if(zone.getZone_code()==site.getZone_code()){
                    zoneName = zone.getZone_name();
                }
            }
            ScZn.put(""+site.getSite_code(),zoneName);
        }
        return ScZn;
    }
}
