package com.wayne.service.impl;

import com.wayne.dao.UserDao;
import com.wayne.entity.UserEntity;
import com.wayne.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author Wayne
 * @date 2019/5/24
 */
@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDao();


    @Override
    public String login(String username, String password) {
        UserEntity userEntity = userDao.selectUserByUsername(username);

        if (null != userEntity && password.equals(userEntity.getPassword())) {
            return "OK";
        }

        return "ERROR";
    }
}
