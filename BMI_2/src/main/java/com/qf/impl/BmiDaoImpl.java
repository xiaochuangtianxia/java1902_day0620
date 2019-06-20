package com.qf.impl;

import com.qf.dao.BaseDao;
import com.qf.dao.BmiDao;
import com.qf.pojo.BmiBean;

import java.util.List;

/**
 * Created by Administrator on 2019/5/14.
 */
public class BmiDaoImpl extends BaseDao implements BmiDao {


    @Override
    public List<BmiBean> findAll() {
        String sql="select * from bmi";
        return selectAll(sql);
    }

    @Override
    public int add(BmiBean bb) {
        String sql="insert into bmi values(null,?,?,?,?,?,'zhangsan')";
        Object[] obj={bb.getDate(),bb.getHeight(),bb.getWeight(),bb.getBmi(),bb.getSign()};
        return addinto(sql,obj);
    }
}
