package com.camp.camping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.camp.camping.DTO.UserDTO;
import com.camp.camping.frame.MyService;
import com.camp.camping.mapper.UserMapper;

@Service
public class UserService implements MyService<String, UserDTO>{

    @Autowired
    UserMapper mapper;

    @Override
    public void insert(UserDTO v) throws Exception {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delete(String k) throws Exception {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void update(UserDTO v) throws Exception {
        // TODO Auto-generated method stub
        
    }

    @Override
    public UserDTO select(String k) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<UserDTO> selectAll() throws Exception {
        // TODO Auto-generated method stub
        return null;
    }
    
}
