package com.pan.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by pan tao on 2019/10/15
 **/
public class MyBatisUnit {
    //变成成员变量可以保证一直使用该SessionFactory对象,增加了效率
    private static SqlSessionFactory sqlSessionFactory;
    //SessionFactory是重量级对象,创建其要花费很多内存(也存在线程安全)
    public static SqlSession getSqlseeison() {
        try {
            InputStream is = Resources.getResourceAsStream("mybatisConfig.xml");
            if(sqlSessionFactory == null) {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            }
            return sqlSessionFactory.openSession();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
