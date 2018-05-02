package edu.black.service.impl;

import edu.black.mapper.EasybuyUserMapper;
import edu.black.model.EasybuyUser;
import edu.black.model.EasybuyUserExample;
import edu.black.service.UserService;
import edu.black.util.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;
public class UserServiceImpl implements UserService {
    Logger logger = LoggerManager.getLogger(UserServiceImpl.class);
    SqlSessionFactory factory =MybatisUtil.getFactory();
    EasybuyUser temp = null;
    List<EasybuyUser> users = null;
    @Override
    public EasybuyUser login(EasybuyUser user) {
        SqlSession session = factory.openSession();
        EasybuyUserMapper mapper =session.getMapper(EasybuyUserMapper.class);
        EasybuyUserExample example = new EasybuyUserExample();
        example.createCriteria().andEuUserNameEqualTo(user.getEuUserName());
        example.createCriteria().andEuPasswordEqualTo(user.getEuPassword());
        List<EasybuyUser> result = mapper.selectByExample(example);
        if (result.size()==1){
            temp = result.get(0);
        }
        session.close();
        return temp;
    }

    @Override
    public boolean register(EasybuyUser user) {
        user.setEuUserId(DateUtil.getDate()+(int)Math.random()*1000);
        user.setEuStatus(1);//1 普通用户 2 管理员
        logger.trace(user.getEuUserId()+"/"+user.getEuUserName()+"/"+user.getEuPassword());
        SqlSession session = factory.openSession();
        EasybuyUserMapper mapper =session.getMapper(EasybuyUserMapper.class);
        boolean result = mapper.insertSelective(user)==1?true:false;
        if (result){
            session.commit();
        }else {
            session.rollback();
        }
        session.close();
        return result;
    }

    @Override
    public boolean updateUserInfo(EasybuyUser user) {
        SqlSession session = factory.openSession();
        EasybuyUserMapper mapper =session.getMapper(EasybuyUserMapper.class);
        EasybuyUserExample example = new EasybuyUserExample();
        example.createCriteria().andEuUserIdEqualTo(user.getEuUserId());
        user.setEuUserId(null);//防止用户修改id
        boolean result = mapper.updateByExampleSelective(user,example)==1?true:false;
        if (result){
            session.commit();
        }else {
            session.rollback();
        }
        session.close();
        return result;
    }

    @Override
    public boolean deleteUser(EasybuyUser user) {
        SqlSession session = factory.openSession();
        EasybuyUserMapper mapper =session.getMapper(EasybuyUserMapper.class);
        boolean result = mapper.deleteByPrimaryKey(user.getEuUserId())==1?true:false;
        if (result){
            session.commit();
        }else {
            session.rollback();
        }
        session.close();
        return result;
    }

    @Override
    public List<EasybuyUser> getAll() {
        SqlSession session = factory.openSession();
        EasybuyUserMapper mapper =session.getMapper(EasybuyUserMapper.class);
        users = mapper.selectByExample(null);
        session.close();
        return users;
    }

    @Override
    public EasybuyUser getUserByUserId(EasybuyUser user) {
        SqlSession session = factory.openSession();
        EasybuyUserMapper mapper =session.getMapper(EasybuyUserMapper.class);
        EasybuyUser result = mapper.selectByPrimaryKey(user.getEuUserId());
        session.close();
        return result;
    }
}
