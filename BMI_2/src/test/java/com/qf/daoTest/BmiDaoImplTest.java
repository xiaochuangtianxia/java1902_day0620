package com.qf.daoTest;

import com.qf.impl.BmiDaoImpl;
import com.qf.service.BmiService;
import org.junit.Test;

/**
 * Created by Administrator on 2019/5/14.
 */
public class BmiDaoImplTest {

  //  @Test
    public void test1(){
        BmiDaoImpl bdi=new BmiDaoImpl();
        System.out.println(bdi.findAll());
    }

   // @Test
    public void test2(){
        BmiService bs=new BmiService();

    }
}
