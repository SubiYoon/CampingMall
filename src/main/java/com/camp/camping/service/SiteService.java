package com.camp.camping.service;

import com.camp.camping.DTO.ReservationDTO;
import com.camp.camping.DTO.SiteDTO;
import com.camp.camping.frame.MyService;
import com.camp.camping.mapper.SiteMapper;
import com.camp.camping.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.*;

@Service
public class SiteService implements MyService<Integer, SiteDTO> {
    @Autowired
    SiteMapper mapper;
    @Inject
    ScheduleService scheduleService;
    @Inject
    ReservationService reservationService;

    @Override
    public void insert(SiteDTO siteDTO) throws Exception {

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

    public List<Integer> selectByCompany(int company_code) {
        return mapper.selectByCompany(company_code);
    }

    public int findCompanyCode(int site_code) {
        return mapper.findCompanyCode(site_code);
    }

    public List<Integer> AvailableSiteCode(int company_code, String stringDate1, String stringDate2) throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(Utility.StringToDate(stringDate2));
        int days = Utility.StringDateDifference(stringDate2, stringDate1);
        List<Integer> site_codes = Collections.emptyList();
        Boolean isAvailable = true;

        for (int i = days; i > 0; i--) {
            calendar.add(Calendar.DATE, -1);
            isAvailable = scheduleService.IsDateEmpty(Utility.DateToString(calendar.getTime()), company_code);
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
    public List<SiteDTO> AvailableSite(int company_code, String stringDate1, String stringDate2) throws Exception {
        List<Integer> siteCodes = AvailableSiteCode(company_code, stringDate1,stringDate2);
        List<SiteDTO> availableSites = new ArrayList<>();
        for(int siteCode:siteCodes){
            SiteDTO site = select(siteCode);
            availableSites.add(site);
        }
        return availableSites;
    }

    public Boolean IsOkToReservation(int site_code, String date) {
        try {
            return scheduleService.IsDateEmpty(date, this.findCompanyCode(site_code)) && reservationService.IsDateEmpty(site_code, date);
        } catch (Exception e) {
            return false;
        }
    }
}
