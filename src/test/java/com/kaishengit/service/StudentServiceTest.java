package com.kaishengit.service;

import com.kaishengit.entity.Student;
import com.kaishengit.uitils.CacheUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by shibo on 2016/12/14.
 */
public class StudentServiceTest {
    private StudentService studentService;
    @Before
    public void setUp() throws Exception {
        studentService = new StudentService();
    }



    @Test
    public void findById() throws Exception {
        Student student = studentService.findById(3);
        student = studentService.findById(3);

        System.out.println(student);
    }
    @Test
    public void findAll() {
        List<Student>  studentList = studentService.findByAll();
        studentList = studentService.findByAll();

        System.out.println(studentList);

    }
    @Test
    public void save() {

        List<Student> studentList = studentService.findByAll();
        int before = studentList.size();
        System.out.println(before);

        Student student = new Student();
        student.setName("史云");
        student.setTel("34566");
        student.setAge(12);
        studentService.save(student);
        studentList = studentService.findByAll();
        int after = studentList.size();
        System.out.println(after);

        Assert.assertEquals(before+1,after);
    }
}