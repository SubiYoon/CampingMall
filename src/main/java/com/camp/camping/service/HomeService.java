package com.camp.camping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.camp.camping.DTO.HomeDTO;
import com.camp.camping.frame.MyService;
import com.camp.camping.mapper.HomeMapper;

@Service
public class HomeService implements MyService<String, HomeDTO>{

    @Autowired
    HomeMapper mapper;

	@Override
	public void insert(HomeDTO v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String k) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(HomeDTO v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public HomeDTO select(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HomeDTO> selectAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<HomeDTO> lnglat(int adcode) throws Exception {
		return mapper.lnglat(adcode);
	}

}
