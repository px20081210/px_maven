package com.px.dao;

import com.px.po.Classification;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ClassificationDao {

    private SqlSessionFactory sqlSessionFactory;

    public ClassificationDao(String configPath) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream(configPath);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    public List<Classification> findAll(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Classification> classifications = sqlSession.selectList("findAll");
        sqlSession.close();
        return classifications;
    }
    public int addRecord(Classification classification){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int rowsAffected = sqlSession.insert("insert",classification);//"insert" mapper命名空间
        sqlSession.commit();
        sqlSession.close();
        return rowsAffected;
    }
    public int deleteRecord(int id){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int rowsAffected = sqlSession.delete("delete",id);
        sqlSession.commit();
        sqlSession.close();
        return rowsAffected;
    }


}
