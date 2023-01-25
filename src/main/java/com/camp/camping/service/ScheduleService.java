package com.camp.camping.service;

import com.camp.camping.DTO.ScheduleDTO;
import com.camp.camping.frame.MyService;
import com.camp.camping.mapper.ScheduleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ScheduleService implements MyService<Integer, ScheduleDTO> {
    @Autowired
    ScheduleMapper mapper;
    @Override
    public void insert(ScheduleDTO v) throws Exception {
        mapper.insert(v);
    }

    @Override
    public void delete(Integer k) throws Exception {
        mapper.delete(k);
    }

    @Override
    public void update(ScheduleDTO v) throws Exception {
        mapper.update(v);
    }

    @Override
    public ScheduleDTO select(Integer k) throws Exception {
        return mapper.select(k);
    }

    @Override
    public List<ScheduleDTO> selectAll() throws Exception {
        return mapper.selectAll();
    }
    public ScheduleDTO selectDate(Date d) throws Exception {
        return mapper.selectDate(d);
    }
    public ScheduleDTO selectDate(String d) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return mapper.selectDate(new Date(sdf.parse(d).getTime()));
    }
    public Boolean IsDateEmpty(String d) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        ScheduleDTO schedule = selectDate(new Date(sdf.parse(d).getTime()));
        try{
            return  schedule == null
                    || schedule.getSchedule_date() == null;
        }catch(Exception e){
            return true;
        }
    }
}
