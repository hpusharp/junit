package com.kaishengit.service;

import com.kaishengit.dao.StudentDao;
import com.kaishengit.entity.Student;
import com.kaishengit.uitils.CacheUtil;

import java.util.List;

/**
 * Created by shibo on 2016/12/13.
 */
public class StudentService {
    private static  final String  STUENT_CACHE_NAME = "student";
    private StudentDao studentDao = new StudentDao();
    private static CacheUtil cacheUtil = new CacheUtil();

    public void save(Student student) {
        studentDao.save(student);
        cacheUtil.remove(STUENT_CACHE_NAME,"studentList");

    }
    public void del(Integer id){
        studentDao.del(id);
        cacheUtil.remove(STUENT_CACHE_NAME,"student:"+id);
        cacheUtil.remove(STUENT_CACHE_NAME,"studentList");
    }
    public Student findById(Integer id) {
        Student student = (Student) cacheUtil.get(STUENT_CACHE_NAME,"student:"+id);
        if(student==null) {
            student = studentDao.findById(id);
            cacheUtil.set(STUENT_CACHE_NAME,"student:"+id,student);
        }
        return student;
    }
    public List<Student> findByAll() {

        List<Student> studentList =(List<Student>) cacheUtil.get(STUENT_CACHE_NAME,"studentList");
        if(studentList==null) {
            studentList = studentDao.findAll();
            cacheUtil.set(STUENT_CACHE_NAME,"studentList",studentList);
        }
        return studentList;
    }




}
