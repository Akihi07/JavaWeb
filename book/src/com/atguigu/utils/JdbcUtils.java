package com.atguigu.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 创建JdbcUtils来管理数据库连接
 */
public class JdbcUtils {

    private static DruidDataSource dataSource;
    static {
        try {
            Properties properties = new Properties();

            /* 读取 jdbc.properties 属性配置文件*/
            InputStream resourceAsStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");

            /* 从流中加载数据 */
            properties.load(resourceAsStream);

            /*创建 数据库 连接池*/
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);

            /*测试连接是否成功，通过打印连接信息来进行测试*/
//            System.out.println(dataSource.getConnection());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }


    /**
     * 获取数据库连接池中的连接
     * @return  如果返回null，说明获取连接失败 有值就是获取连接成功
     */
    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }


    /**
     * 关闭连接，放回数据库连接池
     * @param conn  连接
     */
    public static void close(Connection conn){
        try {
            if(conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
