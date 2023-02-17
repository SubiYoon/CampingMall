package com.camp.camping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.camp.camping.DTO.CompanyDTO;
import com.camp.camping.frame.MyService;
import com.camp.camping.mapper.CompanyMapper;

@Service
public class CompanyService implements MyService<Integer, CompanyDTO> {

	@Autowired
	CompanyMapper mapper;

	@Override
	public void insert(CompanyDTO v) throws Exception {
		mapper.insert(v);
	}

	@Override
	public void delete(Integer k) throws Exception {
		mapper.delete(k);
	}

	@Override
	public void update(CompanyDTO v) throws Exception {
		mapper.update(v);
	}

	@Override
	public CompanyDTO select(Integer k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<CompanyDTO> selectAll() throws Exception {
		return mapper.selectAll();
	}

}
