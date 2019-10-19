package com.pan.test;

import com.pan.dao.ICountryDao;
import com.pan.pojo.Country;
import com.pan.utils.MyBatisUnit;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by pan tao on 2019/10/16
 **/
public class Mytest {

    private ICountryDao dao;

    private SqlSession sqlSession = MyBatisUnit.getSqlseeison();

    @Before
    public void Before() {
        dao = sqlSession.getMapper(ICountryDao.class);
    }

    @After
    public void After(){
        if (sqlSession != null) {
            sqlSession.close();
        }
    }
    @Test
    public void test1() {

        Country country = dao.selectCountryById(2);
        System.out.println(country.getCname());

    }
}
