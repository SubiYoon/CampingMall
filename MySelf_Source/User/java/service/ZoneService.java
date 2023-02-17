package com.camp.camping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.camp.camping.DTO.ZoneDTO;
import com.camp.camping.frame.MyService;
import com.camp.camping.mapper.ZoneMapper;

@Service
public class ZoneService implements MyService<Integer, ZoneDTO> {

    @Autowired
    ZoneMapper mapper;

    @Override
    public void insert(ZoneDTO v) throws Exception {
        mapper.insert(v);
    }

    @Override
    public void delete(Integer k) throws Exception {
        mapper.delete(k);
    }

    @Override
    public void update(ZoneDTO v) throws Exception {
        mapper.update(v);
    }

    @Override
    public ZoneDTO select(Integer k) throws Exception {
        return mapper.select(k);
    }

    @Override
    public List<ZoneDTO> selectAll() throws Exception {
        return mapper.selectAll();
    }

    public List<ZoneDTO> selectZone(Integer companycode) throws Exception {
        return mapper.selectZone(companycode);
    }

}
