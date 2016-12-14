package com.kaishengit.dao;


import com.kaishengit.entity.Student;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.util.List;



/**
 * Created by shibo on 2016/12/13.
 */
public class StudentDaoTestCase {
    private  static StudentDao studentDao;



    @Before
    public void before() {
     studentDao = new StudentDao();


    }
    @Test
    public void testSave() {
        Student student = new Student();
        student.setName("张三");
        student.setAge(21);
        student.setTel("0213-483948");

    }
    @Test
    public void testFindById() {
        Student student = studentDao.findById(3);
        Student student2 = studentDao.findById(3);



       // Assert.assertNotNull(student);
    }
    @Test
    public void testFindAll() {
        List<Student> studentList = studentDao.findAll();
        Assert.assertEquals(7,studentList.size());
    }
    @Test
    public void testDel() {
        studentDao.del(1);
    }

}
