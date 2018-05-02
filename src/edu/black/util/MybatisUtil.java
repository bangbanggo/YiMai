package edu.black.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtil {
    private static SqlSessionFactory factory = null;
    public static SqlSessionFactory getFactory(){
        if (factory==null){
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            String resource = "mybatis-config.xml";
            InputStream inputStream = null;
            try {
                inputStream = Resources.getResourceAsStream(resource);
            } catch (IOException e) {
                e.printStackTrace();
            }
            factory = builder.build(inputStream);
        }
        return factory;
    }
}
