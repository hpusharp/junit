package com.kaishengit.dao;



import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import org.junit.Test;

/**
 * Created by shibo on 2016/12/14.
 */
public class CacheTestCase {

    @Test
    public void  TestCache() {
        CacheManager cacheManager = new CacheManager();
        Ehcache ehcache = cacheManager.getEhcache("student");//读取配置文件，产生ehcache缓存

        //添加
        Element element = new Element("student:1","jack");
        ehcache.put(element);

        //删除
        ehcache.removeAll();

        //取值
        Element e = ehcache.get("student:1");
        System.out.println(e.getObjectValue());

    }
}
