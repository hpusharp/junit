package com.kaishengit.service;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import com.kaishengit.dao.StudentDao;
import com.kaishengit.entity.Student;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by shibo on 2016/12/14.
 */
public class StudentServiceByGuavaCache {

    //第一种缓存方式
   /* private  static  StudentDao studentDao = new StudentDao();

    private static Cache<String,Student> cache = CacheBuilder.newBuilder()
            .maximumSize(100)
            .expireAfterAccess(10,TimeUnit.MINUTES)
            .build();

    public  Student findById(final Integer id) {
        Student student = null;
        try {
            student = cache.get("student" + id, new Callable<Student>() {
                public Student call() throws Exception {
                    return studentDao.findById(id);

                }
            });
        }catch (ExecutionException e) {
            e.printStackTrace();
        }
        return student;
    }*/
    //第二种缓存方式
    LoadingCache<String,Student> cache = CacheBuilder.newBuilder()
            .maximumSize(1000)
            .expireAfterWrite(10, TimeUnit.MINUTES)

            .build(
                    new CacheLoader<String, Student>() {

                        @Override
                        public Student load(String key)  {
                            StudentDao studentDao = new StudentDao();
                            Student student = studentDao.findById(Integer.valueOf(key));
                            return student;
                        }
                    });
    public Student findById(Integer id) {
        Student student = null;
        student = cache.getUnchecked(id.toString());
        return student;
    }
}
