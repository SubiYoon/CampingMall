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
        mapper.insert(v);
    }

    @Override
    public void delete(String k) throws Exception {
        mapper.delete(k);
    }

    @Override
    public void update(UserDTO v) throws Exception {
        mapper.update(v);
    }

    @Override
    public UserDTO select(String k) throws Exception {
        return mapper.select(k);
    }

    @Override
    public List<UserDTO> selectAll() throws Exception {
        return mapper.selectall();
    }
    
}
