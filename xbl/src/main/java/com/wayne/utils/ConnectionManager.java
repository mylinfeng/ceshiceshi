package com.wayne.utils;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * 数据库连接池
 *
 * @author Wayne
 * @date 2019/5/24
 */
public class ConnectionManager {

    private static BasicDataSource dataSource = new BasicDataSource();
    private static String DRIVER;
    private static String URL;
    private static String USERNAME;
    private static String PASSWORD;

    static {
        try {
            // 加载config.properties中配置的数据库连接信息
            Properties prop = new Properties();
            prop.load(ConnectionManager.class.getClassLoader().getResourceAsStream("config.properties"));
            DRIVER = prop.getProperty("jdbc.driver");
            URL = prop.getProperty("jdbc.url");
            USERNAME = prop.getProperty("jdbc.username");
            PASSWORD = prop.getProperty("jdbc.password");
        } catch (IOException e) {
            e.printStackTrace();
        }
        dataSource.setDriverClassName(DRIVER);
        dataSource.setUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);

        // 配置数据库连接池参数
        dataSource.setInitialSize(2);
        dataSource.setMaxIdle(5);
        dataSource.setMinIdle(1);
        dataSource.setMaxWaitMillis(5000);
    }

    public static DataSource getConection() {
        return dataSource;
    }

}
