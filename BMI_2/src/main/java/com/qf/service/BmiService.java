package com.qf.service;

import com.google.gson.Gson;
import com.qf.impl.BmiDaoImpl;
import com.qf.pojo.BmiBean;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/5/14.
 */


public class BmiService extends HttpServlet{

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        if(action==null){
            action="list";
        }
        if("add".equals(action)){
            add(req,resp);
        }
        else if("list".equals(action)){
            list(req,resp);
        }
    }

    //获取页面增加数据，并添加到数据库中
    public void add(HttpServletRequest request,HttpServletResponse response){
        String height=request.getParameter("h");
        String weight=request.getParameter("w");
        String bmi=request.getParameter("bmi");
        String date=request.getParameter("date");
        String sign=request.getParameter("sign");

        BmiDaoImpl bdi=new BmiDaoImpl();
        BmiBean bb=new BmiBean();
        bb.setHeight(height);
        bb.setWeight(weight);
        bb.setBmi(bmi);
        bb.setDate(date);
        bb.setSign(sign);
        bdi.add(bb);
    }

    public void list(HttpServletRequest request,HttpServletResponse response){
        List<BmiBean> listBean=new ArrayList<>();
        BmiDaoImpl bdi=new BmiDaoImpl();
        listBean=bdi.findAll();
        System.out.println(listBean);
        Gson gson=new Gson();
        String res=gson.toJson(listBean);
        try {
            PrintWriter out=response.getWriter();
            out.write(res);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}





/*



public class BmiService extends BaseService {

    public void show(HttpServletRequest request, HttpServletResponse response){
        try {
            List<BmiBean> list=new ArrayList<>();
            BmiDaoImpl bdao=new BmiDaoImpl();
            list=bdao.findAll();
            System.out.println("1");
            System.out.println(list);
            Gson gson=new Gson();
            String res=gson.toJson(list);
            PrintWriter out=response.getWriter();
            out.write(res);
            out.flush();
            out.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    public void add(HttpServletRequest request,HttpServletResponse response){
        String height=request.getParameter("h");
        String weight=request.getParameter("w");
        String bmi=request.getParameter("bmi");
        String date=request.getParameter("date");
        String sign=request.getParameter("sign");

        System.out.println("1");
        System.out.println("==="+height);
        System.out.println("==="+date);

        BmiDaoImpl bdi=new BmiDaoImpl();
        BmiBean bb=new BmiBean();
        bb.setHeight(height);
        bb.setWeight(weight);
        bb.setBmi(bmi);
        bb.setDate(date);
        bb.setSign(sign);
        bdi.add(bb);
    }

}
*/
