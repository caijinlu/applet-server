package com.syt.hotel.dao;

import com.syt.hotel.model.User;

/**
 * @author 0200077
 * @create 2018-10-30 16:19
 **/
public interface UserMapper {

    void insertUser(User user);

    User findOne(Long id);
}
