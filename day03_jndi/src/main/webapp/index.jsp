<%@ page import="java.io.InputStream" %>
<%@ page import="org.apache.ibatis.io.Resources" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactoryBuilder" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="cn.sher6j.dao.UserDao" %>
<%@ page import="cn.sher6j.domain.User" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<body>
<h2>Hello World!</h2>
<%
    //1. 读取配置文件
    InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
    //2. 创建SqlSessionFactory工厂
    SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
    SqlSessionFactory factory = builder.build(is);//SqlSessionFactory是个接口，不可以直接new对象
    //3. 使用工厂生产一个SqlSession对象
    SqlSession session1 = factory.openSession();
    //4. 使用SqlSession创建Dao接口的代理对象
    UserDao userDao = session1.getMapper(UserDao.class);
    //5. 使用代理对象执行方法
    List<User> users = userDao.findAll();
    for (User u : users) {
        System.out.println(u);
    }
    //6. 释放资源
    session1.close();
    is.close();
%>
</body>
</html>
