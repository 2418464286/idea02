package com.hp.service;

import com.hp.entity.User;
import com.hp.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class UserService {
@Autowired
private UserMapper userMapper;

    public User queryById(Long id){
        return  this.userMapper.selectByPrimaryKey(id);
    }
}
