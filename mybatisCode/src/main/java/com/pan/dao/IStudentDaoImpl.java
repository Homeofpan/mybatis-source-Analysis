package com.pan.dao;

import com.pan.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by pan tao on 2019/10/19
 **/
public class IStudentDaoImpl implements IStudentDao {

    private SqlSession sqlSession;

    @Override
    public void insertStudent(Student student) {

        System.out.println("==========> 现在使用的是dao的手动实现类");
        try {
            //加载主配置文件
            InputStream inputStream = Resources.getResourceAsStream("mybatisConfig.xml");
            //创建SqlSessionFactory对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = sqlSessionFactory.openSession();
            //相关操作
            sqlSession.insert("Pan.insertStudent", student);
//			sqlSession.insert("insertStudent", student);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    @Override
    public Student selectById(int id) {
        System.out.println("==========> 现在使用的是dao的手动实现类");
        try {
            //加载主配置文件
            InputStream inputStream = Resources.getResourceAsStream("mybatisConfig.xml");
            //创建SqlSessionFactory对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = sqlSessionFactory.openSession();
            //相关操作
            Student student = (Student) sqlSession.selectList("Pan.selectById", id).get(0);
//			sqlSession.insert("insertStudent", student);
            return student;
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(sqlSession != null) {
                sqlSession.close();
            }
        }
        return null;
    }
}
