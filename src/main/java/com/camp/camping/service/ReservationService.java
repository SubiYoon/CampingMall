package com.camp.camping.service;

import com.camp.camping.DTO.ReservationDTO;
import com.camp.camping.frame.MyService;
import com.camp.camping.mapper.ReservationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService implements MyService<Integer, ReservationDTO> {
    @Autowired
    ReservationMapper mapper;

    @Override
    public void insert(ReservationDTO v) throws Exception {
        mapper.insert(v);
    }

    @Override
    public void delete(Integer k) throws Exception {
        mapper.delete(k);
    }

    @Override
    public void update(ReservationDTO v) throws Exception {
        mapper.update(v);
    }

    @Override
    public ReservationDTO select(Integer k) throws Exception {
        return mapper.select(k);
    }

    @Override
    public List<ReservationDTO> selectAll() throws Exception {
        return mapper.selectAll();
    }
}
