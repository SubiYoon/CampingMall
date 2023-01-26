package com.camp.camping.service;

import com.camp.camping.DTO.SiteDTO;
import com.camp.camping.frame.MyService;
import com.camp.camping.mapper.SiteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiteService implements MyService<Integer, SiteDTO> {
    @Autowired
    SiteMapper mapper;
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
        return null;
    }

    @Override
    public List<SiteDTO> selectAll() throws Exception {
        return null;
    }

    public List<Integer> selectByCompany(int company_code){
        return mapper.selectByCompany(company_code);
    }
}
