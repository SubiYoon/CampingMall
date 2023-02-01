package com.camp.admin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.camp.admin.DTO.UserDTO;
import com.camp.admin.frame.MyMapper;

@Repository
@Mapper
public interface UserMapper extends MyMapper<String, UserDTO>{
    public void kakaoLoginInsert(UserDTO userDTO) throws Exception;
}
