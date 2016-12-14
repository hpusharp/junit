package com.kaishengit.service;

import com.kaishengit.entity.Student;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by shibo on 2016/12/14.
 */
public class StudentServiceByGuavaCacheTest {
    private StudentService studentService = new StudentService();
    @Test
    public void findById() throws Exception {
        Student student = studentService.findById(5);
        student = studentService.findById(5);

        System.out.println(student);
    }

}