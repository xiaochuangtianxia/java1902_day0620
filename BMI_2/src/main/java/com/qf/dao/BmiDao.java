package com.qf.dao;

import com.qf.pojo.BmiBean;

import java.util.List;

/**
 * Created by Administrator on 2019/5/14.
 */
public interface BmiDao {

    //查询
    public List<BmiBean> findAll();

    //增加
    public int add(BmiBean bb);

}
