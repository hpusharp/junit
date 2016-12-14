package com.kaishengit.uitils;

import com.kaishengit.entity.Student;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

import java.io.Serializable;
import java.util.List;


/**
 * ehcache 工具类
 */
public class CacheUtil {
    private static CacheManager cacheManager = new CacheManager();

    public Ehcache getEhcache(String ehcache) {
        return cacheManager.getEhcache(ehcache);
    }

    public void set(Ehcache ehcache, Serializable key, Serializable value) {
        Element element = new Element(key,value);
        ehcache.put(element);
    }
    public void set(String ehcache, Serializable key, Serializable value) {
        Element element = new Element(key,value);
        getEhcache(ehcache).put(element);
    }
    public void set(String ehcache, Object key, Object value) {
        Element element = new Element(key,value);
        getEhcache(ehcache).put(element);
    }
    public Object get(Ehcache ehcache,String key) {
        Element element = ehcache.get(key);
        return  element==null? null:element.getObjectValue();
    }
    public Object get(String ehcache,String key) {
        Element element = getEhcache(ehcache).get(key);
        return  element==null? null:element.getObjectValue();
    }
    public void removeAll(Ehcache ehcache) {
        ehcache.removeAll();
    }
    public void removeAll(String ehcache) {
        getEhcache(ehcache).removeAll();
    }
    public void remove(String ehcache,Serializable key) {
        getEhcache(ehcache).remove(key);
    }
    public void remove(Ehcache ehcache,Serializable key) {
        ehcache.remove(key);
    }

}
