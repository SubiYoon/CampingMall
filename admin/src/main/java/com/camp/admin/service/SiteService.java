package com.camp.admin.service;

import com.camp.admin.DTO.SiteDTO;
import com.camp.admin.frame.MyService;
import com.camp.admin.mapper.SiteMapper;
import com.camp.admin.utility.Utility;
import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        mapper.delete(integer);
    }

    @Override
    public void update(SiteDTO siteDTO) throws Exception {
        mapper.update(siteDTO);
    }

    @Override
    public SiteDTO select(Integer integer) throws Exception {
        return mapper.select(integer);
    }

    @Override
    public List<SiteDTO> selectAll() throws Exception {
        return mapper.selectAll();
    }

    public void updateDel(Integer integer) throws Exception {
        mapper.updateDel(integer);
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

    public SiteDTO selectView(int site_code) {
        return mapper.selectView(site_code);
    }
}
