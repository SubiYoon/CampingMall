package com.camp.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.camp.admin.DTO.AdminDTO;
import com.camp.admin.mapper.AdminMapper;

@Service
public class AdminService {

    @Autowired
    AdminMapper mapper;

    public AdminDTO select(String admin_id) throws Exception{
        return mapper.select(admin_id);
    }
}
