package com.pan.test;

import com.pan.dao.IStudentDao;
import com.pan.dao.IStudentDaoImpl;
import com.pan.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

/**
 * Created by pan tao on 2019/10/19
 **/
public class MyTest {

    private IStudentDao dao;

    @Before
    public void Before() {
        dao = new IStudentDaoImpl();

    }

    @Test
    public void testInsert() {
        Student student = new Student("大吉吧",23,96);
        dao.insertStudent(student);
        System.out.println("111");
    }

    @Test
    public void testSelectStu(){
        Student student = dao.selectById(2);
        System.out.println(student);
    }

    //通过mapper动态代理来完成查询,实现所需
    @Test
    public void selectByMapperProxy() throws Exception {
        //加载主配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatisConfig.xml");
        //创建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        IStudentDao mapperProxy = sqlSession.getMapper(IStudentDao.class);
        Student student = mapperProxy.selectById(2);
        System.out.println(student);
    }
}
