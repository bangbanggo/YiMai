package edu.black.service.impl;

import edu.black.mapper.EasybuyCommentMapper;
import edu.black.model.EasybuyComment;
import edu.black.model.EasybuyCommentExample;
import edu.black.service.CommentService;
import edu.black.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.Date;
import java.util.List;

public class CommentServiceImpl implements CommentService {
    SqlSessionFactory factory = MybatisUtil.getFactory();
    @Override
    public boolean insert(EasybuyComment comment) {
        SqlSession session = factory.openSession();
        EasybuyCommentMapper mapper = session.getMapper(EasybuyCommentMapper.class);
        comment.setEcCreateTime(new Date());
        boolean result = mapper.insertSelective(comment)==1?true:false;
        if (result){
            session.commit();
        }else {
            session.rollback();
        }
        session.close();
        return result;
    }

    @Override
    public boolean delete(EasybuyComment comment) {
        SqlSession session = factory.openSession();
        EasybuyCommentMapper mapper = session.getMapper(EasybuyCommentMapper.class);
        boolean result = mapper.deleteByPrimaryKey(comment.getEcId())==1?true:false;
        if (result){
            session.commit();
        }else {
            session.rollback();
        }
        return result;
    }

    @Override
    public boolean update(EasybuyComment comment) {
        SqlSession session = factory.openSession();
        EasybuyCommentMapper mapper = session.getMapper(EasybuyCommentMapper.class);
        boolean result = mapper.updateByPrimaryKeySelective(comment)==1?true:false;
        if (result){
            session.commit();
        }else {
            session.rollback();
        }
        return result;
    }

    @Override
    public EasybuyComment getComment(int commentid) {
        SqlSession session = factory.openSession();
        EasybuyCommentMapper mapper = session.getMapper(EasybuyCommentMapper.class);
        EasybuyComment comment= mapper.selectByPrimaryKey(commentid);
        session.close();
        return comment;
    }

    @Override
    public List<EasybuyComment> getComments(EasybuyComment comment) {
        SqlSession session = factory.openSession();
        EasybuyCommentMapper mapper = session.getMapper(EasybuyCommentMapper.class);
        EasybuyCommentExample example = new EasybuyCommentExample();
        if (comment!=null){
            //do sth else
        }
        List<EasybuyComment> commentes= mapper.selectByExample(example);
        session.close();
        return commentes;
    }

    @Override
    public List<EasybuyComment> getHistory(List<Integer> ids) {
        return null;
    }
}
