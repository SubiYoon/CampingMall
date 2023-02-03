package com.camp.admin.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.camp.admin.DTO.ReservationDTO;
import com.camp.admin.DTO.SiteDTO;
import com.camp.admin.frame.MyService;
import com.camp.admin.mapper.SiteMapper;
import com.camp.admin.utility.Utility;

@Service
public class SiteService implements MyService<Integer, SiteDTO> {

    @Autowired
    SiteMapper mapper;
    @Autowired
    ScheduleService scheduleService;
    @Autowired
    ReservationService reservationService;

    @Override
    public void insert(SiteDTO siteDTO) throws Exception {
        mapper.insert(siteDTO);
    }

    @Override
    public void delete(Integer integer) throws Exception {

    }

    @Override
    public void update(SiteDTO siteDTO) throws Exception {

    }

    @Override
    public SiteDTO select(Integer integer) throws Exception {
        return mapper.select(integer);
    }

    @Override
    public List<SiteDTO> selectAll() throws Exception {
        return null;
    }
    
    public List<SiteDTO> selectSet(int company_code) throws Exception {
        return mapper.selectSet(company_code);
    }
    
    public List<Integer> selectByCompany(int company_code) {
        return mapper.selectByCompany(company_code);
    }

    public int findCompanyCode(int site_code) {
        return mapper.findCompanyCode(site_code);
    }

    public List<Integer> AvailableSiteCode(int company_code, String stringDate1, String stringDate2)
        throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(Utility.StringToDate(stringDate2));
        int days = Utility.StringDateDifference(stringDate2, stringDate1);
        List<Integer> site_codes = Collections.emptyList();
        Boolean isAvailable;

        for (int i = days; i > 0; i--) {
            calendar.add(Calendar.DATE, -1);
            isAvailable = scheduleService.IsDateEmpty(Utility.DateToString(calendar.getTime()),
                company_code);
            if (!isAvailable) {
                return site_codes;
            }
        }

        site_codes = selectByCompany(company_code);
        Set<Integer> exclusions = new HashSet<>();

        for (int i = days; i > 0; i--) {
            List<ReservationDTO> reservations = reservationService.selectDate(calendar.getTime());
            for (ReservationDTO reservation : reservations) {
                exclusions.add(reservationService.findSiteCode(reservation.getReservation_code()));
            }
            calendar.add(Calendar.DATE, 1);
        }
        for (int exclusion : exclusions) {
            site_codes.remove(Integer.valueOf(exclusion));
        }
        return site_codes;
    }

    //예약가능한 사이트들
    public List<SiteDTO> AvailableSite(int company_code, String stringDate1, String stringDate2)
        throws Exception {
        List<Integer> siteCodes = AvailableSiteCode(company_code, stringDate1, stringDate2);
        List<SiteDTO> availableSites = new ArrayList<>();
        for (int siteCode : siteCodes) {
            SiteDTO site = select(siteCode);
            availableSites.add(site);
        }
        return availableSites;
    }

    //예약 가능한 사이트 갯수
    public int AvailableSiteCount(int company_code, String stringDate1, String stringDate2)
        throws Exception {
        List<Integer> siteCodes = AvailableSiteCode(company_code, stringDate1, stringDate2);
        return siteCodes.size();
    }

    //해당 사이트코드에 두 날짜의 예약이 가능한지
    public Boolean IsOkToReservation(int site_code, String stringDate1, String stringDate2)
        throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(Utility.StringToDate(stringDate2));
        int days = Utility.StringDateDifference(stringDate2, stringDate1);
        boolean isAvailable = true;
        for (int i = days; i > 0; i--) {
            calendar.add(Calendar.DATE, -1);
            String date = Utility.DateToString(calendar.getTime());
            isAvailable &= scheduleService.IsDateEmpty(date, this.findCompanyCode(site_code))
                && reservationService.IsDateEmpty(site_code, date);
        }
        return isAvailable;
    }

    public SiteDTO selectView(int site_code){
        return mapper.selectView(site_code);
    }
}
