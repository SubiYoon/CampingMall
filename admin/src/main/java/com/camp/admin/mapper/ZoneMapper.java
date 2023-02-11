package com.camp.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.camp.admin.DTO.ZoneDTO;
import com.camp.admin.frame.MyMapper;

@Repository
@Mapper
public interface ZoneMapper extends MyMapper<Integer, ZoneDTO> {

	public List<ZoneDTO> selectZone(Integer companycode) throws Exception;

	public void updateDel(Integer site_code) throws Exception;

	public ZoneDTO selectForEdit(Integer k) throws Exception;
}
