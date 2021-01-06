package com.wayne.utils;

import com.wayne.exception.DataAccessException;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.SQLException;

/**
 * CRUD工具类
 * @author Wayne
 * @date 2019/5/24
 */
public class DbHelp {

    // 从连接池中获得连接
    private static QueryRunner runner = new QueryRunner(ConnectionManager.getConection());

    /**
     * 新增
     * @param sql 待执行的SQL
     * @param rsh 结果集处理方式
     * @param params SQL中的参数
     * @param <T> 结果的类的详情信息
     * @throws DataAccessException SQL执行错误时抛出的异常
     */
    public static <T> T insert(String sql, ResultSetHandler<T> rsh, Object...params) throws DataAccessException {
        T t = null;
        try {
            t = runner.insert(sql, rsh, params);
        } catch (SQLException e) {
            throw new DataAccessException("执行: " + sql + "异常");
        }
        return t;
    }

    /**
     * @param sql 待执行的SQL
     * @param params 结果集处理方式
     * @throws DataAccessException SQL执行错误时抛出的异常
     */
    public static void update(String sql, Object... params) throws DataAccessException {
        try {
            runner.update(sql, params);
        } catch (SQLException e) {
            throw new DataAccessException("执行: " + sql + "异常");
        }
    }

    /**
     * @param sql 待执行的SQL
     * @param rsh 结果集处理方式
     * @param params SQL中的参数
     * @param <T> 结果的类的详情信息
     * @throws DataAccessException SQL执行错误时抛出的异常
     */
    public static <T> T query(String sql, ResultSetHandler<T> rsh, Object... params) throws DataAccessException {
        T t = null;
        try {
            t = runner.query(sql, rsh, params);
        } catch (SQLException e) {
            throw new DataAccessException("执行: " + sql + "异常");
        }
        return t;
    }

}
