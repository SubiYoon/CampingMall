package com.camp.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.camp.admin.DTO.UserDTO;
import com.camp.admin.frame.MyMapper;

@Repository
@Mapper
public interface UserMapper extends MyMapper<String, UserDTO>{
    public List<UserDTO> selectUsersInfo(int company_code);
    public UserDTO selectnt(String n,String t) throws Exception;
}
