package com.qf.dao;

import com.qf.pojo.BmiBean;
import com.qf.utils.DButils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/5/14.
 */
public class BaseDao {

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    //查询
    public List<BmiBean> selectAll(String sql){
        List<BmiBean> list=new ArrayList<>();
        try{
            conn=DButils.getConn();
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                BmiBean bmi=new BmiBean();
                bmi.setId(rs.getInt("id"));
                bmi.setDate(rs.getString("date"));
                bmi.setHeight(rs.getString("height"));
                bmi.setWeight(rs.getString("weight"));
                bmi.setBmi(rs.getString("bmi"));
                bmi.setSign(rs.getString("sign"));
                bmi.setUserName(rs.getString("userName"));
                list.add(bmi);
            }
            return list;
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            DButils.close();
        }
            return null;
    }

    //增加
    public int addinto(String sql,Object[] obj){
        int res=0;
        try {
            conn=DButils.getConn();
            ps=conn.prepareStatement(sql);
            if(obj!=null){
                for(int i=0;i<obj.length;i++){
                    ps.setObject(i+1,obj[i]);
                }
            }
            res=ps.executeUpdate();
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
        }   finally {
            DButils.close();
        }
        return res;
    }


}



