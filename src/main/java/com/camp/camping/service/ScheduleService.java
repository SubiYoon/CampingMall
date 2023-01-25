package com.camp.camping.service;

import com.camp.camping.DTO.ScheduleDTO;
import com.camp.camping.frame.MyService;
import com.camp.camping.mapper.ScheduleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
