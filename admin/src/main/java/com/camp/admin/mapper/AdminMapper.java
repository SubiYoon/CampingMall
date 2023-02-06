package com.camp.admin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.camp.admin.DTO.AdminDTO;

@Repository
@Mapper
public interface AdminMapper {
    public AdminDTO select(String admin_id);
}
