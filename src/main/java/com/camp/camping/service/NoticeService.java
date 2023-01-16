package com.camp.camping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.camp.camping.DTO.NoticeDTO;
import com.camp.camping.frame.MyService;
import com.camp.camping.mapper.NoticeMapper;

@Service
public class NoticeService implements MyService<Integer, NoticeDTO>{

    @Autowired
    NoticeMapper mapper;

    @Override
    public void insert(NoticeDTO v) throws Exception {
        mapper.insert(v);        
    }

    @Override
    public void delete(Integer k) throws Exception {
        mapper.delete(k);
    }

    @Override
    public void update(NoticeDTO v) throws Exception {
        mapper.update(v);
    }

    @Override
    public NoticeDTO select(Integer k) throws Exception {
        return mapper.select(k);
    }

    @Override
    public List<NoticeDTO> selectAll() throws Exception {
        return mapper.selectAll();
    }

    
}
