package com.wayne.dao;

import com.wayne.entity.UserEntity;
import com.wayne.utils.DbHelp;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.handlers.BeanHandler;

/**
 * @author Wayne
 * @date 2019/5/24
 */
public class UserDao {

    public UserEntity selectUserByUsername(String username) {
        String sql = "select * from t_user where username = ?";
        return DbHelp.query(sql, new BeanHandler<>(UserEntity.class, new BasicRowProcessor(new GenerousBeanProcessor())), username);
    }
}
