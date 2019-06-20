package com.qf.service;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2019/5/14.
 */
public class BaseService extends HttpServlet{

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String action=req.getParameter("action");
            if(action!=null){
                Class c=this.getClass();
                Method method=c.getDeclaredMethod(action,HttpServletRequest.class,HttpServletResponse.class);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    /*public void service(HttpServletRequest request, HttpServletResponse response){
        try{
            String action=request.getParameter("action");
            if(action!=null){
                Class c=this.getClass();
                Method method=c.getDeclaredMethod(action,HttpServletRequest.class,HttpServletResponse.class);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
*/
}
