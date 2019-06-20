package com.qf.utils;

import java.sql.*;
import java.util.Properties;

/**
 * Created by Administrator on 2019/5/14.
 */
public class DButils {

        private static String driver;
        private static String url;
        private static String user;
        private static String pass;

        private static Connection conn;
        private static PreparedStatement ps;
        private static ResultSet rs;

        //加载驱动
    static {
        try{
            Properties prop=new Properties();
            prop.load(DButils.class.getClassLoader().getResourceAsStream("db.properties"));
            driver=prop.getProperty("jdbc.driver");
            url=prop.getProperty("jdbc.url");
            user=prop.getProperty("jdbc.username");
            pass=prop.getProperty("jdbc.password");
            Class.forName(driver);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    //创建连接
    public static Connection getConn(){
        try{
            return DriverManager.getConnection(url,user,pass);
        }
        catch (Exception e){
            e.printStackTrace();
        }
            return null;
    }

    //关闭连接
    public static void close(){
        try{
            if(rs!=null)
                rs.close();
            if(ps!=null)
                ps.close();
            if(conn!=null)
                conn.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
