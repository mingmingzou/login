package com.jiashiwei;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;




//servlet  �ĸ���
public class BaseServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//������־����
	private Logger logger=Logger.getLogger(BaseServlet.class);
       @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                     doPost(req, resp);
       }
       @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        //��÷�����
        String m=req.getParameter("m");
        logger.info("ִ���˷���:"+m);
        //System.out.println("���÷���:"+m);
        try {
        	//ͨ�������÷���
        	Method method=getClass().getMethod(m,HttpServletRequest.class,HttpServletResponse.class);
		   method.invoke(this, req,resp);
		   logger.info("����"+m+"������");
        }catch(Exception e) {
			e.printStackTrace();
		} 
       }
}
