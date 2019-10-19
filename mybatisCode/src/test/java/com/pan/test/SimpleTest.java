package com.pan.test;

import com.pan.dao.IStudentDao;
import com.pan.pojo.Student;
import com.pan.utils.MyBatisUnit;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by pan tao on 2019/10/15
 **/
public class SimpleTest {

    private IStudentDao dao;

    private SqlSession sqlSession = MyBatisUnit.getSqlseeison();

    @Before
    public void Before() {
        dao = sqlSession.getMapper(IStudentDao.class);
    }
    @Test
    public void test1() {
        Student student = new Student("李四",23,93.5);
        System.out.println("插入前: student = "+ student);
        dao.insertStudent(student);
        sqlSession.commit();
        System.out.println("插入后: student = "+ student);
    }

}
