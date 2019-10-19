package com.pan.dao;

import com.pan.pojo.Student;
import org.apache.ibatis.annotations.Insert;

/**
 * Created by pan tao on 2019/10/15
 **/
public interface IStudentDao {

    void insertStudent(Student student);

    Student selectById(int id);


}
