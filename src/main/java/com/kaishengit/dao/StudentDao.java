package com.kaishengit.dao;

import com.kaishengit.entity.Student;
import com.kaishengit.uitils.DbHelp;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;



import java.util.List;


/**
 * Created by shibo on 2016/12/13.
 */
public class StudentDao {



    public void save(Student stu) {
        String sql = "insert into student(name,age,tel) values(?,?,?)";
        DbHelp.update(sql,stu.getName(),stu.getAge(),stu.getTel());
    }
    public Student findById(Integer id) {

        String sql = "select* from student where id = ?";
        return  DbHelp.query(sql,new BeanHandler<Student>(Student.class),id);
    }
    public List<Student> findAll() {
        String sql = "select * from student";
        return  DbHelp.query(sql,new BeanListHandler<Student>(Student.class));
    }
    public void del(Integer id) {
        String sql = "delete from student where id= ?";
        DbHelp.update(sql,id);
    }
}
