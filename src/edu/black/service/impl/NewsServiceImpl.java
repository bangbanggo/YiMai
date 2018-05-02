package edu.black.service.impl;

import edu.black.mapper.EasybuyNewsMapper;
import edu.black.model.EasybuyNews;
import edu.black.model.EasybuyNewsExample;
import edu.black.service.NewsService;
import edu.black.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.Date;
import java.util.List;

public class NewsServiceImpl implements NewsService {
    private SqlSessionFactory factory = MybatisUtil.getFactory();
    @Override
    public boolean insert(EasybuyNews news) {
        SqlSession session = factory.openSession();
        EasybuyNewsMapper mapper = session.getMapper(EasybuyNewsMapper.class);
        news.setEnCreateTime(new Date());
        boolean result = mapper.insertSelective(news)==1?true:false;
        if (result){
            session.commit();
        }else {
            session.rollback();
        }
        session.close();
        return result;
    }

    @Override
    public boolean delete(EasybuyNews news) {
        SqlSession session = factory.openSession();
        EasybuyNewsMapper mapper = session.getMapper(EasybuyNewsMapper.class);
        boolean result = mapper.deleteByPrimaryKey(news.getEnId())==1?true:false;
        if (result){
            session.commit();
        }else {
            session.rollback();
        }
        return result;
    }

    @Override
    public boolean update(EasybuyNews news) {
        SqlSession session = factory.openSession();
        EasybuyNewsMapper mapper = session.getMapper(EasybuyNewsMapper.class);
        boolean result = mapper.updateByPrimaryKeySelective(news)==1?true:false;
        if (result){
            session.commit();
        }else {
            session.rollback();
        }
        return result;
    }

    @Override
    public EasybuyNews getNews(int newsid) {
        SqlSession session = factory.openSession();
        EasybuyNewsMapper mapper = session.getMapper(EasybuyNewsMapper.class);
        EasybuyNews news= mapper.selectByPrimaryKey(newsid);
        session.close();
        return news;
    }

    @Override
    public List<EasybuyNews> getNewss(EasybuyNews news) {
        SqlSession session = factory.openSession();
        EasybuyNewsMapper mapper = session.getMapper(EasybuyNewsMapper.class);
        EasybuyNewsExample example = new EasybuyNewsExample();
        if (news!=null){
            //do sth else
        }
        List<EasybuyNews> newses= mapper.selectByExample(example);
        session.close();
        return newses;
    }

    @Override
    public List<EasybuyNews> getHistory(List<Integer> ids) {
        return null;
    }
}
